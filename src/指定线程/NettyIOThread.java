package 指定线程;

import java.util.concurrent.locks.LockSupport;

/**
 * des:
 * created by miapoeng on 2020/4/11 9:03
 */
public class NettyIOThread {
    public static void main(String[] args) {
        LogicThreadMgr.getInstance().initThread();
        LockSupport.parkNanos(1000 * 1000 * 5000);
        int index = 0;
        while (true) {
            index ++;
            LockSupport.parkNanos(1000 * 1000 * 500);
            Package pkg = new Package();
            pkg.setHead(index);
            pkg.setPlayerId(index);
            pkg.setMsg(index);
            LogicThreadMgr.getInstance().insertQueue(pkg);
        }
    }
}
