package task2;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ObjectJson {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file.rtf"))) {

            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    User user = new User(name, age);
                    users.add(user);
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("user.json")) {
            gson.toJson(users, writer);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

class User {
    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}