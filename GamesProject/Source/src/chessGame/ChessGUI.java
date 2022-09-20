package chessGame;

import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import main.MasterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;



public class ChessGUI extends JPanel{

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double topPadding = 80.0;
    Board chessBoard;
    private final MasterController presentingController;


    public ChessGUI(Stage stage, MasterController presentingController){
        this.presentingController = presentingController;
        Double boardSize = (screenSize.height*0.975);
        BorderPane border = new BorderPane();
        Scene scene = new Scene(border, screenSize.width*0.8,screenSize.height*0.8);
        scene.getStylesheets().add("mazeGame/ExitButton.css");
        stage.setScene(scene);
        chessBoard = new Board(6,6,boardSize.intValue());
        stage.setResizable(false);
        border.requestFocus();

        SwingNode gameNode = new SwingNode();
        gameNode.setStyle("-fx-background-color: #1C0000;");
        gameNode.setContent(chessBoard);
        border.setCenter(gameNode);

        border.setLeft(verticalPadding());
        border.setRight(verticalPadding());
        border.setTop(horizontalPadding());
        border.setBottom(horizontalPadding());



    }

    private javafx.scene.control.Button createMenuButton() {
        Button button = new javafx.scene.control.Button();
        button.getStyleClass().add("exitButton");
        button.setMaxWidth(40);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                exit();
            }
        });
        return button;
    }

    private Pane verticalPadding() {
        double gameHeight = (screenSize.height*0.8)-(topPadding*2.0);
        Pane p = new Pane();
        p.setPrefWidth(((screenSize.width*0.8)-gameHeight)/2.0);
        p.setStyle("-fx-background-color: #1C3044;");
        return  p;
    }

    private Pane horizontalPadding() {
        Pane p = new Pane();
        p.setPrefHeight(topPadding);
        p.setStyle("-fx-background-color: #1C3044;");
        return  p;
    }

    private void exit() {
        presentingController.showScene();
    }
}