package tumblrApi;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    public String getBlogName() {
        System.out.println("Enter Tumblr blog name:");
        String name = scanner.nextLine().trim();
        System.out.println();
        return name;
    }

    public String getRange() {
        System.out.println("Enter post range (example: 1-10):");
        String range = scanner.nextLine().trim();
        System.out.println();
        return range;
    }

    public void printBlogDetails(Blog blog) {
        System.out.println(blog);
        System.out.println();
    }

    public void printPosts(List<Post> posts) {
        int counter = 1;
        for (Post post : posts) {
            List<String> urls = post.getImageUrls();
            if (urls.isEmpty()) {
                continue;
            }

            System.out.print(counter + ". ");
            for (int i = 0; i < urls.size(); i++) {
                if (i > 0) {
                    System.out.print("   ");
                }
                System.out.println(urls.get(i));
            }
            counter++;
        }
    }

    public void printError(String message) {
        System.err.println("Error occurred: " + message);
    }
}
