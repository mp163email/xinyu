package jetty的使用;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;
import org.mortbay.thread.QueuedThreadPool;

import javax.servlet.http.HttpServlet;

/**
 * des:
 * created by miapoeng on 2020/8/20 15:58
 */
public class JettyServer {
    private Server server = null;
    private Context root = null;
    private String host = null;
    private int port;

    public JettyServer (String host, int port, int minThread, int maxThread) {

        this.port = port;
        this.host = host;

        server = new Server();

        QueuedThreadPool threadPool = new QueuedThreadPool();
        threadPool.setMinThreads(minThread);
        threadPool.setMaxThreads(maxThread);
        server.setThreadPool(threadPool);

        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(port);
        connector.setHost(host);
        connector.setMaxIdleTime(3000);
        server.addConnector(connector);

        root = new Context(server, "/", Context.SESSIONS);
    }

    public void addServlet(String url, HttpServlet servlet) {
        root.addServlet(new ServletHolder(servlet), url);
    }

    public void start () throws Exception {
        server.start();
    }
}
