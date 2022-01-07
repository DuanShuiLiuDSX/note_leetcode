package com.company.oopTest;
//考查多态的笔试题目：

class Base1 {
	public void add(int a, int... arr) {
		System.out.println("base");
	}
}

class Sub1 extends Base1 {

	public void add(int a, int[] arr) {
		System.out.println("sub_1");
	}

	public void add(int a, int b, int c) {
		System.out.println("sub_2");
	}

}

public class InterviewTest1 {

	public static void main(String[] args) {
		Base1 base1 = new Sub1();
		base1.add(1, 2, 3);

//		Sub s = (Sub)base;
//		s.add(1,2,3);
	}
}



