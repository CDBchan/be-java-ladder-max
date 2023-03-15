package kr.codesquad.controller;

import kr.codesquad.domain.*;

public class LadderGameController {
    private final InputOutputController ioController;
    private final Players players;
    private final LadderHeight ladderHeight;
    private final Results result;

    private final Ladder ladder;

    public LadderGameController() {
        this.ioController = new InputOutputController();
        this.players = new Players();
        this.result = new Results();
        this.ladderHeight = new LadderHeight();
        this.ladder  = new Ladder();
    }

    public void startLadderGame(){
        ioController.setupGame(players, ladderHeight, result);
        ladder.createValidLadder(players.getCountOfPlayers(), ladderHeight.getLadderHeight());
        ioController.printLadder(ladder, players, result);
        ExecutionResultGenerator executionResultGenerator = new ExecutionResultGenerator(ladder, players, result);
        ioController.getExecutionResult(executionResultGenerator.getResultMap());
    }
}