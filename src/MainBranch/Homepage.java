package MainBranch;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;

public class Homepage
{
    static Button viewButton, buyButton, sellButton, aboutButton, exitButton;

    public static void setHomePage(Stage primaryStage)
    {
        Label labelTitle = new Label();
        labelTitle.setText("Inventory Management System");
        labelTitle.setAlignment(Pos.CENTER);

        viewButton = new Button("View");
        viewButton.setPrefHeight(50);
        viewButton.setPrefWidth(300);

        viewButton.setOnAction( e-> {
            try {
                ViewPage.viewPageMain(primaryStage);
            }
            catch(Exception el)
            {
                el.printStackTrace();
            }
        });


        buyButton = new Button("Buy");
        buyButton.setPrefHeight(50);
        buyButton.setPrefWidth(300);
        buyButton.setOnAction(e -> {
            BuyPage.BuyPageMain(primaryStage);
        });


        sellButton = new Button("Sell");
        sellButton.setPrefHeight(50);
        sellButton.setPrefWidth(300);
        sellButton.setOnAction( e-> {
            SellPage.SellPageMain(primaryStage);
            });

        aboutButton = new Button("About");
        aboutButton.setPrefHeight(50);
        aboutButton.setPrefWidth(300);
        aboutButton.setOnAction(e -> {
            AboutPage.setAboutPage(primaryStage);
        });

        exitButton = new Button("Exit");
        exitButton.setPrefHeight(50);
        exitButton.setPrefWidth(300);
        exitButton.setOnAction(e -> {
            if(ExitConfirmMain.ExitConfirm())
            {
                primaryStage.close();
            }
        });

        VBox layoutTop = new VBox(20);
        layoutTop.setAlignment(Pos.CENTER);
        layoutTop.setPadding(new Insets(50, 10, 10, 10));
        layoutTop.getChildren().add(labelTitle);

        VBox layoutCenter = new VBox(40);
        layoutCenter.setAlignment(Pos.CENTER);
        layoutCenter.getChildren().addAll(viewButton, buyButton, sellButton, aboutButton, exitButton);

        BorderPane layoutMain = new BorderPane();
        layoutMain.setTop(layoutTop);
        layoutMain.setCenter(layoutCenter);

        Scene scene = new Scene(layoutMain, 800, 800);
        scene.getStylesheets().add("MainBranch/Stylesheet/homepageStyle.css");

        //window = primaryStage;
        primaryStage.setTitle("Homepage");
        primaryStage.setScene(scene);
        //window.setFullScreen(true);
        //window.setMaximized(true);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

}
