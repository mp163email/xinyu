package 钩子;

import java.util.concurrent.TimeUnit;

/**
 * des:
 * created by miapoeng on 2020/4/11 16:19
 */
public class HookTest {
    public static void main(String[] args) {
        //注册钩子
        Runtime.getRuntime().addShutdownHook(new Thread(()-> System.out.println("关程序时,执行了钩子方法")));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
