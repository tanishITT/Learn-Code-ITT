import java.util.HashSet;
import java.util.Set;

public class Creator {

    private final String name;
    private final Set<EarningStrategy> revenueStreams;

    public Creator(String name) {
        this.name = name;
        this.revenueStreams = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addRevenueStream(EarningStrategy strategy) {
        revenueStreams.add(strategy);
    }

    public double calculateTotalEarnings(
            int views,
            int subscribers,
            double engagementRate,
            Region region,
            Season season
    ) {

        double totalEarnings = 0;

        for (EarningStrategy strategy : revenueStreams) {
            totalEarnings += strategy.calculateEarning(
                    views,
                    subscribers,
                    engagementRate,
                    region,
                    season
            );
        }

        return totalEarnings;
    }
}