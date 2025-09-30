package racingcar;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차는_입력값이_4이상이면_전진한다() {
        Car car = new Car("pobi");
        car.move(4); // 고정값
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_입력값이_3이하면_멈춘다() {
        Car car = new Car("pobi");
        car.move(3); // 고정값
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차이름이_비어있거나_공백이면_예외발생() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
