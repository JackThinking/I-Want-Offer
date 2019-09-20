package playground.concurrent;

/**
 * Created by Citrix on 2019/9/18.
 */
public interface Producer {
    void produce() throws InterruptedException;
}
