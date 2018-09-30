package com.example.anchalsinghal.ecommerce_demo.data;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class Tax implements Serializable{

	@SerializedName("name")
	private String name;

	@SerializedName("value")
	private double value;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setValue(double value){
		this.value = value;
	}

	public double getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"Tax{" + 
			"name = '" + name + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}