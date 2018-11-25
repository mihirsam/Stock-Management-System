package MainBranch;

import MainBranch.Database.DatabaseConn;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.sql.ResultSet;

public class BuyDatabaseView
{
    public static void showTable(Stage primaryStage) throws Exception
    {
        try
        {
            //Stage window = new Stage();
            //window.initModality(Modality.APPLICATION_MODAL);

            //main label
            Label labelTitle = new Label("BUY DATABASE");
            labelTitle.setId("title-label");

            //setting tableview
            TableColumn<ProductBuyDB, String> SlCol = new TableColumn<>("Sl. No");
            SlCol.setMinWidth(100);
            SlCol.setCellValueFactory(new PropertyValueFactory<>("proSl"));

            TableColumn<ProductBuyDB, String> IdCol = new TableColumn<>("ID");
            IdCol.setMinWidth(100);
            IdCol.setCellValueFactory(new PropertyValueFactory<>("proId"));

            TableColumn<ProductBuyDB, String> NameCol = new TableColumn<>("NAME");
            NameCol.setMinWidth(100);
            NameCol.setCellValueFactory(new PropertyValueFactory<>("proName"));

            TableColumn<ProductBuyDB, String> QuantityCol = new TableColumn<>("QUANTITY");
            QuantityCol.setMinWidth(100);
            QuantityCol.setCellValueFactory(new PropertyValueFactory<>("proQuantity"));

            TableColumn<ProductBuyDB, String> PriceCol = new TableColumn<>("PRICE");
            PriceCol.setMinWidth(100);
            PriceCol.setCellValueFactory(new PropertyValueFactory<>("proPrice"));

            TableColumn<ProductBuyDB, String> TotalCol = new TableColumn<>("TOTAL");
            TotalCol.setMinWidth(100);
            TotalCol.setCellValueFactory(new PropertyValueFactory<>("proTotal"));

            TableColumn<ProductBuyDB, String> DateCol = new TableColumn<>("DATE");
            DateCol.setMinWidth(200);
            DateCol.setCellValueFactory(new PropertyValueFactory<>("proDate"));

            //setting tableview
            TableView<ProductBuyDB> table = new TableView<>();
            table.setItems(getProduct());
            table.getColumns().addAll(SlCol, IdCol, NameCol, PriceCol, QuantityCol, TotalCol, DateCol);

            //setting back button
            Button backButton = new Button("Back");
            backButton.setPrefWidth(100);
            backButton.setPrefHeight(20);
            backButton.setOnAction(e -> {
                try{
                    ViewPage.viewPageMain(primaryStage);
                }
                catch (Exception el)
                {
                    el.printStackTrace();
                }
            });

            //setting layout
            VBox vBox = new VBox(30);
            vBox.getChildren().addAll(labelTitle, table, backButton);
            vBox.setAlignment(Pos.CENTER);

            Scene scene = new Scene(vBox, 800, 800);
            primaryStage.setScene(scene);

            scene.getStylesheets().add("MainBranch/Stylesheet/tableviewStyle.css");
            //window.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    public static ObservableList<ProductBuyDB> getProduct() throws Exception
    {
        try
        {
            ObservableList<ProductBuyDB> product = FXCollections.observableArrayList();
            ResultSet rs = DatabaseConn.BuyDatabase();

            if(rs != null)
            {
                while(rs.next())
                {
                    ProductBuyDB proDB = new ProductBuyDB();

                    proDB.setProSl(rs.getString("SlNo"));
                    proDB.setProId(rs.getString("ID"));
                    proDB.setProName(rs.getString("ProName"));
                    proDB.setProQuantity(rs.getString("Quantity"));
                    proDB.setProPrice(rs.getString("Price"));
                    proDB.setProTotal(rs.getString("TotalPrice"));
                    proDB.setProDate(rs.getString("BuyDate"));

                    //System.out.println("quan"+rs.getString("Quantity")+"price"+rs.getString("Price"));
                    product.add(proDB);
                }
            }

            return product;
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}
