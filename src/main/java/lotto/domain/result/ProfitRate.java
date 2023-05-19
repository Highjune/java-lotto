package lotto.domain.result;

public class ProfitRate {

    private final double profit;

    public ProfitRate(double profit) {
        this.profit = profit;
    }

    public double value() {
        return profit;
    }
}