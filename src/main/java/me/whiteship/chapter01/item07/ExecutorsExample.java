package me.whiteship.chapter01.item07;

import java.util.concurrent.*;

/**
 * ScheduledThreadPoolExecutor
 *
 * Thread, Runnable, ExecutorService
 * 쓰레드풀의 개수를 정할 때 주의할 것
 *  - CPU, I/O
 *
 * 쓰레드풀의 종류
 *  - Single, Fixed, Cached, Scheduled
 *
 * Runnable, Callable, Future
 *
 * CompletableFuture, ForkJoinPool
 */
public class ExecutorsExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int numberOfCpu = Runtime.getRuntime().availableProcessors();
        
        // Blocking Queue 사용
        ExecutorService service = Executors.newFixedThreadPool(numberOfCpu);

        // 필요한만큼만 만든다. 놀고 있는 Thread 가 있으면 재사용
        // Thread 가 무한정 늘어날 수 있다...
        ExecutorService cacheService = Executors.newCachedThreadPool();

        // Thread 를 하나만 만든다.
        ExecutorService singleService = Executors.newSingleThreadExecutor();

        // 주기적으로 실행하거나 몇 초 후 실행하거나 등등에 사용...
        ExecutorService scheduledService = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 100; i++) {
            service.submit(new Task());
        }

        Future<String> submit = service.submit(new CallAbleTask());

        System.out.println(Thread.currentThread() + " hello");

        // Blocking 됨
        System.out.println(submit.get());

        service.shutdown();
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " world");
        }
    }

    /**
     * Callable
     *  - return 을 받고 싶을 경우
     *  - return type 으로는 Future 를 받는다.
     */
    static class CallAbleTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(2000L);
            return Thread.currentThread() + " world";
        }
    }
}
