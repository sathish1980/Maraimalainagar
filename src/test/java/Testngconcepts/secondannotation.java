package Testngconcepts;

import org.testng.annotations.*;

public class secondannotation 
{
	@Test(groups={"sanity","REG"},timeOut=60,priority=2)
	public void Testcase1()
	{
		System.out.println("Testcase1 in second class");
		throw new ArithmeticException("error");
	}
	@BeforeSuite(groups="sanity")
	public void beforesuite()
	{
		System.out.println("Before Suite");
	}
	
	@Test(priority=0,groups="REG",dependsOnMethods="Testcase1",enabled=true,description="login",invocationCount=5,invocationTimeOut=60)
	public void Testcase2()
	{
		System.out.println("Testcase2 in second class");
	}
	
	@Test(priority=1,groups="REG")
	public void Testcase3()
	{
		System.out.println("Testcase3 in second class");
		String output="Done";
		//Assert.assertEquals(output,"done","actual and expected is not matched");
	}
	
	@BeforeClass(alwaysRun=true)
	public void beforeclass()
	{
		System.out.println("Before class in second class");
	}
	
}
