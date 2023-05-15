package lotto.domain;

import lotto.domian.MatchCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatchCountTest {

    @DisplayName("맞은 갯수가 1 ~ 6이 아닐 경우 예외를 던진다.")
    @Test
    public void rank_InvalidNumber_ThrowException() {
        Assertions.assertThatThrownBy(() -> new MatchCount(7))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
