package MainBranch;

import MainBranch.Database.DatabaseConn;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;

import java.sql.SQLException;

public class BuyPage
{

    public static void BuyPageMain(Stage primaryStage)
    {
        //Stage window = new Stage();
        //window.initModality(Modality.APPLICATION_MODAL);

        Label labelTitle = new Label();
        labelTitle.setText("UPDATE BUY RECORDS");
        labelTitle.setPadding(new Insets(50, 0, 0, 0));

        // Product Id
        Label proId = new Label("Product Id : ");
        proId.setId("input-label");
        proId.setPrefWidth(150);

        TextField proIdInput = new TextField();
        proIdInput.setPromptText("eg: 001");

        HBox layoutId = new HBox(5);
        layoutId.getChildren().addAll(proId, proIdInput);

        layoutId.setMargin(proId, new Insets(100, 5, 10, 244));
        layoutId.setMargin(proIdInput, new Insets(100, 5, 10, 0));
        //layoutId.setAlignment(Pos.CENTER);

        // Product Name
        Label proName = new Label("Product Name : ");
        proName.setId("input-label");
        proName.setPrefWidth(150);

        TextField proNameInput = new TextField();
        proNameInput.setPromptText("eg: Jacket");

        HBox layoutName = new HBox(5);
        layoutName.getChildren().addAll(proName, proNameInput);
        layoutName.setMargin(proName, new Insets(10, 5, 10, 0));
        layoutName.setMargin(proNameInput, new Insets(10, 5, 10, 0));
        layoutName.setAlignment(Pos.CENTER);

        // Quantity
        Label proQuantity = new Label("Quantity : ");
        proQuantity.setId("input-label");
        proQuantity.setPrefWidth(150);

        TextField proQuantityInput = new TextField();
        proQuantityInput.setPromptText("eg: 200");

        HBox layoutQuantity = new HBox(5);
        layoutQuantity.getChildren().addAll(proQuantity, proQuantityInput);
        layoutQuantity.setMargin(proQuantity, new Insets(10, 5, 10, 0));
        layoutQuantity.setMargin(proQuantityInput, new Insets(10, 5, 10, 0));

        layoutQuantity.setAlignment(Pos.CENTER);

        // Price
        Label proPrice = new Label("Price Per Piece : ");
        proPrice.setId("input-label");
        proPrice.setPrefWidth(150);

        TextField proPriceInput = new TextField();
        proPriceInput.setPromptText("eg: 100");

        HBox layoutPrice = new HBox(5);
        layoutPrice.getChildren().addAll(proPrice, proPriceInput);
        layoutPrice.setMargin(proPrice, new Insets(10, 5, 10, 0));
        layoutPrice.setMargin(proPriceInput, new Insets(10, 5, 10, 0));

        layoutPrice.setAlignment(Pos.CENTER);


        // Submit Button
        Button submitButton = new Button("SUBMIT");
        submitButton.setPrefWidth(150);
        submitButton.setPrefHeight(25);
        submitButton.setOnAction(e -> {
            submitBuy(primaryStage, proIdInput.getText(), proNameInput.getText(), proQuantityInput.getText(), proPriceInput.getText());
        });

        // Back Button
        Button backButton = new Button("Back");
        backButton.setPrefWidth(100);
        backButton.setPrefHeight(20);
        backButton.setOnAction(e -> {
            Homepage.setHomePage(primaryStage);
        });


        // Top layout in BorderPane
        VBox layoutTop = new VBox(20);
        layoutTop.setAlignment(Pos.CENTER);
        layoutTop.getChildren().add(labelTitle);

        // Bot layout in BorderPane
        VBox layoutBot = new VBox(20);
        layoutBot.setAlignment(Pos.CENTER);
        layoutBot.setMargin(submitButton, new Insets(100, 10, 10, 10));
        layoutBot.setMargin(backButton, new Insets(10, 10, 100, 10));
        layoutBot.getChildren().addAll(submitButton, backButton);


        VBox layoutMain = new VBox(20);
        layoutMain.getChildren().addAll(layoutTop, layoutId, layoutName, layoutQuantity, layoutPrice, layoutBot);
        layoutMain.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layoutMain, 800, 800);

        primaryStage.setTitle("Buy Page");
        primaryStage.setScene(scene);
        //window.setFullScreen(true);
        //window.setMaximized(true);
        //window.initStyle(StageStyle.UNDECORATED);
        scene.getStylesheets().add("MainBranch/Stylesheet/homepageStyle.css");
        primaryStage.show();

    }

    public static void submitBuy(Stage primaryStage, String id, String name, String quantity, String price)
    {
        int finalID, finalQuantity;
        double finalPrice, totalPrice;

        try
        {
            finalID = Integer.parseInt(id);
            finalQuantity = Integer.parseInt(quantity);
            finalPrice = Double.parseDouble(price);
            totalPrice = finalPrice * finalQuantity;

            boolean result = DatabaseConn.UpdateBuyData(name, finalID, finalQuantity, finalPrice, totalPrice);

            BuyAlertBox.showUpdate(primaryStage, result, finalID, name, finalQuantity, totalPrice);
        }

        catch(NumberFormatException e)
        {
            e.printStackTrace();
            BuyAlertBox.showUpdate(primaryStage, false, 0, "name", 0, 0);
        }

        catch (SQLException e) {
            e.printStackTrace();
            BuyAlertBox.showUpdate(primaryStage, false, 0, "name", 0, 0);
        }
    }
}
