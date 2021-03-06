import model.Pc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class KopyuterServelet extends HttpServlet {
    private Dbweb dbweb;

    public void init() {
        dbweb = new Dbweb();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        List<Pc> pcList = dbweb.selectAllPc();
        pcList.forEach(pc -> {
            writer.write("<table> <tr><th>maker</th><th>model</th><th>price</th></tr><tr><td>"+pc.getMaker()+"</td><td>"+pc.getModel()+"</td><td>"+pc.getPrice()+"</td></tr></table>");
        });

    }
}
