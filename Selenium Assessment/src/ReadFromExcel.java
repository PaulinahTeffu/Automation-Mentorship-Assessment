import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel  {

	public static Object automationSheet;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Declare variables
		String sDefaultPath;
		
		//Get Workspace path
		sDefaultPath = System.getProperty("user.dir");
        sDefaultPath = sDefaultPath.replace("batch", "");
        
        //Print out to Console
        System.out.println("The file path for the workspace is: "+sDefaultPath);
		
        //Call the function to read the excel file from the path located within the framework
		readExcel(sDefaultPath + "\\TestData\\TestData.xlsx","Sheet1");
		
        //Call the function to write to the excel file from the path located within the framework
		writeExcel(sDefaultPath + "\\TestData\\TestData.xlsx","Sheet1");
	}
	
	public static void readExcel(String filePath, String sheetName) throws IOException
	{
		//create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		
		//Set Workbook to null
		Workbook mentorshipWorkbook = new XSSFWorkbook(inputStream);
		
		//Read the sheet inside of the workbook
		Sheet automationSheet = mentorshipWorkbook.getSheet(sheetName);
		
		//Find the number of rows in the excel sheet
		int rowCount = automationSheet.getLastRowNum() - automationSheet.getFirstRowNum();
		
		//Print out to Console the number of Rows (excluding the first row)
		System.out.println("The total number of row are: " + rowCount);
		
		//Create a loop over all the rows of excel file to read it 
		for(int x = 0; x < rowCount+1; x++)
		{
			Row row = automationSheet.getRow(x);
			
			//Create a loop to print cell values  in a row
			for(int y=0; y < row.getLastCellNum(); y++)
			{
				System.out.print(row.getCell(y).getStringCellValue()+ " || ");
			}
			System.out.println();
		}
		
		inputStream.close();
	}
	
	public static void writeExcel(String filePath, String sheetName) throws IOException
	{
		//create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		
		//Set Workbook to null
		Workbook mentorshipWorkbook = new XSSFWorkbook(inputStream);
		
		//Read the sheet inside of the workbook
		Sheet automationSheet = mentorshipWorkbook.getSheet(sheetName);
		
		//Find the number of rows in the excel sheet
		int rowCount = automationSheet.getLastRowNum() - automationSheet.getFirstRowNum();
		
		//Print out to Console the number of Rows (excluding the first row)
		System.out.println("The total number of row are: " + rowCount);
		
		//Create a loop over all the rows of excel file to read it 
		for(int x = 0; x < rowCount+1; x++)
		{
			//Set the Row to use
			Row row = automationSheet.getRow(x);
			
			//Create a loop to print cell values  in a row
			for(int y=0; y < row.getLastCellNum(); y++)
			{
				//Checks if the Cell values equals the criteria listed below
				if(row.getCell(y).getStringCellValue().equals("Price"))
				{
					//Row rowNew = automationSheet.getRow(x);
					Cell cell = row.createCell(y);
					cell.setCellValue("R271,655,08");
				}
				System.out.print(row.getCell(y).getStringCellValue()+ " || ");
			}
			System.out.println();
		}
		
		//Close InputStream
		inputStream.close();
		
		//create an object of FileInputStream class to read excel file
		FileOutputStream outputStream = new FileOutputStream(new File(filePath));
		
		//Write changes to Spreadsheet and Save
		mentorshipWorkbook.write(outputStream);
		
		//Close OutputStream
		outputStream.close();
	}

	public static String getTimeStamp() {
		// TODO Auto-generated method stub
		return null;
	}

}
