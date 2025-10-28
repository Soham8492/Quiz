import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Question> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("data/questions.txt"))) {
            while (sc.hasNextLine()) {
                String q = sc.nextLine();
                String o1 = sc.nextLine();
                String o2 = sc.nextLine();
                String o3 = sc.nextLine();
                String o4 = sc.nextLine();
                String ans = sc.nextLine();
                list.add(new Question(q, o1, o2, o3, o4, ans));
            }
        } catch (Exception e) {
            System.out.println("Error loading questions!");
        }
        new QuizFrame(list);
    }
}
