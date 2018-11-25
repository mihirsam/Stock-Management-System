package MainBranch;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;

public class BuyAlertBox
{
    public static void showUpdate(Stage primaryStage, boolean answer, int id, String name, int quantity, double totalPrice)
    {
        //Stage window = new Stage();
        primaryStage.setTitle("Update");
        //window.initModality(Modality.APPLICATION_MODAL);

        if(answer)
        {
            Label status = new Label("Update Successful");

            Label idLabel = new Label("Product Id : "+id);
            Label nameLabel = new Label("Product Name : "+name);
            Label quantityLabel = new Label("Total Quantity : "+quantity);
            Label priceLabel = new Label("Total Price : "+totalPrice);

            idLabel.setId("input-label");
            nameLabel.setId("input-label");
            quantityLabel.setId("input-label");
            priceLabel.setId("input-label");

            Button okay = new Button("Okay");
            okay.setOnAction(e -> {
                Homepage.setHomePage(primaryStage);
            });

            VBox layoutTop = new VBox(20);
            layoutTop.getChildren().add(status);
            layoutTop.setAlignment(Pos.CENTER);
            layoutTop.setMargin(status, new Insets(30, 10, 50, 10));

            VBox layoutCenter = new VBox(20);
            layoutCenter.getChildren().addAll(idLabel, nameLabel, quantityLabel, priceLabel, okay);
            layoutCenter.setMargin(okay, new Insets(100, 10, 10, 50));
            layoutCenter.setAlignment(Pos.CENTER);

            BorderPane layoutMain = new BorderPane();
            layoutMain.setTop(layoutTop);
            layoutMain.setCenter(layoutCenter);

            Scene scene = new Scene(layoutMain, 800, 800);
            scene.getStylesheets().add("MainBranch/Stylesheet/homepageStyle.css");

            primaryStage.setScene(scene);
        }

        else
        {
            Label status = new Label("Update Failed");

            Button okay = new Button("Okay");
            okay.setOnAction(e -> {
                BuyPage.BuyPageMain(primaryStage);
            });

            VBox layoutMain = new VBox(20);
            layoutMain.getChildren().addAll(status, okay);
            layoutMain.setAlignment(Pos.CENTER);
            layoutMain.setMargin(status, new Insets(100, 10, 50, 10));

            Scene scene = new Scene(layoutMain, 800, 800);
            scene.getStylesheets().add("MainBranch/Stylesheet/homepageStyle.css");

            primaryStage.setScene(scene);
        }


        //window.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
}
