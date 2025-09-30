package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import java.util.List;

public class RaceController {
    private static final String NAME_REGEX = "^\\s*([a-zA-Z가-힣]{1,5}\\s*)(,\\s*[a-zA-Z가-힣]{1,5}\\s*)*$";

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        if (!isValidCarNames(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 각 이름은 1~5글자이며 쉼표로 구분해야 합니다.");
        }
        String[] carNames = input.split(",");
        List<Car> cars=new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }

        System.out.println("시도할 회수는 몇회인가요?");

        String trialInput = Console.readLine();
        if (!isValidTrial(trialInput)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 시도 횟수는 숫자여야 하며 1 이상이어야 합니다.");
        }

        int trials = Integer.parseInt(trialInput);
        Race race = new Race(cars, trials);
        race.start();

        System.out.println("최종 우승자 : " + joinWinnerNames(race.findWinners()));
    }

    public String joinWinnerNames(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    boolean isValidCarNames(String input) {
        return input.matches(NAME_REGEX);
    }

    boolean isValidTrial(String input) {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
