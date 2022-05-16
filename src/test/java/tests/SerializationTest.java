package tests;

import com.google.gson.Gson;
import models.Project;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializationTest {


    public SerializationTest() throws IOException {
    }

    @Test
    public void objectToJsonTest() throws IOException {
        Gson gson = new Gson();
        Project project = new Project("test project",
                "big announcement text",
                false, 2);

        String objectJson = gson.toJson(project);
        System.out.println(objectJson);
        FileWriter file = new FileWriter("projectResult.json");
        gson.toJson(project, file);
        file.close();

    }


    @Test
    public void objecttoJsonTest() throws IOException {
        Gson gson = new Gson();
       String json = "{\"name\":\"test project\",\"announcement\":\"big announcement text\",\"show_Announcement\":false,\"type\":2}";
        Project projectFromString = gson.fromJson(json,Project.class);
        System.out.println(projectFromString.toString());
        System.out.println(projectFromString.getName());


        Reader reader = Files.newBufferedReader(Paths.get("projectResult.json"));
        Project projectFromFile = gson.fromJson(reader,Project.class);
        System.out.println(projectFromFile.toString());
        System.out.println(projectFromFile.getName());
    }




}
