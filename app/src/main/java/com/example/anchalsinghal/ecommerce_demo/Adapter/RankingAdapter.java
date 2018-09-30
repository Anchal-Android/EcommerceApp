package com.example.anchalsinghal.ecommerce_demo.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anchalsinghal.ecommerce_demo.R;

import com.example.anchalsinghal.ecommerce_demo.View.Interfaces.IProduct;
import com.example.anchalsinghal.ecommerce_demo.data.ProductsItem;

import java.util.List;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {


    private List<ProductsItem> productsItemList;
    private List<ProductsItem> productListToView;
   

    private IProduct listener;


    public RankingAdapter(List<ProductsItem> productListToView, List<ProductsItem> productsItemList, IProduct listener) {
        this.productListToView = productListToView;
        this.productsItemList = productsItemList;
this.listener = listener;

    }

    @NonNull
    @Override
    public RankingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.listview_category_holder, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RankingAdapter.ViewHolder holder, final int position) {

        try {

            boolean flag = false;
            int id = -1;
            for(int i=0; i<productListToView.size();i++)
            {
                if(productListToView.get(i).getId()== productsItemList.get(position).getId())
                {
                    flag = true;
                    id=i;
                    break;
                }

            }
            if(flag)
            holder.tv_categories.setText(productListToView.get(id).getName());

            holder.layout.setTag(position);

            final int finalId = id;
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.getProductVariantsList(productListToView.get(finalId));

                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return productsItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_categories;
       

        public View layout;

        ViewHolder(View v) {
            super(v);
            layout = v;
            tv_categories = v.findViewById(R.id.tv_categories);
            


        }
    }
}
