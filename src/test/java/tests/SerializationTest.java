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

    @Test
    public void objectToJsonTest() throws IOException {
        Gson gson = new Gson();

        Project project = new Project("Test Project N", "Big-big text", false, 2);

        String objectJson = gson.toJson(project);
        System.out.println(objectJson);


        // FileWriter - дл€ работы с файлами
        FileWriter file = new FileWriter("project_result.json");

        // пишем JSON в файл
        gson.toJson(project, file);

        // ќЅя«ј“≈Ћ№Ќќ закрываем файл
        file.close();
    }

    @Test
    public void jsonToObjectTest() throws IOException {
        Gson gson = new Gson();

        String json = "{\"name\":\"Test Project N\",\"announcement\":\"Big-big text\",\"show_announcement\":false,\"type\":2}";

        Project project = gson.fromJson(json, Project.class);

        System.out.println(project.toString());
        System.out.println(project.getName());


        // use File Reader дл€ чтени€ инфы из файлов
        Reader reader = Files.newBufferedReader(Paths.get("project_result.json"));
        Project projectFromFile = gson.fromJson(reader, Project.class);
        System.out.println(projectFromFile.toString());
        System.out.println(projectFromFile.getName());
    }
}
