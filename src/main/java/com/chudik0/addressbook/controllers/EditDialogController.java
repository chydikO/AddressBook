package com.chudik0.addressbook.controllers;

import com.chudik0.addressbook.objects.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditDialogController {
    @FXML
    public TextField textFieldName;
    @FXML
    public TextField textFieldPhone;
    @FXML
    public Button okButton;
    @FXML
    public Button cancelButton;
    private Person person;

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void setPerson(Person person) {
        this.person = person;
        textFieldName.setText(person.getFio());
        textFieldPhone.setText(person.getPhone());
    }
}
