package 控制反转;

/**
 * des:
 * created by miapoeng on 2020/4/10 10:41
 */
public class TestMain {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMsg("this is a message");

        Player player = new Player();

        //组装，管理
        MessageService messageService = new MessageService(player, message);

        //顺序方式
        messageService.playerSendMessage();

        //逆序方式
        messageService.messageSendByPlayer();
    }
}
