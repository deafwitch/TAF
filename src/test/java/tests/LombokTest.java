package tests;

import lombok.Cleanup;
import lombok.extern.java.Log;
import lombok.val;
import lombok.var;
import models.*;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;

@Log        // подключаем логирование
public class LombokTest {

    @Test
    public void valTest(){
        val list = new ArrayList<String>();         // Transfer to final variable
        list.add("Test value");
        System.out.println(list.get(0));
    }

    @Test
    public void varTest(){
        var list = new ArrayList<String>();         // Transfer to not final variable
        list.add("Test value");
        System.out.println(list.get(0));
    }

    @Test
    public void cleanUpTest() throws IOException {

        // контроль за открытием/закрытием файла
        @Cleanup InputStream in = new FileInputStream("src/test/resources/text.txt");
        @Cleanup OutputStream out = new FileOutputStream("src/test/resources/text1.txt");

        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }
    }

    @Test
    public void getterAndSetterTest(){
        Person person = new Person();
        person.setAge(23);
        System.out.println(person.getAge());
    }

    @Test
    public void toStringTest(){
        Person1 person = new Person1();
        person.setAge(23);
        person.setName("Vlad");
        System.out.println(person.getName() + " is " + person.getAge());
        System.out.println(person.toString());
    }

    @Test
    public void equalsAndHashCodeTest(){
        Person1 person = new Person1();
        person.setAge(23);
        person.setName("Vlad");

        Person1 person1 = new Person1();
        person1.setAge(23);
        person1.setName("Vlad");


        System.out.println(person.equals(person1));

        System.out.println(person.toString());
        System.out.println(person1.toString());

        System.out.println(person.hashCode());
        System.out.println(person1.hashCode());
    }

    @Test
    public void argsConstructorTest(){
        Person1 person = new Person1();
        person.setAge(23);
        person.setName("Vlad");

        Person1 person1 = new Person1(30, "Alex");

        System.out.println(person);
        System.out.println(person1);
    }

    @Test
    public void requiredArgsConstructorTest(){
        Person2 person = new Person2();
        person.setAge(23);
        person.setName("Vlad");

        Person2 person1 = new Person2(30, "Alex", "Trostyanko");

        Person2 person2 = new Person2("Surnamed");

        System.out.println(person);
        System.out.println(person1);
        System.out.println(person2);
    }

    @Test
    public void dataConstructorTest(){
        Person3 person = new Person3();
        person.setAge(23);
        person.setName("Vlad");

        Person3 person1 = new Person3("Tros");

        System.out.println(person);
        System.out.println(person1);
    }

    @Test
    public void builderTest(){
        PersonBuilder person = PersonBuilder.builder()
                .name("Alex")
                .surname("Tros")
                .age(30)
                .build();

        System.out.println(person);
    }

    @Test
    public void builderWithExcludeTest(){
        PersonBuilder person = PersonBuilder.builder()
                .name("Alex")
                .surname("Tros")
                .age(30)
                .UUID(0)
                .build();

        PersonBuilder person1 = PersonBuilder.builder()
                .name("Alex")
                .surname("Tros")
                .age(30)
                .UUID(1)
                .build();

        System.out.println(person);
        System.out.println(person1);
        System.out.println(person.equals(person1));
    }

    @Test
    public void logTest(){
        PersonBuilder person = PersonBuilder.builder()
                .name("Alex")
                .surname("Tros")
                .age(30)
                .UUID(0)
                .build();

        PersonBuilder person1 = PersonBuilder.builder()
                .name("Alex")
                .surname("Tros")
                .age(30)
                .UUID(1)
                .build();

        log.severe(person.toString());
        log.severe(person1.toString());
    }
}
