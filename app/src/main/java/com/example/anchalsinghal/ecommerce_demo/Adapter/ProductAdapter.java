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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<ProductsItem> values;
    
    private IProduct listener;

    public ProductAdapter(List<ProductsItem> values, IProduct listener) {
        this.values = values;
        this.listener = listener;
       
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.listview_category_holder, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductAdapter.ViewHolder holder, int position) {

        try {

            holder.tv_categories.setText(values.get(position).getName());

            holder.layout.setTag(position);
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.getProductVariantsList(values.get(holder.getAdapterPosition()));

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return values.size();
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
