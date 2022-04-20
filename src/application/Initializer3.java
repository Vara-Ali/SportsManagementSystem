package application;

import business.*;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import business.Account;
import business.SportDescription;
import javafx.scene.control.ListView;

public class Initializer3  implements Initializable {


    //  private static final ArrayList<SportDescription> CasesDesc = null;
    private Stage stage;
    private Scene scene;
    private Parent root;
    Account acc;
    SportsClub ngo=new SportsClub();
    Sport case2;

    @FXML
    private ResourceBundle resources;

    @FXML
    public ListView<String> ModeratorList = new ListView<>();

    @FXML
    private Label label1;
    public Button ok;


    static String modGot;
    String titleGot2;
    String amountGot;
    static ArrayList<SportDescription> finalTemp2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc = new Account();


        ArrayList<Moderator> getAllmod =new ArrayList<Moderator>();
        try {
            getAllmod = acc.getAllmoderator();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("in main");
        for(int i=0;i<getAllmod.size();i++) {
            System.out.println("im in loop of get moderator DAta");

            System.out.println("Name "+getAllmod.get(i).getFirstname());
            ModeratorList.getItems().add(getAllmod.get(i).getFirstname());
        }
        //cases.getItems(temp2.get(i).getTitle());



        ArrayList<Moderator> modTemp = getAllmod;
        //finalTemp2 = CasesDesc;
        //ListCase.getSelectionModel().clearSelection();

        ModeratorList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                // TODO Auto-generated method stub
                modGot=ModeratorList.getSelectionModel().getSelectedItem();




            }
        });    // ListCase.getSelectionModel().clearSelection();

    }

    public void delMod(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        acc.deletemoderator(modGot);

        root = FXMLLoader.load(getClass().getResource("ModeratorDeleted.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Moderator Deleted Successfully");
        stage.show();

    }
    public void loginFailed(ActionEvent e) throws IOException
    {
        root=FXMLLoader.load(getClass().getResource("ModeratorList.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Delete a Moderator");
        stage.show();

    }

    public void backtoAdminMenu(ActionEvent e) throws IOException
    {
        root=FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Admin Menu");
        stage.show();
    }


}