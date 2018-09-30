package com.example.anchalsinghal.ecommerce_demo.View;


import com.example.anchalsinghal.ecommerce_demo.data.ProductsItem;
import com.example.anchalsinghal.ecommerce_demo.data.Response;

import java.util.List;


public interface Iview {

     void assesmentList();
    void getList(Response assesmentList);

    void getProductList(List<ProductsItem> productlist);


}

