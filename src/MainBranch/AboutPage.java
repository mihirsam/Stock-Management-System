package MainBranch;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;

public class AboutPage
{
    public static void setAboutPage(Stage primaryStage)
    {
        primaryStage.setTitle("About");

        Label labelTitle = new Label("ABOUT");
        labelTitle.setPadding(new Insets(0, 10, 30, 10));

        final String aboutText = "Stock Management System is a software system for tracking inventory levels, orders, sales and deliveries." +
                " It can also be used in the manufacturing industry to create a work order, " +
                "bill of materials and other production-related documents. " +
                "Companies use stock management software to avoid product overstock and outages. " +
                "It is a tool for organizing inventory data that before was generally stored in hard-copy form" +
                " or in spreadsheets.";

        Label labelAbout = new Label(aboutText);
        labelAbout.setId("about-text");
        labelAbout.setWrapText(true);

        Button settingButton = new Button("Setting");
        settingButton.setPrefWidth(150);
        settingButton.setPrefHeight(25);
        settingButton.setOnAction(e -> {
            //set address of database
            SettingMain.setSetting(primaryStage);
        });

        Button backButton = new Button("Back");
        backButton.setPrefWidth(100);
        backButton.setPrefHeight(20);
        backButton.setOnAction(e -> {
            Homepage.setHomePage(primaryStage);
        });

        VBox layoutMain = new VBox(20);
        layoutMain.getChildren().addAll(labelTitle, labelAbout, settingButton, backButton);
        layoutMain.setAlignment(Pos.CENTER);
        layoutMain.setMargin(labelAbout, new Insets(50, 50, 50, 50));

        Scene scene = new Scene(layoutMain, 800, 800);
        scene.getStylesheets().add("MainBranch/Stylesheet/homepageStyle.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
