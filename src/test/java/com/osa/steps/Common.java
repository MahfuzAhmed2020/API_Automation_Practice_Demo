package com.osa.steps;

import java.util.HashMap;
import java.util.List;
import com.osa.base.AppContains;
import com.osa.api.Apis;
import com.osa.api.Format;
import com.osa.api.RequestHelper;
import com.osa.api.UsersValues;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class Common {
	public static void main(String[] args) {
		HashMap<String, String> h = new HashMap<String, String>();
		h.put("a", "AAA");
		h.put("b", "BBBBB");
		System.out.println(h.get("a"));
	}

	RequestHelper cv = new RequestHelper();
	private Response response;

	@When("I am sending {string} request to this endpoint {string} with JSON body")
	public void sendRequestWithJsonBody(String requestType, String endpoint, String payload) {
		response = Apis.executeRequest(requestType, endpoint, payload);
		cv.getResponse(response);
		AppContains.LOG.info(Format.prettyPrint(response));
	}

	@Then("the response status code should be {int}")
	public void verifyResponseStatus(int expectedStatus) {
		AppContains.LOG.info("=====verifyResponseStatus=======");
		response.then().statusCode(expectedStatus);
	}

	@Given("^the authentication is completed here$")
	public void the_authentication_is_completed_here() throws Throwable {
		System.out.println("=====The authentication is done!!!=====");
	}

	@When("^I am sending \"([^\"]*)\" request to this endpoint \"([^\"]*)\"$")
	public void i_am_sending_request_to_this_endpoint(String requestType, String endpoint) throws Throwable {
		AppContains.LOG.info("=====Sending a " + requestType + " to =====" + endpoint+"======");
		Response res_get = Apis.executeRequest(requestType, endpoint);
		response = res_get;
		cv.getResponse(res_get);
		AppContains.LOG.info(Format.prettyPrint(res_get));
	}

	@Then("^Verifying the following values$")
	public void verifying_the_following_values(DataTable data) throws Throwable {
		AppContains.LOG.info("=====VERIFYING THE PAYLOAD=======");
		HashMap<String, List<UsersValues>> hm = cv.verifyResponse(data);
		List<UsersValues> userValue = hm.get("val");
		for (UsersValues usersValues : userValue) {
			cv.verifyAPIRes(usersValues.getXpath(), usersValues.getExpectedValue());
		}
		
	}

    @Then("the response body should be {string}")
    public void verifyResponseBody(String expectedBody) {
        org.testng.Assert.assertEquals(response.asString(), expectedBody);
    }
}
