class FibonacciException extends Exception {
    public FibonacciException(String message) {
        super(message);
    }
}

class PrimeThread extends Thread {
    @Override
    public void run() {
        calculatePrimes();
    }

    private void calculatePrimes() {
        System.out.println("Calculating first 25 prime numbers...");
        int count = 0;
        int num = 2;

        while (count < 25) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
        System.out.println("\nPrime calculation complete.");
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class FibonacciThread extends Thread {
    @Override
    public void run() {
        try {
            calculateFibonacci();
        } catch (FibonacciException e) {
            System.out.println(e.getMessage());
        }
    }

    private void calculateFibonacci() throws FibonacciException {
        System.out.println("Calculating first 50 Fibonacci numbers...");
        int n = 50;
        int[] fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            System.out.print(fib[i] + " ");

            if (i == 25) {
                try {
                    System.out.println("\nFibonacci thread sleeping for 3 seconds...");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new FibonacciException("Fibonacci thread interrupted. Moving to prime computation.");
            }
        }

        System.out.println("\nFibonacci calculation complete.");
    }
}

public class ThreadExercise1 {
    public static void main(String[] args) {
        PrimeThread primeThread = new PrimeThread();
        FibonacciThread fibonacciThread = new FibonacciThread();

        // Set thread priorities
        primeThread.setPriority(Thread.MIN_PRIORITY); // Priority 5
        fibonacciThread.setPriority(Thread.MAX_PRIORITY); // Priority 8

        // Start threads
        primeThread.start();
        fibonacciThread.start();

        try {
            // Wait for threads to finish
            primeThread.join();
            fibonacciThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread exiting.");
    }
}
