
package graphics.manager;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TopBorderController implements Initializable {
    @FXML
    private Label timeLabel;
    @FXML
    public  Label welcomeLabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            String min = Integer.toString(currentTime.getMinute());
            String sec = Integer.toString(currentTime.getSecond());
            if (min.length() == 1) {
                min = "0" + min;
            }
            if (sec.length() == 1) {
                sec = "0" + sec;
            }
            timeLabel.setText(currentTime.getHour() + ":" + min + ":" + sec);
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }    
    public  void getUser(String user) {
        
        welcomeLabel.setText("کاربر : "+user);

    }
    
}
