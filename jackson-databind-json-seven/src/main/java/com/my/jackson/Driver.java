package com.my.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.json.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Student student;

            //InputStream resourceAsStream = Driver.class.getResourceAsStream("/data/sample-lite.json");
            InputStream resourceAsStream = Driver.class.getResourceAsStream("/data/sample-full.json");

            if (resourceAsStream != null) {
                student = objectMapper
                        .readValue(new InputStreamReader(resourceAsStream), Student.class);

                System.out.println(student);
                System.out.println(student.getAddress());
                System.out.println(Arrays.toString(student.getLanguages()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
