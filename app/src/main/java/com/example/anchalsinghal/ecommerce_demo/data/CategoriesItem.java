package com.example.anchalsinghal.ecommerce_demo.data;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class CategoriesItem{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("child_categories")
	private List<Object> childCategories;

	@SerializedName("products")
	private List<ProductsItem> products;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setChildCategories(List<Object> childCategories){
		this.childCategories = childCategories;
	}

	public List<Object> getChildCategories(){
		return childCategories;
	}

	public void setProducts(List<ProductsItem> products){
		this.products = products;
	}

	public List<ProductsItem> getProducts(){
		return products;
	}

	@Override
 	public String toString(){
		return 
			"CategoriesItem{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",child_categories = '" + childCategories + '\'' + 
			",products = '" + products + '\'' + 
			"}";
		}
}