package com.ttylink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListParamTest {

	public static void resetList(List<Integer> dataList){
		dataList.subList(2,4).set(0,40);
		System.err.println("r0___"+dataList.toString()+dataList.toArray());
		dataList=new ArrayList<Integer>(dataList);
		System.err.println("r1___"+dataList.toString()+dataList.toArray());
		dataList.add(50);
		System.err.println("r2___"+dataList.toString());
		
	}
	public static void setOne(List<Integer> dataList){
		System.err.println("3___"+dataList.toString());
		dataList.set(3,100);
		System.err.println("4___"+dataList.toString());
	}

	public static void main(String[] args){
		List<Integer> dataList=new ArrayList<Integer>(Arrays.asList(10,20,30,null));
		System.err.println(dataList.toString()+dataList.toArray());
		resetList(dataList);
		System.err.println("1___"+dataList.toString()+dataList.toArray());
		setOne(dataList);
		System.err.println("2___"+dataList.toString());
		int sum=0;
		for(Integer v:dataList){
			sum+=v;
		}
		System.out.println(sum);
	}
	
}