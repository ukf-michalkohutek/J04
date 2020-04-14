package AddressBook;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.*;

import static AddressBook.Commands.*;

public class TableViewController {
    @FXML private TableView<Student> tableView;
    @FXML private TextField CommandPane;

    private HashMap<Integer, Student> hashMap = new HashMap<>();

    private int id = 1;

    @FXML
    private void initialize() {
        for(Student student : this.tableView.getItems()) {
            // Bad solution but at least I used hashMap and work with it
            // this.id is same as student.getId --> I could use student.getId as key
            this.hashMap.put(this.id++, student);
        }

        this.CommandPane.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
    }

    @FXML
    protected void execute(ActionEvent event) {
        Parser parser = new Parser(this.CommandPane.getText());

        //********ADD COMMAND****************
        //***********************************
        if (parser.getActualCommand() == ADD) {
            Student student = new Student(parser.getFirstName(), parser.getLastName(), parser.getEmail());
            this.hashMap.put(this.id++, student);
            this.CommandPane.setText("");
            this.tableView.getItems().add(student);
        //******** SEARCH COMMAND ******************
        //******************************************
        }else if (parser.getActualCommand() == SEARCH) {
            String toBeFound = parser.getTextToBeFound();
            this.CommandPane.setText("");

            if (toBeFound.equals("")) return;

            Set<Student> newSet = new HashSet<>();
            ObservableList<Student> filteredList = FXCollections.observableArrayList();
            // Go through hashMap and check every student's attributes
            for(Map.Entry<Integer, Student> entry : this.hashMap.entrySet()) {
                if (entry.getValue().getFirstName().contains(parser.getTextToBeFound()) ||
                        entry.getValue().getLastName().contains(parser.getTextToBeFound()) ||
                        entry.getValue().getEmail().contains(parser.getTextToBeFound())) {
                    newSet.add(entry.getValue());
                }
            }

            filteredList.clear();
            filteredList.addAll(newSet);
            this.tableView.setItems(filteredList);

        //********** LIST COMMAND ********************
        //********************************************
        }else if (parser.getActualCommand() == LIST) {
            ObservableList<Student> list = FXCollections.observableArrayList();

            for (Map.Entry<Integer, Student> entry : this.hashMap.entrySet()) {
                list.add(entry.getValue());
            }
            this.tableView.setItems(list);
            this.CommandPane.setText("");
        //************ DELETE COMMAND ****************
        //********************************************
        }else if (parser.getActualCommand() == DELETE) {
            // Delete selected Student
            Student student = this.tableView.getSelectionModel().getSelectedItem();
            if (student == null) return;

            this.hashMap.remove(student.getId());

            ObservableList<Student> list = FXCollections.observableArrayList();

            for (Map.Entry<Integer, Student> entry : this.hashMap.entrySet()) {
                list.add(entry.getValue());
            }
            
            this.tableView.getItems().remove(student);

            this.tableView.setItems(list);

            this.CommandPane.setText("");
        //************* QUIT COMMAND ********************
        //***********************************************
        }else if (parser.getActualCommand() == QUIT) {
            Platform.exit();
        //************* EDIT COMMAND ********************
        //***********************************************
        }else if (parser.getActualCommand() == EDIT) {
            // Edit selected student
            Student student = this.tableView.getSelectionModel().getSelectedItem();

            if (student == null) return;

            if (!parser.getEmail().equals("")) {
                student.setEmail(parser.getEmail());
                this.hashMap.get(student.getId()).setEmail(parser.getEmail());
            }

            if (!parser.getFirstName().equals("")) {
                student.setFirstName(parser.getFirstName());
                this.hashMap.get(student.getId()).setFirstName(parser.getFirstName());
            }

            if (!parser.getLastName().equals("")) {
                student.setLastName(parser.getLastName());
                this.hashMap.get(student.getId()).setLastName(parser.getLastName());
            }

            this.tableView.refresh();
            this.CommandPane.setText("");
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeight(500);
            alert.setTitle("Legend");
            alert.setHeaderText(null);
            alert.setContentText("ADD -> [Add F:<name> L:<lastName> E:<email>] or mixture of these attributes\n" +
                    "EDIT: [Edit F:<name> L:<lastName> E:<email>] or mixture of these attributes\n" +
                    "DELETE: [Delete]\n" +
                    "QUIT: [Quit]\n" +
                    "SEARCH: [Search <text>]\n" +
                    "LIST: [List]");

            alert.showAndWait();
            this.CommandPane.setText("");
        }
    }



}
