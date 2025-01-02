package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class CalciService {

	public double add(double num1, double num2) {
		return num1+num2;
	}
	
	public double sub(double num1, double num2) {
		return num1-num2;
	}
	
	public double mul(double num1, double num2) {
		return num1*num2;
	}
	
	public double div(double num1, double num2) {
		if(num2 == 0) {
			throw new ArithmeticException("Division by zero is not Allowed");
		}
		return num1/num2;
	}
	
	public double mod(double num1, double num2) {
		return num1%num2;
	}
	
	public double sqr(double num1, double num2) {
		return Math.pow(num1, num2);
	}
}
