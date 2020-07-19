package com.offcn.model;

import java.util.Vector;
import java.util.List;

public class Model {
	int value; //权值
	int num;// 手数 (几次能够走完，没有挡的情况下)
	public List<String> a1=new Vector<String>(); //单张
	public List<String> a2=new Vector<String>(); //对子
	public List<String> a3=new Vector<String>(); //3带
	public List<String> a123=new Vector<String>(); //连子
	public List<String> a112233=new Vector<String>(); //连牌
	public List<String> a111222=new Vector<String>(); //飞机
	public List<String> a4=new Vector<String>(); //炸弹
}
