package com.vipabc.utils;


import shelper.environment.Environment;

public class Env {
	public static String qa_test_home;
	
	public Env(){
		if(System.getProperty("qa_test_home")==null){
			System.setProperty("qa_test_home", ".");
		}
		qa_test_home=System.getProperty("qa_test_home");
		Environment.set4If();
	}
	
	
}
