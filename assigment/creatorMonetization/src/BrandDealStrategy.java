public class BrandDealStrategy implements EarningStrategy {

    private final double baseContractAmount;

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
        if (season == Season.HOLIDAY && engagementRate > 0.05) {
            return baseContractAmount * 1.2;
        }
        return baseContractAmount;
    }
}