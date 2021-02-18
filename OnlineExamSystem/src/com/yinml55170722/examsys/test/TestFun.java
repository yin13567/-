package com.fuhao55170725.examsys.test;

public class TestFun {
	//排序算法
	private double[] sortD(double[] datas){
		double[]res=new double[datas.length];
		for(int i=0;i<datas.length;i++) {
			res[i]=datas[i];
		}
		while(true) {
			boolean ordered=true;
			for(int i=0;i<res.length-1;i++) {
				if(res[i]-res[i+1]>0) {
					double tmp=res[i];
					res[i]=res[i+1];
					res[i+1]=tmp;
					ordered=false;
				}
			}
			if(ordered) {break;}
		}
		return res;
	}
		//从数组中找到第一个数字的位置
		private int findIndex(double[]list, double num) {
			for(int i=0;i<list.length;i++) {
				if(list[i]-num==0) {
					return i;
				}
			}
			return -1;
		}
		
		private int[] genRandom(int bign,int smalln) {//从0到bign-1中产生smalln的随机数
			double[]randomFloat=new double[bign];
			int[]res=new int[smalln];
			System.out.println("产生的随机数如下:");
			for(int i=0;i<bign;i++) {
				randomFloat[i] = Math.random();
				System.out.println(randomFloat[i]);
			}
			double[] sorteddata=sortD(randomFloat);
			System.out.println("排序之后如下:");
			for(int i=0;i<bign;i++) {
				System.out.println(sorteddata[i]);
			}
			
			for(int i=0;i<smalln;i++) {
				res[i]=findIndex(randomFloat,sorteddata[i]);			
			}
			return res;
		}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int res[]=new TestFun().genRandom(20,11);
		for(int i=0;i<res.length;i++) {
			System.out.println(res[i]);
		}
	}

}
