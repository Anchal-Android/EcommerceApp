package com.example.anchalsinghal.ecommerce_demo.data;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@SerializedName("rankings")
	private List<RankingsItem> rankings;

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	public void setRankings(List<RankingsItem> rankings){
		this.rankings = rankings;
	}

	public List<RankingsItem> getRankings(){
		return rankings;
	}

	public void setCategories(List<CategoriesItem> categories){
		this.categories = categories;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"rankings = '" + rankings + '\'' + 
			",categories = '" + categories + '\'' + 
			"}";
		}
}