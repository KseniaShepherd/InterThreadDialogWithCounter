import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    Integer count = 0;

    @Override
    public Integer call() throws Exception {
        while (count < 2) {
            System.out.println(("Я поток " + Thread.currentThread().getName() + ". Всем привет!"));
            count++;
        }
        return count;
    }
}
