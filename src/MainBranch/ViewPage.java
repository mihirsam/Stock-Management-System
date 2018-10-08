package MainBranch;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;

public class ViewPage
{
    public static void viewPageMain()
    {
        Stage window = new Stage();
        window.setTitle("View Page");
        window.initModality(Modality.APPLICATION_MODAL);

        Label title = new Label("VIEW PAGE");

        Button viewDatabase = new Button("Database");
        viewDatabase.setPrefHeight(50);
        viewDatabase.setPrefWidth(300);
        /*viewDatabase.setOnAction(e -> {

        }); */

        Button viewSales = new Button("Sales Record");
        viewSales.setPrefHeight(50);
        viewSales.setPrefWidth(300);

        Button viewBuy = new Button("Buy Records");
        viewBuy.setPrefHeight(50);
        viewBuy.setPrefWidth(300);

        Button backButton = new Button("Back");
        backButton.setPrefHeight(20);
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> {
            window.close();
        });

        VBox layoutMain = new VBox(20);
        layoutMain.getChildren().addAll(title, viewDatabase, viewSales, viewBuy, backButton);
        layoutMain.setPadding(new Insets(50, 10, 10, 10));
        layoutMain.setMargin(viewDatabase, new Insets(120, 0, 0, 0));
        layoutMain.setMargin(viewSales, new Insets(20, 0, 0, 0));
        layoutMain.setMargin(viewBuy, new Insets(20, 0, 0, 0));
        layoutMain.setMargin(backButton, new Insets(60, 0, 0, 0));
        layoutMain.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(layoutMain, 800, 800);
        scene.getStylesheets().add("MainBranch/Stylesheet/homepageStyle.css");

        window.setScene(scene);
        window.initStyle(StageStyle.UNDECORATED);
        window.showAndWait();
    }
}
