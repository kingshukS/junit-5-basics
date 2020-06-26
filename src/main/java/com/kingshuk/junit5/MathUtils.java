package com.kingshuk.junit5;

public class MathUtils {
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public int subtraction(int a, int b) {
		return a-b;
	}
	
	public int multiply(int a, int b) {
		return a*b;
	}
	
	public int divide(int a, int b) {
		return a/b;
	}
	
	public int rem(int a, int b) {
		return a%b;
	}
	
	public double calculateCircleArea(double radius) {
		return Math.PI*radius*radius;
	}
	
	public String checkStringParameter(String str) {
		return str;
	}
}
