

//import excel classes
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;//Use for .xlsx file extensions
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.*;

//Import Date time classes
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataFunctions {
	
public static String DefaultPath;
public static Sheet AutomationSheet;
static FileInputStream inputStream;
static String globalFilePath;
static String globalSheetName;
	
public Sheet readExcel(String filePath, String sheetName)  throws Exception 
{
		//Get workspace path
		//DefaultPath = ("C:\\Users\\PetronellaMdukaza\\workspace\\AutomationMentorship\\src");
		DefaultPath = System.getProperty("user.dir");
		DefaultPath = DefaultPath.replace("batch", "");
		globalFilePath = filePath;
		globalSheetName = sheetName;
		
		//Create an object of FileInputStream class to read excel file
		inputStream = new FileInputStream (new File(DefaultPath + filePath));
		
		//Set Workbook to null
		@SuppressWarnings("resource")		
		Workbook AutomationWorkbook = new XSSFWorkbook(inputStream);
		
		//Read the sheet inside of the workbook
		AutomationSheet = AutomationWorkbook.getSheet(sheetName);
				
		return AutomationSheet;
		
	}
	
	public static String getExcelCellData(String Column, int iRow, Sheet sheet) throws Exception 
	{
		
		String Value = null; //A placeholder to check if it finds what you specified
		String ColValue = null;
		
		Row row = sheet.getRow(0);
		for (int i = 0; i<columnCount(sheet); i++) 
		{
			
			ColValue = row.getCell(i).getStringCellValue().trim();
			
			if(ColValue.equals(Column))
			{
				Row row1 = sheet.getRow(iRow);
				Cell cell = row1.getCell(i);
				DataFormatter formatter = new DataFormatter();
				Value = formatter.formatCellValue(cell);
				break;
		
			}	
			
		}
		
		return Value;
	}

	public static int columnCount(Sheet sheet)
	{
		int iCount = 0;
		iCount = sheet.getRow(0).getLastCellNum();
		return iCount;
	}
	
	public static int rowCount(Sheet sheet) throws Exception
	{
		
		int count = 0;
		count = sheet.getPhysicalNumberOfRows();
		return count;
	}
	
public static void writeExcel(String Column, int iRow, Sheet sheet, String sMessage) throws Exception
{
	inputStream = new FileInputStream(new File(DefaultPath + globalFilePath));
	Workbook AutomationWorkbook = new XSSFWorkbook(inputStream);
	AutomationSheet = AutomationWorkbook.getSheet(globalSheetName);
	
	Row row = AutomationSheet.getRow(0);
	
	for( int c = 0; c < columnCount(AutomationSheet); c++) 
	{
		for(int i=0; i<row.getLastCellNum();i++) 
		{
		if (row.getCell(i).getStringCellValue().trim().equals(Column))
		{
			Row row1 = AutomationSheet.getRow(iRow);
			Cell cell = row1.createCell(i);
			cell.setCellValue(sMessage);
			break;
			}
		}	
	}
	
//close inputstream
inputStream.close();

//create an object of file inputstream class to read excel file
FileOutputStream outputStream = new FileOutputStream(new File(DefaultPath + globalFilePath));


//write changes to the spreadsheet and save
AutomationWorkbook.write(outputStream);

//close outputstream
outputStream.close();
}

public static String getTimeStamp()
{

//get current time stamp
return(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));	
	
}

public String API_Elements(String sBody, String sField) throws Exception
{

	//Check sBody for '[', and remove '[' and ']'
	if(sBody.charAt(0)=='[')
	{
		//Remove '[' and ']'
		sBody = sBody.substring(1, sBody.length()-1);
	}
	
	//Create Object
	Object obj=JSONValue.parse(sBody);
	
	//Create JSON Object
	JSONObject jsonObject = (JSONObject) obj;    
    
    //Return the value to main function
    return jsonObject.get(sField).toString();  
}

public int CountNumberOfOccuringChar(String sTemp, char sChar)
{
	//Set iCount to 0
	int iCount = 0;
	
	for(int i=0;i<sTemp.length();i++)
    {
		if(sTemp.charAt(i) == sChar)
		{
			//Increment iCount
			iCount++;
		}
    }
	//Return iCount to main function
	return iCount;
}

public boolean DataCompareAPI(String sTestActual, String sTestExpected) 
{
	boolean bDataCheck = false;
	
	//Check sBody for '[', and remove '[' and ']'
	if(sTestActual.charAt(0)=='[')
	{
		//Remove '[' and ']'
		sTestActual = sTestActual.substring(1, sTestActual.length()-1);
		
		//Split string and store in the array
		String [] arr = sTestActual.split("\",\"");
		
		//Run through the elements of the array
		for(int i=0;i<=arr.length-1;i++)
		{
			//Replace '"' with ''
			arr[i] = arr[i].replace("\"", "");
			
			//Check if Actual equals Expected
			if(arr[i].equalsIgnoreCase(sTestExpected))
			{
				//Update bDataCheck
				bDataCheck = true;
			}
		}
	}
	else
	{
		//Check if Actual equals Expected
		if(sTestActual.equalsIgnoreCase(sTestExpected))
		{
			//Update bDataCheck
			bDataCheck = true;
		}
	}
		
	//Return bDataCheck to main function
	return bDataCheck;



}

}
