package com.example.anchalsinghal.ecommerce_demo.data;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class VariantsItem implements Serializable{

	@SerializedName("color")
	private String color;

	@SerializedName("size")
	private String size;

	@SerializedName("price")
	private int price;

	@SerializedName("id")
	private int id;

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"VariantsItem{" + 
			"color = '" + color + '\'' + 
			",size = '" + size + '\'' + 
			",price = '" + price + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}