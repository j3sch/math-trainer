package org.trainer;

import org.trainer.Exercise.Arithmetic;
import org.trainer.Exercise.Factory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Factory f1 = new Factory();

        try (final Scanner scanner = new Scanner(System.in)) {

            int userInput;

            do {
                String randomType = f1.getRandomType(true, true, true);

                Arithmetic task = f1.getArithmetic(randomType, "beGinneR");

                int[] arr = task.getTask();
                System.out.println("calculate: " + task.getRenderedTask(arr));

                userInput = scanner.nextInt();

                if (task.checkSolution(arr, userInput)) {
                    System.out.println(userInput + " is correct");
                } else {
                    System.out.println(userInput + " isn't correct.");
                }
            } while (true);
        }
    }
}
