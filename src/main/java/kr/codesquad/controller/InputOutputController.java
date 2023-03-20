package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderHeight;
import kr.codesquad.domain.Players;
import kr.codesquad.domain.Results;
import kr.codesquad.util.Validator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InputOutputController {

    private final OutputView outputView;
    private final InputView inputView;
    private final Validator validator;

    public InputOutputController() {
        this.validator = new Validator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    List<String> getPlayers() {
        List<String> playersList;
        while (true) {
            inputView.playerNamePrompt();
            playersList = validator.getValidPlayerFromUser(inputView.getInput());
            if(playersList != null){
                break;
            }
        }
        return playersList;
    }

    int  getHeight() {
        int tempHeight;
        while (true){
            inputView.LadderHeightPrompt();
            tempHeight = Integer.parseInt(inputView.getInput());
            if(validator.getValidHeightFromUser(tempHeight)){
                break;
            }
        }
        return tempHeight;
    }

     List getResults(int playerNum) {
        List<String> resultsList;
        while (true) {
            inputView.resultPrompt();
            resultsList = validator.getResultsFromUser(inputView.getInput(),playerNum);
            if(resultsList != null){
                break;
            }
        }
        return resultsList;
    }

    void getExecutionResult(HashMap<String, String> resultMap){
        while (true) {
            inputView.selectPlayerPrompt();
            outputView.getExecutionResult(inputView.getInput(),resultMap);
        }
    }

    void printLadder(Ladder ladder, Players player, Results result) {
        outputView.printLadder(ladder, player, result);
    }
}
