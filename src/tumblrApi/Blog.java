package tumblrApi;

public class Blog {
    private final String title;
    private final String name;
    private final String description;
    private final int totalPosts;

    public Blog(String title, String name, String description, int totalPosts) {
        this.title = title;
        this.name = name;
        this.description = description;
        this.totalPosts = totalPosts;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getTotalPosts() {
        return totalPosts;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Blog name: " + name + "\n" +
                "About: " + description + "\n" +
                "Total posts: " + totalPosts;
    }
}
