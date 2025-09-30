package racingcar;


import java.util.ArrayList;
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

    
    public void start() {
        for (int i = 0; i < trials; i++) {
            for (Car car : cars) {
                car.move(); // 자동차가 움직이는 로직은 Car 클래스가 담당
            }
            printRoundResult();
        }
    }

    public List<Car> findWinners() {
        int maxDistance = 0;
        for (Car car : cars) {
            if(car.getPosition() >maxDistance){
                maxDistance=car.getPosition();
            }
        }
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }

    public void printRoundResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
