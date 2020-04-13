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

import java.util.HashSet;
import java.util.Set;

import static AddressBook.Commands.*;

public class TableViewController {
    @FXML private TableView<Student> tableView;
    @FXML private TextField CommandPane;

    private ObservableList<Student> filteredList = FXCollections.observableArrayList();
    private ObservableList<Student> oldData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        this.oldData = this.tableView.getItems();
        this.CommandPane.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
    }

    @FXML
    protected void execute(ActionEvent event) {
        ObservableList<Student> data = tableView.getItems();

        Parser parser = new Parser(this.CommandPane.getText());

        //********ADD COMMAND****************
        if (parser.getActualCommand() == ADD) {
            data.add(new Student(parser.getFirstName(), parser.getLastName(), parser.getEmail()));
            this.CommandPane.setText("");
        //******** SEARCH COMMAND ******************
        }else if (parser.getActualCommand() == SEARCH) {
            String toBeFound = parser.getTextToBeFound();
            this.CommandPane.setText("");

            if (toBeFound.equals("")) return;

            Set<Student> newSet = new HashSet<>();
            for(Student student : data) {
                if (student.getFirstName().contains(parser.getTextToBeFound()) ||
                        student.getLastName().contains(parser.getTextToBeFound()) ||
                        student.getEmail().contains(parser.getTextToBeFound())) {
                    newSet.add(student);
                }
            }

            this.filteredList.clear();
            this.filteredList.addAll(newSet);
            this.tableView.setItems(this.filteredList);

        //********** LIST COMMAND ********************
        }else if (parser.getActualCommand() == LIST) {
            this.tableView.setItems(this.oldData);
            this.CommandPane.setText("");
        //************ DELETE COMMAND ****************
        }else if (parser.getActualCommand() == DELETE) {
            Student student = this.tableView.getSelectionModel().getSelectedItem();
            if (student == null) return;

            this.oldData.remove(student);
            this.tableView.getItems().remove(student);

            this.tableView.setItems(this.oldData);

            this.CommandPane.setText("");
        //************* QUIT COMMAND ********************
        }else if (parser.getActualCommand() == QUIT) {
            Platform.exit();
        //************* EDIT COMMAND ********************
        }else if (parser.getActualCommand() == EDIT) {
            Student student = this.tableView.getSelectionModel().getSelectedItem();

            if (student == null) return;
            if (!parser.getEmail().equals("")) {
                student.setEmail(parser.getEmail());
            }

            if (!parser.getFirstName().equals("")) {
                student.setFirstName(parser.getFirstName());
            }

            if (!parser.getLastName().equals("")) {
                student.setLastName(parser.getLastName());
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
