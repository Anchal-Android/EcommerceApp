package com.example.anchalsinghal.ecommerce_demo.View.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anchalsinghal.ecommerce_demo.Adapter.VariantAdapter;
import com.example.anchalsinghal.ecommerce_demo.R;
import com.example.anchalsinghal.ecommerce_demo.Utils.Constants;
import com.example.anchalsinghal.ecommerce_demo.data.ProductsItem;

public class ProductVariantsFragment extends Fragment {

    RecyclerView rv_product_variant;
   ProductsItem productsItemVariants;
    public RecyclerView.Adapter<VariantAdapter.ViewHolder> madapter;
    public RecyclerView.LayoutManager layoutManager;
TextView tv_productTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
       View view = inflater.inflate(R.layout.product_variant_fragment,container,false);

        tv_productTitle = view.findViewById(R.id.tv_productTitle);
        rv_product_variant = view.findViewById(R.id.rv_product_variant);


        try {
            Bundle extras = getArguments();
            if (extras != null) {

                productsItemVariants = (ProductsItem) getArguments().getSerializable("ListData");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert productsItemVariants != null;
        tv_productTitle.setText(productsItemVariants.getName());
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        rv_product_variant.setLayoutManager(layoutManager);
        madapter = new VariantAdapter(productsItemVariants);
        rv_product_variant.setAdapter(madapter);
        Constants.getAnimation(rv_product_variant);

               return view;
    }
}
