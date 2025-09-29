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
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분, 각 이름은 1~5글자, 공백 허용)");
            String input = Console.readLine();

            // 정규식: 공백 허용, 1~5글자, 쉼표 구분
            String regex = "^\\s*([a-zA-Z가-힣]{1,5})\\s*(\\s*,\\s*([a-zA-Z가-힣]{1,5})\\s*)*$";

            if (!input.matches(regex)) {
                throw new IllegalArgumentException("잘못된 입력입니다. 각 이름은 1~5글자이어야 하며, 쉼표로 구분해야 합니다.");
            }

            // 입력을 쉼표로 나누고 양쪽 공백 제거
            String[] names = input.split(",");
            for (int i = 0; i < names.length; i++) {
                names[i] = names[i].trim();
            }

            this.carNamesList = names;
        }


        if (trials <= 0) {
            System.out.println("시도할 회수는 몇회인가요?");
            String trialInput = Console.readLine();
            try {
                this.trials = Integer.parseInt(trialInput);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력입니다. 시도 횟수는 숫자여야 합니다.");
            }

            if (this.trials <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
        }
    }

}
