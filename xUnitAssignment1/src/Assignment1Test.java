import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class Assignment1Test {

    Assignment1 assignment1 = new Assignment1();
    QueueImpl newQueue = assignment1.createQueue("int");


    @BeforeEach
    void setUp() {
        assignment1.addInt(10);
        assignment1.addInt(11);
        assignment1.addInt(12);
        assignment1.addInt(15);
    }

    @AfterEach
    void tearDown() {
        for (int i = 0; i < assignment1.checkSize(); i++){
            assignment1.removeElement();
        }
    }


    @Test
    void createQueue() {
        RuntimeException thrown = Assertions.assertThrows(
                RuntimeException.class,
                () -> assignment1.createQueue("bool"),
                "Expected assignment1.createQueue() to throw RuntimeException, but it didn't"
        );
        Assertions.assertTrue(thrown.getMessage().contains("string Or integer"));
        System.out.println("Boolean test for createQueue() successfull!");

        RuntimeException thrown2 = Assertions.assertThrows(
                RuntimeException.class,
                () -> assignment1.createQueue("short"),
                "Expected assignment1.createQueue() to throw RuntimeException, but it didn't"
        );
        Assertions.assertTrue(thrown2.getMessage().contains("string Or integer"));
        System.out.println("Short test for createQueue() successfull!");

        RuntimeException thrown3 = Assertions.assertThrows(
                RuntimeException.class,
                () -> assignment1.createQueue("array"),
                "Expected assignment1.createQueue() to throw RuntimeException, but it didn't"
        );
        Assertions.assertTrue(thrown3.getMessage().contains("string Or integer"));
        System.out.println("Array test for createQueue() successfull!");

        RuntimeException thrown4 = Assertions.assertThrows(
                RuntimeException.class,
                () -> assignment1.createQueue("long"),
                "Expected assignment1.createQueue() to throw RuntimeException, but it didn't"
        );
        Assertions.assertTrue(thrown4.getMessage().contains("string Or integer"));
        System.out.println("Long test for createQueue() successfull!");

        QueueImpl tempQueue = assignment1.createQueue("str");
        Assertions.assertEquals(tempQueue.getClass(), QueueImpl.class);
        System.out.println("Class check test for createQueue() successfull!");
    }


    @Test
    void addInt() {
        int oldSize = assignment1.checkSize();
        assignment1.addInt(1000);
        int newSize = assignment1.checkSize();
        Assertions.assertTrue(newSize > oldSize);
        System.out.println("Test addInt() Successfull!");
    }

    @Test
    void peekFirst()
    {
        Assertions.assertEquals("Success", assignment1.peekFirst());
        System.out.println("Test peekFirst() Successfull!");
    }

    @Test
    void removeElement() {
        int oldSize = assignment1.checkSize();
        Assertions.assertEquals("Removed", assignment1.removeElement());
        int newSize = assignment1.checkSize();
        Assertions.assertTrue(newSize < oldSize);
        System.out.println("Test removeElement() Successfull!");
    }

    @Test
    void checkSize() {
        Assertions.assertEquals("Not Empty", assignment1.checkEmpty());
        Assertions.assertTrue(0 != assignment1.checkSize());
        System.out.println("Test checkSize() Successfull!");
    }

    @Test
    void checkEmpty() {
        Assertions.assertEquals("Not Empty", assignment1.checkEmpty());
        int queueLen = assignment1.checkSize();
        for (int i = 0; i < queueLen; i++){
            assignment1.removeElement();
        }
        Assertions.assertEquals(0, assignment1.checkSize());
        Assertions.assertEquals("Empty", assignment1.checkEmpty());
        System.out.println("Test checkEmpty() Successfull!");
    }

}