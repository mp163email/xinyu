package 控制反转;

/**
 * des:
 * created by miapoeng on 2020/4/10 10:41
 */
public class Player {
    public void sendMessage (Message message) {
        System.out.println("发送消息>>>" + message.getMsg());
    }
}
