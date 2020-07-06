package graphics.manager.madeexam;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import graphics.launcher.Start;
import graphics.manager.MainPageController;
import javafx.scene.control.ScrollPane;
import manager.tools.FormattedFiled;

public class SaveExamController implements Initializable {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane gridGroups;
    private static ArrayList<String> groupsName = new ArrayList<>();
    @FXML
    private Button browseButton;
    @FXML
    private Button finishButton;
    @FXML
    private Button addStudentButton;
    @FXML
    private Label pathFileLabel;
    @FXML
    private RadioButton excelRadioButton;
    @FXML
    private RadioButton manualRadioButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gridGroups.setVgap(5);
        gridGroups.setHgap(15);
        gridGroups.setPadding(new Insets(10));
    }

    public void finishButtonAction() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainPageController.class.getResource("MainPage.fxml"));
        BorderPane border = loader.load();
        Start.getBorder().setCenter(border);
        MainPageController userController2 = (MainPageController) loader.getController();
                //just for test we should add it when we get groups chat from database
                userController2.setGroups(new String[]{"گروه اول","گروه دوم"});
    }

    public void browseButtonAction() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
        File file = fc.showOpenDialog(null);
        if (file != null) {
            pathFileLabel.setText("Selected File:" + file.getAbsolutePath());
        }
    }

    public void addStudentButtonAction() {
        Dialog<Results> dialog = new Dialog<>();
        dialog.setTitle("Dialog Test");
        dialog.setHeaderText("Please specify…");
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField nameField = new TextField("نام");
        nameField.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        TextField lastNameField = new TextField("نام خانوادگی");
        lastNameField.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        TextField IDField = new TextField();
        IDField.setPromptText("شماره دانشجویی");
        IDField.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        IDField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    IDField.setText(newValue.replaceAll("[^\\d]", ""));
                } else {

                }
            }

        });
        dialogPane.setContent(new VBox(8, nameField, lastNameField, IDField));
        Platform.runLater(nameField::requestFocus);
        dialog.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                return new Results(nameField.getText(),
                        lastNameField.getText(), Long.valueOf(IDField.getText()));
            }
            return null;
        });
        Optional<Results> optionalResult = dialog.showAndWait();
        optionalResult.ifPresent((Results results) -> {
            addQuestion((String.valueOf(results.studentId)));
        });
    }

    public void addQuestion(String Question) {
        groupsName.add(Question);
        int column = 0;
        for (int r = 0; r < groupsName.size(); r++) {
            Button button = new Button(groupsName.get(r));
            button.setFont(Font.font("B Koodak", 12));
            button.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            button.setAlignment(Pos.CENTER);
            button.setPrefWidth(100);
            button.setStyle(""
                    + "-fx-background-radius:10;"
                    + "-fx-border-color:white;"
                    + "-fx-border-radius:10;"
                    + "-fx-border-width:1");
            gridGroups.add(button, column, r/5);
            GridPane.setHalignment(button, HPos.CENTER);
            GridPane.setValignment(button, VPos.CENTER);
            column++;
            if (column==5) {
                column=0;
            }
        }

    }

    public void excelRadioButtonAction() {
        browseButton.setDisable(false);
        pathFileLabel.setDisable(false);
        addStudentButton.setDisable(true);
        scrollPane.setDisable(true);
    }

    public void manualRadioButtonAction() {
        browseButton.setDisable(true);
        pathFileLabel.setDisable(true);
        addStudentButton.setDisable(false);
        scrollPane.setDisable(false);
    }
}

class Results {

    String name;
    String lastName;
    long studentId;

    public Results(String name, String lastname, long studentId) {
        this.name = name;
        this.lastName = lastname;
        this.studentId = studentId;
    }
}
