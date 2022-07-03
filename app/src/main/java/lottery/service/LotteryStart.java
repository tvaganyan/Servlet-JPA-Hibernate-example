package lottery.service;

import org.json.simple.JSONObject;

public class LotteryStart {
    private Actions actions;

    public LotteryStart(){
        this.actions = new Actions();
    }

    public int getRandomNumber(long n) {
        return (int) ((Math.random() * (n - 1)) + 1);
    }
    
    public JSONObject Start() {
        JSONObject o = new JSONObject();
        long count = actions.ParticipantCount();
        if(count < 2){
            o.put("error", "less than two participants");
            return o;
        }
        o = actions.lotteryDraw(getRandomNumber(count), getRandomNumber(1000));
        return o;
    }
}
