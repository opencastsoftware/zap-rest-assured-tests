package steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import utils.ZapUtils;

public class Hooks {

    private static boolean zapEnabled = false;
    private static String url = "https://test-api.dev.opencastsoftware.com";

    @Before
    public void beforeScenario(Scenario scenario) {
        // Check if scenario has @zapScan tag
        if (scenario.getSourceTagNames().contains("@zapScan")) {
            zapEnabled = true;
            System.out.println("ZAP scan enabled for this scenario.");
            RestAssured.useRelaxedHTTPSValidation();
            RestAssured.proxy("localhost", 8080);
        }
    }

//    @After
//    public void afterScenario() {
//        if (zapEnabled) {

    /// /            RestAssured.baseURI = "https://test-api.dev.opencastsoftware.com/employee";
//            ZapUtils.addURLToScanTree(url);
//            ZapUtils.startActiveScan(url);
//            ZapUtils.waitForActiveScanCompletion();
//            ZapUtils.createReport(url);
//            System.out.println("ZAP scan and report done.");
//        }
//    }
    @AfterAll
    public static void afterAll() {
        if (zapEnabled) {
            ZapUtils.startActiveScan(url);
            ZapUtils.waitForActiveScanCompletion();
            ZapUtils.createReport(url);
        }
    }
}