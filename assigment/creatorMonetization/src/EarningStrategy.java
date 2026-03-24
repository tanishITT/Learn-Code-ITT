public interface EarningStrategy {

    double calculateEarning(
            int views,
            int subscribers,
            double engagementRate,
            Region region,
            Season season
    );
}