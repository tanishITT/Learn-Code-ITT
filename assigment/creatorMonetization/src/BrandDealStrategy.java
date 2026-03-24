public class BrandDealStrategy implements EarningStrategy {

    private final double baseContractAmount;
    private final double fixedEngagementRate = 0.05;

    public BrandDealStrategy(double baseContractAmount) {
        this.baseContractAmount = baseContractAmount;
    }

    @Override
    public double calculateEarning(
            int views,
            int subscribers,
            double engagementRate,
            Region region,
            Season season
    ) {
        if (season == Season.HOLIDAY && engagementRate > fixedEngagementRate) {
            return baseContractAmount * 1.2;
        }
        return baseContractAmount;
    }
}