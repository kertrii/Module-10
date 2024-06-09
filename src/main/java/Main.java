import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String fileName = "file.txt";
        PhoneNumberValidator.readAndPrintValidPhoneNumber(fileName);
        System.out.println();

        List<User> users = UsersList.readUsersFromFile("file1.txt");
        UsersList.writeUsersToJson(users, "user.json");
        UsersList.printFileContents("user.json");
        System.out.println();

        Map<String, Integer> wordFrequency = WordFrequency.calculateWordFrequency("words.txt");
        WordFrequency.printWordFrequency(wordFrequency);
    }
}
