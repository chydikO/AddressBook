package com.chudik0.addressbook.controllers;

import com.chudik0.addressbook.Main;
import com.chudik0.addressbook.interfaces.impls.CollectionAddressBook;
import com.chudik0.addressbook.objects.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {
    private final CollectionAddressBook addressBookImpl = new CollectionAddressBook();
    @FXML
    public Button addButton;
    @FXML
    public Button editButton;
    @FXML
    public Button deleteButton;
    @FXML
    public TextField textField;
    @FXML
    public Button searchButton;
    @FXML
    public TableView<Person> tableViewAddressBook;
    @FXML
    public Label labelCount;
    @FXML
    public TableColumn<Person, String> columnFio;
    @FXML
    public TableColumn<Person, String> columnPhone;

    @FXML
    public void initialize() {
        addressBookImpl.fillTestData();
        updateCountLabel();

        columnFio.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
        tableViewAddressBook.setItems(addressBookImpl.getPersonArrayList());
    }

    private void updateCountLabel() {
        labelCount.setText("Count of records " + addressBookImpl.getPersonArrayList().size());
    }

    public void showDialog(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("edit-view.fxml")));
        stage.setTitle("Edit Record");
        stage.setMinHeight(150);
        stage.setMinWidth(300);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }
}