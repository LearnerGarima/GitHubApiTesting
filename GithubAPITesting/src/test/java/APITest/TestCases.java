package APITest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import Helpers.ReusableMethods;
import Helpers.UserServiceHelper;
import Constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCases extends UserServiceHelper {

	static RequestSpecification myspec;

	
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = getBaseURI();
		
	}

@Test 
	public static void getSingleRepoTestCase1() {
		// TODO Auto-generated method stub
		Response response = getSingleRepoTestCase1();
		ReusableMethods.verifyStatusCode(response, 200);
		Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
		
		JsonPath jsonObj = response.body().jsonPath();
		System.out.println("full Name " + jsonObj.get("full_name"));
		Assert.assertEquals(jsonObj.get("default_branch"), "main");
	}

	@Test
	private static void getSingleRepoTestCase2() {
		// TODO Auto-generated method stub9
		Response response = getSingleRepoNegative();
		ReusableMethods.verifyStatusCode(response, 404);
		JsonPath jsonObj = response.body().jsonPath();
		Assert.assertEquals(jsonObj.get("default_branch"), "Not Found");

	}

	@Test()
	public void getAllReposSchema() {
		String mytoken = UserServiceHelper.gettoken();
	
		System.out.println(myspec);
		System.out.println(mytoken);
        Response response =RestAssured
		.given().log().all()   //logging the info
		.header("Authorization","Bearer" +mytoken)
		.spec(myspec)
		.when()
		.get(EndPoints.GET_ALLREPOS);
			response.then().log();
		response.prettyPrint();
		ReusableMethods.verifyStatusCode(response, 200);
		Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
		response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("RepoSchemajson"));
		
		
		
		
	}


	@Test
	private static void createSingleRepoTestCas4() {
		

		Response response = createRepoTestCase4();
		ReusableMethods.verifyStatusCode(response, 201);
		JsonPath jsonObj = response.body().jsonPath();
		System.out.println("Repository Name " + jsonObj.get("name"));
		Assert.assertEquals(jsonObj.get("name"), "Hello");
		Assert.assertEquals(jsonObj.get("owner.login"), getOwnerName());
		Assert.assertEquals(jsonObj.get("owner.type"), "User");
	}

	

	@Test
	private static void createSingleRepoTestCas5() {
		// TODO Auto-generated method stub
		Response response = createRepoTestCase4();
		ReusableMethods.verifyStatusCode(response, 422);
		JsonPath jsonObj = response.body().jsonPath();
		Assert.assertEquals(jsonObj.get("errors[0].message"), getErrorMsg());

	}

	@Test
	private static void updateSingleRepoTestCas6() {
		// TODO Auto-generated method stub
		Response response = updateRepo();
		ReusableMethods.verifyStatusCode(response, 200);
		JsonPath jsonObj = response.body().jsonPath();
		Assert.assertEquals(jsonObj.get("name"), getRepoName());

	}

	@Test
	private static void updateSingleRepoTestCas7() {
		// TODO Auto-generated method stub;
		Response response = updateRepo();
		ReusableMethods.verifyStatusCode(response, 204);

		//

	}

	
	@Test
	private static void validateTestCase8() {
		// TODO Auto-generated method stub
		Response response = updateRepo();
		ReusableMethods.verifyStatusCode(response, 404);
		JsonPath jsonObj = response.body().jsonPath();
		Assert.assertEquals(jsonObj.get("message"), getMessageNotFound());

	}

}