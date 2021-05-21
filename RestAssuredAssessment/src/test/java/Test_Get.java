import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_Get {
@Test
 void test_01(){

	
	Response response = RestAssured.get("http://restcountries.eu/rest/v1/name");


	System.out.println(response.asString());
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
	System.out.println(response.getHeader("content-type"));
	System.out.println(response.getTime());


	
	
	
	
	
	
	
	
	
	
	
	
}
}
