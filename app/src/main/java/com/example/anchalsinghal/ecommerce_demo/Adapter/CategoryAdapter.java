package com.example.anchalsinghal.ecommerce_demo.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anchalsinghal.ecommerce_demo.R;
import com.example.anchalsinghal.ecommerce_demo.View.Iview;
import com.example.anchalsinghal.ecommerce_demo.data.CategoriesItem;
import com.example.anchalsinghal.ecommerce_demo.data.ProductsItem;
import com.example.anchalsinghal.ecommerce_demo.data.RankingsItem;
import com.example.anchalsinghal.ecommerce_demo.data.Response;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Response values;
    private List<CategoriesItem> categoryList;



    private Iview listener;

    public CategoryAdapter(Response values, Iview listener) {
        this.values = values;
        categoryList = this.values.getCategories();
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.listview_category_holder, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryAdapter.ViewHolder holder, int position) {

        try {
            Log.e("categoryitem", categoryList.get(position).getName());
            holder.tv_categories.setText(categoryList.get(position).getName());

            holder.layout.setTag(position);
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    List<ProductsItem> productList = categoryList.get(holder.getAdapterPosition()).getProducts();
                    listener.getProductList(productList);

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
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
