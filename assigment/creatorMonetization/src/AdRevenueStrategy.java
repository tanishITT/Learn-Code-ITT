public class AdRevenueStrategy implements EarningStrategy {

    private static final double BASE_CPM = 0.05;

    @Override
    public double calculateEarning(
            int views,
            int subscribers,
            double engagementRate,
            Region region,
            Season season
    ) {
        double multiplier = getRegionMultiplier(region);
        return views * BASE_CPM * multiplier;
    }

    private double getRegionMultiplier(Region region) {
        return switch (region) {
            case US -> 1.5;
            case UK -> 1.2;
            case IN -> 0.8;
            case GLOBAL -> 1.0;
        };
    }
}