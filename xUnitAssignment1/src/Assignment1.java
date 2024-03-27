import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Assignment1 {


    QueueImpl newQueue = createQueue("str");

    public QueueImpl createQueue(String type){
        if (type.equals("int")){
            QueueImpl<Integer> newQueue = new QueueImpl<>();
            return newQueue;
        }
        else if (type.equals("str")) {
            QueueImpl<String> newQueue = new QueueImpl<>();
            return newQueue;
        }
        else{
            throw new RuntimeException("Queue can only be created for types string Or integer");
        }
    }


    public String addInt(int number){
        try {
            newQueue.addElement(number);
            return("Success");
        }
        catch (RuntimeException exception){
            System.out.println("Error while adding element to the queue " + number);
            return("Error");
        }
    }

    public String peekFirst(){
        try {
            newQueue.checkFirst();
            return("Success");
        }
        catch (RuntimeException exception){
            System.out.println("Error while checking the first element of the queue");
            return("Error");
        }
    }


    public String removeElement(){
        try {
            newQueue.removeFirstElement();
            return("Removed");
        }
        catch (RuntimeException exception){
            System.out.println("Error while removing first element of the queue.");
            return("Error");
        }
    }


    public int checkSize(){
        try {
            return newQueue.howMany();
        }
        catch (RuntimeException exception){
            System.out.println("Error while adding element to the queue");
            return(-1);
        }
    }

    public String checkEmpty(){
        try {
            if (newQueue.isEmpty()) {
                return("Empty");
            }
            else{
                return("Not Empty");
            }

        }
        catch (RuntimeException exception){
            System.out.println("Error while checking if empty.");
            return("Error");
        }
    }



    public static void main(String[] args) {

        Assignment1 assignment1 = new Assignment1();

//        for (int i = 0; i < 100; i+=2){
//            assignment1.addInt(i*i);
//        }
        assignment1.checkSize();

        assignment1.checkEmpty();

        assignment1.peekFirst();

        assignment1.addInt(1500);

        assignment1.checkEmpty();

        assignment1.checkSize();

        assignment1.removeElement();

        Queue<Integer> intQueue = new LinkedList<>();


    }


}
