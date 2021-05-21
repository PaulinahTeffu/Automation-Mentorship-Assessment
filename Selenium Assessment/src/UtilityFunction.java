import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.net.Urls;
import org.testng.Reporter;
import org.testng.internal.ReporterConfig;

public class UtilityFunction{
	
	boolean bStepCheck;
	String sStatus;
	
	public static String sURL;
	public static String sSearchItem;
	public static String sSortBy;
	public static String sQuantity;
	

	
public static int iIteration;
	public static Sheet sheetGlobal;
	public static TakesScreenshot driver;
	
	UtilityFunction utils = new UtilityFunction();
	ExtendedReport repo = new ExtendedReport();
	
	public void NavigateToURL(Sheet sheet, int i) throws Exception
	{
		//Set iIteration to i
		iIteration = i;
		
		//Set sheetGlobal to sheet
		sheetGlobal = sheet;
		
		sURL = Datafunctions.getExcelCellData("URL", i, sheet);
		
		//Navigate to the URL
		utils.NavigateToURL(sURL);
		
		//Validate Navigation to URL
		repo.ReportStep("Search", "SearchItem", "Navigate to URL");
	}
	
	private void NavigateToURL(String sURL2) {
		// TODO Auto-generated method stub
		
	}

	public void Login(Sheet sheet, int i) throws Exception
	{
		sSearchItem = Datafunctions.getExcelCellData("Cellphone", i, sheet);
		sSortBy= Datafunctions.getExcelCellData("High  to  low", i, sheet);
		sQuantity = Datafunctions.getExcelCellData("17", i, sheet);
		
		// Capture User name
		Urls.urlEncode(sURL);
		//Select from the 'Sortby' DropDown
		utils.SelectDropDownVisibleText("Searchitem", "sSortBy", Datafunctions.getExcelCellData("SortBy", i, sheet));
		
		
		//Select from the 'ArrivingTo' DropDown
		utils.SelectDropDownVisibleText("Searchitem", "Quantity", Datafunctions.getExcelCellData("Quantity", i, sheet));
		
		// Click the Add to Cart
		utils.ClickObject("Searchitem","add-to-cart-or-refresh");
		
		//Validate Add to Cart
				repo.ReportStep("xpath", "//button[@id='blockcart-modal']", "Click Add to cart");;
	}

	private void SelectDropDownVisibleText(String string, String string2, String excelCellData) {
		// TODO Auto-generated method stub
		
	}

	public void SetupWebDriver() {
		// TODO Auto-generated method stub
		
	}

	public void EnterText(String string, String string2, String ssearchitem2) {
		// TODO Auto-generated method stub
		
	}

	public static boolean waitForElement(String sObject, String sIdentifier) {
		// TODO Auto-generated method stub
		return false;
	}

	public void ClickObject(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
	
	

	}


