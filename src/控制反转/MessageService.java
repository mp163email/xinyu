package 控制反转;

/**
 * des:
 * created by miapoeng on 2020/4/10 10:41
 */
public class MessageService {

    private Player player;

    private Message message;

    public MessageService(Player player, Message message) {
        this.player = player;
        this.message = message;
    }

    public void playerSendMessage () {
        player.sendMessage(message);
    }

    public void messageSendByPlayer () {
        message.sendMessage(player);
    }
}
