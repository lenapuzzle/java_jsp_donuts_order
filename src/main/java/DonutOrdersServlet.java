import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/orders")
public class DonutOrdersServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Map<String, Integer> donutOrders = new HashMap<String, Integer>();
    donutOrders.put("Jennifer", 10);
    donutOrders.put("Alex", 1);
    donutOrders.put("Carly", 3);
    Map<String,String> donutMessages = new HashMap<>();
    Map<String, String> favoriteDonuts = new HashMap<>();
    favoriteDonuts.put("Jennifer", "Custard");
    favoriteDonuts.put("Carly", "Maple Bar");

    String message = "Please do not take advantage of donut day. We need to talk about sugar crashes.";
    int orderTotal = 0          ;
    for(String order : donutOrders.keySet()) {
      if(donutOrders.get(order) > 5) {
        donutOrders.put(order, 2);
        donutMessages.put(order, message);
      } else {
        donutMessages.put(order, "");
      }
      orderTotal += donutOrders.get(order);
    }
    String name = req.getParameter("name");
    if(req.getParameter("name") != null && req.getParameter("name") != "") {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/show.jsp");
      req.setAttribute("name", name);
      req.setAttribute("order", donutOrders.get(name));
      req.setAttribute("favoriteDonut", favoriteDonuts.get(name));

      dispatcher.forward(req, resp);

    } else {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
      req.setAttribute("donutOrders", donutOrders);
      req.setAttribute("orderTotal", orderTotal);
      req.setAttribute("donutMessages", donutMessages);
      dispatcher.forward(req, resp);
    }
  }
}