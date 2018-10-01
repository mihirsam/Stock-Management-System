package MainBranch;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;

public class Homepage extends Application {

    Stage window;
    Button viewButton, buyButton, sellButton;
    BuyPage buyPage = new BuyPage();


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        Label labelTitle = new Label();
        labelTitle.setText("STOCK MANAGEMENT SYSTEM");
        labelTitle.setAlignment(Pos.CENTER);

        viewButton = new Button("VIEW");
        viewButton.setPrefHeight(50);
        viewButton.setPrefWidth(300);
        /*
        viewButton.setOnAction( e-> {

            });
         */

        buyButton = new Button("BUY");
        buyButton.setPrefHeight(50);
        buyButton.setPrefWidth(300);

        buyButton.setOnAction(e -> {
            BuyPage.BuyPageMain();
        });


        sellButton = new Button("SELL");
        sellButton.setPrefHeight(50);
        sellButton.setPrefWidth(300);
        /*
        sellButton.setOnAction( e-> {

            });
         */

        VBox layoutTop = new VBox(20);
        layoutTop.setAlignment(Pos.CENTER);
        layoutTop.setPadding(new Insets(50, 10, 10, 10));
        layoutTop.getChildren().add(labelTitle);

        VBox layoutCenter = new VBox(40);
        layoutCenter.setAlignment(Pos.CENTER);
        layoutCenter.getChildren().addAll(viewButton, buyButton, sellButton);

        BorderPane layoutMain = new BorderPane();
        layoutMain.setTop(layoutTop);
        layoutMain.setCenter(layoutCenter);

        Scene scene = new Scene(layoutMain, 800, 800);

        window = primaryStage;
        window.setTitle("Homepage");
        window.setScene(scene);
        //window.setFullScreen(true);
        //window.setMaximized(true);
        window.show();
    }

}
