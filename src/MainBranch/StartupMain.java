package MainBranch;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StartupMain extends Application
{
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)
    {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Homepage.setHomePage(primaryStage);
    }
}

