package fr.stateofmind.lambda;

import org.junit.Test;

public class ClosuresTest {


    @Test
    public void test() throws Exception {
        int a = 10;
        int b = 20;
        doProcess(a, i -> System.out.println(i + b));
    }


    private static void doProcess(int i, Process process) {
        process.process(i);
    }

    interface Process {
        void process(int i);
    }
}
