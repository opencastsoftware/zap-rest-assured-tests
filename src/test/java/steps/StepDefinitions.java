package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ZapUtils;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    private Response response;
    private String postRequestBody;
    String url = "https://test-api.dev.opencastsoftware.com";

    @Given("I have a valid authentication token")
    public void i_have_a_valid_authentication_token() {
        // nothing needed here
    }

    @When("I GET the {string} endpoint")
    public void i_get_the_endpoint(String endpoint) {
        RestAssured.baseURI = "https://test-api.dev.opencastsoftware.com";
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    @Then("I should receive {string} as response code")
    public void i_should_receive_as_response_code(String expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals(Integer.parseInt(expectedStatusCode), actualStatusCode);
    }

    @Given("I have the following employee data")
    public void i_have_the_following_employee_data() {
        postRequestBody = "{\n" +
                "          \"forename\": \"tester\",\n" +
                "          \"surname\": \"5\",\n" +
                "          \"salary\": 51000,\n" +
                "          \"holidayAllowance\": 30,\n" +
                "          \"roles\": [{ \"level\": \"lead\", \"title\": \"tester\" }]\n" +
                "        }";
    }

    @When("I send a POST request to the employee endpoint")
    public void i_send_a_post_request_to_the_employee_endpoint() {
        RestAssured.baseURI = "https://test-api.dev.opencastsoftware.com/employee";
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(postRequestBody)
                .post()
                .then()
                .extract().response();
    }

    @Then("I start the active scan using zap")
    public void i_start_the_active_scan_using_zap() {
        ZapUtils.addURLToScanTree(url);
        ZapUtils.startActiveScan(url);
        ZapUtils.waitForActiveScanCompletion();
        ZapUtils.createReport(url);
        System.out.println("ZAP scan and report done.");
    }
}
