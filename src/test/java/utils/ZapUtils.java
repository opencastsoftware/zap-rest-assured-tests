package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;


public class ZapUtils {

    private static RequestSpecification requestSpecification;
    private static Response response;

    private static final String zapAddress = "127.0.0.1";
    private static final int zapPort = 8080;
//    private static final String apiKey = System.getProperty("APIKEY");

    static {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("http://" + zapAddress + ":" + zapPort + "/JSON");
    }

    public static void waitForPassiveScanCompletion() {
        response = requestSpecification.get("/pscan/view/recordsToScan/");
        String records = response.jsonPath().get("recordsToScan");

        while (!records.equals("0")) {
            System.out.println("under passive scanning");
            response = requestSpecification.get("/pscan/view/recordsToScan/");
            records = response.jsonPath().get("recordsToScan");
        }
        System.out.println("passive scan is completed");
    }

    public static void addURLToScanTree(String stte_to_test) {
        requestSpecification.queryParam("url", stte_to_test);

        response = requestSpecification.get("/core/action/accessUrl/");
        if (response.getStatusCode() == 200)
            System.out.println("URL has been added to Scan tree");
    }

    public static void startActiveScan(String stte_to_test) {
        requestSpecification.queryParam("url", stte_to_test);

        response = requestSpecification.get("/ascan/action/scan/");
        if (response.getStatusCode() == 200)
            System.out.println("active scan has started");
    }

    public static void waitForActiveScanCompletion() {
        response = requestSpecification.get("/ascan/view/status/");
        String status = response.jsonPath().get("status");

        while (!status.equals("100")) {
            System.out.println("active scan is in progress");
            response = requestSpecification.get("/ascan/view/status/");
            status = response.jsonPath().get("status");
        }
        System.out.println("active scan has completed");
    }

    public static void createReport(String site_to_test) {
        String title = "Demo Title";
        String template = "traditional-html";
        String description = "Demo description";
        String sites = site_to_test;
        String reportfilename = "zap-report";
        String reportdir = System.getProperty("user.dir");

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("title", title);
        queryParams.put("template", template);
        queryParams.put("description", description);
        queryParams.put("sites", sites);
        queryParams.put("reportFileName", reportfilename);
        queryParams.put("reportDir", reportdir);

        response = requestSpecification.queryParams(queryParams).get("/reports/action/generate/");
        if (response.body().asString().contains(reportfilename)) {
            System.out.println("Zap report has been created");
        } else {
            throw new RuntimeException("zap report not created");
        }
    }
}