package com.korit.servletstudy.login;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class UserRepository {
    public List<User> users;

    public UserRepository(ServletContext context) {
        String realPath = context.getRealPath("/WEB-INF/user.json");
        try (FileReader fileReader = new FileReader(realPath)) {//close를 안해도 된다
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
            ObjectMapper objectMapper = new ObjectMapper();

            this.users = objectMapper.readValue(stringBuilder.toString(), List.class);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public User save() {

        return null;
    }

    public User findById(int id) {
        return null;
    }
    public User findByUsername(String username) {
        return null;
    }
    public List<User> findByAll() {
        return List.of();
    }


}
