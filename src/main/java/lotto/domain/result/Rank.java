package lotto.domain.result;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {

    FIRST((count, isBonus) -> count == 6, 6, 2_000_000_000),
    SECOND((count, isBonus) -> count == 5 && isBonus, 5, 30_000_000),
    THIRD((count, isBonus) -> count == 5 && !isBonus, 5, 1_500_000),
    FOURTH((count, isBonus) -> count == 4, 4, 50_000),
    FIFTH((count, isBonus) -> count == 3, 3, 5_000),
    MISS((count, isBonus) -> false, 0, 0);

    private final BiPredicate<Integer, Boolean> matcher;
    private final int matchingCount;
    private final int prize;

    Rank(BiPredicate<Integer, Boolean> matcher, int matchingCount, int prize) {
        this.matcher = matcher;
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Rank find(MatchCount matchCount, boolean isBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matcher.test(matchCount.value(), isBonus))
                .findFirst()
                .orElse(MISS);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

}