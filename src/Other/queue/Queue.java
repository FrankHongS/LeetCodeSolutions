package Other.queue;

/**
 * Created by Frank_Hon on 2019-07-20 12:00.
 * E-mail: frank_hon@foxmail.com
 */
public interface Queue<T> {

    void push(T item);

    T pop();

    int size();

    boolean isEmpty();

}
