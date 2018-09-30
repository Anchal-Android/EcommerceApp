package com.example.anchalsinghal.ecommerce_demo.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anchalsinghal.ecommerce_demo.R;
import com.example.anchalsinghal.ecommerce_demo.data.ProductsItem;
import com.example.anchalsinghal.ecommerce_demo.data.VariantsItem;

import java.util.List;

public class VariantAdapter extends RecyclerView.Adapter<VariantAdapter.ViewHolder> {

    private ProductsItem values;

    private List<VariantsItem> variantsItemList;


    public VariantAdapter(ProductsItem values) {
        this.values = values;
        variantsItemList = values.getVariants();

    }

    @NonNull
    @Override
    public VariantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.listview_product_variants, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VariantAdapter.ViewHolder holder, final int position) {

        try {

            if (!variantsItemList.get(position).getColor().equalsIgnoreCase("") &&
                    variantsItemList.get(position).getColor() != null) {

                holder.tv_color.setVisibility(View.VISIBLE);
                String color = variantsItemList.get(position).getColor();
                holder.tv_color.setText(color);
            }
            else
            {
                holder.tv_color.setVisibility(View.GONE);
            }

            if (variantsItemList.get(position).getSize()!=null) {

                holder.tv_size.setVisibility(View.VISIBLE);
                String size = "Size: " + variantsItemList.get(position).getSize();
                holder.tv_size.setText(size);
            }
            else
            {
                holder.tv_size.setVisibility(View.GONE);
            }

            if (variantsItemList.get(position).getPrice() != 0) {
                holder.tv_price.setVisibility(View.VISIBLE);

                String price = "Price: " + variantsItemList.get(position).getPrice() + " + " +
                        values.getTax().getValue() + " " + values.getTax().getName();
                holder.tv_price.setText(price);
            }
            else
            {
                holder.tv_price.setVisibility(View.GONE);
            }
            holder.layout.setTag(position);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return variantsItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_color, tv_size, tv_price;

        public View layout;

        ViewHolder(View v) {
            super(v);
            layout = v;
            tv_color = v.findViewById(R.id.tv_color);
            tv_size = v.findViewById(R.id.tv_size);
            tv_price = v.findViewById(R.id.tv_price);

        }
    }
}
