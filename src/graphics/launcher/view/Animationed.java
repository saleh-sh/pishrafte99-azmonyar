package graphics.launcher.view;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Admin
 */
public class Animationed {

    private int count;
    private double opacity;
    private BorderPane border;
    public Animationed(int count, BorderPane border, double opacity) {
        this.count =count;
        this.opacity = opacity;
        this.border = border;
    }
    public void generateAnimation(){
        for (int i = 0; i < count; i++) {
            Animation(border, opacity);
        }
    }
    public void removeAnimation() {
        border.getChildren().removeAll();
    }

    private void Animation(BorderPane border, double opacity) {
        Random rand = new Random();
        int sizeOfSqaure = rand.nextInt(50) + 1;
        int speedOfSqaure = rand.nextInt(10) + 5;
        int startXPoint = rand.nextInt((int) border.getWidth());
        int startYPoint = rand.nextInt((int) border.getHeight());
        int direction = rand.nextInt(5) + 1;

        KeyValue moveXAxis = null;
        KeyValue moveYAxis = null;
        Rectangle r1 = null;

        switch (direction) {
            case 1:
                // MOVE LEFT TO RIGHT
                r1 = new Rectangle(0, startYPoint, sizeOfSqaure, sizeOfSqaure);
                moveXAxis = new KeyValue(r1.xProperty(), border.getWidth() - sizeOfSqaure);
                break;
            case 2:
                // MOVE TOP TO BOTTOM
                r1 = new Rectangle(startXPoint, 0, sizeOfSqaure, sizeOfSqaure);
                moveYAxis = new KeyValue(r1.yProperty(), border.getHeight() - sizeOfSqaure);
                break;
            case 3:
                // MOVE LEFT TO RIGHT, TOP TO BOTTOM
                r1 = new Rectangle(startXPoint, 0, sizeOfSqaure, sizeOfSqaure);
                moveXAxis = new KeyValue(r1.xProperty(), border.getWidth() - sizeOfSqaure);
                moveYAxis = new KeyValue(r1.yProperty(), border.getHeight() - sizeOfSqaure);
                break;
            case 4:
                // MOVE BOTTOM TO TOP
                r1 = new Rectangle(startXPoint, border.getHeight() + 20 - sizeOfSqaure, sizeOfSqaure, sizeOfSqaure);
                moveYAxis = new KeyValue(r1.xProperty(), 0);
                break;
            case 5:
                // MOVE RIGHT TO LEFT
                r1 = new Rectangle(border.getHeight() + 20 - sizeOfSqaure, startYPoint, sizeOfSqaure, sizeOfSqaure);
                moveXAxis = new KeyValue(r1.xProperty(), 0);
                break;
            case 6:
                //MOVE RIGHT TO LEFT, BOTTOM TO TOP
                r1 = new Rectangle(startXPoint, 0, sizeOfSqaure, sizeOfSqaure);
                moveXAxis = new KeyValue(r1.xProperty(), border.getWidth() - sizeOfSqaure);
                moveYAxis = new KeyValue(r1.yProperty(), border.getHeight() - sizeOfSqaure);
                break;

            default:
                System.out.println("default");
        };
        r1.setFill(Color.rgb(68, 114, 226, opacity));

        KeyFrame keyFrame = new KeyFrame(Duration.millis(speedOfSqaure * 1000), moveXAxis, moveYAxis);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        border.getChildren().add(border.getChildren().size() - 1, r1);

    }
}
