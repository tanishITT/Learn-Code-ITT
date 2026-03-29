import java.util.ArrayList;
import java.util.List;

public class LSPDemo {
    public static void main(String[] args) {
        List<Bird> birds = new ArrayList<>();
        birds.add(new Sparrow("Tweety"));
        birds.add(new Eagle("Baldy"));
        birds.add(new Penguin("Pingu"));
        birds.add(new Duck("Donald"));

        BirdSanctuary sanctuary = new BirdSanctuary();

        for (Bird bird : birds) {
            sanctuary.demonstrateBirdMovement(bird);
        }

        System.out.println("\n========== FLYING BIRDS ==========");
        sanctuary.demonstrateFlyingAbility(new Eagle("Sky King"));
        sanctuary.demonstrateFlyingAbility(new Duck("Quackers"));

        System.out.println("\n========== SWIMMING BIRDS ==========");
        sanctuary.demonstrateSwimmingAbility(new Penguin("Waddles"));
        sanctuary.demonstrateSwimmingAbility(new Duck("Splashy"));
    }
}