package lotto.ui;

import lotto.domian.Lotto;
import lotto.domian.LottoBundle;
import lotto.domian.Rank;
import lotto.domian.Record;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void showLottoBundle(LottoBundle bundle) {
        bundle.unfoldLottoBundle()
                .stream()
                .forEach(lotto -> {
                    showLottoNumber(lotto);
                });
        System.out.println();
    }

    public static void showRecord(Record record) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        printEachRank(record);
    }

    private static void printEachRank(Record record) {
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> {
                    System.out.println(rank.getMatchingCount() + "개 일치 (" + rank.getPrize() + ")- " + record.getRecord().getOrDefault(rank, 0) + "개");
                });
    }

    private static void showLottoNumber(Lotto lotto) {
        List<Integer> sortedNumbers = sort(lotto);
        printNumbers(sortedNumbers);
    }

    private static void printNumbers(List<Integer> sortedNumbers) {
        System.out.println(sortedNumbers
                .stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.joining(", ", "[", "]")));
    }

    private static List<Integer> sort(Lotto lotto) {
        return lotto.getLottoNumber()
                .stream()
                .map(lottoNumber -> lottoNumber.getNumber())
                .sorted()
                .collect(Collectors.toList());
    }

}
