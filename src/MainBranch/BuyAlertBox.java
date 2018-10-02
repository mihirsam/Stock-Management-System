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
    public static void showUpdate(boolean answer, int id, String name, int quantity, double totalPrice)
    {
        Stage window = new Stage();
        window.setTitle("Update");
        window.initModality(Modality.APPLICATION_MODAL);

        if(answer)
        {
            Label status = new Label("Update Successful");

            Label idLabel = new Label("Product Id : "+id);
            Label nameLabel = new Label("Product Name : "+name);
            Label quantityLabel = new Label("Total Quantity : "+quantity);
            Label priceLabel = new Label("Total Price : "+totalPrice);

            Button okay = new Button("Okay");
            okay.setOnAction(e -> window.close());

            VBox layoutTop = new VBox(20);
            layoutTop.getChildren().add(status);
            layoutTop.setAlignment(Pos.CENTER);
            layoutTop.setMargin(status, new Insets(30, 10, 50, 10));

            VBox layoutCenter = new VBox(20);
            layoutCenter.getChildren().addAll(idLabel, nameLabel, quantityLabel, priceLabel, okay);
            layoutCenter.setMargin(okay, new Insets(50, 10, 10, 50));
            layoutCenter.setAlignment(Pos.CENTER);

            BorderPane layoutMain = new BorderPane();
            layoutMain.setTop(layoutTop);
            layoutMain.setCenter(layoutCenter);

            Scene scene = new Scene(layoutMain, 500, 500);
            window.setScene(scene);
        }

        else
        {
            Label status = new Label("Update Failed");

            Button okay = new Button("Okay");
            okay.setOnAction(e -> window.close());

            VBox layoutMain = new VBox(20);
            layoutMain.getChildren().addAll(status, okay);
            layoutMain.setAlignment(Pos.CENTER);
            layoutMain.setMargin(status, new Insets(50, 10, 50, 10));

            Scene scene = new Scene(layoutMain, 500, 500);

            window.setScene(scene);
        }

        window.initStyle(StageStyle.UNDECORATED);
        window.showAndWait();
    }
}
