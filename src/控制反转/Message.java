package 控制反转;

/**
 * des:
 * created by miapoeng on 2020/4/10 10:41
 */
public class Message {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void sendMessage (Player player) {
        player.sendMessage(this);
    }
}
