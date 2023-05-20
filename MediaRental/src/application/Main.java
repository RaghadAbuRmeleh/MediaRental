    package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;


public class Main extends Application {

	public static MediaRentalManger phaseTwo = new MediaRentalManger();
	@Override
	public void start(Stage primaryStage) {

		try {

			BorderPane root = new BorderPane();
			BorderPane root1 = new BorderPane();
			BorderPane root2 = new BorderPane();
			BorderPane root3 = new BorderPane();


			Image test = new Image ("background (1).jpg");

			BackgroundImage bImg = new BackgroundImage (test,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
			Background bground = new Background (bImg);
			root.setBackground(bground);
			root1.setBackground(bground);
			root2.setBackground(bground);
			root3.setBackground(bground);


			Scene scene = new Scene(root,1370,710);
			VBox box1 = new VBox ();
			VBox box2 = new VBox ();
			//BackgroundFill[] background = new Paint ("interinter.png");
			//	Background bg= new Background (background);

			Label bottom = new Label ("   Rental Media System");
			bottom.setAlignment(Pos.BOTTOM_CENTER);
			bottom.setFont(Font.font(45));
			Image image = new Image ("interface.png");

			ImageView imagge= new ImageView (image);
			imagge.setFitHeight(500);
			imagge.setFitWidth(500);
			box1.getChildren().addAll(imagge,bottom);
			box1.setPadding(new Insets (60,20,10,10));
			box1.setSpacing(20);

			//box1.setAlignment(Pos.BASELINE_LEFT);

			Image image1 = new Image("customers.png");
			Button customersBttn = new Button ("  Customers", new ImageView (image1));
			customersBttn.setPrefHeight(200);
			customersBttn.setPrefWidth(250);
			customersBttn.setFont(Font.font(20));
			Image image2 = new Image("media.png");
			Button mediaBttn = new Button ("  Media", new ImageView (image2));
			mediaBttn.setPrefHeight(200);
			mediaBttn.setPrefWidth(250);
			mediaBttn.setFont(Font.font(20));
			Image image3 = new Image("rent.png");
			Button rentBttn = new Button ("  Rent", new ImageView (image3));
			rentBttn.setPrefHeight(200);
			rentBttn.setPrefWidth(250);
			rentBttn.setFont(Font.font(20));
			box2.getChildren().addAll(customersBttn,mediaBttn,rentBttn);
			//box2.setAlignment(Pos.BASELINE_RIGHT);
			box2.setPadding(new Insets (100,70,100,330));
			box2.setSpacing(70);


			//root.getChildren().addAll(box1,box2);
			root.setLeft(box2);
			root.setCenter(box1);
			//root.setBackground(bg);



			//EVENTS AND ACTIONS 



			Scene customerScene = new Scene(root1, 1370, 710);
			customersBttn.setOnAction(e -> primaryStage.setScene(customerScene));

			VBox customersMenu = new VBox();
			Label title1 = new Label ("Customer Menu");
			title1.setFont(Font.font(50));
			title1.setPadding(new Insets (10,0,30,0));
			customersMenu.setAlignment(Pos.CENTER);
			customersMenu.setPadding(new Insets (20,30,10,0));
			Button addc = new Button ("Add new customer");
			addc.setPrefWidth(500);
			addc.setPrefHeight(70);
			addc.setFont(Font.font(25));
			Button deletec = new Button ("Delete customer");
			deletec.setPrefWidth(500);
			deletec.setPrefHeight(70);
			deletec.setFont(Font.font(25));
			Button updatec = new Button ("Update information about customer");
			updatec.setPrefWidth(500);
			updatec.setPrefHeight(70);
			updatec.setFont(Font.font(25));
			Button searchc = new Button ("Search a customer by ID");
			searchc.setPrefWidth(500);
			searchc.setPrefHeight(70);
			searchc.setFont(Font.font(25));
			Button returnc = new Button ("Return to main page");
			returnc.setPrefWidth(500);
			returnc.setPrefHeight(70);
			returnc.setFont(Font.font(25));
			customersMenu.setSpacing(20);
			customersMenu.getChildren().addAll(title1,addc,deletec,updatec,searchc,returnc);
			root1.setCenter(customersMenu);


			BorderPane addcMenu = new BorderPane();
			addcMenu.setBackground(bground);
			Scene addcScene = new Scene(addcMenu, 1370, 710);

			addc.setOnAction(e -> primaryStage.setScene(addcScene));
			HBox forTitle2 = new HBox ();
			Label title2 = new Label ("Add New Customer Menu");
			title2.setFont(Font.font(40));
			forTitle2.getChildren().add(title2);
			forTitle2.setAlignment(Pos.CENTER);
			forTitle2.setPadding(new Insets (50,0,0,0));
			addcMenu.setTop(forTitle2);

			RadioButton lm = new RadioButton ("Limited");
			lm.setFont(Font.font(20));
			lm.setPadding(new Insets (0,3,0,7));
			RadioButton unlm = new RadioButton ("Unlimited");
			unlm.setFont(Font.font(20));
			unlm.setPadding(new Insets (0,3,0,7));
			lm.setDisable(true);
			unlm.setDisable(true);

			HBox hboxx = new HBox();
			hboxx.getChildren().addAll(lm,unlm);

			ToggleGroup tg0 = new ToggleGroup ();
			lm.setToggleGroup(tg0);
			unlm.setToggleGroup(tg0);

			VBox labels1 = new VBox ();
			labels1.setPadding(new Insets (78,9,9,50));
			Label label1 = new Label ("Customer ID:      ");
			label1.setFont(Font.font(20));
			Label label2 = new Label ("Customer Name:    ");
			label2.setFont(Font.font(20));
			Label label3 = new Label ("Customer Address: ");
			label3.setFont(Font.font(20));
			Label label4 = new Label ("Customer Mobile:  ");
			label4.setFont(Font.font(20));
			Label label5 = new Label ("Customer Plan:  ");
			label5.setFont(Font.font(20));
			Label label6 = new Label ("*Limited Value:  ");
			label6.setFont(Font.font(15));
			labels1.getChildren().addAll(label1,label2,label3,label4,label5,label6);
			labels1.setAlignment(Pos.CENTER_LEFT);
			labels1.setSpacing(40);
			addcMenu.setLeft(labels1);

			VBox txtFs1 = new VBox ();
			txtFs1.setPadding(new Insets (76,150,7,7));
			TextField txtF1 = new TextField ();
			txtF1.setFont(Font.font(20));
			TextField txtF2 = new TextField ();
			txtF2.setFont(Font.font(20));
			txtF2.setDisable(true);
			TextField txtF3 = new TextField ();
			txtF3.setFont(Font.font(20));
			txtF3.setDisable(true);
			TextField txtF4 = new TextField ();
			txtF4.setFont(Font.font(20));
			txtF4.setDisable(true);
			TextField txtF5 = new TextField ();
			txtF5.setFont(Font.font(15));	
			txtF5.setDisable(true);
			txtFs1.getChildren().addAll(txtF1,txtF2,txtF3,txtF4,hboxx,txtF5);
			txtFs1.setSpacing(30);
			txtFs1.setAlignment(Pos.CENTER);
			txtF1.setOnKeyTyped(e->{
				txtF2.setDisable(false);	
			});
			txtF2.setOnKeyTyped(e->{
				txtF3.setDisable(false);	
			});
			txtF3.setOnKeyTyped(e->{
				txtF4.setDisable(false);	
			});
			txtF4.setOnKeyTyped(e->{
				lm.setDisable(false);
				unlm.setDisable(false);
			});
			lm.setOnKeyTyped(e->{
				txtF5.setDisable(false);
			});
			unlm.setOnKeyTyped(e->{
				txtF5.setDisable(true);
			});
			addcMenu.setCenter(txtFs1);

			lm.setOnAction(e-> {

				if (lm.isSelected()) 
					txtF5.setDisable(false);
				else

					txtF5.setDisable(true);
			});
			unlm.setOnAction(e-> {

				if (unlm.isSelected()) 
					txtF5.setDisable(true);

			});


			HBox buttons1 = new HBox ();
			Image imageAdd = new Image("add-user.png");
			Image imageBack = new Image("back.png");
			Button add = new Button ("   Add", new ImageView (imageAdd));
			add.setPrefHeight(90);
			add.setPrefWidth(250);
			add.setFont(Font.font(20));
			Button backBtn1 = new Button ("   Back", new ImageView (imageBack));
			backBtn1.setPrefHeight(90);
			backBtn1.setPrefWidth(250);
			backBtn1.setFont(Font.font(20));
			buttons1.getChildren().addAll(add,backBtn1);
			buttons1.setAlignment(Pos.TOP_CENTER);
			buttons1.setSpacing(100);
			buttons1.setPadding(new Insets (20,30,30,30));

			addcMenu.setBottom(buttons1);



			add.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					String selected = ((RadioButton)tg0.getSelectedToggle()).getText();
					phaseTwo.addCustomer(txtF1.getText(), txtF2.getText(), txtF3.getText(), txtF4.getText(),selected);
					if(txtF5.getText() != null) {
						int x = Integer.parseInt(txtF5.getText());
						phaseTwo.setLimitedPlanLimit(x);
					}
					else if (txtF5.getText().isBlank()) {
						phaseTwo.setLimitedPlanLimit(2);
					}

					writeFile();
				}
			});

			backBtn1.setOnAction(e -> {
				primaryStage.setScene(customerScene); 
				txtF1.clear();
				txtF2.clear();
				txtF3.clear();
				txtF4.clear();
				txtF5.clear();
				lm.setSelected(false);
				unlm.setSelected(false);

			});



			BorderPane deletecMenu = new BorderPane();
			deletecMenu.setBackground(bground);
			Scene deletecScene = new Scene(deletecMenu, 1370, 710);

			deletec.setOnAction(e -> primaryStage.setScene(deletecScene));
			HBox forTitle3 = new HBox ();
			Label title3 = new Label ("Delete Customer Menu");
			title3.setFont(Font.font(40));
			forTitle3.getChildren().add(title3);
			forTitle3.setAlignment(Pos.CENTER);
			forTitle3.setPadding(new Insets (50,0,0,0));
			deletecMenu.setTop(forTitle3);

			RadioButton lm1 = new RadioButton ("Limited");
			lm1.setFont(Font.font(20));
			lm1.setPadding(new Insets (0,3,0,7));
			RadioButton unlm1 = new RadioButton ("Unlimited");
			unlm1.setFont(Font.font(20));
			unlm1.setPadding(new Insets (0,3,0,7));
			lm1.setDisable(true);
			unlm1.setDisable(true);

			HBox hboxx1 = new HBox();
			hboxx1.getChildren().addAll(lm1,unlm1);

			ToggleGroup tg1 = new ToggleGroup ();
			lm1.setToggleGroup(tg1);
			unlm1.setToggleGroup(tg1);

			VBox labels2 = new VBox ();
			labels2.setPadding(new Insets (78,9,9,50));
			Label label11 = new Label ("Customer ID:      ");
			label11.setFont(Font.font(20));
			Label label22 = new Label ("Customer Name:    ");
			label22.setFont(Font.font(20));
			Label label33 = new Label ("Customer Address: ");
			label33.setFont(Font.font(20));
			Label label44 = new Label ("Customer Mobile:  ");
			label44.setFont(Font.font(20));
			Label label55 = new Label ("Customer Plan: ");
			label55.setFont(Font.font(20));
			Label label66 = new Label ("*Limited Value:  ");
			label66.setFont(Font.font(15));
			labels2.getChildren().addAll(label11,label22,label33,label44,label55,label66);
			labels2.setAlignment(Pos.CENTER_LEFT);
			labels2.setSpacing(40);
			deletecMenu.setLeft(labels2);

			VBox txtFs2 = new VBox ();
			txtFs2.setPadding(new Insets (76,150,7,7));
			TextField txtF11 = new TextField ();
			txtF11.setFont(Font.font(20));
			TextField txtF22 = new TextField ();
			txtF22.setFont(Font.font(20));
			txtF22.setDisable(true);
			TextField txtF33 = new TextField ();
			txtF33.setFont(Font.font(20));
			txtF33.setDisable(true);
			TextField txtF44 = new TextField ();
			txtF44.setFont(Font.font(20));
			txtF44.setDisable(true);
			TextField txtF55 = new TextField ();
			txtF55.setFont(Font.font(15));
			txtF55.setDisable(true);
			txtFs2.getChildren().addAll(txtF11,txtF22,txtF33,txtF44,hboxx1,txtF55);
			txtFs2.setSpacing(30);
			txtFs2.setAlignment(Pos.CENTER);
			txtF11.setOnKeyTyped(e->{
				txtF22.setDisable(false);	
			});
			txtF22.setOnKeyTyped(e->{
				txtF33.setDisable(false);	
			});
			txtF33.setOnKeyTyped(e->{
				txtF44.setDisable(false);	
			});
			txtF44.setOnKeyTyped(e->{
				lm1.setDisable(false);
				unlm1.setDisable(false);
			});
			lm.setOnKeyTyped(e->{
				txtF5.setDisable(false);
			});
			unlm.setOnKeyTyped(e->{
				txtF5.setDisable(true);
			});

			lm1.setOnAction(e-> {

				if (lm1.isSelected()) 
					txtF55.setDisable(false);
				else

					txtF55.setDisable(true);
			});
			unlm1.setOnAction(e-> {

				if (unlm1.isSelected()) 
					txtF55.setDisable(true);

			});
			deletecMenu.setCenter(txtFs2);

