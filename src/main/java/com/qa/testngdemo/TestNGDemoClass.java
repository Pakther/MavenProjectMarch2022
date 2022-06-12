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

public class TestNGDemoClass {

	
@BeforeSuite
public void beforeSuite() {
	
	System.out.println("This is the before suite method");
	
	
}
@BeforeTest
public void beforeTest() {
	System.out.println("This is the before test method");

	
	
}
@BeforeClass
public void beforeClass() {
	System.out.println("This is the before class method");

}
@BeforeMethod
public void beforeMethod() {
	
	System.out.println("This is the before method ");

	
}
@Test (priority = -1)
public void testMethod1() {
	System.out.println("Test A");
	
	
}
@Test(priority = 0)
public void testMethod2() {
	System.out.println("Test B");
	
}
@Test(priority = 4)
public void testMethod3() {
	System.out.println("Test C");
}
@Test(priority = 3)
public void testMethod4() {

	System.out.println("Test D");
	
}


@AfterMethod
public void afterMethod() {
	System.out.println("This is the after method");
	
}
@AfterClass
public void afterClass() {
	System.out.println("This is the after class method");

	
}
@AfterTest
public void afterTest() {
	System.out.println("This is the after test method");

	
	
}
@AfterSuite
public void afterSuite() {
	System.out.println("This is the after suite method");
 
	
}


}
