//package com.chudik0.addressbook.controllers;
//
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.testfx.api.FxRobot;
//
//
//@ExtendWith(ApplicationExtension.class)
//public class MainControllerTest {
//
//    private Button testButton;
//    private Stage ownerStage;
//
//    @BeforeEach
//    void setUp() {
//        // Set up a test stage as the owner of the dialog
//        ownerStage = new Stage();
//        ownerStage.setScene(new Scene(new StackPane(), 200, 200));
//        ownerStage.show();
//
//        // Set up a test button that will be clicked to open the dialog
//        testButton = new Button("Test Button");
//        testButton.setOnAction(event -> {
//            try {
//                new MainController().showDialog(event);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//
//        // Add the button to the scene
//        StackPane root = new StackPane(testButton);
//        Scene scene = new Scene(root, 200, 200);
//        ownerStage.setScene(scene);
//    }
//
//    @Test
//    void testShowDialogWhenButtonClickedThenOpensNewStageWithEditRecordTitle(FxRobot robot) {
//        // Act
//        robot.clickOn(testButton);
//
//        // Assert
//        assertTrue(robot.listWindows().stream().anyMatch(window -> {
//            Stage stage = (Stage) window;
//            return "Edit Record".equals(stage.getTitle());
//        }), "The new stage should have the title 'Edit Record'");
//    }
//
//    @Test
//    void testShowDialogWhenButtonClickedThenOpensNewStageWithSpecifiedDimensions(FxRobot robot) {
//        // Act
//        robot.clickOn(testButton);
//
//        // Assert
//        assertTrue(robot.listWindows().stream().anyMatch(window -> {
//            Stage stage = (Stage) window;
//            return stage.getMinWidth() == 300 && stage.getMinHeight() == 150;
//        }), "The new stage should have the specified dimensions of 300x150");
//    }
//
//    @Test
//    void testShowDialogWhenButtonClickedThenSetsStageAsModalWindow(FxRobot robot) {
//        // Act
//        robot.clickOn(testButton);
//
//        // Assert
//        assertTrue(robot.listWindows().stream().anyMatch(window -> {
//            Stage stage = (Stage) window;
//            return stage.getModality() == Modality.WINDOW_MODAL && stage.getOwner() == ownerStage;
//        }), "The new stage should be set as a modal window with the correct owner");
//    }
//}
