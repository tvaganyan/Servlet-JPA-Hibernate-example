package lottery.servlets;

import lottery.service.Actions;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WinnersServlet", urlPatterns = { "/lottery/winners" })
public class WinnersServlet extends HttpServlet {
    private Actions actions = new Actions();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.getWriter().print(actions.getAllWinners().toJSONString());
    }
}
