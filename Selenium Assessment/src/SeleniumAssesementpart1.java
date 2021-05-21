import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 

public class SeleniumAssesementpart1 {
    
    public static void main(String[] args)throws Exception  {
        // TODO Auto-generated method stub

 

        //Initialize the ChromeDriver
        System.setProperty("webdriver.chrome.driver","C:\\Sellenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
		
		
		
		//Navigate to the URL
		driver.get("https://www.geewiz.co.za/");

				
		//Maximize Browser window
		driver.manage().window().maximize();
		
		
		//wait 5 seconds
		Thread.sleep(5000);
				
		//Enter Search Item 
		driver.findElement(By.xpath("//*[@id='search_widget']/form/input[2]")).click();
				
		//wait 5 seconds
		Thread.sleep(5000);
		
		//Type in Search Item 
		driver.findElement(By.xpath("//*[@id='search_widget']/form/input[2]")).sendKeys("cellphone");
		
		//wait 5 seconds
		Thread.sleep(5000);
		//c.Click on the Magnifying glass button
		driver.findElement(By.xpath("//*[@id='search_widget']/form/button")).click();
		
		
		//wait 5 seconds
		Thread.sleep(5000);
		//d.Select in the "Sort By" drop down list e.g., "Price: Lowest first“
		driver.findElement(By.xpath("//*[@id='js-product-list-top']/div/div[2]/div/div/div/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='js-product-list-top']/div/div[2]/div/div/div/div/a[5]")).click();
		
		//wait 5 seconds
		Thread.sleep(5000);
        //e.Click on the First result
		driver.findElement(By.xpath("//*[@id='js-product-list']/div/div/div/div[1]/article/div/div[2]/h3/a")).click();
		
		
		//wait 5 seconds
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
		Thread.sleep(2000);
		
		//f.Enter quantity in the "Quantity" text field greater than 15 e.g., “20"
		 JavascriptExecutor js1 = (JavascriptExecutor)driver;
         js1.executeScript("document.getElementById('quantity_wanted').value='17'");

         
         
         
         
		//wait 5 seconds
		Thread.sleep(5000);
		//g.Click on the "Add to cart" button
		driver.findElement(By.xpath("//*[@id='add-to-cart-or-refresh']/div[3]/div[1]/div[2]/button[1]")).click();
		
		 

		
		//wait 5 seconds
		Thread.sleep(5000);
		//i.Click on the "Continue shopping" button, when the pop up appears
		driver.findElement(By.xpath("//*[@id='product_confirmation_modal']/div[2]/button[1]")).click();
		

		
		//wait 5 seconds
		Thread.sleep(5000);
		//g.Click on the Cart
		driver.findElement(By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/div/button")).click();
		
		
		//Close WebDriver
		//driver.close();
				
				
		//Close Browser
		//driver.quit();
		
		
		WebElement titleValidation  = driver.findElement(By.xpath("//*[@id='main']/div/div[1]/div/div[2]/ul/li[2]/div/div[4]/div/div[2]/div/div[2]/span/strong"));
		 
		if (titleValidation.isDisplayed())
		{
			System.out.print("is  greater than R10,000");
		}
		else
		{
			System.out.print("is less than R10,000");	
			
		}
		
		//VAlidating the Actual the Actual and expected 
		String expectedText= "R10,000"; 
		
		String actualText = titleValidation.getText();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

