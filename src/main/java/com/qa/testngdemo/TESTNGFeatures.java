package com.qa.testngdemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TESTNGFeatures {
	
	// global pre-conditions
	// pre - conditions
	
	
@BeforeSuite	
public void beforeSuite() {
	
	System.out.println("BEFORE SUITE --");
		
	}
@AfterSuite
public void afterSuite() {
	
	System.out.println("AFTER SUITE --");

	
}
@BeforeMethod
public void beforeMethod() {
	System.out.println("BEFORE METHOD--");
}
@AfterMethod
public void afterMethod() {
	System.out.println("After method---");
	
	
}
@BeforeClass
public void beforeClass() {
	System.out.println("Before class ---");
	
}@AfterClass
public void afterClass() {
	System.out.println("After Class--");
}
@Test
public void addition() {
	int a = 2;
	int b = 3;
	int c = a + b;
	
	System.out.println(c);
	
}
@Test
public void stringConcat() {
	
	String abc = "I love you.....";
	String def = "just kidding";
	
	System.out.println(abc + def);
	
}
@Test
public void abcMethod() {
	System.out.println("This is the abc method...");
	
}@BeforeTest
public void beforeTest() {
	System.out.println("Before test--");
}@AfterTest	
public void afterTest() {
	System.out.println("After test--");
}


}


