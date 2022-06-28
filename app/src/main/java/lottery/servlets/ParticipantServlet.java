package lottery.servlets;

import lottery.service.Actions;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "ParticipantServlet", urlPatterns = { "/lottery/participant" })
public class ParticipantServlet extends HttpServlet {
    private Actions actions = new Actions();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.getWriter().print(actions.getAllParticipant().toJSONString());
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader br = request.getReader();
        JSONParser parser = new JSONParser();
        JSONObject o = (JSONObject) JSONValue.parse(br);
        actions.addParticipant(o);
    }
}
