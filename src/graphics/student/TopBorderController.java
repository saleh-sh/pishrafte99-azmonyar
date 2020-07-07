
package graphics.student;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
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
    @FXML
    Label liveDate; 
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
            liveDate.setText(LocalDate.now().toString());
            
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }    
    public  void getUser(String user) {
        
        welcomeLabel.setText("دانشجو : "+user);

    }
    
}