			HBox buttons2 = new HBox ();
			Image imageDelete = new Image("remove-user.png");
			Image imageFind = new Image("find.png");
			Button backBtn2 = new Button ("  Back", new ImageView (imageBack));
			backBtn2.setPrefHeight(90);
			backBtn2.setPrefWidth(250);
			backBtn2.setFont(Font.font(20));
			Button delete = new Button ("  Delete", new ImageView (imageDelete));
			delete.setPrefHeight(90);
			delete.setPrefWidth(250);
			delete.setFont(Font.font(20));
			Button find = new Button ("  Find", new ImageView (imageFind));
			find.setPrefHeight(90);
			find.setPrefWidth(250);
			find.setFont(Font.font(20));
			buttons2.getChildren().addAll(find,delete,backBtn2);
			buttons2.setAlignment(Pos.TOP_CENTER);
			buttons2.setSpacing(100);
			buttons2.setPadding(new Insets(20,30,30,30));
			deletecMenu.setBottom(buttons2);

			find.setOnAction(e -> {
				for (int i = 0 ; i < phaseTwo.customerList.size() ; i ++ ) {

					if (phaseTwo.customerList.get(i).getId().equalsIgnoreCase(txtF11.getText())) {
						txtF22.setText(phaseTwo.customerList.get(i).getName());
						txtF33.setText(phaseTwo.customerList.get(i).getAddress());
						txtF44.setText(phaseTwo.customerList.get(i).getMobile());
						if (phaseTwo.customerList.get(i).getPlan().equalsIgnoreCase("Limited"))
							tg1.selectToggle(lm1);
						else if (phaseTwo.customerList.get(i).getPlan().equalsIgnoreCase("Unlimited"))
							tg1.selectToggle(unlm1);
						txtF55.setText(String.valueOf(phaseTwo.customerList.get(i).getLimited()));
					}
					writeFile();
				}
			});

			delete.setOnAction(e -> {
				String selected1 = ((RadioButton)tg1.getSelectedToggle()).getText();
				phaseTwo.removeCustomer(txtF11.getText(), txtF22.getText(), txtF33.getText(), txtF44.getText(),selected1);
				writeFile();
			});

			backBtn2.setOnAction(e -> {
				primaryStage.setScene(customerScene);
				txtF11.clear();
				txtF22.clear();
				txtF33.clear();
				txtF44.clear();
				txtF55.clear();
				lm1.setSelected(false);
				unlm1.setSelected(false);
			});


			BorderPane searchcMenu = new BorderPane ();
			searchcMenu.setBackground(bground);
			Scene searchcScene = new Scene(searchcMenu, 1370, 710);

			searchc.setOnAction(e -> primaryStage.setScene(searchcScene));
			HBox forTitle4 = new HBox ();
			Label title4 = new Label ("Search a Customer by ID");
			title4.setFont(Font.font(40));
			forTitle4.getChildren().add(title4);
			forTitle4.setAlignment(Pos.CENTER);
			forTitle4.setPadding(new Insets (50,0,0,0));
			searchcMenu.setTop(forTitle4);

			RadioButton lm4 = new RadioButton ("Limited");
			lm4.setFont(Font.font(20));
			lm4.setPadding(new Insets (0,3,0,7));
			RadioButton unlm4 = new RadioButton ("Unlimited");
			unlm4.setFont(Font.font(20));
			unlm4.setPadding(new Insets (0,3,0,7));
			lm4.setDisable(true);
			unlm4.setDisable(true);

			HBox hboxx4 = new HBox();
			hboxx4.getChildren().addAll(lm4,unlm4);

			ToggleGroup tg4 = new ToggleGroup ();
			lm4.setToggleGroup(tg4);
			unlm4.setToggleGroup(tg4);

			VBox labels3 = new VBox ();
			labels3.setPadding(new Insets (78,9,9,50));
			Label label111 = new Label  ("Customer ID:      ");
			label111.setFont(Font.font(20));
			Label label222 = new Label  ("Customer Name:    ");
			label222.setFont(Font.font(20));
			Label label333 = new Label  ("Customer Address: ");
			label333.setFont(Font.font(20));
			Label label444 = new Label  ("Customer Mobile:  ");
			label444.setFont(Font.font(20));
			Label label555 = new Label  ("Customer Plan: ");
			label555.setFont(Font.font(20));
			Label label666 = new Label  ("*Limited Value:  ");
			label666.setFont(Font.font(15));
			labels3.getChildren().addAll(label111,label222,label333,label444,label555,label666);
			labels3.setAlignment(Pos.CENTER_LEFT);
			labels3.setSpacing(40);
			searchcMenu.setLeft(labels3);

			VBox txtFs3 = new VBox ();
			txtFs3.setPadding(new Insets (76,150,7,7));
			TextField txtF111 = new TextField ();
			txtF111.setFont(Font.font(20));
			TextField txtF222= new TextField ();
			txtF222.setFont(Font.font(20));
			txtF222.setDisable(true);
			TextField txtF333 = new TextField ();
			txtF333.setFont(Font.font(20));
			txtF333.setDisable(true);
			TextField txtF444 = new TextField ();
			txtF444.setFont(Font.font(20));
			txtF444.setDisable(true);
			TextField txtF555 = new TextField ();
			txtF555.setFont(Font.font(15));
			txtF555.setDisable(true);
			txtFs3.getChildren().addAll(txtF111,txtF222,txtF333,txtF444,hboxx4,txtF555);
			txtFs3.setSpacing(30);
			txtFs3.setAlignment(Pos.CENTER);
			/*txtF111.setOnKeyTyped(e->{
				txtF222.setDisable(false);	
			});
			txtF222.setOnKeyTyped(e->{
				txtF333.setDisable(false);	
			});
			txtF333.setOnKeyTyped(e->{
				txtF444.setDisable(false);	
			});*/
			searchcMenu.setCenter(txtFs3);

			HBox buttons3 = new HBox ();
			Image findCustomer = new Image ("searchcustomer.png");
			Button backBtn3 = new Button ("   Back", new ImageView (imageBack));
			backBtn3.setPrefHeight(90);
			backBtn3.setPrefWidth(250);
			backBtn3.setFont(Font.font(20));
			Button find2 = new Button ("   Find Customer", new ImageView (findCustomer));
			find2.setPrefHeight(90);
			find2.setPrefWidth(250);
			find2.setFont(Font.font(20));
			buttons3.getChildren().addAll(find2,backBtn3);
			buttons3.setAlignment(Pos.TOP_CENTER);
			buttons3.setSpacing(100);
			buttons3.setPadding(new Insets(20,30,30,30));
			searchcMenu.setBottom(buttons3);


			find2.setOnAction(e -> {
				for (int i = 0 ; i < phaseTwo.customerList.size() ; i ++ ) {

					if (phaseTwo.customerList.get(i).getId().equalsIgnoreCase(txtF111.getText())) {
						txtF222.setText(phaseTwo.customerList.get(i).getName());
						txtF333.setText(phaseTwo.customerList.get(i).getAddress());
						txtF444.setText(phaseTwo.customerList.get(i).getMobile());
						if (phaseTwo.customerList.get(i).getPlan().equalsIgnoreCase("Limited"))
							tg4.selectToggle(lm4);
						else if (phaseTwo.customerList.get(i).getPlan().equalsIgnoreCase("Unlimited"))
							tg4.selectToggle(unlm4);
						txtF555.setText(String.valueOf(phaseTwo.customerList.get(i).getLimited()));
					}
					writeFile();
				}
			});


			backBtn3.setOnAction(e ->{ 
				primaryStage.setScene(customerScene);
				txtF111.clear();
				txtF222.clear();
				txtF333.clear();
				txtF444.clear();
				txtF555.clear();
				lm4.setSelected(false);
				unlm4.setSelected(false);
			});


			BorderPane updatecMenu = new BorderPane ();
			updatecMenu.setBackground(bground);
			Scene updatecScene = new Scene(updatecMenu, 1370, 710);

			updatec.setOnAction(e -> primaryStage.setScene(updatecScene));
			HBox forTitle5 = new HBox ();
			Label title5 = new Label ("Update Information About Customer");
			title5.setFont(Font.font(40));
			forTitle5.getChildren().add(title5);
			forTitle5.setAlignment(Pos.CENTER);
			forTitle5.setPadding(new Insets (50,0,0,0));
			updatecMenu.setTop(forTitle5);

			RadioButton lm2 = new RadioButton ("Limited");
			lm2.setFont(Font.font(15));
			lm2.setPadding(new Insets (0,3,0,7));
			RadioButton unlm2 = new RadioButton ("Unlimited");
			unlm2.setFont(Font.font(15));
			unlm2.setPadding(new Insets (0,3,0,7));
			lm2.setDisable(true);
			unlm2.setDisable(true);

			HBox hboxx2 = new HBox();
			hboxx2.getChildren().addAll(lm2,unlm2);

			ToggleGroup tg2 = new ToggleGroup ();
			lm2.setToggleGroup(tg2);
			unlm2.setToggleGroup(tg2);

			RadioButton lm3 = new RadioButton ("Limited");
			lm3.setFont(Font.font(15));
			lm3.setPadding(new Insets (0,3,0,7));
			RadioButton unlm3 = new RadioButton ("Unlimited");
			unlm3.setFont(Font.font(15));
			unlm3.setPadding(new Insets (0,3,0,7));
			lm3.setDisable(true);
			unlm3.setDisable(true);

			HBox hboxx3 = new HBox();
			hboxx3.getChildren().addAll(lm3,unlm3);

			ToggleGroup tg3 = new ToggleGroup ();
			lm3.setToggleGroup(tg3);
			unlm3.setToggleGroup(tg3);

			VBox labels4 = new VBox ();
			labels4.setPadding(new Insets (28,9,9,50));
			Label label1111 = new Label     ("Customer ID:            ");
			label1111.setFont(Font.font(16));
			Label label2222 = new Label     ("Customer Name:          ");
			label2222.setFont(Font.font(16));
			Label labelNew2222 = new Label  ("*New Customer Name:      ");
			labelNew2222.setFont(Font.font(13));
			Label label3333 = new Label     ("Customer Address:       ");
			label3333.setFont(Font.font(16));
			Label labelNew3333 = new Label  ("*New Customer Address:   ");
			labelNew3333.setFont(Font.font(13));
			Label label4444 = new Label     ("Customer Mobile:        ");
			label4444.setFont(Font.font(16));
			Label labelNew4444 = new Label  ("*New Customer Mobile:    ");
			labelNew4444.setFont(Font.font(13));
			Label label5555 = new Label     ("Customer Plan:       ");
			label5555.setFont(Font.font(16));
			Label labelNew5555 = new Label  ("*New Customer Plan:   ");
			labelNew5555.setFont(Font.font(13));
			Label label6666 = new Label     ("Limited Value:        ");
			label6666.setFont(Font.font(16));
			Label labelNew6666 = new Label  ("*New Limited Value:    ");
			labelNew6666.setFont(Font.font(13));
			labels4.getChildren().addAll(label1111,label2222,labelNew2222,label3333,labelNew3333,label4444,labelNew4444,label5555,labelNew5555,label6666,labelNew6666);
			labels4.setAlignment(Pos.CENTER_LEFT);
			labels4.setSpacing(18);
			updatecMenu.setLeft(labels4);

			VBox txtFs4 = new VBox ();
			txtFs4.setPadding(new Insets (28,150,7,7));
			TextField txtF1111 = new TextField ();
			txtF1111.setFont(Font.font(16));
			TextField txtF2222= new TextField ();
			txtF2222.setFont(Font.font(16));
			txtF2222.setDisable(true);
			TextField txtFNew2222= new TextField ();
			txtFNew2222.setFont(Font.font(13));
			txtFNew2222.setDisable(true);
			TextField txtF3333 = new TextField ();
			txtF3333.setFont(Font.font(16));
			txtF3333.setDisable(true);
			TextField txtFNew3333 = new TextField ();
			txtFNew3333.setFont(Font.font(13));
			txtFNew3333.setDisable(true);
			TextField txtF4444 = new TextField ();
			txtF4444.setFont(Font.font(16));
			txtF4444.setDisable(true);
			TextField txtFNew4444 = new TextField ();
			txtFNew4444.setFont(Font.font(13));
			txtFNew4444.setDisable(true);
			TextField txtF6666 = new TextField ();
			txtF6666.setFont(Font.font(16));
			txtF6666.setDisable(true);
			TextField txtFNew6666 = new TextField ();
			txtFNew6666.setFont(Font.font(13));
			txtFNew6666.setDisable(true);
			txtFs4.getChildren().addAll(txtF1111,txtF2222,txtFNew2222,txtF3333,txtFNew3333,txtF4444,txtFNew4444,hboxx2,hboxx3,txtF6666,txtFNew6666);
			txtFs4.setSpacing(11);
			txtFs4.setAlignment(Pos.CENTER);

