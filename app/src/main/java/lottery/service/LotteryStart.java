package lottery.service;

import org.json.simple.JSONObject;
import java.net.URL;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

public class LotteryStart {
    private Actions actions;

    public LotteryStart(){
        this.actions = new Actions();
    }

    public int getRandomNumber(long n) {
        return (int) ((Math.random() * (n - 1)) + 1);
    }

    public int getRandomNumberHTTPS(long n) throws IOException {
        String httpsURL = "https://www.random.org/integers/?num=1&min=1&max="
                + n + "&col=1&base=10&format=plain&rnd=new";
        URL myUrl = new URL(httpsURL);
        HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        int r = Integer.parseInt(br.readLine(), 10);
        System.out.println(r);
        return r;
    }

    public JSONObject Start()throws IOException{
        JSONObject o = new JSONObject();
        long count = actions.ParticipantCount();
        if(count < 2){
            o.put("error", "less than two participants");
            return o;
        }
        int c = getRandomNumber(count);
        long l = getRandomNumber(1000);
        o = actions.lotteryDraw(c, l);
        return o;
    }
}
