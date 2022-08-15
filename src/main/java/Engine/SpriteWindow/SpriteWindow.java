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

/*
    Step: Program a sprite editing platform
 */
public class SpriteWindow extends Application {

    // private attribute that contains the structure of the window
    private Group root;

    // Method needed to open the window
    public static void main(String[] args) {
        launch(args);
    }


    // Method that declares the structure of the window
    @Override
    public void start(Stage stage) throws Exception {
        // Set name of window
        stage.setTitle("Sprite Editor");
        // Set visibility of window
        stage.show();
        // create root as a group of nodes
        root = new Group();
        // create new scene and add root as node group
        Scene sprScene = new Scene(root);
        // set the stage scene as the previously created scene
        stage.setScene(sprScene);


        // get the canvas # of pixels from the getCanvas method
        int canvasSize = getCanvas();
        // print out the # of pixels for testing
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
