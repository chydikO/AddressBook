module com.chudik0.addressbook {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.chudik0.addressbook to javafx.fxml;
    opens com.chudik0.addressbook.objects to javafx.base;
    exports com.chudik0.addressbook;
    exports com.chudik0.addressbook.controllers;

}