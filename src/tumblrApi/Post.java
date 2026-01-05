package tumblrApi;

import java.util.Collections;
import java.util.List;

public class Post {
    private final String id;
    private final List<String> imageUrls;

    public Post(String id, List<String> imageUrls) {
        this.id = id;
        this.imageUrls = imageUrls != null ? imageUrls : Collections.emptyList();
    }

    public String getId() {
        return id;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }
}
