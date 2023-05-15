package lotto.domain;

import lotto.domian.Lotto;
import lotto.domian.LottoNumber;
import lotto.domian.Rank;
import lotto.domian.WinNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WinNumberTest {

    private WinNumber winNumber;

    @BeforeEach
    public void setUp() {
        winNumber = new WinNumber(Lotto.of(Arrays.asList(1,2,3,4,5,6)), new LottoNumber(45));
    }

    @DisplayName("맞은 갯수로 순위를 구할 수 있다.")
    @Test
    public void match_CountNumber_Correct() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(winNumber.match(lotto)).isEqualTo(Rank.FIRST);
    }

}
