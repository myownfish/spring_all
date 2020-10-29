package com.luv2code;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        // TODO Auto-generated method stub

        ObjectMapper mapper = new ObjectMapper();
//        System.out.println(System.getProperty("user.dir"));
        Student theStudent = mapper.readValue(new File("src/main/resources/data/sample-lite.json"), Student.class);

        System.out.println(theStudent.getFirstName());

        Student theStudent2 = mapper.readValue(new File("src/main/resources/data/sample-full.json"), Student.class);

        System.out.println(theStudent2.getAddress());
        System.out.println(theStudent2.getActive());
        System.out.println(theStudent2.getLanguages());

    }

}
