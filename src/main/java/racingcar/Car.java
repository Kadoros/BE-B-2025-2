package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5글자여야 합니다.");
        }
        this.name = name;
    }

    public void move() {
        move(Randoms.pickNumberInRange(0, 9));
    }

    public void move(int randNumberInput) {
        if (randNumberInput >= 4) {
            position++;
        }
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
