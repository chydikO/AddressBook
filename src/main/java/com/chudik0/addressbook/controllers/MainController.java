package com.chudik0.addressbook.controllers;

import com.chudik0.addressbook.Main;
import com.chudik0.addressbook.interfaces.impls.CollectionAddressBook;
import com.chudik0.addressbook.objects.Person;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private final CollectionAddressBook addressBookImpl = new CollectionAddressBook();
    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private EditDialogController editDialogController;
    private Stage editDialogStage;

    private Stage mainStage;

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

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @FXML
    public void initialize() {
        tableViewAddressBook.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        columnFio.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
        initListeners();
        fillData();
        initLoader();
    }

    private void initLoader() {
        try {
            fxmlLoader.setLocation(Main.class.getResource("fxml/edit-view.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void initListeners() {
        addressBookImpl.getPersonArrayList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCountLabel();
            }
        });

        tableViewAddressBook.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    editDialogController.setPerson((Person)tableViewAddressBook.getSelectionModel().getSelectedItem());
                    showDialog();
                }
            }
        });
    }

    private void fillData() {
        addressBookImpl.fillTestData();
        tableViewAddressBook.setItems(addressBookImpl.getPersonArrayList());
    }

    private void updateCountLabel() {
        labelCount.setText("Count of records " + addressBookImpl.getPersonArrayList().size());
    }

    public void actionButtonPressed(ActionEvent actionEvent) throws IOException {
        Object source = actionEvent.getSource();
        if (!(source instanceof Button clickedButton)) {
            return;
        }
        Person selectedPerson = (Person) tableViewAddressBook.getSelectionModel().getSelectedItem();
        switch (clickedButton.getId()) {
            case "addButton" -> {
                editDialogController.setPerson(new Person());
                showDialog();
                addressBookImpl.addPerson(editDialogController.getPerson());
                System.out.println("add -> " + selectedPerson);
            }
            case "editButton" -> {
                showDialog();
                editDialogController.setPerson(selectedPerson);
            }
            case "deleteButton" -> {
                addressBookImpl.deletePerson((Person) tableViewAddressBook.getSelectionModel().getSelectedItem());
                System.out.println("delete -> " + selectedPerson);
            }
        }
    }

    private void showDialog() {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle("Edit Record");
            editDialogStage.setMinHeight(150);
            editDialogStage.setMinWidth(300);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }
        editDialogStage.showAndWait();
    }
}