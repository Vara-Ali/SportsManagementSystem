package application;

import business.Sport;
import business.SportDescription;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

import java.util.ResourceBundle;

import business.SportsClub;
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

import javafx.scene.control.ListView;

public class Initializer2  implements Initializable {
	
	/*
	 * IDHARV PROBLEM ARAHI HAI
	 * 
	 */
  //  private static final ArrayList<SportDescription> CasesDesc = null;
	private Stage stage;
    private Scene scene;
    private Parent root;
    SportDescription cd;
    SportsClub ngo=new SportsClub();
    Sport case2;

    @FXML
    private ResourceBundle resources;

    @FXML
    public ListView<String> ListCase = new ListView<>();

    @FXML
    private Label label1;
    public Button ok;

    @FXML
    public TextField AmountLabel=new TextField();

    @FXML
    private Button donateDone;
    @FXML
    private Button DonateNow;

    static String titleGot;
    String titleGot2;
    String amountGot;
    static ArrayList<SportDescription> finalTemp2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        case2 = new Sport();
        cd = new SportDescription();

        ArrayList<SportDescription> CasesDesc =new ArrayList<SportDescription>();
        try {
        	CasesDesc = cd.getAll();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("in main");
        for(int i=0;i<CasesDesc.size();i++) {
			System.out.println("im in loop of getDAta");

			System.out.println("Name "+CasesDesc.get(i).getTitle());
			ListCase.getItems().add(CasesDesc.get(i).getTitle());
		}
            //cases.getItems(temp2.get(i).getTitle());



        ArrayList<SportDescription> finalTemp = CasesDesc;
        finalTemp2 = CasesDesc;
        //ListCase.getSelectionModel().clearSelection();

        ListCase.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                // TODO Auto-generated method stub
                titleGot=ListCase.getSelectionModel().getSelectedItem();

                //CandidateController.party=party;
                for (int i = 0; i < finalTemp.size(); i++) {
                    //System.out.println( "Title " + finalTemp.get(i).getTitle());
                    if(titleGot.equals(finalTemp.get(i).getTitle()))
                    {
                        titleGot2 = "Title: " + "\n" + titleGot + "\n\n\n" + "Description: " +"\n"+
                                finalTemp.get(i).getDesc() + "\n\n\n"
                                + "Target: " + "\n" + String.valueOf(finalTemp.get(i).getTarget()) ;
                        System.out.println("INSIDE FTN " + titleGot2);
                    }
                }
                label1.setText(titleGot2);
                //ListCase.getItems().clear();
                //ListCase.getSelectionModel().clearSelection();

            }
        });     ListCase.getSelectionModel().clearSelection();

    }


    @FXML
    void verifyCase(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        //ListCase.getSelectionModel().clearSelection();
        for (int i = 0; i < finalTemp2.size(); i++) {
            if(titleGot.equals(finalTemp2.get(i).getTitle()))
            {
                String newcase=titleGot;
                String newCaseDesc=finalTemp2.get(i).getDesc();
                String newgoal=String.valueOf(finalTemp2.get(i).getTarget());
                int newGoal=Integer.parseInt(newgoal);
                System.out.println("IM NOW AN INTEGER"+newGoal);
                ngo.addCases(newcase, newCaseDesc, newGoal);
            }
        }
        System.out.println("DELETE THIS" + titleGot);
        case2.deleteCase(titleGot);

        case2.deleteCase(titleGot);
        root=FXMLLoader.load(getClass().getResource("CasesPendingApproval.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Verified Sport!");
        stage.show();

        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("VerifiedSuccessfully.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        stage.setTitle("Verified Sport!");
        stage.setScene(scene);
        stage.show();

    }

    public void delteCase(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
    {
        case2.deleteCase(titleGot);
        root=FXMLLoader.load(getClass().getResource("CasesPendingApproval.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Verified Sport!");
        stage.show();
    }

    public void BacktomoderatorMenu(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
    {
        root=FXMLLoader.load(getClass().getResource("ModeratorMenu.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Moderator Menu");
        stage.show();
    }


    public void loginFailed(ActionEvent e) throws IOException
    {

        Stage stage=(Stage) ok.getScene().getWindow();
        // do what you have to do
        stage.close();

    }
    

}