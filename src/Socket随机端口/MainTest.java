package Socket随机端口;

import java.net.ServerSocket;

/**
 * des:
 * created by miapoeng on 2020/4/27 10:39
 */
public class MainTest {
    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 10; i++) {
            ServerSocket serverSocket = new ServerSocket(0);//设置成0就是随机端口， 为啥我这随机端口是5万多开始的，内网机器上是3万开始的呢
            int randomPort = serverSocket.getLocalPort();
            serverSocket.close();
            System.out.println(randomPort);
        }
    }
}
