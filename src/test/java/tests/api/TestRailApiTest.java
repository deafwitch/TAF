package tests.api;

import configuration.Endpoints;
import configuration.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Project;
import models.ProjectType;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestRailApiTest extends BaseApiTest {

    @Test
    public void getAllProjectsTest() {

        // Setup request Object
        RequestSpecification httpRequest = given();
        httpRequest.header(HTTP.CONTENT_TYPE, ContentType.JSON);
        httpRequest.auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        // Setup Response Object
        Response response = httpRequest.request(Method.GET, Endpoints.GET_PROJECTS);

        // Get Response Status
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);
    }

    @Test
    public void getAllProjectsShortTest() {
        given()
                //.header(HTTP.CONTENT_TYPE, ContentType.JSON)
                //.auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectTest() {
        Project newProject = Project.builder()
                .name("MyLittleProject123")
                .build();

        given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\"\n" +
                        "}", newProject.getName()))
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectTest2() {
        Project project = Project.builder()
                .name("MyLittleProject1231234123456")
                .typeOfProject(ProjectType.SINGLE_SUITE_MODE)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getTypeOfProject());

        given()
                .body(jsonAsMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectTest3() {
        Project project = Project.builder()
                .name("MyLittleProject1231234123456")
                .typeOfProject(ProjectType.SINGLE_SUITE_BASELINES)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getTypeOfProject());

        Project newProject = given()
                .body(jsonAsMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);

        System.out.println(newProject.toString());
    }
}
