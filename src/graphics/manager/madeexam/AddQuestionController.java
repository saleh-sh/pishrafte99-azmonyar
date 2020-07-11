package graphics.manager.madeexam;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import graphics.launcher.Start;

public class AddQuestionController implements Initializable {

    private int numQue = 0;
    @FXML
    private GridPane gridGroups;
    private static ArrayList<String> groupsName = new ArrayList<>();
    private ObservableList<String> type = FXCollections.observableArrayList("تستی",
            "صحیح/غلط", "تشریحی");
    @FXML
    private ComboBox typeQuestion;
    @FXML
    private Button nextStepButton;
    @FXML
    private Button saveAndGoButton;
    @FXML
    private Button addQuestionButton;
    @FXML
    private Label typeLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeQuestion.setItems(type);
        gridGroups.setVgap(15);
        gridGroups.setPadding(new Insets(10));
        if (!groupsName.isEmpty()) {
            saveAndGoButton.setVisible(true);
        }
    }

    public void saveAndGoButton() throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FinalSetting.fxml"));
        BorderPane border = loader1.load();
        Start.getBorder().setCenter(border);
    }

    public void addQuestion(String Question) {
        groupsName.add(Question);
        for (int r = 0; r < groupsName.size(); r++) {
            Button button = new Button(groupsName.get(r));
            button.setFont(Font.font("B Koodak", 12));
            button.setPrefWidth(500);
            button.setMinHeight(60);
            button.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            button.setAlignment(Pos.CENTER_LEFT);
            button.setStyle(""
                    + "-fx-background-radius:10;"
                    + "-fx-border-color:white;"
                    + "-fx-border-radius:10;"
                    + "-fx-border-width:1");
            gridGroups.add(button, 0, r);
            GridPane.setHalignment(button, HPos.CENTER);
            GridPane.setValignment(button, VPos.CENTER);
        }

    }

    public void addQuestionButtonAction() {
        addQuestionButton.setVisible(false);
        typeQuestion.setVisible(true);
        typeLabel.setVisible(true);
    }

    public void typeQuestionAction() {
        if ((String) typeQuestion.getValue() != null) {
            nextStepButton.setVisible(true);
        }
    }

    public void nextStepButton() throws IOException {
        numQue++;
        FXMLLoader loader = new FXMLLoader();
        BorderPane border;
        String value = (String) typeQuestion.getValue();
        if (value.equals("تستی")) {
            loader.setLocation(getClass().getResource("TestQuestion.fxml"));
            border = loader.load();
            TestQuestionController userController2 = (TestQuestionController) loader.getController();
            userController2.setNumQue(numQue);
        } else if (value.equals("تشریحی")) {
            loader.setLocation(getClass().getResource("TextQuestion.fxml"));
            border = loader.load();
            TextQuestionController userController2 = (TextQuestionController) loader.getController();
            userController2.setNumQue(numQue);
        } else {
            loader.setLocation(getClass().getResource("TFQuestion.fxml"));
            border = loader.load();
            TFQuestionController userController2 = (TFQuestionController) loader.getController();
            userController2.setNumQue(numQue);
        }
        Start.getBorder().setCenter(border);
    }
}
