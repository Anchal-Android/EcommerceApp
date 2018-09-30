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
import android.widget.TextView;
import android.widget.Toast;


import com.example.anchalsinghal.ecommerce_demo.Adapter.CategoryAdapter;
import com.example.anchalsinghal.ecommerce_demo.Model.NetworkManager;
import com.example.anchalsinghal.ecommerce_demo.Presenter.PresenterClass;
import com.example.anchalsinghal.ecommerce_demo.R;
import com.example.anchalsinghal.ecommerce_demo.Utils.Constants;
import com.example.anchalsinghal.ecommerce_demo.View.Interfaces.IRecycler;
import com.example.anchalsinghal.ecommerce_demo.View.Iview;
import com.example.anchalsinghal.ecommerce_demo.data.ProductsItem;
import com.example.anchalsinghal.ecommerce_demo.data.Response;

import java.util.List;


public class CategoryFragment extends Fragment implements Iview, View.OnClickListener {

Response assesmentList;
private PresenterClass presenterActivity;

    RecyclerView rv_category;

    public CategoryAdapter madapter;
    public RecyclerView.LayoutManager layoutManager;

    IRecycler mCallback;
    TextView tv_filter;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_categorylist,container,false);
        tv_filter = getActivity().findViewById(R.id.tv_filter);
        rv_category = view.findViewById(R.id.rv_category);

        presenterActivity = new PresenterClass(this,new NetworkManager(getActivity()));
        assesmentList();

        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rv_category.setLayoutManager(layoutManager);
        tv_filter.setOnClickListener(this);
        return view;
    }


    @Override
    public void assesmentList() {

         presenterActivity.callApi();

    }

    @Override
    public void getList(Response assesmentList) {

        this.assesmentList = assesmentList;

        madapter = new CategoryAdapter(assesmentList,this);
        rv_category.setAdapter(madapter);
        madapter.notifyDataSetChanged();
        Constants.getAnimation(rv_category);
    }

    @Override
    public void getProductList(List<ProductsItem> productlist) {

        if(productlist.size()>0)
        mCallback.onCategoryShown(productlist);
        else
        {
            Toast.makeText(getActivity(),"No Products available for this Category",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.tv_filter:

                mCallback.getRankingList(assesmentList);
                break;
        }

    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
