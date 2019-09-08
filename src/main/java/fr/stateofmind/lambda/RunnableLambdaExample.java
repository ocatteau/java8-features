package fr.stateofmind.lambda;

public class RunnableLambdaExample {

    public static void main(String[] args) {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside runnable 1");
            }
        };

        new Thread(runnable1).run();

        // Java 8 Lambda
        Runnable runnableLambda = () -> {
            System.out.println("Inside runnable 2");
        };
        new Thread(runnableLambda).run();

        Runnable runnableLambda1 = () -> System.out.println("Inside runnable 3");
        new Thread(runnableLambda1).run();

        new Thread(() -> System.out.println("Inside runnable 4")).run();
    }
}
