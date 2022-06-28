package lottery.service;

import lottery.dao.LotteryDao;
import lottery.model.Participant;
import lottery.model.Winners;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class Actions {
    private LotteryDao lotteryDao;

    public Actions(){
        lotteryDao = LotteryDao.getInstans();
    }

    public void addParticipant(JSONObject o) {
        Participant p = new Participant();
        p.setName((String) o.get("name"));
        p.setAge((Long) o.get("age"));
        p.setCity((String) o.get("city"));
        lotteryDao.addParticipant(p);
    }

    public JSONArray getAllParticipant() {
        List<Participant> list = lotteryDao.getAllParticipant();
        JSONArray res = new JSONArray();
        for(Participant p: list){
            JSONObject o = new JSONObject();
            o.put("name", p.getName());
            o.put("age", p.getAge());
            o.put("city", p.getCity());
            res.add(o);
        }
        return res;
    }

    public long ParticipantCount() {
        return lotteryDao.ParticipantCount();
    }

    public JSONObject lotteryDraw(int n, long win_sum){
        Participant p = lotteryDao.getWinner(n);
        Winners w = new Winners();
        w.setName(p.getName());
        w.setAge(p.getAge());
        w.setCity(p.getCity());
        w.setWin_sum(win_sum);
        lotteryDao.addWinners(w);
        JSONObject o = new JSONObject();
        o.put("name", w.getName());
        o.put("age", w.getAge());
        o.put("city", w.getCity());
        o.put("win_sum", w.getWin_sum());
        return o;
    }

    public JSONArray getAllWinners() {
        List<Winners> list = lotteryDao.getAllWinners();
        JSONArray res = new JSONArray();
        for(Winners p: list){
            JSONObject o = new JSONObject();
            o.put("name", p.getName());
            o.put("age", p.getAge());
            o.put("city", p.getCity());
            o.put("win_sum", p.getWin_sum());
            res.add(o);
        }
        return res;
    }
}
