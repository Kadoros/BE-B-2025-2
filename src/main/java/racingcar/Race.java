package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Race {
    private String[] carNamesList;
    private int trials;

    // Constructor with all parameters
    public Race(String[] carNamesList, int trials) {
        this.carNamesList = carNamesList;
        this.trials = trials;
    }

    // Constructor with default trials
    public Race(String[] carNamesList) {
        this(carNamesList, 0); // default trials = 5
    }

    // Constructor with default car names and trials
    public Race() {
        this(new String[]{}, 0); // default values
    }

    public String[] getCarNamesList() {
        return carNamesList;
    }

    public void setCarNamesList(String[] carNamesList) {
        this.carNamesList = carNamesList;
    }

    public int getTrials() {
        return trials;
    }

    public void setTrials(int trials) {
        this.trials = trials;
    }

    // Ask user for input only if car names or trials are not set
    public void run() {
        if (carNamesList == null || carNamesList.length == 0) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames = Console.readLine();
            this.carNamesList = carNames.split(",");
        }

        if (trials <= 0) {
            System.out.println("시도할 회수는 몇회인가요?");
            this.trials = Integer.parseInt(Console.readLine());
        }
    }
}
