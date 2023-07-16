package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @DisplayName("캐싱처리한 로또번호의 객체는 서로 같은 객체다.")
    @Test
    public void cashing_sameObject() {
        LottoNumber lottoNumber = LottoNumber.from("1");
        Assertions.assertThat(LottoNumber.from(1)).isEqualTo(lottoNumber);
        Assertions.assertThat(LottoNumber.from(1) == lottoNumber);
    }

    @DisplayName("로또번호는 1 ~ 45 사이의 숫자여야 한다.")
    @Test
    public void lottoNumber_RangeInBetween1And45_CreateSuccess() {
        int number = 45;
        LottoNumber lottoNumber = LottoNumber.from(number);

        Assertions.assertThat(lottoNumber.getNumber()).isEqualTo(45);
    }

    @DisplayName("로또번호는 1 ~ 45 사이의 숫자가 아니라면 예외를 던진다")
    @Test
    public void lottoNumber_RangeInBetween1And45_IfNotThrowException() {
        int number = 46;
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.from(number));
    }

    @DisplayName("숫자형태의 로또번호가 아니라면 예외를 던진다.")
    @Test
    public void lottoNumber_NotNumericFormat_ThrowException() {
        String number = "a";
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.from(number));
    }

}