			txtF1111.setOnKeyTyped(e->{
				txtF2222.setDisable(false);	
			});
			txtF2222.setOnKeyTyped(e->{
				txtFNew2222.setDisable(false);	
			});
			txtFNew2222.setOnKeyTyped(e->{
				txtF3333.setDisable(false);	
			});
			txtF3333.setOnKeyTyped(e->{
				txtFNew3333.setDisable(false);	
			});
			txtFNew3333.setOnKeyTyped(e->{
				txtF4444.setDisable(false);	
			});
			txtF4444.setOnKeyTyped(e->{
				txtFNew4444.setDisable(false);	
			});
			txtFNew4444.setOnKeyTyped(e->{
				lm2.setDisable(false);	
				unlm2.setDisable(false);
				lm3.setDisable(false);	
				unlm3.setDisable(false);
			});
			/*lm3.setOnKeyTyped(e->{
				txtF6666.setDisable(false);	
			});
			unlm3.setOnKeyTyped(e->{
				txtF6666.setDisable(true);	
			});
			txtF6666.setOnKeyTyped(e->{
				txtFNew6666.setDisable(false);	
			});*/

			lm2.setOnAction(e-> {

				if (lm2.isSelected()) 
					txtF6666.setDisable(false);
				else
					txtF6666.setDisable(true);
			});
			unlm2.setOnAction(e-> {

				if (unlm2.isSelected()) 
					txtF6666.setDisable(true);

			});
			lm3.setOnAction(e-> {

				if (lm3.isSelected()) 
					txtFNew6666.setDisable(false);
				else
					txtFNew6666.setDisable(true);
			});
			unlm3.setOnAction(e-> {

				if (unlm3.isSelected()) 
					txtFNew6666.setDisable(true);

			});

			updatecMenu.setCenter(txtFs4);


			HBox buttons4 = new HBox ();
			Image updateCustomer = new Image ("update.png");
			Button backBtn4 = new Button ("   Back", new ImageView (imageBack));
			backBtn4.setPrefHeight(75);
			backBtn4.setPrefWidth(250);
			backBtn4.setFont(Font.font(20));
			Button update = new Button ("   Update\n Customer", new ImageView (updateCustomer));
			update.setPrefHeight(75);
			update.setPrefWidth(250);
			update.setFont(Font.font(20));
			buttons4.getChildren().addAll(update,backBtn4);
			buttons4.setAlignment(Pos.TOP_CENTER);
			buttons4.setSpacing(100);
			buttons4.setPadding(new Insets(0,30,30,30));
			updatecMenu.setBottom(buttons4);

			update.setOnAction(e -> {
				String selected3 = ((RadioButton)tg2.getSelectedToggle()).getText();
				String selected4 = ((RadioButton)tg3.getSelectedToggle()).getText();
				phaseTwo.updateCustomer(txtF1111.getText(),txtF2222.getText(),txtF3333.getText(),txtF4444.getText(),selected3,txtFNew2222.getText(),txtFNew3333.getText(),txtFNew4444.getText(),selected4);
				writeFile();
			});

			backBtn4.setOnAction(e -> {
				primaryStage.setScene(customerScene);
				txtF1111.clear();
				txtF2222.clear();
				txtFNew2222.clear();
				txtF3333.clear();
				txtFNew3333.clear();
				txtF4444.clear();
				txtFNew4444.clear();
				txtF6666.clear();
				txtFNew6666.clear();
				lm3.setSelected(false);
				unlm3.setSelected(false);
				lm2.setSelected(false);
				unlm2.setSelected(false);
			});


			returnc.setOnAction(e -> primaryStage.setScene(scene));


			//EDIIITTTT MEDIIIIAAAAAAA

			Scene mediaScene = new Scene(root2, 1370, 710);
			mediaBttn.setOnAction(e -> primaryStage.setScene(mediaScene));


			VBox mediaMenu = new VBox();
			Label title7 = new Label ("Media Menu");
			title7.setFont(Font.font(50));
			title7.setPadding(new Insets (10,0,30,0));
			mediaMenu.setAlignment(Pos.CENTER);
			mediaMenu.setPadding(new Insets (20,30,10,0));
			Button addm = new Button ("Add new media");
			addm.setPrefWidth(500);
			addm.setPrefHeight(70);
			addm.setFont(Font.font(25));
			Button deletem = new Button ("Delete media");
			deletem.setPrefWidth(500);
			deletem.setPrefHeight(70);
			deletem.setFont(Font.font(25));
			Button updatem = new Button ("Update information about media");
			updatem.setPrefWidth(500);
			updatem.setPrefHeight(70);
			updatem.setFont(Font.font(25));
			Button searchm = new Button ("Search a media by code");
			searchm.setPrefWidth(500);
			searchm.setPrefHeight(70);
			searchm.setFont(Font.font(25));
			Button printm = new Button ("Print all media information");
			printm.setPrefWidth(500);
			printm.setPrefHeight(70);
			printm.setFont(Font.font(25));
			Button returnm = new Button ("Return to main page");
			returnm.setPrefWidth(500);
			returnm.setPrefHeight(70);
			returnm.setFont(Font.font(25));
			mediaMenu.setSpacing(20);
			mediaMenu.getChildren().addAll(title7,addm,deletem,updatem,searchm,printm,returnm);
			root2.setCenter(mediaMenu);
			//MEDIIIIIIAAAAAAAAAAA

			BorderPane addmMenu = new BorderPane ();
			addmMenu.setBackground(bground);
			Scene addmScene = new Scene(addmMenu, 1370, 710);

			addm.setOnAction(e -> primaryStage.setScene(addmScene));

			HBox hbbox = new HBox ();
			Label select = new Label ("  Media Types:  ");
			select.setFont(Font.font(30));
			hbbox.setAlignment(Pos.CENTER);
			ComboBox <String> combobox = new ComboBox <>();
			combobox.setPromptText("Please select a type");
			combobox.setPadding(new Insets (15,10,10,15));
			combobox.setStyle("-fx-font-size: 18;");
			ObservableList <String> mediaTypes  = combobox.getItems();

			mediaTypes.add("Game");
			mediaTypes.add("Movie");
			mediaTypes.add("Album");
			hbbox.getChildren().addAll(select,combobox);

			VBox forTitle8 = new VBox ();
			Label title8 = new Label ("Add New Media Menu");
			title8.setFont(Font.font(40));
			forTitle8.getChildren().addAll(title8,hbbox);
			forTitle8.setAlignment(Pos.CENTER);
			forTitle8.setPadding(new Insets (50,0,0,0));
			forTitle8.setSpacing(25);
			addmMenu.setTop(forTitle8);



			combobox.setOnAction( e -> {

				if (combobox.getValue()=="Game") {
					VBox labels5 = new VBox ();
					labels5.setPadding(new Insets (52,9,9,50));
					Label mlabel1 = new Label ("Game Code:        ");
					mlabel1.setFont(Font.font(20));
					Label mlabel2 = new Label ("Game Title:       ");
					mlabel2.setFont(Font.font(20));
					Label mlabel3 = new Label ("Number Of Copies: ");
					mlabel3.setFont(Font.font(20));
					Label mlabel4 = new Label ("Game Weight:      ");
					mlabel4.setFont(Font.font(20));
					labels5.getChildren().addAll(mlabel1,mlabel2,mlabel3,mlabel4);
					labels5.setAlignment(Pos.CENTER_LEFT);
					labels5.setSpacing(50);
					addmMenu.setLeft(labels5);

					VBox txtFs5 = new VBox ();
					txtFs5.setPadding(new Insets (50,150,7,7));
					TextField mtxtF1 = new TextField ();
					mtxtF1.setDisable(false);
					mtxtF1.setFont(Font.font(20));
					TextField mtxtF2 = new TextField ();
					//mtxtF2.setDisable(true);
					mtxtF2.setFont(Font.font(20));
					TextField mtxtF3 = new TextField ();
					//mtxtF3.setDisable(true);
					mtxtF3.setFont(Font.font(20));
					TextField mtxtF4 = new TextField ();
					//mtxtF4.setDisable(true);
					mtxtF4.setFont(Font.font(20));
					txtFs5.getChildren().addAll(mtxtF1,mtxtF2,mtxtF3,mtxtF4);
					txtFs5.setSpacing(40);
					txtFs5.setAlignment(Pos.CENTER);



					/*mtxtF1.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent arg0) {
							mtxtF2.setDisable(false);
						}
					});*/


					addmMenu.setCenter(txtFs5);

					HBox buttons5 = new HBox ();
					Image addg = new Image ("addgame.png");
					Button addGame = new Button ("  Add \n Game", new ImageView (addg));
					addGame.setPrefHeight(90);
					addGame.setPrefWidth(250);
					addGame.setFont(Font.font(20));
					addGame.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent arg0) {
							int x = Integer.parseInt(mtxtF3.getText());
							double y = Double.parseDouble(mtxtF4.getText());
							phaseTwo.addGame(mtxtF1.getText(), mtxtF2.getText(), x, y);
							writeFile();
						}
					});

					Button backBtn5 = new Button ("  Back", new ImageView (imageBack));
					backBtn5.setPrefHeight(90);
					backBtn5.setPrefWidth(250);
					backBtn5.setFont(Font.font(20));

