package racingcar;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceTest {

    @Test
    void 시도횟수가_0이하면_예외발생() {
        List<Car> cars = List.of(new Car("pobi"));
        assertThatThrownBy(() -> new Race(cars, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상");
    }

    @Test
    void 공동우승자가_있을수도_있다() {
        Car pobi = new Car("pobi");
        Car jun = new Car("jun");

        pobi.move(4); // 1칸 이동
        jun.move(4);  // 1칸 이동 → 같은 거리

        Race race = new Race(List.of(pobi, jun), 1);
        List<Car> winners = race.findWinners();

        assertThat(winners).containsExactlyInAnyOrder(pobi, jun);
    }
    @Test
    void 무작위숫자가_4이상이면_이동() {
        Car car = new Car("pobi");

        car.move(4); // 고정값 입력
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(5); // 다른 4 이상 값
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void 무작위숫자가_3이하이면_멈춤() {
        Car car = new Car("pobi");

        car.move(3); // 고정값 입력
        assertThat(car.getPosition()).isEqualTo(0);

    }


}
