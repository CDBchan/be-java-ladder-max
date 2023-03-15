package kr.codesquad.domain;

import java.util.HashMap;

public class ExecutionResultGenerator {
    private HashMap<String,String> resultMap;
    public HashMap<String, String> getResultMap() {
        return resultMap;
    }

    public ExecutionResultGenerator(Ladder ladder, Players player, Results result) {
        this.resultMap = new HashMap<>();
        generateResultMap(ladder,player,result);
    }

    private void generateResultMap(Ladder ladder, Players player, Results result){
        for(int i=0;i<player.getPlayersList().size();i++){
            int ladderRideResult = ladder.rideLadder(i);
            String playerName = player.getNameFromNameList(i);
            String resultValue = result.getResultFromResultList(ladderRideResult);
            resultMap.put(playerName, resultValue);
        }
    }
}
