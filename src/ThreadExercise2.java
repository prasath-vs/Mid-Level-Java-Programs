import java.util.Random;

class EvenNumberThread extends Thread {
    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int evenNumber = 1000 + 2 * random.nextInt(501); // Generating even numbers between 1000 and 2000
            System.out.println("Even Thread: " + evenNumber);

            try {
                Thread.sleep(random.nextInt(1000)); // Random sleep not exceeding 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class OddNumberThread extends Thread {
    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            int oddNumber = 3001 + 2 * random.nextInt(1500); // Generating odd numbers between 3000 and 6000
            System.out.println("Odd Thread: " + oddNumber);

            try {
                Thread.sleep(random.nextInt(1000)); // Random sleep not exceeding 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadExercise2 {
    public static void main(String[] args) {
        EvenNumberThread evenThread = new EvenNumberThread();
        OddNumberThread oddThread = new OddNumberThread();

        // Start threads
        evenThread.start();
        oddThread.start();

        // Randomly select an integer between 0 and 100
        Random random = new Random();
        int randomInt = random.nextInt(101);
        System.out.println("Main Thread: Random Integer - " + randomInt + ", Square Root - " + Math.sqrt(randomInt));
    }
}
