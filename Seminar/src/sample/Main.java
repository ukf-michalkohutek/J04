package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.HashMap;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        HBox box = new HBox(10);
        HBox box1 = new HBox(10);
        Scene scene = new Scene(root,310,100);

        HashMap<String, String>CapitalCities = new HashMap<String, String>();

        box1.setLayoutY(50);

        TextField textField = new TextField();
        TextField textField1 = new TextField();

        Button add = new Button("Add");
        Button edite = new Button("Edite");
        Button delete = new Button("Delete");
        Button search = new Button("Search");
        Button list = new Button("List");
        Button quit = new Button("Quit");

        add.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!CapitalCities.containsKey(textField.getText()))
                CapitalCities.put(textField.getText(),textField1.getText());
                System.out.println(textField.getText() + "-" + textField1.getText() + " was added");
                System.out.println(CapitalCities);
            }
        });

        edite.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CapitalCities.computeIfPresent(textField.getText(),(k,v) -> v + textField1.getText());
                System.out.println(textField.getText() + " was updated");
            }
        });

        delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CapitalCities.remove(textField.getText());
                System.out.println(textField.getText() + " was deleted");
                System.out.println(CapitalCities);
            }
        });

        search.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(CapitalCities.get(textField.getText()));
            }
        });

        list.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(CapitalCities);
            }
        });

        quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.exit(0);
            }
        });

        CapitalCities.put("England","London");
        CapitalCities.put("Germany","Berlin");
        CapitalCities.put("Norway","Oslo");
        CapitalCities.put("USA","Washington DC");

        box1.getChildren().addAll(textField,textField1);
        box.getChildren().addAll(add,edite,delete,search,list,quit);
        root.getChildren().addAll(box,box1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
