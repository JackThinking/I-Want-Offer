package playground.concurrent;

/**
 * Created by Citrix on 2019/9/18.
 */
abstract class AbstractConsumer implements Runnable, Consumer {
    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
