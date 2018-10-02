package MainBranch;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;

public class SellPage
{
    public static void SellPageMain()
    {
        Stage window = new Stage();
        window.setTitle("Sell Page");
        window.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();

        Label labelTitle = new Label("UPDATE SALES RECORD AND BILLING");
        labelTitle.setPadding(new Insets(20, 10, 30, 10));

        // Customer Details

        Label custLabel = new Label("Customer Details");
        custLabel.setPadding(new Insets(20, 10, 10, 50));
        GridPane.setConstraints(custLabel, 8, 0);

        // Customer Name
        Label custName = new Label("Customer Name : ");
        custName.setPadding(new Insets(10, 10, 20, 100));
        GridPane.setConstraints(custName, 10, 1);

        TextField custNameInput = new TextField();
        custNameInput.setPadding(new Insets(10, 10, 10, 10));
        custNameInput.setPromptText("eg: Mihir");
        GridPane.setConstraints(custNameInput, 11, 1);

        // Customer Phone Number
        Label custPhone = new Label("Phone Number : ");
        custPhone.setPadding(new Insets(10, 10, 20, 100));
        GridPane.setConstraints(custPhone, 10, 2);

        TextField custPhoneInput = new TextField();
        custPhoneInput.setPromptText("eg: 8942977749");
        custPhoneInput.setPadding(new Insets(10, 10, 10, 10));
        GridPane.setConstraints(custPhoneInput, 11, 2);

        // Product Details

        Label proLabel = new Label("Product Details");
        proLabel.setPadding(new Insets(50, 10, 10, 50));
        GridPane.setConstraints(proLabel, 8, 4);

        // Product Id
        Label proId = new Label("Product Id : ");
        proId.setPadding(new Insets(10, 10, 20, 100));
        GridPane.setConstraints(proId, 10, 5);

        TextField proIdInput = new TextField();
        proIdInput.setPadding(new Insets(10, 10, 10, 10));
        proIdInput.setPromptText("eg: 001");
        GridPane.setConstraints(proIdInput, 11, 5);

        // Product Name
        Label proName = new Label("Product Name : ");
        proName.setPadding(new Insets(10, 10, 20, 100));
        GridPane.setConstraints(proName, 10, 6);

        TextField proNameInput = new TextField();
        proNameInput.setPadding(new Insets(10, 10, 10, 10));
        proNameInput.setPromptText("eg: Jacket");
        GridPane.setConstraints(proNameInput, 11, 6);

        // Quantity
        Label proQuantity = new Label("Quantity : ");
        proQuantity.setPadding(new Insets(10, 10, 20, 100));
        GridPane.setConstraints(proQuantity, 10, 7);

        TextField proQuantityInput = new TextField();
        proQuantityInput.setPadding(new Insets(10, 10, 10, 10));
        proQuantityInput.setPromptText("eg: 200");
        GridPane.setConstraints(proQuantityInput, 11, 7);

        // Price
        Label proPrice = new Label("Price Per Piece: ");
        proPrice.setPadding(new Insets(10, 10, 20, 100));
        GridPane.setConstraints(proPrice, 10, 8);

        TextField proPriceInput = new TextField();
        proPriceInput.setPadding(new Insets(10, 10, 10, 10));
        proPriceInput.setPromptText("eg: 100");
        GridPane.setConstraints(proPriceInput, 11, 8);

        grid.getChildren().addAll(custLabel, custName, custNameInput, custPhone, custPhoneInput, proLabel, proId,
                proIdInput, proName, proNameInput, proQuantity, proQuantityInput, proPrice, proPriceInput);

        // Submit Button
        Button submitButton = new Button("SUBMIT");
        submitButton.setPrefWidth(150);
        submitButton.setPrefHeight(25);
        submitButton.setOnAction(e -> {
            submitSell(custNameInput.getText(), custPhoneInput.getText(), proIdInput.getText(), proNameInput.getText(), proQuantityInput.getText(), proPriceInput.getText());
        });


        // Back Button
        Button backButton = new Button("Back");
        backButton.setPrefWidth(100);
        backButton.setPrefHeight(20);
        backButton.setOnAction(e -> window.close());

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
        //window.setMaximized(true);
        window.initStyle(StageStyle.UNDECORATED);
        window.showAndWait();

    }

    public static void submitSell(String custName, String custNo, String proId, String proName, String proQuantity, String proPrice)
    {
        int finalQuantity, finalId;
        Long finalCustNo;
        double finalPrice, finalTotalPrice;

        try
        {
            finalCustNo = Long.parseLong(custNo);
            finalQuantity = Integer.parseInt(proQuantity);
            finalId = Integer.parseInt(proId);
            finalPrice = Double.parseDouble(proPrice);
            finalTotalPrice = finalPrice * finalQuantity;

            BillPage.BillPageMain(true, custName, finalCustNo, finalId, proName, finalQuantity, finalPrice, finalTotalPrice);
        }

        catch(NumberFormatException e)
        {
            BillPage.BillPageMain(false, "", 0L, 0, "", 0, 0, 0);
        }
    }
}
