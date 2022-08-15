package Engine;
import javafx.application.Application;
import javafx.stage.Stage;

/*
    Step: Programmatically open a window
 */

public class Start extends Application {


    // Method needed to open the window
    public static void main(String[] args) {
        launch(args);
    }


    // Method that declares the structure of the window
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Engine Prototype");
        stage.show();
    }
}
