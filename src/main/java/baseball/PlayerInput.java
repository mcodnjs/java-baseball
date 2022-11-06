package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PlayerInput {

    private static final String NUMBER_PATTERN = "[1-9]{3}";
    private static final String GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_EXCEPTION_MESSAGE = "잘못된 값을 입력하였습니다.";

    public static List<Integer> inputPlayerNumber() {
        List<Integer> playerNumber = new ArrayList<>();
        System.out.print(GAME_INPUT_MESSAGE);
        String playerInputs = Console.readLine();
        if(!Pattern.matches(NUMBER_PATTERN, playerInputs)) {
            throw new IllegalArgumentException(GAME_EXCEPTION_MESSAGE + Game.GAME_TERMINATE_MESSAGE);
        }
        for (String playerInput : playerInputs.split("")) {
            playerNumber.add(Integer.parseInt(playerInput));
        }
        return playerNumber;
    }

    public static String inputRestartGame() {
        String gameProgress = Console.readLine();
        if (!gameProgress.equals(Game.GAME_RESTART) && !gameProgress.equals(Game.GAME_TERMINATE)) {
            throw new IllegalArgumentException(GAME_EXCEPTION_MESSAGE + Game.GAME_TERMINATE_MESSAGE);
        }
        return gameProgress;
    }
}
