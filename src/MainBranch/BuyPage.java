package MainBranch;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;

public class BuyPage
{

    public static void BuyPageMain()
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();

        Label labelTitle = new Label();
        labelTitle.setText("RECORD BOUGHT STOCKS");
        labelTitle.setPadding(new Insets(50, 10, 50, 10));

        // Product Id
        Label proId = new Label("Enter Product Id : ");
        proId.setPadding(new Insets(30, 10, 30, 100));
        GridPane.setConstraints(proId, 10, 0);

        TextField proIdInput = new TextField();
        proIdInput.setPadding(new Insets(10, 10, 10, 10));
        proIdInput.setPromptText("eg: 001");
        GridPane.setConstraints(proIdInput, 11, 0);

        // Product Name
        Label proName = new Label("Enter Product Name : ");
        proName.setPadding(new Insets(30, 10, 30, 100));
        GridPane.setConstraints(proName, 10, 1);

        TextField proNameInput = new TextField();
        proNameInput.setPadding(new Insets(10, 10, 10, 10));
        proNameInput.setPromptText("eg: Jacket");
        GridPane.setConstraints(proNameInput, 11, 1);

        // Quantity
        Label proQuantity = new Label("Enter Quantity : ");
        proQuantity.setPadding(new Insets(30, 10, 30, 100));
        GridPane.setConstraints(proQuantity, 10, 2);

        TextField proQuantityInput = new TextField();
        proQuantityInput.setPadding(new Insets(10, 10, 10, 10));
        proQuantityInput.setPromptText("eg: 200");
        GridPane.setConstraints(proQuantityInput, 11, 2);

        // Price
        Label proPrice = new Label("Enter Price Per Piece: ");
        proPrice.setPadding(new Insets(30, 10, 30, 100));
        GridPane.setConstraints(proPrice, 10, 3);

        TextField proPriceInput = new TextField();
        proPriceInput.setPadding(new Insets(10, 10, 10, 10));
        proPriceInput.setPromptText("eg: 100");
        GridPane.setConstraints(proPriceInput, 11, 3);

        grid.getChildren().addAll(proId, proIdInput, proName, proNameInput, proQuantity, proQuantityInput, proPrice, proPriceInput);

        // Submit Button
        Button submitButton = new Button("SUBMIT");
        submitButton.setPrefWidth(150);
        submitButton.setPrefHeight(25);
        submitButton.setOnAction(e -> {
            submitBuy(proIdInput.getText(), proNameInput.getText(), proQuantityInput.getText(), proPriceInput.getText());
        });

        // Back Button
        Button backButton = new Button("Back");
        backButton.setPrefWidth(100);
        backButton.setPrefHeight(20);
        backButton.setOnAction(e -> window.close());

        // Left layout for BorderPane
        /*
        VBox layoutLeft = new VBox(20);
        layoutLeft.setAlignment(Pos.BOTTOM_CENTER);
        layoutLeft.getChildren().add(backButton);
        layoutLeft.setMargin(backButton, new Insets(50, 10, 100, 10));
        */

        // Top layout in BorderPane
        VBox layoutTop = new VBox(20);
        layoutTop.setAlignment(Pos.CENTER);
        layoutTop.getChildren().add(labelTitle);

        // Bot layout in BorderPane
        VBox layoutBot = new VBox(20);
        layoutBot.setAlignment(Pos.CENTER);
        layoutBot.setMargin(submitButton, new Insets(20, 10, 10, 10));
        layoutBot.setMargin(backButton, new Insets(10, 10, 100, 10));
        layoutBot.getChildren().addAll(submitButton, backButton);

        //BorderPane
        BorderPane layoutMain = new BorderPane();
        layoutMain.setTop(layoutTop);
        layoutMain.setCenter(grid);
        layoutMain.setBottom(layoutBot);
        //layoutMain.setLeft(layoutLeft);


        Scene scene = new Scene(layoutMain, 800, 800);

        window.setTitle("Buy Page");
        window.setScene(scene);
        //window.setFullScreen(true);
        window.setMaximized(true);
        window.showAndWait();

    }

    public static void submitBuy(String id, String name, String quantity, String price)
    {
        int finalID, finalQuantity;
        double finalPrice, totalPrice;

        try
        {
            finalID = Integer.parseInt(id);
            finalQuantity = Integer.parseInt(quantity);
            finalPrice = Double.parseDouble(price);
            totalPrice = finalPrice * finalQuantity;

            BuyAlertBox.showUpdate(true, finalID, name, finalQuantity, totalPrice);
        }

        catch(NumberFormatException e)
        {
            System.out.println("\nInvalid Input!");
            BuyAlertBox.showUpdate(false, 0, "name", 0, 0);
        }
    }
}
