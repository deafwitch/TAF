package tests.api;

import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectApiTest extends BaseApiTest {

    @Test
    public void positiveTest() {
        Project expectedProject = Project.builder()
                .typeOfProject(1)
                .name("WP Test")
                .announcement("Test An")
                .build();

        Assert.assertEquals(projectHelper.getProject(1),expectedProject);
    }

    @Test
    public void negativeInvalidProjectTest() {
        Assert.assertEquals(projectHelper.getProjectResponse(500).getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void positiveCountProjectsTest() {
        Assert.assertEquals(projectHelper.getAllProjects().size(), 12);

        // etc
        Assert.assertEquals(projectHelper.getAllProjects().get(0).getName(), "WP Test");
    }

    @Test
    public void getParamFromConsole(){
        System.out.println(System.getProperty("psw"));
    }
}
