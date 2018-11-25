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

public class SalesDatabaseView
{
    public static void showTable(Stage primaryStage) throws Exception
    {
        try
        {
            //Stage window = new Stage();
            //window.initModality(Modality.APPLICATION_MODAL);

            //main label
            Label labelTitle = new Label("SALES DATABASE");
            labelTitle.setId("title-label");

            //setting table view columns
            TableColumn<ProductSalesDB, String> SlCol = new TableColumn<>("Sl. No");
            SlCol.setMinWidth(50);
            SlCol.setCellValueFactory(new PropertyValueFactory<>("proSl"));

            TableColumn<ProductSalesDB, String> IdCol = new TableColumn<>("ID");
            IdCol.setMinWidth(50);
            IdCol.setCellValueFactory(new PropertyValueFactory<>("proId"));

            TableColumn<ProductSalesDB, String> NameCol = new TableColumn<>("NAME");
            NameCol.setMinWidth(100);
            NameCol.setCellValueFactory(new PropertyValueFactory<>("proName"));

            TableColumn<ProductSalesDB, String> CustCol = new TableColumn<>("CUST. NAME");
            CustCol.setMinWidth(100);
            CustCol.setCellValueFactory(new PropertyValueFactory<>("custName"));

            TableColumn<ProductSalesDB, String> PhoneCol = new TableColumn<>("PHONE NO.");
            PhoneCol.setMinWidth(100);
            PhoneCol.setCellValueFactory(new PropertyValueFactory<>("custPhone"));

            TableColumn<ProductSalesDB, String> PriceCol = new TableColumn<>("PRICE");
            PriceCol.setMinWidth(50);
            PriceCol.setCellValueFactory(new PropertyValueFactory<>("proPrice"));

            TableColumn<ProductSalesDB, String> QuantityCol = new TableColumn<>("QUANTITY");
            QuantityCol.setMinWidth(50);
            QuantityCol.setCellValueFactory(new PropertyValueFactory<>("proQuantity"));

            TableColumn<ProductSalesDB, String> TotalCol = new TableColumn<>("TOTAL");
            TotalCol.setMinWidth(50);
            TotalCol.setCellValueFactory(new PropertyValueFactory<>("proTotal"));

            TableColumn<ProductSalesDB, String> DateCol = new TableColumn<>("DATE");
            DateCol.setMinWidth(200);
            DateCol.setCellValueFactory(new PropertyValueFactory<>("proDate"));

            //setting tableview
            TableView<ProductSalesDB> table = new TableView<>();
            table.setItems(getProduct());
            table.getColumns().addAll(SlCol, IdCol, NameCol, PriceCol, QuantityCol, TotalCol, CustCol, PhoneCol, DateCol);

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

    public static ObservableList<ProductSalesDB> getProduct() throws Exception
    {
        try
        {
            ObservableList<ProductSalesDB> product = FXCollections.observableArrayList();
            ResultSet rs = DatabaseConn.SalesDatabase();

            if(rs != null)
            {
                while(rs.next())
                {
                    ProductSalesDB proDB = new ProductSalesDB();

                    proDB.setProId(rs.getString("ProId"));
                    proDB.setProName(rs.getString("ProName"));
                    proDB.setProQuantity(rs.getString("Quantity"));
                    proDB.setProPrice(rs.getString("Price"));
                    proDB.setProSl(rs.getString("ID"));
                    proDB.setCustName(rs.getString("CustName"));
                    proDB.setCustPhone(rs.getString("CustPhNo"));
                    proDB.setProTotal(rs.getString("TotalPrice"));
                    proDB.setProDate(rs.getString("SellDate"));

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
