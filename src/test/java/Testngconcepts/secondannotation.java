package Testngconcepts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class secondannotation 
{
	@Test
	public void Testcase1()
	{
		System.out.println("Testcase1 in second class");
	}
	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("Before Suite");
	}
	
	@Test
	public void Testcase2()
	{
		System.out.println("Testcase2 in second class");
	}
	
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Before class in second class");
	}
	
}
