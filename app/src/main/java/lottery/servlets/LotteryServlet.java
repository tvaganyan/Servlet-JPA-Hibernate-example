package lottery.servlets;

import lottery.service.LotteryStart;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LotteryServlet", urlPatterns = { "/lottery/start" })
public class LotteryServlet  extends HttpServlet {
     private LotteryStart lotteryStart = new LotteryStart();

     @Override
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
          response.setContentType("application/json");
          response.getWriter().print(lotteryStart.Start().toJSONString());
     }
}
