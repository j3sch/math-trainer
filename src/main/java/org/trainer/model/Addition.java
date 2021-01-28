package org.trainer.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Addition extends Task {

    private static final Logger log = LogManager.getLogger(Addition.class);

    public Addition(String difficulty) {
        this.difficulty = difficulty;
        this.operands = new int[3];
        this.operands = createOperationArray();
        this.renderedTask = renderTask();
    }

    private int[] createOperationArray() {
        int max = 0, min = 0, rand1, rand2;

        switch (difficulty) {
            case BEGINNER:
                max = 50;
                min = 1;
                break;
            case MEDIUM:
                max = 500;
                min = 100;
                break;
            case HARD:
                max = 5000;
                min = 1000;
                break;
        }

        rand1 = RAND.nextInt((max - min) + 1) + min;
        rand2 = RAND.nextInt((max - min) + 1) + min;
        operands[0] = rand1;
        operands[1] = rand2;
        operands[2] = rand1 + rand2;

        log.info("{}+{}={}", operands[0], operands[1], operands[2]);

        return operands.clone();

    }

    private String renderTask() {
        return operands[0] + "+" + operands[1];
    }

}