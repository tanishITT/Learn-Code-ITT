public class SubscriptionStrategy implements EarningStrategy {

    private static final double SUBSCRIPTION_FEE = 2.0;

    @Override
    public double calculateEarning(
            int views,
            int subscribers,
            double engagementRate,
            Region region,
            Season season
    ) {
        return subscribers * SUBSCRIPTION_FEE;
    }
}