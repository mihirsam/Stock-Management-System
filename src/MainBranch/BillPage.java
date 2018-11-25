package MainBranch;

import java.util.*;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;
import java.text.SimpleDateFormat;

public class BillPage
{
    public static void BillPageMain(Stage primaryStage, boolean status, String custName, String custNo, int proId,
                                    String proName, int proQuantity, double proPrice, double totalPrice)
    {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(today);

        //Stage window = new Stage();
        primaryStage.setTitle("Billing Page");
        //window.initModality(Modality.APPLICATION_MODAL);

        if(status)
        {
            // title
            Label labelTitle = new Label("BILL RECEIPT");

            VBox layoutTop = new VBox(20);
            layoutTop.getChildren().add(labelTitle);
            layoutTop.setMargin(labelTitle, new Insets(50, 10, 10, 10));
            layoutTop.setAlignment(Pos.CENTER);

            // Customer Info
            Label custNameLabel = new Label("Customer Name : "+ custName);
            Label custNoLabel = new Label("Customer Phone Number : "+custNo);
            Label dateLabel = new Label("Date : "+ strDate);

            custNameLabel.setId("title-label");
            custNoLabel.setId("title-label");
            dateLabel.setId("title-label");

            custNameLabel.setMinWidth(400);
            custNoLabel.setMinWidth(400);

            HBox layoutTwo = new HBox(20);
            layoutTwo.getChildren().addAll(custNameLabel, dateLabel);
            layoutTwo.setMargin(custNameLabel, new Insets(50, 10, 10, 50));
            layoutTwo.setMargin(dateLabel, new Insets(50, 10, 10, 10));

            // Titles
            Label proIdLabel = new Label("Id");
            Label proNameLabel = new Label("Name");
            Label proQuantityLabel = new Label("Quantity");
            Label proPriceLabel = new Label("Price");
            Label proTotalLabel = new Label("Total Price");

            proIdLabel.setMinWidth(100);
            proNameLabel.setMinWidth(140);
            proQuantityLabel.setMinWidth(140);
            proPriceLabel.setMinWidth(140);
            proTotalLabel.setMinWidth(140);

            proIdLabel.setId("title-label");
            proNameLabel.setId("title-label");
            proQuantityLabel.setId("title-label");
            proPriceLabel.setId("title-label");
            proTotalLabel.setId("title-label");

            HBox layoutTitle = new HBox(20);
            layoutTitle.getChildren().addAll(proIdLabel, proNameLabel, proPriceLabel, proQuantityLabel, proTotalLabel);
            layoutTitle.setMargin(proIdLabel, new Insets(10, 0, 30, 50));
            layoutTitle.setMargin(proNameLabel, new Insets(10, 0, 30, 0));
            layoutTitle.setMargin(proPriceLabel, new Insets(10, 0, 30, 0));
            layoutTitle.setMargin(proQuantityLabel, new Insets(10, 0, 30, 0));
            layoutTitle.setMargin(proTotalLabel, new Insets(10, 0, 30, 0));

            // Details
            Label proIdDetails = new Label(""+proId);
            Label proNameDetails = new Label(""+proName);
            Label proQuantityDetails = new Label(""+proQuantity);
            Label proPriceDetails = new Label("Rs. "+proPrice);
            Label proTotalDetails = new Label("Rs. "+totalPrice);

            proIdDetails.setMinWidth(100);
            proNameDetails.setMinWidth(140);
            proQuantityDetails.setMinWidth(140);
            proPriceDetails.setMinWidth(140);
            proTotalDetails.setMinWidth(140);

            proIdDetails.setId("input-label");
            proNameDetails.setId("input-label");
            proQuantityDetails.setId("input-label");
            proPriceDetails.setId("input-label");
            proTotalDetails.setId("input-label");


            HBox layoutDetails = new HBox(20);
            layoutDetails.getChildren().addAll(proIdDetails, proNameDetails, proPriceDetails, proQuantityDetails, proTotalDetails);
            layoutDetails.setMargin(proIdDetails, new Insets(10, 0, 30, 50));
            layoutDetails.setMargin(proNameDetails, new Insets(10, 0, 30, 0));
            layoutDetails.setMargin(proPriceDetails, new Insets(10, 0, 30, 0));
            layoutDetails.setMargin(proQuantityDetails, new Insets(10, 0, 30, 0));
            layoutDetails.setMargin(proTotalDetails, new Insets(10, 0, 30, 0));


            Button closeButton = new Button("Close");
            closeButton.setPrefWidth(100);
            closeButton.setPrefHeight(20);
            closeButton.setOnAction(e -> {
                Homepage.setHomePage(primaryStage);
            });

            VBox layoutMain = new VBox(5);
            layoutMain.getChildren().addAll(layoutTop, layoutTwo, custNoLabel, layoutTitle, layoutDetails, closeButton);
            layoutMain.setMargin(custNoLabel, new Insets(0, 10, 100, 50));
            layoutMain.setMargin(closeButton, new Insets(100, 0, 100, 350));

            Scene scene = new Scene(layoutMain, 800, 800);
            scene.getStylesheets().add("MainBranch/Stylesheet/homepageStyle.css");

            primaryStage.setScene(scene);
            //window.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();

        }

        else
        {
            Label invalidLabel = new Label("INVALID INPUT");

            Button closeButton = new Button("Close");
            closeButton.setPrefWidth(100);
            closeButton.setPrefHeight(20);
            closeButton.setOnAction(e -> {
                SellPage.SellPageMain(primaryStage);
            });

            VBox layout = new VBox(100);
            layout.getChildren().addAll(invalidLabel, closeButton);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout, 800, 800);
            scene.getStylesheets().add("MainBranch/Stylesheet/homepageStyle.css");

            primaryStage.setScene(scene);
            //window.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
        }
    }
}
