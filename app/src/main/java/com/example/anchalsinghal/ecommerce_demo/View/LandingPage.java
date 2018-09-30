package com.example.anchalsinghal.ecommerce_demo.View;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.example.anchalsinghal.ecommerce_demo.R;
import com.example.anchalsinghal.ecommerce_demo.View.Fragments.CategoryFragment;
import com.example.anchalsinghal.ecommerce_demo.View.Fragments.ProductFragment;
import com.example.anchalsinghal.ecommerce_demo.View.Fragments.ProductVariantsFragment;
import com.example.anchalsinghal.ecommerce_demo.View.Fragments.RankingItemsFragment;
import com.example.anchalsinghal.ecommerce_demo.View.Interfaces.IRecycler;
import com.example.anchalsinghal.ecommerce_demo.data.CategoriesItem;
import com.example.anchalsinghal.ecommerce_demo.data.ProductsItem;
import com.example.anchalsinghal.ecommerce_demo.data.RankingsItem;
import com.example.anchalsinghal.ecommerce_demo.data.Response;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LandingPage extends AppCompatActivity implements IRecycler, View.OnClickListener {

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction;
    private static  int position=0;
    TextView tv_filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        tv_filter = findViewById(R.id.tv_filter);

        tv_filter.setOnClickListener(this);

        transaction = manager.beginTransaction();
        transaction.replace(R.id.ll_activitylayout, new CategoryFragment(), "category_fragment");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
       // transaction.addToBackStack("category_fragment");
        transaction.commit();
    }

    @Override
    public void onCategoryShown(List<ProductsItem> productList) {

        transaction =  manager.beginTransaction();
        Bundle bundle =  new Bundle();
        bundle.putSerializable("ListData", (Serializable) productList);

        ProductFragment productFragment =  new ProductFragment();
        productFragment.setArguments(bundle);
        transaction.replace(R.id.ll_activitylayout,productFragment,"productFragment");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack("productFragment");
        transaction.commit();

    }

    @Override
    public void onProductVariantsList(ProductsItem productsItem) {

        transaction =  manager.beginTransaction();
        Bundle bundle =  new Bundle();
        bundle.putSerializable("ListData", productsItem);

        ProductVariantsFragment productVariantsFragment =  new ProductVariantsFragment();
        productVariantsFragment.setArguments(bundle);
        transaction.replace(R.id.ll_activitylayout,productVariantsFragment,"productVariantsFragment");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack("productVariantsFragment");
        transaction.commit();

    }

    @Override
    public void getRankingList(final Response rankingList) {

        final List<RankingsItem> rankingsItems = rankingList.getRankings();

               try {

           String[] rankings = new String[rankingsItems.size()];
            try {
                for (int i = 0; i < rankingsItems.size(); i++) {
                    rankings[i] = rankingsItems.get(i).getRanking();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Initialize the Alert Dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);


            // Set the dialog title
            builder.setTitle("Select")
                    // Specify the list array, the items to be selected by default (null for none),
                    // and the listener through which to receive callbacks when items are selected
                    .setSingleChoiceItems(rankings, position, new DialogInterface
                            .OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            // TODO Auto-generated method stub
                            position = id;


                        }
                    })

                    // Set the action buttons
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id1) {
                            // User clicked OK, so save the result somewhere
                            // or return them to the component that opened the dialog
                            if (rankingsItems.size() > 0) {
                                List<ProductsItem> rankingProduct = rankingsItems.get(position)
                                        .getProducts();
                                List<CategoriesItem> productsItems = rankingList.getCategories();
                                List<ProductsItem> productListToView;
                                List<ProductsItem> productsItems1 = new ArrayList<>();


                                for(int i=0; i<rankingList.getCategories().size();i++)
                                {
                                    productListToView =(productsItems.get(i).getProducts());

                                    productsItems1.addAll(productListToView);

                                }

                                dialog.dismiss();

                                transaction =  manager.beginTransaction();
                                Bundle bundle =  new Bundle();
                                bundle.putSerializable("RankingData", (Serializable) rankingProduct);
                                bundle.putSerializable("ProductData",(Serializable) productsItems1);

                                RankingItemsFragment rankingItemsFragment =  new RankingItemsFragment();
                                rankingItemsFragment.setArguments(bundle);
                                transaction.replace(R.id.ll_activitylayout,rankingItemsFragment,"rankingItemsFragment");
                                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                                transaction.addToBackStack("rankingItemsFragment");
                                transaction.commit();

                            }





                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

       /* CategoryFragment categoryFragment = (CategoryFragment)getFragmentManager().findFragmentByTag("category_fragment");

        if(categoryFragment!=null && categoryFragment.isVisible())
        {
            finish();
        }
        else*/
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onClick(View v) {



    }
}
