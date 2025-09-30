package racingcar;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceControllerTest {

    @Test
    void 자동차이름입력검증() {
        RaceController controller = new RaceController();

        assertThat(controller.isValidCarNames("pobi,jun")).isTrue();
        assertThat(controller.isValidCarNames("pobi, jun")).isTrue();
        assertThat(controller.isValidCarNames("")).isFalse();
        assertThat(controller.isValidCarNames("abcdef")).isFalse();
        assertThat(controller.isValidCarNames("abcdef,asd")).isFalse();
    }

    @Test
    void 시도횟수입력검증() {
        RaceController controller = new RaceController();

        assertThat(controller.isValidTrial("3")).isTrue();
        assertThat(controller.isValidTrial("0")).isFalse();
        assertThat(controller.isValidTrial("-1")).isFalse();
        assertThat(controller.isValidTrial("abc")).isFalse();
    }

    @Test
    void 공동우승자_쉼표로_구분해서_출력() {
        // 자동차 생성
        Car pobi = new Car("pobi");
        Car jun = new Car("jun");

        // 둘 다 1칸 이동 → 공동 우승
        pobi.move(4);
        jun.move(4);

        // Race 생성 및 start 호출 안 해도 findWinners 확인 가능
        Race race = new Race(List.of(pobi, jun), 1);

        RaceController controller = new RaceController();
        String winnersStr = controller.joinWinnerNames(race.findWinners());

        // 쉼표로 구분된 문자열 확인
        assertThat(winnersStr).isEqualTo("pobi, jun");
    }
}

