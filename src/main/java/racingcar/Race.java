package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int trials;

    // Constructor with all parameters
    public Race(List<Car> cars, int trials) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 목록이 비어있습니다.");
        }
        if (trials <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        this.cars = cars;
        this.trials = trials;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTrials() {
        return trials;
    }

    public void start() {
        for (int i = 0; i < trials; i++) {
            for (Car car : cars) {
                car.move(); // 자동차가 움직이는 로직은 Car 클래스가 담당
            }
        }
    }
}
