package MainBranch;

import MainBranch.Database.DatabaseConn;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;

public class SettingMain
{
    public static void setSetting(Stage primaryStage)
    {
        primaryStage.setTitle("Setting");

        Label labelTitle = new Label("SETTING");
        labelTitle.setPadding(new Insets(0, 10, 30, 10));

        Label labelSet = new Label("Set Path To Database");
        labelSet.setPadding(new Insets(50, 10, 10, 10));
        labelSet.setId("title-label");

        Label labelEg = new Label("eg: D:\\\\Resources\\\\Database\\\\smsDemo.accdb");
        labelEg.setPadding(new Insets(0, 10, 30, 10));
        labelEg.setId("title-label");

        TextField dbPathInput = new TextField();
        dbPathInput.setPromptText("eg: D:\\Resources\\Database\\smsDemo.accdb");
        dbPathInput.setPrefWidth(500);
        dbPathInput.setPrefHeight(25);

        Button applyButton = new Button("Apply");
        applyButton.setPrefWidth(150);
        applyButton.setPrefHeight(25);
        applyButton.setOnAction(e -> {
            DatabaseConn.dbPath = dbPathInput.getText();
            Homepage.setHomePage(primaryStage);
        });

        Button backButton = new Button("Back");
        backButton.setPrefHeight(20);
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> {
            AboutPage.setAboutPage(primaryStage);
        });

        VBox layoutMain = new VBox(20);
        layoutMain.getChildren().addAll(labelTitle, labelSet, labelEg, dbPathInput, applyButton, backButton);
        layoutMain.setAlignment(Pos.CENTER);
        layoutMain.setMargin(labelSet, new Insets(50, 50, 10, 50));
        layoutMain.setMargin(dbPathInput, new Insets(10, 50, 50, 50));

        Scene scene = new Scene(layoutMain, 800, 800);
        scene.getStylesheets().add("MainBranch/Stylesheet/homepageStyle.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