					backBtn5.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(mediaScene);
							mtxtF1.clear();
							mtxtF2.clear();
							mtxtF3.clear();
							mtxtF4.clear();
						}
					});

					buttons5.getChildren().addAll(addGame,backBtn5);
					buttons5.setAlignment(Pos.TOP_CENTER);
					buttons5.setSpacing(100);
					buttons5.setPadding(new Insets(30,30,30,30));
					addmMenu.setBottom(buttons5);

				}

				else if (combobox.getValue()=="Movie") {
					VBox labels6 = new VBox ();
					labels6.setPadding(new Insets (52,9,9,50));
					Label mlabel11 = new Label ("Movie Code:       ");
					mlabel11.setFont(Font.font(20));
					Label mlabel22 = new Label ("Movie Title:      ");
					mlabel22.setFont(Font.font(20));
					Label mlabel33 = new Label ("Number Of Copies: ");
					mlabel33.setFont(Font.font(20));
					Label mlabel44 = new Label ("Movie Rating:     ");
					mlabel44.setFont(Font.font(20));
					labels6.getChildren().addAll(mlabel11,mlabel22,mlabel33,mlabel44);
					labels6.setAlignment(Pos.CENTER_LEFT);
					labels6.setSpacing(50);
					addmMenu.setLeft(labels6);

					RadioButton dr = new RadioButton ("DR");
					dr.setFont(Font.font(20));
					dr.setPadding(new Insets (0,3,0,7));
					RadioButton hr = new RadioButton ("HR");
					hr.setFont(Font.font(20));
					hr.setPadding(new Insets (0,3,0,7));
					RadioButton ac = new RadioButton ("AC");
					ac.setFont(Font.font(20));
					ac.setPadding(new Insets (0,3,0,7));

					HBox hbox = new HBox();
					hbox.getChildren().addAll(dr,hr,ac);

					ToggleGroup tg = new ToggleGroup ();
					dr.setToggleGroup(tg);
					hr.setToggleGroup(tg);
					ac.setToggleGroup(tg);

					VBox txtFs6 = new VBox ();
					txtFs6.setPadding(new Insets (50,150,7,7));
					TextField mtxtF11 = new TextField ();
					mtxtF11.setFont(Font.font(20));
					TextField mtxtF22 = new TextField ();
					mtxtF22.setFont(Font.font(20));
					TextField mtxtF33 = new TextField ();
					mtxtF33.setFont(Font.font(20));
					txtFs6.getChildren().addAll(mtxtF11,mtxtF22,mtxtF33,hbox);
					txtFs6.setSpacing(40);
					txtFs6.setAlignment(Pos.CENTER);
					addmMenu.setCenter(txtFs6);
					HBox buttons6 = new HBox ();

					Image addmovie = new Image ("addmovie.png");
					Button addMovie = new Button ("  Add \n Movie", new ImageView (addmovie));
					addMovie.setPrefHeight(90);
					addMovie.setPrefWidth(250);
					addMovie.setFont(Font.font(20));

					addMovie.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent arg0) {
							int x1 = Integer.parseInt(mtxtF33.getText());
							String selected5 = ((RadioButton)tg.getSelectedToggle()).getText();
							phaseTwo.addMovie(mtxtF11.getText(), mtxtF22.getText(), x1, selected5);
							writeFile();
						}
					});

					Button backBtn6 = new Button ("  Back", new ImageView (imageBack));
					backBtn6.setPrefHeight(90);
					backBtn6.setPrefWidth(250);
					backBtn6.setFont(Font.font(20));

					backBtn6.setOnAction( new EventHandler<ActionEvent>() {
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(mediaScene);
							mtxtF11.clear();
							mtxtF22.clear();
							mtxtF33.clear();
							dr.setSelected(false);
							hr.setSelected(false);
							ac.setSelected(false);
						}
					});


					buttons6.getChildren().addAll(addMovie,backBtn6);
					buttons6.setAlignment(Pos.TOP_CENTER);
					buttons6.setSpacing(100);
					buttons6.setPadding(new Insets(30,30,30,30));
					addmMenu.setBottom(buttons6);

				}

				else if (combobox.getValue()=="Album") {
					VBox labels7 = new VBox ();
					labels7.setPadding(new Insets (52,9,9,50));
					Label mlabel111 = new Label ("Album Code:       ");
					mlabel111.setFont(Font.font(20));
					Label mlabel222 = new Label ("Album Title:      ");
					mlabel222.setFont(Font.font(20));
					Label mlabel333 = new Label ("Number Of Copies: ");
					mlabel333.setFont(Font.font(20));
					Label mlabel444 = new Label ("Artist:           ");
					mlabel444.setFont(Font.font(20));
					Label mlabel555 = new Label ("Songs:            ");
					mlabel555.setFont(Font.font(20));
					labels7.getChildren().addAll(mlabel111,mlabel222,mlabel333,mlabel444,mlabel555);
					labels7.setAlignment(Pos.CENTER_LEFT);
					labels7.setSpacing(35);
					addmMenu.setLeft(labels7);

					VBox txtFs7 = new VBox ();
					txtFs7.setPadding(new Insets (50,150,7,7));
					TextField mtxtF111 = new TextField ();
					mtxtF111.setFont(Font.font(18));
					TextField mtxtF222 = new TextField ();
					mtxtF222.setFont(Font.font(18));
					TextField mtxtF333 = new TextField ();
					mtxtF333.setFont(Font.font(18));
					TextField mtxtF444 = new TextField ();
					mtxtF444.setFont(Font.font(18));
					TextField mtxtF555 = new TextField ();
					mtxtF555.setFont(Font.font(18));
					txtFs7.getChildren().addAll(mtxtF111,mtxtF222,mtxtF333,mtxtF444,mtxtF555);
					txtFs7.setSpacing(25);
					txtFs7.setAlignment(Pos.CENTER);
					addmMenu.setCenter(txtFs7);

					HBox buttons7 = new HBox ();
					Image addalbum = new Image  ("addsong.png");
					Button addAlbum = new Button ("  Add \n Album", new ImageView (addalbum));
					addAlbum.setPrefHeight(90);
					addAlbum.setPrefWidth(250);
					addAlbum.setFont(Font.font(20));

					addAlbum.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent arg0) {
							int x2 = Integer.parseInt(mtxtF333.getText());
							phaseTwo.addAlbum(mtxtF111.getText(), mtxtF222.getText(), x2, mtxtF444.getText(),mtxtF555.getText());
							writeFile();
						}
					});

					Button backBtn7 = new Button ("  Back", new ImageView (imageBack));
					backBtn7.setPrefHeight(90);
					backBtn7.setPrefWidth(250);
					backBtn7.setFont(Font.font(20));

					backBtn7.setOnAction( new EventHandler<ActionEvent>() {
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(mediaScene);
							mtxtF111.clear();
							mtxtF222.clear();
							mtxtF333.clear();
							mtxtF444.clear();
							mtxtF555.clear();
						}
					});

					buttons7.getChildren().addAll(addAlbum,backBtn7);
					buttons7.setAlignment(Pos.TOP_CENTER);
					buttons7.setSpacing(100);
					buttons7.setPadding(new Insets(15,30,30,30));
					addmMenu.setBottom(buttons7);

				}

			});


			BorderPane deletemMenu = new BorderPane();
			deletemMenu.setBackground(bground);
			Scene deletemScene = new Scene(deletemMenu, 1370, 710);

			deletem.setOnAction(e -> primaryStage.setScene(deletemScene));
			HBox forTitleD = new HBox ();
			Label titleD = new Label ("Delete Media Menu");
			titleD.setFont(Font.font(40));
			forTitleD.getChildren().add(titleD);
			forTitleD.setAlignment(Pos.CENTER);
			forTitleD.setPadding(new Insets (50,0,0,0));
			deletemMenu.setTop(forTitleD);

			VBox labels8 = new VBox ();
			labels8.setPadding(new Insets (102,9,9,50));
			Label mlabel1D = new Label ("Media Code:      ");
			mlabel1D.setFont(Font.font(20));
			labels8.getChildren().addAll(mlabel1D);
			labels8.setAlignment(Pos.CENTER);
			deletemMenu.setLeft(labels8);

			VBox txtFs8 = new VBox ();
			txtFs8.setPadding(new Insets (100,150,7,7));
			TextField mtxtF1D = new TextField ();
			mtxtF1D.setFont(Font.font(20));

			txtFs8.getChildren().addAll(mtxtF1D);
			txtFs8.setSpacing(40);
			txtFs8.setAlignment(Pos.CENTER);
			deletemMenu.setCenter(txtFs8);

			HBox buttons8 = new HBox ();
			Image mimageDelete = new Image("trash.png");
			Image mimageFind = new Image("find.png");
			Button backBtn8 = new Button ("  Back", new ImageView (imageBack));
			backBtn8.setPrefHeight(90);
			backBtn8.setPrefWidth(250);
			backBtn8.setFont(Font.font(20));
			Button findM = new Button ("  Find", new ImageView (mimageFind));
			findM.setPrefHeight(90);
			findM.setPrefWidth(250);
			findM .setFont(Font.font(20));
			buttons8.getChildren().addAll(findM,backBtn8);
			buttons8.setAlignment(Pos.TOP_CENTER);
			buttons8.setSpacing(100);
			buttons8.setPadding(new Insets(30,30,30,30));
			deletemMenu.setBottom(buttons8);
			backBtn8.setOnAction(e -> primaryStage.setScene(mediaScene));


			findM.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					for (int i = 0; i < phaseTwo.mediaList.size(); i++) {
						if (phaseTwo.mediaList.get(i).getCode().equalsIgnoreCase(mtxtF1D.getText()))
							if (phaseTwo.mediaList.get(i) instanceof Game) {
								VBox labels5 = new VBox ();
								labels5.setPadding(new Insets (52,9,9,50));
								Label mlabel1 = new Label ("Game Code:        ");
								mlabel1.setFont(Font.font(20));
								Label mlabel2 = new Label ("Game Title:       ");
								mlabel2.setFont(Font.font(20));
								Label mlabel3 = new Label ("Number Of Copies: ");
								mlabel3.setFont(Font.font(20));
								Label mlabel4 = new Label ("Game Weight:      ");
								mlabel4.setFont(Font.font(20));
								labels5.getChildren().addAll(mlabel1,mlabel2,mlabel3,mlabel4);
								labels5.setAlignment(Pos.CENTER_LEFT);
								labels5.setSpacing(50);
								deletemMenu.setLeft(labels5);

								VBox txtFs5 = new VBox ();
								txtFs5.setPadding(new Insets (50,150,7,7));
								TextField mtxtF1 = new TextField ();
								mtxtF1.setFont(Font.font(20));
								mtxtF1.setText(mtxtF1D.getText());
								mtxtF1.setDisable(true);
								TextField mtxtF2 = new TextField ();
								mtxtF2.setFont(Font.font(20));
								mtxtF2.setDisable(true);
								mtxtF2.setText(phaseTwo.mediaList.get(i).getTitle());
								TextField mtxtF3 = new TextField ();
								String z = String.valueOf(phaseTwo.mediaList.get(i).getNumOfCopies());
								mtxtF3.setDisable(true);
								mtxtF3.setText(z);
								mtxtF3.setFont(Font.font(20));
								TextField mtxtF4 = new TextField ();
								String s = String.valueOf(((Game)phaseTwo.mediaList.get(i)).getWeigth());
								mtxtF4.setText(s);
								mtxtF4.setDisable(true);
								mtxtF4.setFont(Font.font(20));
								txtFs5.getChildren().addAll(mtxtF1,mtxtF2,mtxtF3,mtxtF4);
								txtFs5.setSpacing(40);
								txtFs5.setAlignment(Pos.CENTER);

								deletemMenu.setCenter(txtFs5);

								HBox buttons5 = new HBox ();
								Button deleteg = new Button ("  Delete \n   Game", new ImageView (mimageDelete));
								deleteg.setPrefHeight(90);
								deleteg.setPrefWidth(250);
								deleteg.setFont(Font.font(20));
								deleteg.setOnAction(new EventHandler<ActionEvent>() {
									public void handle(ActionEvent arg0) {
										int x = Integer.parseInt(mtxtF3.getText());
										double y = Double.parseDouble(mtxtF4.getText());
										phaseTwo.removeGame(mtxtF1.getText(), mtxtF2.getText(), x, y);
										writeFile();
									}
								});

								Button backBtn5 = new Button ("  Back", new ImageView (imageBack));
								backBtn5.setPrefHeight(90);
								backBtn5.setPrefWidth(250);
								backBtn5.setFont(Font.font(20));

								backBtn5.setOnAction(new EventHandler<ActionEvent>() {
									public void handle(ActionEvent arg0) {
										primaryStage.setScene(deletemScene)	;
										deletemMenu.setLeft(labels8);
										deletemMenu.setBottom(buttons8);
										deletemMenu.setCenter(txtFs8);
										mtxtF1D.clear();


									}
								});

								buttons5.getChildren().addAll(deleteg,backBtn5);
								buttons5.setAlignment(Pos.TOP_CENTER);
								buttons5.setSpacing(100);
								buttons5.setPadding(new Insets(30,30,30,30));
								deletemMenu.setBottom(buttons5);
								deletemMenu.setCenter(txtFs5);
							}

							else if (phaseTwo.mediaList.get(i) instanceof Movie) {
								VBox labels6 = new VBox ();
								labels6.setPadding(new Insets (52,9,9,50));
								Label mlabel11 = new Label ("Movie Code:       ");
								mlabel11.setFont(Font.font(20));
								Label mlabel22 = new Label ("Movie Title:      ");
								mlabel22.setFont(Font.font(20));
								Label mlabel33 = new Label ("Number Of Copies: ");
								mlabel33.setFont(Font.font(20));
								Label mlabel44 = new Label ("Movie Rating:     ");
								mlabel44.setFont(Font.font(20));
								labels6.getChildren().addAll(mlabel11,mlabel22,mlabel33,mlabel44);
								labels6.setAlignment(Pos.CENTER_LEFT);
								labels6.setSpacing(50);
								deletemMenu.setLeft(labels6);

								RadioButton dr = new RadioButton ("DR");
								dr.setFont(Font.font(20));
								dr.setPadding(new Insets (0,3,0,7));
								dr.setDisable(true);
								RadioButton hr = new RadioButton ("HR");
								hr.setFont(Font.font(20));
								hr.setPadding(new Insets (0,3,0,7));
								hr.setDisable(true);
								RadioButton ac = new RadioButton ("AC");
								ac.setFont(Font.font(20));
								ac.setPadding(new Insets (0,3,0,7));
								ac.setDisable(true);
								HBox hbox = new HBox();
								hbox.getChildren().addAll(dr,hr,ac);

								ToggleGroup tg = new ToggleGroup ();
								dr.setToggleGroup(tg);
								hr.setToggleGroup(tg);
								ac.setToggleGroup(tg);

								if ( ((Movie)phaseTwo.mediaList.get(i)).getRating().equalsIgnoreCase("DR"))
									tg.selectToggle(dr);
								else if ( ((Movie)phaseTwo.mediaList.get(i)).getRating().equalsIgnoreCase("HR"))
									tg.selectToggle(hr);
								else if ( ((Movie)phaseTwo.mediaList.get(i)).getRating().equalsIgnoreCase("AC"))
									tg.selectToggle(ac);


								VBox txtFs6 = new VBox ();
								txtFs6.setPadding(new Insets (50,150,7,7));
								TextField mtxtF11 = new TextField ();
								mtxtF11.setText(mtxtF1D.getText());
								mtxtF11.setDisable(true);
								mtxtF11.setFont(Font.font(20));
								TextField mtxtF22 = new TextField ();
								mtxtF22.setText(phaseTwo.mediaList.get(i).getTitle());
								mtxtF22.setDisable(true);
								mtxtF22.setFont(Font.font(20));
								TextField mtxtF33 = new TextField ();
								String z = String.valueOf(phaseTwo.mediaList.get(i).getNumOfCopies());
								mtxtF33.setText(z);
								mtxtF33.setDisable(true);
								mtxtF33.setFont(Font.font(20));
								txtFs6.getChildren().addAll(mtxtF11,mtxtF22,mtxtF33,hbox);
								txtFs6.setSpacing(40);
								txtFs6.setAlignment(Pos.CENTER);
								deletemMenu.setCenter(txtFs6);
								HBox buttons6 = new HBox ();
								Button deletemo = new Button ("  Delete \n  Movie", new ImageView (mimageDelete));
								deletemo.setPrefHeight(90);
								deletemo.setPrefWidth(250);
								deletemo.setFont(Font.font(20));

								deletemo.setOnAction(new EventHandler<ActionEvent>() {
									public void handle(ActionEvent arg0) {
										int x1 = Integer.parseInt(mtxtF33.getText());
										String selected5 = ((RadioButton)tg.getSelectedToggle()).getText();
										phaseTwo.removeMovie(mtxtF11.getText(), mtxtF22.getText(), x1, selected5);
										writeFile();
									}
								});

								Button backBtn6 = new Button ("  Back", new ImageView (imageBack));
								backBtn6.setPrefHeight(90);
								backBtn6.setPrefWidth(250);
								backBtn6.setFont(Font.font(20));

								backBtn6.setOnAction( new EventHandler<ActionEvent>() {
									public void handle(ActionEvent arg0) {
										primaryStage.setScene(deletemScene)	;
										deletemMenu.setLeft(labels8);
										deletemMenu.setBottom(buttons8);
										deletemMenu.setCenter(txtFs8);
										mtxtF1D.clear();
									}
								});


								buttons6.getChildren().addAll(deletemo,backBtn6);
								buttons6.setAlignment(Pos.TOP_CENTER);
								buttons6.setSpacing(100);
								buttons6.setPadding(new Insets(30,30,30,30));
								deletemMenu.setBottom(buttons6);

							}

							else if (phaseTwo.mediaList.get(i) instanceof Album) {

								VBox labels7 = new VBox ();
								labels7.setPadding(new Insets (52,9,9,50));
								Label mlabel111 = new Label ("Album Code:       ");
								mlabel111.setFont(Font.font(20));
								Label mlabel222 = new Label ("Album Title:      ");
								mlabel222.setFont(Font.font(20));
								Label mlabel333 = new Label ("Number Of Copies: ");
								mlabel333.setFont(Font.font(20));
								Label mlabel444 = new Label ("Artist:           ");
								mlabel444.setFont(Font.font(20));
								Label mlabel555 = new Label ("Songs:            ");
								mlabel555.setFont(Font.font(20));
								labels7.getChildren().addAll(mlabel111,mlabel222,mlabel333,mlabel444,mlabel555);
								labels7.setAlignment(Pos.CENTER_LEFT);
								labels7.setSpacing(35);
								deletemMenu.setLeft(labels7);

								VBox txtFs7 = new VBox ();
								txtFs7.setPadding(new Insets (50,150,7,7));
								TextField mtxtF111 = new TextField ();
								mtxtF111.setText(mtxtF1D.getText());
								mtxtF111.setDisable(true);
								mtxtF111.setFont(Font.font(18));
								TextField mtxtF222 = new TextField ();
								mtxtF222.setText(phaseTwo.mediaList.get(i).getTitle());
								mtxtF222.setDisable(true);
								mtxtF222.setFont(Font.font(18));
								TextField mtxtF333 = new TextField ();
								String t = String.valueOf(phaseTwo.mediaList.get(i).getNumOfCopies());
								mtxtF333.setDisable(true);
								mtxtF333.setText(t);
								mtxtF333.setFont(Font.font(18));
								TextField mtxtF444 = new TextField ();
								mtxtF444.setText(((Album)phaseTwo.mediaList.get(i)).getArtist());
								mtxtF444.setFont(Font.font(18));
								mtxtF444.setDisable(true);
								TextField mtxtF555 = new TextField ();
								mtxtF555.setText(((Album)phaseTwo.mediaList.get(i)).getSong());
								mtxtF555.setDisable(true);
								mtxtF555.setFont(Font.font(18));
								txtFs7.getChildren().addAll(mtxtF111,mtxtF222,mtxtF333,mtxtF444,mtxtF555);
								txtFs7.setSpacing(25);
								txtFs7.setAlignment(Pos.CENTER);
								deletemMenu.setCenter(txtFs7);

								HBox buttons7 = new HBox ();
								Button deleteal = new Button ("  Delete \n  Album", new ImageView (mimageDelete));
								deleteal.setPrefHeight(90);
								deleteal.setPrefWidth(250);
								deleteal.setFont(Font.font(20));

								deleteal.setOnAction(new EventHandler<ActionEvent>() {
									public void handle(ActionEvent arg0) {
										int x2 = Integer.parseInt(mtxtF333.getText());
										phaseTwo.removeAlbum(mtxtF111.getText(), mtxtF222.getText(), x2, mtxtF444.getText(),mtxtF555.getText());
										writeFile();
									}
								});

								Button backBtn7 = new Button ("  Back", new ImageView (imageBack));
								backBtn7.setPrefHeight(90);
								backBtn7.setPrefWidth(250);
								backBtn7.setFont(Font.font(20));

								backBtn7.setOnAction( new EventHandler<ActionEvent>() {
									public void handle(ActionEvent arg0) {
										primaryStage.setScene(deletemScene)	;
										deletemMenu.setLeft(labels8);
										deletemMenu.setBottom(buttons8);
										deletemMenu.setCenter(txtFs8);
										mtxtF1D.clear();


									}
								});

								buttons7.getChildren().addAll(deleteal,backBtn7);
								buttons7.setAlignment(Pos.TOP_CENTER);
								buttons7.setSpacing(100);
								buttons7.setPadding(new Insets(15,30,30,30));
								deletemMenu.setBottom(buttons7);

							}
					}
				}
			});

			BorderPane searchmMenu = new BorderPane();
			searchmMenu.setBackground(bground);
			Scene searchmScene = new Scene(searchmMenu, 1370, 710);

			searchm.setOnAction(e -> primaryStage.setScene(searchmScene));
			HBox forTitleS = new HBox ();
			Label titleS = new Label ("Seach Media Menu");
			titleS.setFont(Font.font(40));
			forTitleS.getChildren().add(titleS);
			forTitleS.setAlignment(Pos.CENTER);
			forTitleS.setPadding(new Insets (50,0,0,0));
			searchmMenu.setTop(forTitleS);

			VBox labels9 = new VBox ();
			labels9.setPadding(new Insets (102,9,9,50));
			Label mlabel1S = new Label ("Media Code:      ");
			mlabel1S.setFont(Font.font(20));
			labels9.getChildren().add(mlabel1S);
			labels9.setAlignment(Pos.CENTER_LEFT);
			labels9.setSpacing(50);
			searchmMenu.setLeft(labels9);

			VBox txtFs9 = new VBox ();
			txtFs9.setPadding(new Insets (100,150,7,7));
			TextField mtxtF1S = new TextField ();
			mtxtF1S.setFont(Font.font(20));
			txtFs9.getChildren().add(mtxtF1S);
			txtFs9.setSpacing(40);
			txtFs9.setAlignment(Pos.CENTER);
			searchmMenu.setCenter(txtFs9);


			HBox buttons9 = new HBox ();
			Button backBtn9 = new Button ("  Back", new ImageView (imageBack));
			backBtn9.setPrefHeight(90);
			backBtn9.setPrefWidth(250);
			backBtn9.setFont(Font.font(20));
			Button findM2 = new Button ("  Search", new ImageView (mimageFind));
			findM2.setPrefHeight(90);
			findM2.setPrefWidth(250);
			findM2.setFont(Font.font(20));
			buttons9.getChildren().addAll(findM2,backBtn9);
			buttons9.setAlignment(Pos.TOP_CENTER);
			buttons9.setSpacing(100);
			buttons9.setPadding(new Insets(30,30,30,30));
			searchmMenu.setBottom(buttons9);

			findM2.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {

					for (int j = 0; j < phaseTwo.mediaList.size(); j++) {
						if (phaseTwo.mediaList.get(j).getCode().equalsIgnoreCase(mtxtF1S.getText()))
							if (phaseTwo.mediaList.get(j) instanceof Game) {
								VBox labels5 = new VBox ();
								labels5.setPadding(new Insets (52,9,9,50));
								Label mlabel1 = new Label ("Game Code:        ");
								mlabel1.setFont(Font.font(20));
								Label mlabel2 = new Label ("Game Title:       ");
								mlabel2.setFont(Font.font(20));
								Label mlabel3 = new Label ("Number Of Copies: ");
								mlabel3.setFont(Font.font(20));
								Label mlabel4 = new Label ("Game Weight:      ");
								mlabel4.setFont(Font.font(20));
								labels5.getChildren().addAll(mlabel1,mlabel2,mlabel3,mlabel4);
								labels5.setAlignment(Pos.CENTER_LEFT);
								labels5.setSpacing(50);
								searchmMenu.setLeft(labels5);

								VBox txtFs5 = new VBox ();
								txtFs5.setPadding(new Insets (50,150,7,7));
								TextField mtxtF1 = new TextField ();
								mtxtF1.setFont(Font.font(20));
								mtxtF1.setText(mtxtF1S.getText());
								mtxtF1.setDisable(true);
								TextField mtxtF2 = new TextField ();
								mtxtF2.setFont(Font.font(20));
								mtxtF2.setDisable(true);
								mtxtF2.setText(phaseTwo.mediaList.get(j).getTitle());
								TextField mtxtF3 = new TextField ();
								String a = String.valueOf(phaseTwo.mediaList.get(j).getNumOfCopies());
								mtxtF3.setDisable(true);
								mtxtF3.setText(a);
								mtxtF3.setFont(Font.font(20));
								TextField mtxtF4 = new TextField ();
								String b = String.valueOf(((Game)phaseTwo.mediaList.get(j)).getWeigth());
								mtxtF4.setText(b);
								mtxtF4.setDisable(true);
								mtxtF4.setFont(Font.font(20));
								txtFs5.getChildren().addAll(mtxtF1,mtxtF2,mtxtF3,mtxtF4);
								txtFs5.setSpacing(40);
								txtFs5.setAlignment(Pos.CENTER);

								searchmMenu.setCenter(txtFs5);

								HBox buttons5 = new HBox ();

								Button backBtn5 = new Button ("  Back", new ImageView (imageBack));
								backBtn5.setPrefHeight(90);
								backBtn5.setPrefWidth(250);
								backBtn5.setFont(Font.font(20));

								backBtn5.setOnAction(new EventHandler<ActionEvent>() {
									public void handle(ActionEvent arg0) {
										primaryStage.setScene(searchmScene)	;
										searchmMenu.setLeft(labels9);
										searchmMenu.setBottom(buttons9);
										searchmMenu.setCenter(txtFs9);
										mtxtF1S.clear();
									}
								});

								buttons5.getChildren().add(backBtn5);
								buttons5.setAlignment(Pos.TOP_CENTER);
								buttons5.setSpacing(100);
								buttons5.setPadding(new Insets(30,30,30,30));
								searchmMenu.setBottom(buttons5);
								searchmMenu.setCenter(txtFs5);
							}

							else if (phaseTwo.mediaList.get(j) instanceof Movie) {
								VBox labels6 = new VBox ();
								labels6.setPadding(new Insets (52,9,9,50));
								Label mlabel11 = new Label ("Movie Code:       ");
								mlabel11.setFont(Font.font(20));
								Label mlabel22 = new Label ("Movie Title:      ");
								mlabel22.setFont(Font.font(20));
								Label mlabel33 = new Label ("Number Of Copies: ");
								mlabel33.setFont(Font.font(20));
								Label mlabel44 = new Label ("Movie Rating:     ");
								mlabel44.setFont(Font.font(20));
								labels6.getChildren().addAll(mlabel11,mlabel22,mlabel33,mlabel44);
								labels6.setAlignment(Pos.CENTER_LEFT);
								labels6.setSpacing(50);
								searchmMenu.setLeft(labels6);

								RadioButton dr = new RadioButton ("DR");
								dr.setFont(Font.font(20));
								dr.setPadding(new Insets (0,3,0,7));
								dr.setDisable(true);
								RadioButton hr = new RadioButton ("HR");
								hr.setFont(Font.font(20));
								hr.setPadding(new Insets (0,3,0,7));
								hr.setDisable(true);
								RadioButton ac = new RadioButton ("AC");
								ac.setFont(Font.font(20));
								ac.setPadding(new Insets (0,3,0,7));
								ac.setDisable(true);
								HBox hbox = new HBox();
								hbox.getChildren().addAll(dr,hr,ac);

								ToggleGroup tg = new ToggleGroup ();
								dr.setToggleGroup(tg);
								hr.setToggleGroup(tg);
								ac.setToggleGroup(tg);

								if ( ((Movie)phaseTwo.mediaList.get(j)).getRating().equalsIgnoreCase("DR"))
									tg.selectToggle(dr);
								else if ( ((Movie)phaseTwo.mediaList.get(j)).getRating().equalsIgnoreCase("HR"))
									tg.selectToggle(hr);
								else if ( ((Movie)phaseTwo.mediaList.get(j)).getRating().equalsIgnoreCase("AC"))
									tg.selectToggle(ac);


								VBox txtFs6 = new VBox ();
								txtFs6.setPadding(new Insets (50,150,7,7));
								TextField mtxtF11 = new TextField ();
								mtxtF11.setText(mtxtF1S.getText());
								mtxtF11.setDisable(true);
								mtxtF11.setFont(Font.font(20));
								TextField mtxtF22 = new TextField ();
								mtxtF22.setText(phaseTwo.mediaList.get(j).getTitle());
								mtxtF22.setDisable(true);
								mtxtF22.setFont(Font.font(20));
								TextField mtxtF33 = new TextField ();
								String i = String.valueOf(phaseTwo.mediaList.get(j).getNumOfCopies());
								mtxtF33.setText(i);
								mtxtF33.setDisable(true);
								mtxtF33.setFont(Font.font(20));
								txtFs6.getChildren().addAll(mtxtF11,mtxtF22,mtxtF33,hbox);
								txtFs6.setSpacing(40);
								txtFs6.setAlignment(Pos.CENTER);
								searchmMenu.setCenter(txtFs6);
								HBox buttons6 = new HBox ();

								Button backBtn6 = new Button ("  Back", new ImageView (imageBack));
								backBtn6.setPrefHeight(90);
								backBtn6.setPrefWidth(250);
								backBtn6.setFont(Font.font(20));

								backBtn6.setOnAction( new EventHandler<ActionEvent>() {
									public void handle(ActionEvent arg0) {
										primaryStage.setScene(searchmScene)	;
										searchmMenu.setLeft(labels9);
										searchmMenu.setBottom(buttons9);
										searchmMenu.setCenter(txtFs9);
										mtxtF1S.clear();

									}
								});


								buttons6.getChildren().add(backBtn6);
								buttons6.setAlignment(Pos.TOP_CENTER);
								buttons6.setSpacing(100);
								buttons6.setPadding(new Insets(30,30,30,30));
								searchmMenu.setBottom(buttons6);

							}

							else if (phaseTwo.mediaList.get(j) instanceof Album) {

								VBox labels7 = new VBox ();
								labels7.setPadding(new Insets (52,9,9,50));
								Label mlabel111 = new Label ("Album Code:       ");
								mlabel111.setFont(Font.font(20));
								Label mlabel222 = new Label ("Album Title:      ");
								mlabel222.setFont(Font.font(20));
								Label mlabel333 = new Label ("Number Of Copies: ");
								mlabel333.setFont(Font.font(20));
								Label mlabel444 = new Label ("Artist:           ");
								mlabel444.setFont(Font.font(20));
								Label mlabel555 = new Label ("Songs:            ");
								mlabel555.setFont(Font.font(20));
								labels7.getChildren().addAll(mlabel111,mlabel222,mlabel333,mlabel444,mlabel555);
								labels7.setAlignment(Pos.CENTER_LEFT);
								labels7.setSpacing(35);
								searchmMenu.setLeft(labels7);

								VBox txtFs7 = new VBox ();
								txtFs7.setPadding(new Insets (50,150,7,7));
								TextField mtxtF111 = new TextField ();
								mtxtF111.setText(mtxtF1S.getText());
								mtxtF111.setDisable(true);
								mtxtF111.setFont(Font.font(18));
								TextField mtxtF222 = new TextField ();
								mtxtF222.setText(phaseTwo.mediaList.get(j).getTitle());
								mtxtF222.setDisable(true);
								mtxtF222.setFont(Font.font(18));
								TextField mtxtF333 = new TextField ();
								String z = String.valueOf(phaseTwo.mediaList.get(j).getNumOfCopies());
								mtxtF333.setDisable(true);
								mtxtF333.setText(z);
								mtxtF333.setFont(Font.font(18));
								TextField mtxtF444 = new TextField ();
								mtxtF444.setText(((Album)phaseTwo.mediaList.get(j)).getArtist());
								mtxtF444.setFont(Font.font(18));
								mtxtF444.setDisable(true);
								TextField mtxtF555 = new TextField ();
								mtxtF555.setText(((Album)phaseTwo.mediaList.get(j)).getSong());
								mtxtF555.setDisable(true);
								mtxtF555.setFont(Font.font(18));
								txtFs7.getChildren().addAll(mtxtF111,mtxtF222,mtxtF333,mtxtF444,mtxtF555);
								txtFs7.setSpacing(25);
								txtFs7.setAlignment(Pos.CENTER);
								searchmMenu.setCenter(txtFs7);

								HBox buttons7 = new HBox ();

								Button backBtn7 = new Button ("  Back", new ImageView (imageBack));
								backBtn7.setPrefHeight(90);
								backBtn7.setPrefWidth(250);
								backBtn7.setFont(Font.font(20));

								backBtn7.setOnAction( new EventHandler<ActionEvent>() {
									public void handle(ActionEvent arg0) {
										primaryStage.setScene(searchmScene)	;
										searchmMenu.setLeft(labels9);
										searchmMenu.setBottom(buttons9);
										searchmMenu.setCenter(txtFs9);
										mtxtF1S.clear();

									}
								});

								buttons7.getChildren().addAll(backBtn7);
								buttons7.setAlignment(Pos.TOP_CENTER);
								buttons7.setSpacing(100);
								buttons7.setPadding(new Insets(15,30,30,30));
								searchmMenu.setBottom(buttons7);

							}
					}
				}
			});

			backBtn9.setOnAction(e -> primaryStage.setScene(mediaScene));



			BorderPane updatemMenu = new BorderPane ();
			updatemMenu.setBackground(bground);
			Scene updatemScene = new Scene(updatemMenu, 1370, 710);

			updatem.setOnAction(e -> primaryStage.setScene(updatemScene));

			HBox hbboxx = new HBox ();
			Label select2 = new Label ("  Media Types:  ");
			select2.setFont(Font.font(22));
			hbboxx.setAlignment(Pos.CENTER);
			ComboBox <String> combobox2 = new ComboBox <> ();
			combobox2.setPromptText("Please select a media type to update");
			combobox2.setPadding(new Insets (15,2,10,15));
			combobox2.setStyle("-fx-font-size: 18;");
			//combobox2.setPrefWidth(80);
			//combobox2.setPrefHeight(20);
			ObservableList <String> mediaTypes2  = combobox2.getItems();

			mediaTypes2.add("Game");
			mediaTypes2.add("Movie");
			mediaTypes2.add("Album");
			hbboxx.getChildren().addAll(select2,combobox2);

			VBox forTitle9 = new VBox ();
			Label title9 = new Label ("Update Media Menu");
			title9.setFont(Font.font(35));
			forTitle9.getChildren().addAll(title9,hbboxx);
			forTitle9.setAlignment(Pos.CENTER);
			forTitle9.setPadding(new Insets (35,0,0,0));
			forTitle9.setSpacing(25);
			updatemMenu.setTop(forTitle9);

			combobox2.setOnAction( e -> {

				if (combobox2.getValue()=="Game") {
					VBox labels5 = new VBox ();
					labels5.setPadding(new Insets (28,9,9,50));
					Label mlabel1 = new Label ("Game Code:        ");
					mlabel1.setFont(Font.font(17));
					Label mlabel1New = new Label ("*New Game Code:        ");
					mlabel1New.setFont(Font.font(14));
					Label mlabel2 = new Label ("Game Title:       ");
					mlabel2.setFont(Font.font(17));
					Label mlabel2New = new Label ("*New Game Title:       ");
					mlabel2New.setFont(Font.font(14));
					Label mlabel3 = new Label ("Number Of Copies: ");
					mlabel3.setFont(Font.font(17));
					Label mlabel3New = new Label ("*New Number Of Copies: ");
					mlabel3New.setFont(Font.font(14));
					Label mlabel4 = new Label ("Game Weight:      ");
					mlabel4.setFont(Font.font(17));
					Label mlabel4New = new Label ("*New Game Weight:      ");
					mlabel4New.setFont(Font.font(14));
					labels5.getChildren().addAll(mlabel1,mlabel1New,mlabel2,mlabel2New,mlabel3,mlabel3New,mlabel4,mlabel4New);
					labels5.setAlignment(Pos.CENTER_LEFT);
					labels5.setSpacing(18);
					updatemMenu.setLeft(labels5);

					VBox txtFs5 = new VBox ();
					txtFs5.setPadding(new Insets (28,150,7,7));
					TextField mtxtF1 = new TextField ();
					mtxtF1.setDisable(false);
					mtxtF1.setFont(Font.font(16));
					TextField mtxtF1New = new TextField ();
					//mtxtF1.setDisable(false);
					mtxtF1New.setFont(Font.font(13));
					TextField mtxtF2 = new TextField ();
					mtxtF2.setFont(Font.font(16));
					TextField mtxtF2New = new TextField ();
					mtxtF2New.setFont(Font.font(13));
					TextField mtxtF3 = new TextField ();
					mtxtF3.setFont(Font.font(16));
					TextField mtxtF3New = new TextField ();
					mtxtF3New.setFont(Font.font(13));
					TextField mtxtF4 = new TextField ();
					mtxtF4.setFont(Font.font(16));
					TextField mtxtF4New = new TextField ();
					mtxtF4New.setFont(Font.font(13));
					txtFs5.getChildren().addAll(mtxtF1,mtxtF1New,mtxtF2,mtxtF2New,mtxtF3,mtxtF3New,mtxtF4,mtxtF4New);
					txtFs5.setSpacing(11);
					txtFs5.setAlignment(Pos.CENTER);

					updatemMenu.setCenter(txtFs5);

					HBox buttons5 = new HBox ();
					Button updateGame = new Button ("  Update \n   Game", new ImageView (updateCustomer));
					updateGame.setPrefHeight(90);
					updateGame.setPrefWidth(250);
					updateGame.setFont(Font.font(20));
					updateGame.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent arg0) {
							int x = Integer.parseInt(mtxtF3.getText());
							double y = Double.parseDouble(mtxtF4.getText());
							int x2 = Integer.parseInt(mtxtF3New.getText());
							double y2 = Double.parseDouble(mtxtF4New.getText());
							phaseTwo.updateGame(mtxtF1.getText(), mtxtF2.getText(), x, y, mtxtF1New.getText(), mtxtF2New.getText(), x2, y2);
							writeFile();
						}
					});

					Button backBtn5 = new Button ("  Back", new ImageView (imageBack));
					backBtn5.setPrefHeight(90);
					backBtn5.setPrefWidth(250);
					backBtn5.setFont(Font.font(20));

					backBtn5.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(mediaScene)	;
							mtxtF1.clear();
							mtxtF2.clear();
							mtxtF3.clear();
							mtxtF4.clear();
							mtxtF1New.clear();
							mtxtF2New.clear();
							mtxtF3New.clear();
							mtxtF4New.clear();
						}
					});

					buttons5.getChildren().addAll(updateGame,backBtn5);
					buttons5.setAlignment(Pos.TOP_CENTER);
					buttons5.setSpacing(100);
					buttons5.setPadding(new Insets(30,30,30,30));
					updatemMenu.setBottom(buttons5);

				}

				else if (combobox2.getValue()=="Movie") {
					VBox labels6 = new VBox ();
					labels6.setPadding(new Insets (28,9,9,50));
					Label mlabel11 = new Label ("Movie Code:       ");
					mlabel11.setFont(Font.font(17));
					Label mlabel11New = new Label ("*New Movie Code:       ");
					mlabel11New.setFont(Font.font(14));
					Label mlabel22 = new Label ("Movie Title:      ");
					mlabel22.setFont(Font.font(17));
					Label mlabel22New = new Label ("*New Movie Title:      ");
					mlabel22New.setFont(Font.font(14));
					Label mlabel33 = new Label ("Number Of Copies: ");
					mlabel33.setFont(Font.font(17));
					Label mlabel33New = new Label ("*New Number Of Copies: ");
					mlabel33New.setFont(Font.font(14));
					Label mlabel44 = new Label ("Movie Rating:     ");
					mlabel44.setFont(Font.font(17));
					Label mlabel44New = new Label ("*New Movie Rating:     ");
					mlabel44New.setFont(Font.font(14));
					labels6.getChildren().addAll(mlabel11,mlabel11New,mlabel22,mlabel22New,mlabel33,mlabel33New,mlabel44,mlabel44New);
					labels6.setAlignment(Pos.CENTER_LEFT);
					labels6.setSpacing(18);
					updatemMenu.setLeft(labels6);

					RadioButton dr = new RadioButton ("DR");
					dr.setFont(Font.font(17));
					dr.setPadding(new Insets (0,3,0,7));
					RadioButton hr = new RadioButton ("HR");
					hr.setFont(Font.font(17));
					hr.setPadding(new Insets (0,3,0,7));
					RadioButton ac = new RadioButton ("AC");
					ac.setFont(Font.font(17));
					ac.setPadding(new Insets (0,3,0,7));

					HBox hbox = new HBox();
					hbox.getChildren().addAll(dr,hr,ac);

					ToggleGroup tg = new ToggleGroup ();
					dr.setToggleGroup(tg);
					hr.setToggleGroup(tg);
					ac.setToggleGroup(tg);

					RadioButton drn = new RadioButton ("DR");
					drn.setFont(Font.font(14));
					drn.setPadding(new Insets (0,3,0,7));
					RadioButton hrn = new RadioButton ("HR");
					hrn.setFont(Font.font(14));
					hrn.setPadding(new Insets (0,3,0,7));
					RadioButton acn = new RadioButton ("AC");
					acn.setFont(Font.font(14));
					acn.setPadding(new Insets (0,3,0,7));

					HBox hboxn = new HBox();
					hboxn.getChildren().addAll(drn,hrn,acn);

					ToggleGroup tgn = new ToggleGroup ();
					drn.setToggleGroup(tgn);
					hrn.setToggleGroup(tgn);
					acn.setToggleGroup(tgn);
					VBox txtFs6 = new VBox ();
					txtFs6.setPadding(new Insets (28,150,7,7));
					TextField mtxtF11 = new TextField ();
					mtxtF11.setFont(Font.font(16));
					TextField mtxtF11New = new TextField ();
					mtxtF11New.setFont(Font.font(13));
					TextField mtxtF22 = new TextField ();
					mtxtF22.setFont(Font.font(16));
					TextField mtxtF22New = new TextField ();
					mtxtF22New.setFont(Font.font(13));
					TextField mtxtF33 = new TextField ();
					mtxtF33.setFont(Font.font(16));
					TextField mtxtF33New = new TextField();
					mtxtF33New.setFont(Font.font(13));
					txtFs6.getChildren().addAll(mtxtF11,mtxtF11New,mtxtF22,mtxtF22New,mtxtF33,mtxtF33New,hbox,hboxn);
					txtFs6.setSpacing(12);
					txtFs6.setAlignment(Pos.CENTER);
					updatemMenu.setCenter(txtFs6);
					HBox buttons6 = new HBox ();

					Button updateMovie = new Button ("  Update \n   Movie", new ImageView (updateCustomer));
					updateMovie.setPrefHeight(90);
					updateMovie.setPrefWidth(250);
					updateMovie.setFont(Font.font(20));

					updateMovie.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent arg0) {
							int x1 = Integer.parseInt(mtxtF33.getText());
							String selected5 = ((RadioButton)tg.getSelectedToggle()).getText();
							int x1n = Integer.parseInt(mtxtF33New.getText());
							String selected5n = ((RadioButton)tgn.getSelectedToggle()).getText();
							phaseTwo.updateMovie(mtxtF11.getText(), mtxtF22.getText(), x1, selected5, mtxtF11New.getText(), mtxtF22New.getText(), x1n, selected5n );
							writeFile();
						}
					});

					Button backBtn6 = new Button ("  Back", new ImageView (imageBack));
					backBtn6.setPrefHeight(90);
					backBtn6.setPrefWidth(250);
					backBtn6.setFont(Font.font(20));

					backBtn6.setOnAction( new EventHandler<ActionEvent>() {
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(mediaScene);
							mtxtF11.clear();
							mtxtF11New.clear();
							mtxtF22.clear();
							mtxtF22New.clear();
							mtxtF33.clear();
							mtxtF33New.clear();
							dr.setSelected(false);
							drn.setSelected(false);
							hr.setSelected(false);
							hrn.setSelected(false);
							ac.setSelected(false);
							acn.setSelected(false);

						}
					});


					buttons6.getChildren().addAll(updateMovie,backBtn6);
					buttons6.setAlignment(Pos.TOP_CENTER);
					buttons6.setSpacing(100);
					buttons6.setPadding(new Insets(30,30,30,30));
					updatemMenu.setBottom(buttons6);

				}

				else if (combobox2.getValue()=="Album") {



					VBox labels7 = new VBox ();
					labels7.setPadding(new Insets (20,9,9,50));
					Label mlabel111 = new Label ("Album Code:       ");
					mlabel111.setFont(Font.font(16));
					Label mlabel111New = new Label ("*New Album Code:       ");
					mlabel111New.setFont(Font.font(13));
					Label mlabel222 = new Label ("Album Title:      ");
					mlabel222.setFont(Font.font(16));
					Label mlabel222New = new Label ("*New Album Title:      ");
					mlabel222New.setFont(Font.font(13));
					Label mlabel333 = new Label ("Number Of Copies: ");
					mlabel333.setFont(Font.font(16));
					Label mlabel333New = new Label ("*New Number Of Copies: ");
					mlabel333New.setFont(Font.font(13));
					Label mlabel444 = new Label ("Artist:           ");
					mlabel444.setFont(Font.font(16));
					Label mlabel444New = new Label ("*New Artist:           ");
					mlabel444New.setFont(Font.font(13));
					Label mlabel555 = new Label ("Songs:            ");
					mlabel555.setFont(Font.font(16));
					Label mlabel555New = new Label ("*New Songs:            ");
					mlabel555New.setFont(Font.font(13));
					labels7.getChildren().addAll(mlabel111,mlabel111New,mlabel222,mlabel222New,mlabel333,mlabel333New,mlabel444,mlabel444New,mlabel555,mlabel555New);
					labels7.setAlignment(Pos.CENTER_LEFT);
					labels7.setSpacing(18);
					updatemMenu.setLeft(labels7);

					VBox txtFs7 = new VBox ();
					txtFs7.setPadding(new Insets (20,150,7,7));
					TextField mtxtF111 = new TextField ();
					mtxtF111.setFont(Font.font(16));
					TextField mtxtF111New = new TextField ();
					mtxtF111New.setFont(Font.font(13));
					TextField mtxtF222 = new TextField ();
					mtxtF222.setFont(Font.font(16));
					TextField mtxtF222New = new TextField ();
					mtxtF222New.setFont(Font.font(13));
					TextField mtxtF333 = new TextField ();
					mtxtF333.setFont(Font.font(16));
					TextField mtxtF333New = new TextField ();
					mtxtF333New.setFont(Font.font(13));
					TextField mtxtF444 = new TextField ();
					mtxtF444.setFont(Font.font(16));
					TextField mtxtF444New = new TextField ();
					mtxtF444New.setFont(Font.font(13));
					TextField mtxtF555 = new TextField ();
					mtxtF555.setFont(Font.font(16));
					TextField mtxtF555New = new TextField ();
					mtxtF555New.setFont(Font.font(13));
					txtFs7.getChildren().addAll(mtxtF111,mtxtF111New,mtxtF222,mtxtF222New,mtxtF333,mtxtF333New,mtxtF444,mtxtF444New,mtxtF555,mtxtF555New);
					txtFs7.setSpacing(11);
					txtFs7.setAlignment(Pos.CENTER);
					updatemMenu.setCenter(txtFs7);

					HBox buttons7 = new HBox ();
					Button updateAlbum = new Button ("  Update \n   Album", new ImageView (updateCustomer));
					updateAlbum.setPrefHeight(70);
					updateAlbum.setPrefWidth(250);
					updateAlbum.setFont(Font.font(18));

					updateAlbum.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent arg0) {
							int x2 = Integer.parseInt(mtxtF333.getText());
							int x2n = Integer.parseInt(mtxtF333New.getText());
							phaseTwo.updateAlbum(mtxtF111.getText(), mtxtF222.getText(), x2, mtxtF444.getText(),mtxtF555.getText(), mtxtF111New.getText(), mtxtF222New.getText(), x2n, mtxtF333New.getText(), mtxtF555New.getText());
							writeFile();
						}
					});

					Button backBtn7 = new Button ("  Back", new ImageView (imageBack));
					backBtn7.setPrefHeight(70);
					backBtn7.setPrefWidth(250);
					backBtn7.setFont(Font.font(18));

					backBtn7.setOnAction( new EventHandler<ActionEvent>() {
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(mediaScene);
							mtxtF111.clear();
							mtxtF111New.clear();
							mtxtF222.clear();
							mtxtF222New.clear();
							mtxtF333.clear();
							mtxtF333New.clear();
							mtxtF444.clear();
							mtxtF444New.clear();
							mtxtF555.clear();
							mtxtF555New.clear();

						}
					});

					buttons7.getChildren().addAll(updateAlbum,backBtn7);
					buttons7.setAlignment(Pos.TOP_CENTER);
					buttons7.setSpacing(100);
					buttons7.setPadding(new Insets(10,30,25,30));
					updatemMenu.setBottom(buttons7);

				}

			});


			BorderPane printmMenu = new BorderPane();
			printmMenu.setBackground(bground);
			Scene printmScene = new Scene(printmMenu, 1370, 710);

			printm.setOnAction(e -> primaryStage.setScene(printmScene));
			HBox forTitleP = new HBox ();
			Label titleP = new Label ("Print Media Information");
			titleP.setFont(Font.font(40));
			forTitleP.getChildren().add(titleP);
			forTitleP.setAlignment(Pos.CENTER);
			forTitleP.setPadding(new Insets (50,0,0,0));
			printmMenu.setTop(forTitleP);

			VBox labels10 = new VBox ();
			labels10.setPadding(new Insets (102,9,9,50));
			Label mlabel1P = new Label ("All Media Information:      ");
			mlabel1P.setFont(Font.font(22));
			labels10.getChildren().addAll(mlabel1P);
			labels10.setAlignment(Pos.TOP_CENTER);
			printmMenu.setLeft(labels10);

			VBox txtFs10 = new VBox ();
			txtFs10.setPadding(new Insets (100,150,7,7));
			TextArea mtxtF1P = new TextArea ();
			mtxtF1P.setDisable(true);
			mtxtF1P.setFont(Font.font(20));
			mtxtF1P.setPrefHeight(400);
			txtFs10.getChildren().add(mtxtF1P);
			txtFs10.setAlignment(Pos.CENTER);
			printmMenu.setCenter(txtFs10);

			HBox buttons10 = new HBox ();
			Image mimagePrint = new Image("print.png");
			Button backBtn10 = new Button ("  Back", new ImageView (imageBack));
			backBtn10.setPrefHeight(90);
			backBtn10.setPrefWidth(250);
			backBtn10.setFont(Font.font(20));
			Button printM = new Button ("  Print", new ImageView (mimagePrint));
			printM.setPrefHeight(90);
			printM.setPrefWidth(250);
			printM.setFont(Font.font(20));
			buttons10.getChildren().addAll(printM,backBtn10);
			buttons10.setAlignment(Pos.TOP_CENTER);
			buttons10.setSpacing(100);
			buttons10.setPadding(new Insets(30,30,30,30));
			printmMenu.setBottom(buttons10);
			backBtn10.setOnAction(e -> {
				primaryStage.setScene(mediaScene);
				mtxtF1P.clear();
			});

			printM.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					mtxtF1P.setText(phaseTwo.getAllMediaInfo());
				}
			});

			returnm.setOnAction(e -> primaryStage.setScene(scene));



			Scene rentScene = new Scene(root3, 1370, 710);
			rentBttn.setOnAction(e -> primaryStage.setScene(rentScene));

			VBox rentMenu = new VBox();
			Label title10 = new Label ("Rent Menu");
			title10.setFont(Font.font(50));
			title10.setPadding(new Insets (10,0,30,0));
			rentMenu.setAlignment(Pos.CENTER);
			rentMenu.setPadding(new Insets (20,30,10,0));
			Button rentForm = new Button ("Rent Form");
			rentForm.setPrefWidth(500);
			rentForm.setPrefHeight(60);
			rentForm.setFont(Font.font(25));
			Button printInterested = new Button ("Print the requested interested media in\n   the cart by give the id of customer");
			printInterested.setPrefWidth(500);
			printInterested.setPrefHeight(85);
			printInterested.setFont(Font.font(25));
			Button printRented = new Button ("Print the rented media in the cart by\n          give the id of customer");
			printRented.setPrefWidth(500);
			printRented.setPrefHeight(85);
			printRented.setFont(Font.font(25));
			Button returnRented = new Button ("Return Rented media by give the id of\n  customer and then return the media");
			returnRented.setPrefWidth(500);
			returnRented.setPrefHeight(85);
			returnRented.setFont(Font.font(25));
			Button returnr = new Button ("Return to main page");
			returnr.setPrefWidth(500);
			returnr.setPrefHeight(60);
			returnr.setFont(Font.font(25));
			rentMenu.setSpacing(20);
			rentMenu.getChildren().addAll(title10,rentForm,printInterested,printRented,returnRented,returnr);
			root3.setCenter(rentMenu);

			BorderPane rentFormMenu = new BorderPane();
			rentFormMenu.setBackground(bground);
			Scene rentFormScene = new Scene(rentFormMenu, 1370, 710);

			rentForm.setOnAction(e -> primaryStage.setScene(rentFormScene));
			HBox forTitle11 = new HBox ();
			Label title11 = new Label ("Rent Form");
			title11.setFont(Font.font(40));
			forTitle11.getChildren().add(title11);
			forTitle11.setAlignment(Pos.CENTER);
			forTitle11.setPadding(new Insets (50,0,0,0));
			rentFormMenu.setTop(forTitle11);

			VBox labels11 = new VBox ();
			labels11.setPadding(new Insets (60,9,9,50));
			Label rlabel1 = new Label ("Customer ID:      ");
			rlabel1.setFont(Font.font(20));
			Label rlabel2 = new Label ("Media Code:       ");
			rlabel2.setFont(Font.font(20));
			Label rlabel3 = new Label ("Rented Date:      ");
			rlabel3.setFont(Font.font(20));
			labels11.getChildren().addAll(rlabel1,rlabel2,rlabel3);
			labels11.setAlignment(Pos.CENTER_LEFT);
			labels11.setSpacing(150);
			rentFormMenu.setLeft(labels11);

			VBox txtFs11 = new VBox ();
			txtFs11.setPadding(new Insets (58,150,7,7));
			TextField rtxtF1 = new TextField ();
			rtxtF1.setFont(Font.font(20));
			rtxtF1.setPrefHeight(10);
			TextArea rtxtA2 = new TextArea ();
			rtxtA2.setFont(Font.font(20));
			rtxtA2.setDisable(true);
			rtxtA2.setPromptText("Enter the needed customer information; name, address, mobile, etc ... ");
			rtxtA2.setPrefHeight(250);
			TextField rtxtF3 = new TextField ();
			rtxtF3.setFont(Font.font(20));
			rtxtF3.setDisable(true);
			rtxtF3.setPrefHeight(10);
			TextArea rtxtA4 = new TextArea ();
			rtxtA4.setFont(Font.font(20));
			rtxtA4.setDisable(true);
			rtxtA4.setPrefHeight(260);
			rtxtA4.setPromptText("Enter the media information needed; (whether its movie, albub or game), title, number of copies, etc ..." );
			TextField rtxtF5 = new TextField ();
			rtxtF5.setFont(Font.font(20));
			LocalDate date = LocalDate.now();
			rtxtF5.setText(date.toString());
			rtxtF5.setDisable(true);
			rtxtF5.setPrefHeight(10);
			txtFs11.getChildren().addAll(rtxtF1,rtxtA2,rtxtF3,rtxtA4,rtxtF5);
			txtFs11.setSpacing(10);
			txtFs2.setAlignment(Pos.CENTER);
			rtxtF1.setOnKeyTyped(e->{
				rtxtA2.setDisable(false);	
			});
			rtxtA2.setOnKeyTyped(e->{
				rtxtF3.setDisable(false);	
			});
			rtxtF3.setOnKeyTyped(e->{
				rtxtA4.setDisable(false);	
			});

			rentFormMenu.setCenter(txtFs11);

			HBox buttons11 = new HBox ();
			Image addToCart = new Image("cart.png");
			Image proccessCart = new Image("checkout.png");
			Button backBtn11 = new Button ("  Back", new ImageView (imageBack));
			backBtn11.setPrefHeight(90);
			backBtn11.setPrefWidth(250);
			backBtn11.setFont(Font.font(20));
			Button addcart = new Button ("  Add To Cart", new ImageView (addToCart));
			addcart.setPrefHeight(90);
			addcart.setPrefWidth(250);
			addcart.setFont(Font.font(20));
			Button procart = new Button ("  Proccess Cart", new ImageView (proccessCart));
			procart.setPrefHeight(90);
			procart.setPrefWidth(250);
			procart.setFont(Font.font(20));

			buttons11.getChildren().addAll(addcart,procart,backBtn11);
			buttons11.setAlignment(Pos.TOP_CENTER);
			buttons11.setSpacing(60);
			buttons11.setPadding(new Insets(10,30,30,30));
			rentFormMenu.setBottom(buttons11);

			addcart.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					phaseTwo.addToCart(rtxtF1.getText(), rtxtF3.getText());
					writeFile();
				}
			});

			procart.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					phaseTwo.processRequests();
					writeFile();
				}
			});

			backBtn11.setOnAction(e -> {
				primaryStage.setScene(rentScene);
				rtxtF1.clear();
				rtxtF3.clear();
				rtxtA2.clear();
				rtxtA4.clear();
		
			});

			BorderPane interstedMenu = new BorderPane();
			interstedMenu.setBackground(bground);
			Scene interstedScene = new Scene(interstedMenu, 1370, 710);

			printInterested.setOnAction(e -> primaryStage.setScene(interstedScene));
			HBox forTitle12 = new HBox ();
			Label title12 = new Label ("Interested Cart For A Customer");
			title12.setFont(Font.font(40));
			forTitle12.getChildren().add(title12);
			forTitle12.setAlignment(Pos.CENTER);
			forTitle12.setPadding(new Insets (50,0,0,0));
			interstedMenu.setTop(forTitle12);

			VBox labels12 = new VBox ();
			labels12.setPadding(new Insets (0,9,175,50));
			Label rlabel11 = new Label ("Customer ID:      ");
			rlabel11.setFont(Font.font(20));
			Label rlabel22 = new Label ("Intersted Cart:      ");
			rlabel22.setFont(Font.font(20));
			labels12.getChildren().addAll(rlabel11,rlabel22);
			labels12.setAlignment(Pos.CENTER_LEFT);
			labels12.setSpacing(35);
			interstedMenu.setLeft(labels12);

			VBox txtFs12 = new VBox ();
			txtFs12.setPadding(new Insets (60,150,7,7));
			TextField rtxtF11 = new TextField ();
			rtxtF11.setFont(Font.font(20));
			rtxtF11.setPrefHeight(10);
			TextArea rtxtA22 = new TextArea ();
			rtxtA22.setFont(Font.font(20));
			rtxtA22.setDisable(true);
			rtxtA22.setPrefHeight(250);
			txtFs12.getChildren().addAll(rtxtF11,rtxtA22);
			txtFs12.setSpacing(20);
			txtFs12.setAlignment(Pos.CENTER);

			interstedMenu.setCenter(txtFs12);

			HBox buttons12 = new HBox ();
			Image print1 = new Image("print.png");
			Button backBtn12 = new Button ("  Back", new ImageView (imageBack));
			backBtn12.setPrefHeight(90);
			backBtn12.setPrefWidth(250);
			backBtn12.setFont(Font.font(20));
			Button printint = new Button ("        Print\n Interested Cart", new ImageView (print1));
			printint.setPrefHeight(90);
			printint.setPrefWidth(250);
			printint.setFont(Font.font(20));
			buttons12.getChildren().addAll(printint,backBtn12);
			buttons12.setAlignment(Pos.TOP_CENTER);
			buttons12.setSpacing(100);
			buttons12.setPadding(new Insets(10,30,30,30));
			interstedMenu.setBottom(buttons12);

			printint.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {

					rtxtA22.setText(phaseTwo.printIntersted(rtxtF11.getText()));
					writeFile();
				}

			});
			backBtn12.setOnAction(e -> {
				primaryStage.setScene(rentScene);
				rtxtF11.clear();
				rtxtA22.clear();
			});

			BorderPane rentedMenu = new BorderPane();
			rentedMenu.setBackground(bground);
			Scene rentedScene = new Scene(rentedMenu, 1370, 710);

			printRented.setOnAction(e -> primaryStage.setScene(rentedScene));
			HBox forTitle13 = new HBox ();
			Label title13 = new Label ("Rented Cart For A Customer");
			title13.setFont(Font.font(40));
			forTitle13.getChildren().add(title13);
			forTitle13.setAlignment(Pos.CENTER);
			forTitle13.setPadding(new Insets (50,0,0,0));
			rentedMenu.setTop(forTitle13);

			VBox labels13 = new VBox ();
			labels13.setPadding(new Insets (0,9,175,50));
			Label rlabel111 = new Label ("Customer ID:      ");
			rlabel111.setFont(Font.font(20));
			Label rlabel222 = new Label ("Rented Cart:      ");
			rlabel222.setFont(Font.font(20));
			labels13.getChildren().addAll(rlabel111,rlabel222);
			labels13.setAlignment(Pos.CENTER_LEFT);
			labels13.setSpacing(35);
			rentedMenu.setLeft(labels13);

			VBox txtFs13 = new VBox ();
			txtFs13.setPadding(new Insets (60,150,7,7));
			TextField rtxtF111 = new TextField ();
			rtxtF111.setFont(Font.font(20));
			rtxtF111.setPrefHeight(10);
			TextArea rtxtA222 = new TextArea ();
			rtxtA222.setFont(Font.font(20));
			rtxtA222.setDisable(true);
			rtxtA222.setPrefHeight(250);
			txtFs13.getChildren().addAll(rtxtF111,rtxtA222);
			txtFs13.setSpacing(20);
			txtFs13.setAlignment(Pos.CENTER);

			rentedMenu.setCenter(txtFs13);

			HBox buttons13 = new HBox ();
			Button backBtn13 = new Button ("  Back", new ImageView (imageBack));
			backBtn13.setPrefHeight(90);
			backBtn13.setPrefWidth(250);
			backBtn13.setFont(Font.font(20));
			Button printrent = new Button ("       Print\n  Rented Cart", new ImageView (print1));
			printrent.setPrefHeight(90);
			printrent.setPrefWidth(250);
			printrent.setFont(Font.font(20));
			buttons13.getChildren().addAll(printrent,backBtn13);
			buttons13.setAlignment(Pos.TOP_CENTER);
			buttons13.setSpacing(100);
			buttons13.setPadding(new Insets(10,30,30,30));
			rentedMenu.setBottom(buttons13);

			backBtn13.setOnAction(e ->{ 
				primaryStage.setScene(rentScene);
				rtxtA222.clear();
				rtxtF111.clear();
			});

			printrent.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					rtxtA222.setText(phaseTwo.printRented(rtxtF111.getText()));
					writeFile();
				}

			});

			BorderPane returnMenu = new BorderPane();
			returnMenu.setBackground(bground);
			Scene returnScene = new Scene(returnMenu, 1370, 710);

			returnRented.setOnAction(e -> primaryStage.setScene(returnScene));
			HBox forTitle14 = new HBox ();
			Label title14 = new Label ("Return Media Menu");
			title14.setFont(Font.font(40));
			forTitle14.getChildren().add(title14);
			forTitle14.setAlignment(Pos.CENTER);
			forTitle14.setPadding(new Insets (50,0,0,0));
			returnMenu.setTop(forTitle14);

			VBox labels14 = new VBox ();
			labels14.setPadding(new Insets (102,9,9,50));
			Label rlabel1111 = new Label ("Customer ID:      ");
			rlabel1111.setFont(Font.font(20));
			Label rlabel2222 = new Label ("Media Code:      ");
			rlabel2222.setFont(Font.font(20));
			labels14.getChildren().addAll(rlabel1111,rlabel2222);
			labels14.setAlignment(Pos.CENTER);
			labels14.setSpacing(35);
			returnMenu.setLeft(labels14);

			VBox txtFs14 = new VBox ();
			txtFs14.setPadding(new Insets (100,150,7,7));
			TextField rtxtF1111 = new TextField ();
			rtxtF1111.setFont(Font.font(20));
			rtxtF1111.setPrefHeight(10);
			TextField rtxtF2222 = new TextField ();
			rtxtF2222.setFont(Font.font(20));
			rtxtF2222.setPrefHeight(10);
			rtxtF2222.setDisable(true);
			txtFs14.getChildren().addAll(rtxtF1111,rtxtF2222);
			txtFs14.setSpacing(20);
			txtFs14.setAlignment(Pos.CENTER);
			rtxtF1111.setOnKeyTyped(e->{
				rtxtF2222.setDisable(false);	
			});

			returnMenu.setCenter(txtFs14);

			Image returnCart = new Image("return.png");
			HBox buttons14 = new HBox ();
			Button backBtn14 = new Button ("  Back", new ImageView (imageBack));
			backBtn14.setPrefHeight(90);
			backBtn14.setPrefWidth(250);
			backBtn14.setFont(Font.font(20));
			Button returncart = new Button ("  Return Cart", new ImageView (returnCart));
			returncart.setPrefHeight(90);
			returncart.setPrefWidth(250);
			returncart.setFont(Font.font(20));
			buttons14.getChildren().addAll(returncart,backBtn14);
			buttons14.setAlignment(Pos.TOP_CENTER);
			buttons14.setSpacing(100);
			buttons14.setPadding(new Insets(10,30,30,30));
			returnMenu.setBottom(buttons14);
			backBtn14.setOnAction(e -> {
				primaryStage.setScene(rentScene);
				rtxtF1111.clear();
				rtxtF2222.clear();
			});

			returncart.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					phaseTwo.returnMedia(rtxtF1111.getText(), rtxtF2222.getText());
					writeFile();
				}

			});

			returnr.setOnAction(e -> primaryStage.setScene(scene));

			//END ACTIONS

			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setMaximized(true);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void readFiles() {
		
		File customerFile = new File ("Customers.txt");
		File mediaFile = new File ("Media.txt");
		File rentedFile = new File ("Rented.txt");
		File interstedFile = new File ("Intersted.txt");

		try {
			
			Scanner input = new Scanner (customerFile);
			while (input.hasNextLine()) {
				String str=input.nextLine();
				String [] str2 = str.split(",");
				phaseTwo.addCustomer(str2[0], str2[1], str2[2],str2[3],str2[4]);
				String s1 = str2[5].toString();
				phaseTwo.setLimitedPlanLimit(Integer.parseInt(s1));
				input.close();
			}	

		}
		
		catch (Exception e) {
			System.out.println("File not found.");
		}


		try {
			Scanner input = new Scanner (mediaFile);
			String s1= "", s2="", s3="";
			while (input.hasNextLine()) {
				String str = input.nextLine();
				String [] str2 = str.split(",");
				if (str2[0].equalsIgnoreCase("Game")) {
					s1 = str2[3].toString();
					s2 = str2[4].toString();
					phaseTwo.addGame(str2[1], str2[2], Integer.parseInt(s1), Double.parseDouble(s2));
				}
				if (str2[0].equalsIgnoreCase("Movie"))
					phaseTwo.addMovie(str2[1], str2[2], Integer.parseInt(s1), str2[4]);
				if (str2[0].equalsIgnoreCase("Album"))
					phaseTwo.addAlbum(str2[1], str2[2], Integer.parseInt(s1), str2[4], str2[5]);
				input.close();
			}
		}
		catch (Exception e) {
			System.out.println("File not found.");
		}

		try {
			Scanner input = new Scanner (rentedFile);
			while (input.hasNextLine()) {
				String str = input.nextLine();
				String [] str2 = str.split(",");
				phaseTwo.processRequests();
				input.close();
			}
		}
		catch (Exception e) {
			System.out.println("File not found.");
		}
		try {
			Scanner input = new Scanner (interstedFile);
			while (input.hasNextLine()) {
				String str = input.nextLine();
				String [] str2 = str.split(",");
				phaseTwo.addToCart(str2[0], str2[1]);
				input.close();
			}
		}
		catch (Exception e) {
			System.out.println("File not found.");
		}
	}

	private void writeFile() {
		PrintWriter output = null;
		try {
			output = new PrintWriter("Customers.txt");
			for (int j = 0; j < phaseTwo.customerList.size(); j++) {
				output.println(phaseTwo.customerList.get(j).toString());
			}
			output.close();				

		} catch (FileNotFoundException e) {
			System.out.println(e+ "File Customers.txt is not found. ");
		}
		try {
			output = new PrintWriter("Media.txt");
			for (int j = 0; j < phaseTwo.mediaList.size(); j++) {
				output.println(phaseTwo.mediaList.get(j).toString());
			}
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println(e+ "File Media.txt is not found. ");
		}
		try {
			output = new PrintWriter("Interested.txt");
			for (int j = 0; j < phaseTwo.customerList.size(); j++) {
				output.println(phaseTwo.customerList.get(j).getName() +"  "+ phaseTwo.customerList.get(j).getInterested());
			}
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println(e+ "File Interested.txt is not found. ");
		}
		try {
			output = new PrintWriter("Rented.txt");
			for (int j = 0; j < phaseTwo.customerList.size(); j++) {
				output.println(phaseTwo.customerList.get(j).getName() +"  "+ phaseTwo.customerList.get(j).getRented());
			}
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println( e+ "File Rented.txt is not found. ");
		}
	}

}

    
