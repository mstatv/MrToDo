package main.screenAnimations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class ErrorShaker {

    // private TranslateTransition object
    private TranslateTransition translateTransition;

    // constructor
    // Node as parameter
    public ErrorShaker(Node node) {

        // init translateTransition object
        translateTransition = new TranslateTransition(Duration.millis(75), node);
        // 0 as a float
        translateTransition.setFromX(0f);
        // movement on x axis 15 as a float
        translateTransition.setByX(15f);
        // cycles movement - 4 cycles
        translateTransition.setCycleCount(4);
        // back and forth
        translateTransition.setAutoReverse(true);

    }

    public void errorShake() {
        // implement animation
        translateTransition.playFromStart();
    }

}
