import java.util.Iterator;
import java.util.LinkedList;

public class QueueImpl<T> implements Iterable<T> {


    @Override
    public Iterator<T> iterator() {
        return null;
    }
    private LinkedList<T> queueList = new LinkedList<T>();

    public QueueImpl() {}

    public  QueueImpl(T firstElement){
        addElement(firstElement);
    }

    public int howMany(){
        return queueList.size();
    }

    public boolean isEmpty(){
        return howMany() == 0;
    }

    public T checkFirst(){
        if (isEmpty()){
            throw new RuntimeException("Empty Queue of Names!");
        }
        return queueList.peekFirst();
    }

    public T removeFirstElement(){
        if (isEmpty()){
            throw new RuntimeException("Cannot remove element from an empty queue!");
        }
        System.out.println("Removing: " + queueList.peekFirst());
        return queueList.removeFirst();
    }


    public void addElement(T element){
        if (element == null){
            throw new RuntimeException("Cannot add null elements to the list!");
        }
        queueList.addLast(element);
    }

}