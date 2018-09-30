package com.example.anchalsinghal.ecommerce_demo.data;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class RankingsItem implements Serializable{

	@SerializedName("ranking")
	private String ranking;

	@SerializedName("products")
	private List<ProductsItem> products;

	public void setRanking(String ranking){
		this.ranking = ranking;
	}

	public String getRanking(){
		return ranking;
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
			"RankingsItem{" + 
			"ranking = '" + ranking + '\'' + 
			",products = '" + products + '\'' + 
			"}";
		}
}