package playground.concurrent;

/**
 * Created by Citrix on 2019/9/18.
 */
abstract class AbstractProducer implements Runnable, Producer {
    @Override
    public void run() {
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
