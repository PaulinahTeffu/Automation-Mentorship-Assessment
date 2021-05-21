//Excel Classes
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;//Use for .xlsx file extensions


public class Datafunctions {
	//Declare variables
	public String sDefaultPath;
	public Sheet automationSheet;
	
	
	public Sheet readExcel(String filePath, String sheetName) throws Exception
	{

		//Get Workspace path
		sDefaultPath = System.getProperty("user.dir");
	    sDefaultPath = sDefaultPath.replace("batch", "");
		
		//create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(new File(sDefaultPath + filePath));
		
		//Set Workbook to null
		Workbook mentorshipWorkbook = new XSSFWorkbook(inputStream);
		
		//Read the sheet inside of the workbook
		automationSheet = mentorshipWorkbook.getSheet(sheetName);
		
		return automationSheet;
	}
	
	public static String getExcelCellData(String sColumn, int iRow, Sheet sheet) throws Exception
	{
		String sValue = null;
		String sColValue = null;
		
		Row row = sheet.getRow(0);
		for(int i=0;i<columnCount(sheet);i++)
		{
			sColValue = row.getCell(i).getStringCellValue().trim();
			
			if(sColValue.equals(sColumn))
			{
				Row row1 = sheet.getRow(iRow);
				Cell cell = row1.getCell(i);
				DataFormatter formatter = new DataFormatter();
				sValue = formatter.formatCellValue(cell);
				break;
			}
			
		}
		return sValue;
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

	public boolean DataCompareAPI(String sTestActual, String sTestExpected) {
		// TODO Auto-generated method stub
		return false;
	}

}
