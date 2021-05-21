//Selenium Classes
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Excel Classes
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;//Use for .xls file extensions
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;//Use for .xlsx file extensions

//TestNG
import org.testng.annotations.*;


public class GeewizFunctions {
	
	UtilityFunction utils = new UtilityFunction();
	FunctionalLib funcLib = new FunctionalLib();
	
	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		//Setup WebDriver
		utils.SetupWebDriver();
		
		//Wait
		utils.wait(2);
	}
	
	@Test()
	public void main() throws Exception {
		// TODO Auto-generated method stub
		
		for(int x=0; x<2; x++)
		{
			//Navigate to URL
			utils.NavigateToURL("https://www.geewiz.co.za/");
			
			//Login to Site
			funcLib.Search(sSearchItem, sSortBy);
		}
	}
	
	@AfterMethod
	public void afterMethod() throws Exception
	{
		//Wait
		utils.wait(5);
		
		//Close Browser and WebDriver
		utils.CloseBrowser();
	}
}

