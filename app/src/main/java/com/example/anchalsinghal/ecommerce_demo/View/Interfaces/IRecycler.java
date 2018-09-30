package com.example.anchalsinghal.ecommerce_demo.View.Interfaces;


import com.example.anchalsinghal.ecommerce_demo.data.ProductsItem;
import com.example.anchalsinghal.ecommerce_demo.data.Response;

import java.util.List;


public interface IRecycler {

    void onCategoryShown(List<ProductsItem> productsItemList);

    void onProductVariantsList(ProductsItem productsItem);

    void getRankingList(Response rankingList);
}
