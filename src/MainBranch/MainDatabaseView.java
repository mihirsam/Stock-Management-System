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

public class MainDatabaseView
{
    public static void showTable() throws Exception
    {
        try
        {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);

            //main label
            Label labelTitle = new Label("MAIN DATABASE");
            labelTitle.setPadding(new Insets(20, 10, 30, 10));

            //setting table view columns
            TableColumn<ProductMainDB, String> IdCol = new TableColumn<>("ID");
            IdCol.setMinWidth(50);
            IdCol.setCellValueFactory(new PropertyValueFactory<>("proId"));

            TableColumn<ProductMainDB, String> NameCol = new TableColumn<>("NAME");
            NameCol.setMinWidth(200);
            NameCol.setCellValueFactory(new PropertyValueFactory<>("proName"));

            TableColumn<ProductMainDB, String> QuantityCol = new TableColumn<>("QUANTITY");
            QuantityCol.setMinWidth(200);
            QuantityCol.setCellValueFactory(new PropertyValueFactory<>("proQuantity"));

            TableColumn<ProductMainDB, String> PriceCol = new TableColumn<>("PRICE");
            PriceCol.setMinWidth(200);
            PriceCol.setCellValueFactory(new PropertyValueFactory<>("proPrice"));

            //setting tableview
            TableView<ProductMainDB> table = new TableView<>();
            table.setItems(getProduct());
            table.getColumns().addAll(IdCol, NameCol, QuantityCol, PriceCol);

            //setting back button
            Button backButton = new Button("Back");
            backButton.setPrefWidth(100);
            backButton.setPrefHeight(20);
            backButton.setOnAction(e -> window.close());

            //
            VBox vBox = new VBox(30);
            vBox.getChildren().addAll(table);

            Scene scene = new Scene(vBox);
            window.setScene(scene);
            window.show();

            scene.getStylesheets().add("MainBranch/Stylesheet/homepageStyle.css");
            window.initStyle(StageStyle.UNDECORATED);
            window.showAndWait();
        }

        catch (Exception e)
        {
            throw e;
        }
    }

    public static ObservableList<ProductMainDB> getProduct() throws Exception
    {
        try
        {
            ObservableList<ProductMainDB> product = FXCollections.observableArrayList();
            ResultSet rs = DatabaseConn.MainDatabase();

            while(rs.next())
            {
                ProductMainDB proDB = new ProductMainDB();

                proDB.setProId(rs.getInt("ID"));
                proDB.setProName(rs.getString("ProName"));
                proDB.getProQuantity(rs.getInt("Quantity"));
                proDB.getProPrice(rs.getInt("Price"));

                product.add(proDB);
            }

            return product;
        }

        catch(Exception e)
        {
            throw e;
        }
    }
}
