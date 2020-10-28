import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService threadPool = Executors.newFixedThreadPool(cores);
        List<MyCallable> myTasks = Arrays.asList(new MyCallable(), new MyCallable(), new MyCallable(), new MyCallable());
        List<Future<Integer>> futures = threadPool.invokeAll(myTasks);
        Integer result = 0;
        for (Future<Integer> task : futures) {
            result += task.get();
        }
        System.out.println("Количество отправленных сообщений: " + result);
        threadPool.shutdown();

    }
}


