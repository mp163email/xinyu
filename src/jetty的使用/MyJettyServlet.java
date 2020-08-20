package jetty的使用;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * des:
 * created by miapoeng on 2020/8/20 16:12
 */
public class MyJettyServlet extends HttpServlet {
    public MyJettyServlet () {

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ip = req.getRemoteAddr();
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println(String.format("ip=%s, uname=%s, pwd=%s", ip, uname, pwd));

        resp.setContentType("text/plain;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = resp.getWriter();
        out.println("注册成功");
        out.flush();
    }

}
