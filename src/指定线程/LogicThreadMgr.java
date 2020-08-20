package 指定线程;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * des:
 * created by miapoeng on 2020/4/11 9:03
 */
public class LogicThreadMgr {

    private static final int THREAD_NUM = 5;

    private LogicThread[] logicThreads = new LogicThread[THREAD_NUM];
    private ArrayBlockingQueue<Package>[] blockingQueues = new ArrayBlockingQueue[THREAD_NUM];

    public static LogicThreadMgr instance;

    public static LogicThreadMgr getInstance () {
        if (instance == null) {
            instance = new LogicThreadMgr();
        }
        return instance;
    }

    private LogicThreadMgr () {

    }

    /**
     * 初始化
     */
    public void initThread () {
        for (int i = 0; i < THREAD_NUM; i++) {
            blockingQueues[i] = new ArrayBlockingQueue(1024);
        }
        for (int i = 0; i < THREAD_NUM; i++) {
            logicThreads[i] = new LogicThread(blockingQueues[i]);
            logicThreads[i].start();
        }
    }

    /**
     * 向队列中插入数据包
     */
    public void insertQueue (Package pkg) {
        if (pkg == null) {
            return;
        }
        int playerId = pkg.getPlayerId();
        int queueIndex = playerId % THREAD_NUM;
        ArrayBlockingQueue<Package> blockingQueue = blockingQueues[queueIndex];
        try {
            blockingQueue.put(pkg);
        } catch (Exception e) {
            System.out.println("put queue error, playerid = " + pkg.getPlayerId());
        }
    }

    /**
     * 逻辑线程
     */
    private class LogicThread extends Thread{

        private ArrayBlockingQueue<Package> msgQueue;

        public LogicThread (ArrayBlockingQueue<Package> msgQueue) {
            this.msgQueue = msgQueue;
        }

        @Override
        public void run() {
            while (true) {
                Package pkg = msgQueue.poll();
                if (pkg == null) {
                    continue;
                }
                System.out.println(Thread.currentThread().getName() + " 处理包 " + pkg.getHead());
            }
        }
    }


}
