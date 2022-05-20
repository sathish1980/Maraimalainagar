package Testngconcepts;

import org.testng.annotations.*;

public class Annatotate {
	
	
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("After Suite");
	}

	@BeforeTest
	public void beforetest()
	{
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void aftertest()
	{
		System.out.println("After test");
	}
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Before class");
	}
	
	@AfterClass
	public void afterclass()
	{
		System.out.println("After Class");
	}
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After method");
	}
	
	@Test(priority=1)
	public void Testcase1()
	{
		System.out.println("Testcase1");
	}

	@Test(priority=0)
	public void Testcase2()
	{
		System.out.println("Testcase2");
	}
	
}
