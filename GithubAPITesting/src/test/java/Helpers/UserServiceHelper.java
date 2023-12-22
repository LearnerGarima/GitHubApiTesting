package Helpers;

import Constants.EndPoints;
import Utilities.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserServiceHelper {

	public static String getBaseURI() 
	{  
		
	String baseURI= Utils.getConfigProperty("baseURL");
	return baseURI;
  	
    }
	public static String gettoken()
	{
		String token= Utils.getConfigProperty("token");
		return token;
		
	}
	public static String getOwnerName()
	{
		String owner= Utils.getConfigProperty("owner");
		return owner;
		
	}
	
	public static String getRepoName()
	{
		String repoName= Utils.getConfigProperty("repoName");
		return repoName;
		
	}
	
	public static String getErrorMsg()
	{
		String message= Utils.getConfigProperty("errorMessage");
		return message;
		
	}
	
	public static String getMessageNotFound()
	{
		String message= Utils.getConfigProperty("message");
		return message;
		
	}
	
	
	
	public static Response getSingleRepoTestCase1() {
	    String mytoken = UserServiceHelper.gettoken();
	    System.out.println(mytoken);
	    Response response = RestAssured.given().contentType("application/json").header("Authorization","Bearer" +mytoken)
	            .pathParam("owner",getOwnerName())
	            .when()
	            .get(EndPoints.GET_SINGLE_REPOS);

	    response.prettyPrint();
	    return response;

	}

	
	public static Response getSingleRepoNegative() {
	    String mytoken = UserServiceHelper.gettoken(); 
	    System.out.println(mytoken);
	    Response response = RestAssured.given().contentType("application/json")
	            .header("Authorization","Bearer" +mytoken)
	            .pathParam("owner",getOwnerName())

	            .when().get(EndPoints.GET_NEG_TEST_SINGLE_REPOS);
	    response.prettyPrint();
	    return response;

	}

	
	public static Response createRepoTestCase4() {
	    String mytoken = UserServiceHelper.gettoken();
	    
	    System.out.println(mytoken);

	    Response response = RestAssured.given().contentType("application/json")
	            
	            .body(ReusableMethods.getCreateSingleRepo()).auth().oauth2(mytoken).when().post(EndPoints.CREATE_REPOS);
	    response.prettyPrint();
	    return response;

	}

	public static Response updateRepo() {
	    String mytoken = UserServiceHelper.gettoken();
	    
	    System.out.println(mytoken);

	    Response response = RestAssured.given().contentType("application/json")
	            .pathParam("owner",getOwnerName())
	            .body(ReusableMethods.getUpdateSingleRepo()).header("Authorization","Bearer" +mytoken).when()
	            .patch(EndPoints.UPDATE_REPOS);
	    response.prettyPrint();
	    return response;
	}

	public static Response deleteRepo() {
	    String mytoken = UserServiceHelper.gettoken();
	   
	    System.out.println(mytoken);

	    Response response = RestAssured.given().contentType("application/json")
	            .pathParam("owner",getOwnerName())
	            .header("Authorization","Bearer" +mytoken)

	            .when().delete(EndPoints.DELETE_REPOS);
	    response.prettyPrint();
	    return response;
	}

	
 }

