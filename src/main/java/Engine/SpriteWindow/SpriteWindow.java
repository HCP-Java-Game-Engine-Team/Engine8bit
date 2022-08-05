package Engine.SpriteWindow;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.InputMismatchException;

public class SpriteWindow extends Application {
    private Group root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sprite Editor");
        stage.show();
        Scene sprScene = new Scene(root);
        stage.setScene(sprScene);

        int canvasSize = getCanvas();
        System.out.println(canvasSize);
    }

    private int getCanvas() {
        Label errorLabel = new Label();
        Label sizeLabel1 = new Label("Width: ");
        TextField sizeField = new TextField("Enter a value less than or equal to 255");
        Label sizeLabel2 = new Label("Height: ");
        TextField sizeField2 = new TextField("Enter a value less than or equal to 255");
        Button enterButton = new Button("Submit");
        HBox hb = new HBox();
        root.getChildren().add(hb);
        hb.getChildren().addAll(errorLabel, sizeLabel1, sizeField, sizeLabel2, sizeField2, enterButton);
        hb.setSpacing(10);
        enterButton.setOnAction(event -> {
            try {
                width = Integer.parseInt(sizeField.getText());
                height = Integer.parseInt(sizeField2.getText());
            } catch (InputMismatchException e) {
                errorLabel.setText("Sorry that input was invalid, please try again");
            }
        });
    }
}
