package jetty的使用;

/**
 * des:
 * created by miapoeng on 2020/8/20 16:09
 */
public class JettyMain {

    //http://127.0.0.1:8103/miaopeng/register?uname=miao&pwd=1234
    public static void main(String[] args) throws Exception {
        JettyServer jettyServer = new JettyServer("0.0.0.0", 8103, 1, 5);
        jettyServer.addServlet("/miaopeng/register", new MyJettyServlet());
        jettyServer.start();
        System.out.println("-------Jetty Server Start Succ---------");
    }
}
