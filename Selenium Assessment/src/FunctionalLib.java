i
public class FunctionalLib{
	
	private static final String sSearchItem = null;
	public static int iIteration;
	UtilityFunction utils = new UtilityFunction();
	private Object sSortBy;
	private Object sQuantity;
	
	public void Search(String sUsername, String sPassword) throws Exception
	{
		// Capture Search item 
		utils.EnterText("Search", "userName", sSearchItem);
		
		// Capture the SortBy
		utils.EnterText("Search", "17",(String) sSortBy);
		// Capture the SortBy
				utils.EnterText("Search", "17",(String) sQuantity);
		
		// Click add to to  continue Cart  Submit Button
		utils.ClickObject("Search","submit");
		
		// Click the Submit Button
		utils.ClickObject("name","submit");
				
		
		utils.wait(5);
	}

}
