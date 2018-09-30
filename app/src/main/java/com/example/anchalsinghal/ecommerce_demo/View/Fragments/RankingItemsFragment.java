package com.example.anchalsinghal.ecommerce_demo.View.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.anchalsinghal.ecommerce_demo.Adapter.RankingAdapter;
import com.example.anchalsinghal.ecommerce_demo.R;
import com.example.anchalsinghal.ecommerce_demo.Utils.Constants;
import com.example.anchalsinghal.ecommerce_demo.View.Interfaces.IProduct;
import com.example.anchalsinghal.ecommerce_demo.View.Interfaces.IRecycler;
import com.example.anchalsinghal.ecommerce_demo.data.ProductsItem;


import java.util.List;

public class RankingItemsFragment extends Fragment implements IProduct {

    RecyclerView rv_category;
    List<ProductsItem> productsItemList;
    List<ProductsItem> RankingProductList;
    public RecyclerView.Adapter<RankingAdapter.ViewHolder> madapter;
    public RecyclerView.LayoutManager layoutManager;

    IRecycler mCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{

            mCallback = (IRecycler) context;

        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString()+ "must implement onHeadLineSelectedListener");
        }
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview, container, false);

        rv_category = view.findViewById(R.id.rv_category);

        try {
            Bundle extras = getArguments();
            if (extras != null) {

                productsItemList = (List<ProductsItem>) getArguments().getSerializable("ProductData");
                RankingProductList = (List<ProductsItem>) getArguments().getSerializable("RankingData");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        rv_category.setLayoutManager(layoutManager);
        madapter = new RankingAdapter(productsItemList,RankingProductList,this);
        rv_category.setAdapter(madapter);
        madapter.notifyDataSetChanged();
        Constants.getAnimation(rv_category);

        return view;
    }


    @Override
    public void getProductVariantsList(ProductsItem productsItem) {

        if(productsItem.getVariants().size()>0)
            mCallback.onProductVariantsList(productsItem);
        else
            Toast.makeText(getActivity(),"No Variants available for this Product", Toast.LENGTH_LONG).show();

    }
}
