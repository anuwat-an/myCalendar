/**
 * Anuwat Angkuldee 5810401066
 */

package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletePageController {

    @FXML
    private Label textLabel;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Stage stage;

    private int deleteID;
    private MainController mainController;

    @FXML
    public void confirmDel() {
        try {
            /** setup */
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:Appointments.db";
            Connection connection = DriverManager.getConnection(dbURL);

            /** query delete appointments */
            if (connection != null) {
                String query = "delete from Appointments where id="+deleteID;
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);

                connection.close();
            }

            /**
             * #EDIT add and use calendar's method to remove
             */
            this.mainController.getCalendar().deleteAppointment(deleteID);
            this.mainController.setAppointmentsDetails();

            this.stage.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void cancelDel() {
        this.stage.close();
    }

    public void setDeleteID(int id) {
        this.deleteID = id;
        this.textLabel.setText("Are you sure to delete appointment ID: "+deleteID);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setMainController(MainController ctrlr) {
        this.mainController = ctrlr;
    }

}