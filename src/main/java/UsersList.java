import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

public class UsersList {

    public static List<User> readUsersFromFile(String filename) {
        List<User> users = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("file1.txt"))){
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                users.add(new User(name, age));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void writeUsersToJson(List<User> users, String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        try (FileWriter writer = new FileWriter(filename)){
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printFileContents(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
