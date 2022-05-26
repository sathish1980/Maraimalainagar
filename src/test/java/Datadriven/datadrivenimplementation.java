package Datadriven;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.ExcelRead;

public class datadrivenimplementation 
{
	@DataProvider(name="facebooklogin")
	public Object[][] datadrivenfromexcel() throws IOException 
	{
		return ExcelRead.read();
	}

}
