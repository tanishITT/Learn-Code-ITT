class BirdSanctuary {
    public void demonstrateBirdMovement(Bird bird) {
        System.out.println("\n--- " + bird.getName() + " ---");
        bird.move();
        bird.eat();
    }

    public void demonstrateFlyingAbility(Flyable flyable) {
        System.out.println("\nFlying demonstration:");
        flyable.fly();
        System.out.println("Max altitude: " + flyable.getMaxAltitude() + " meters");
    }

    public void demonstrateSwimmingAbility(Swimmable swimmable) {
        System.out.println("\nSwimming demonstration:");
        swimmable.swim();
        System.out.println("Max depth: " + swimmable.getMaxDepth() + " meters");
    }
}