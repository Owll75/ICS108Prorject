package project;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class MainClass extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		//The main pane
		BorderPane mainPane = new BorderPane();
		
		//Creating Text object for first message
		Text firstMessage = new Text("Registration System");
		firstMessage.setFont(new Font("Times New Roman",80));		
		mainPane.setCenter(firstMessage);
		
		//Creating an HBox for the buttons
		HBox buttonPane = new HBox();
		
		//Creating 3 button objects
		Button viewCourse = new Button("View course");
		buttonPane.getChildren().add(viewCourse);
		HBox.setMargin(viewCourse, new Insets(15,15,15,15));
		
		Button studentDetails = new Button("View student details");
		buttonPane.getChildren().add(studentDetails);
		HBox.setMargin(studentDetails, new Insets(15,15,15,15));
		
		Button save = new Button("Save");
		buttonPane.getChildren().add(save);
		HBox.setMargin(save, new Insets(15,15,15,15));
		
		buttonPane.setAlignment(Pos.CENTER);
		
		//adding the HBox to the main pane
		mainPane.setBottom(buttonPane);
		
	
		
		//creating a scene
		Scene scene = new Scene(mainPane,1280,720);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//creating a pane for courses
		BorderPane coursePane = new BorderPane();
		
		//Creating a ListView for courses
		ListView<String> coursesList = new ListView<>(FXCollections.observableArrayList(TestClass.getCourseNames()));
		coursesList.setPrefSize(200, 700);
		coursePane.setLeft(new ScrollPane(coursesList));
		
		//creating texts and labels to view course info.
		GridPane centerNode = new GridPane();
		
		Label idLabel = new Label("ID: ");
		TextField idTextField = new TextField();
		coursePane.setCenter(idTextField);		 idTextField.setPrefWidth(300);
		centerNode.add(idLabel, 0, 0);
		centerNode.add(idTextField, 1, 0);
		
		Label nameLabel = new Label("Name: ");
		TextField nameTextField = new TextField();	nameTextField.setEditable(false);
		centerNode.add(nameLabel, 0, 1);
		centerNode.add(nameTextField, 1, 1);
		
		Label daysLabel = new Label("Days: ");
		TextField daysTextField = new TextField();  daysTextField.setEditable(false);
		centerNode.add(daysLabel, 0, 2);
		centerNode.add(daysTextField, 1, 2);
		
		Label locationLabel = new Label("Location: ");
		TextField locationTextField = new TextField(); locationTextField.setEditable(false);
		centerNode.add(locationLabel, 0, 3);
		centerNode.add(locationTextField, 1, 3);
		
		Label timeLabel = new Label("Time: ");
		TextField timeTextField = new TextField(); timeTextField.setEditable(false);
		centerNode.add(timeLabel, 0, 4);
		centerNode.add(timeTextField, 1, 4);
		
		Label courseStatus = new Label("Status: ");
		TextField courseStatusText = new TextField(); courseStatusText.setEditable(false);
		centerNode.add(courseStatus, 0, 5);
		centerNode.add(courseStatusText, 1, 5);
		
		centerNode.setAlignment(Pos.CENTER);
		centerNode.setVgap(10);
		coursePane.setCenter(centerNode);
		BorderPane.setAlignment(centerNode,Pos.CENTER);
		
		//creating a list view for students registered in the chosen course.
	
		coursesList.getSelectionModel().selectedItemProperty().addListener(e -> 
		idList(coursesList.getSelectionModel().getSelectedItem(),idTextField,nameTextField,daysTextField,locationTextField,timeTextField,courseStatusText,coursesList,coursePane));

		// HBox for the buttons in Course pane
		HBox courseBox = new HBox();
		Button back = new Button("Back");
		courseBox.getChildren().add(back);
		
		Button previous = new Button("< Previous");
		courseBox.getChildren().add(previous);
		
		Button next = new Button("Next >");
		courseBox.getChildren().add(next);
		
		Button search = new Button("Search");
		courseBox.getChildren().add(search);

		courseBox.setAlignment(Pos.CENTER);
		courseBox.setSpacing(10); coursePane.setBottom(courseBox);
		
		//Setting actions for the buttons
		back.setOnAction(e -> primaryStage.setScene(scene));
		previous.setOnAction(e -> coursesList.getSelectionModel().selectPrevious());
		next.setOnAction(e -> coursesList.getSelectionModel().selectNext());
		search.setOnAction(e -> {
			String enteredID = idTextField.getText();
			idList(enteredID,idTextField,nameTextField,daysTextField,locationTextField,timeTextField,courseStatusText,coursesList,coursePane);

			
		});
		
		
		//creating a scene for Courses
		Scene scene2 = new Scene(coursePane,1280,720);
		
		//Going to courses Pane when viewCourse Button is clicked
		viewCourse.setOnAction(e -> primaryStage.setScene(scene2));

		//Hassan code
		
		//creating a scene for Courses
				int  currentStudent = 1;
				BorderPane studentPane = new BorderPane();
				
				Scene scene4 = new Scene(studentPane,870,620);
				//Going to courses Pane when viewCourse Button is clicked
				studentDetails.setOnAction(e -> primaryStage.setScene(scene4));
				
				
				//Creating an HBox for the buttons sPane
				HBox sPane = new HBox();
				Button backButton = new Button("Back");
				HBox.setMargin(backButton, new Insets(5,5,5,5));
				backButton.setOnAction(e -> primaryStage.setScene(scene));
				
				Button previousButton = new Button("<Previous");
				HBox.setMargin(previousButton, new Insets(5,5,5,5));
				
				//creating buttons
				Button nextButton = new Button("Next>");
				HBox.setMargin(nextButton, new Insets(5,5,5,5));
				
				Button registerButton = new Button("Register");
				HBox.setMargin(registerButton, new Insets(5,5,5,5));
				
				Button dropButton = new Button("Drop");
				HBox.setMargin(dropButton, new Insets(5,5,5,5));
				
				Button searchButton = new Button("Search");
				HBox.setMargin(searchButton, new Insets(5,5,5,5));
				
				sPane.getChildren().addAll(backButton,previousButton,nextButton,registerButton,dropButton,searchButton);
				sPane.setAlignment(Pos.CENTER);
				
				//adding the HBox to the student pane
				studentPane.setBottom(sPane);
				
				//Creating an VBox for the Text tPane
				VBox tPane = new VBox();
						
				//Creating the text 
				Text studentId = new Text("Student ID:");
				studentId.setFont(new Font("Times New Roman",16));
				VBox.setMargin(studentId, new Insets(40,25,25,25));
				Text registeredCourses = new Text("registered courses:");
				registeredCourses.setFont(new Font("Times New Roman",16));
				VBox.setMargin(registeredCourses, new Insets(40,25,25,25));
				Text notRegisteredCourses = new Text("not registered courses:");
				notRegisteredCourses.setFont(new Font("Times New Roman",16));
				VBox.setMargin(notRegisteredCourses, new Insets(230,25,25,25));
				
				//add them to the VBox to student pane 
				tPane.getChildren().addAll(studentId,registeredCourses,notRegisteredCourses);
				
				studentPane.setLeft(tPane);
				
				
				//Creating an VBox for the items vPane
				VBox vPane = new VBox();
				
				TextField studentIDTextField = new TextField( );
				VBox.setMargin(studentIDTextField, new Insets(40,25,25,25));
				
				ListView<Course> coursesRegistered = new ListView<>();
				coursesRegistered.setPrefSize(200, 200);
				VBox.setMargin(coursesRegistered, new Insets(40,25,25,25));
				
				ComboBox<Course> notRegCourses = new ComboBox<> ();
				notRegCourses.setPrefSize(700, 25);
				
				VBox.setMargin(notRegCourses, new Insets(40,25,25,25));
				
				//add them to the VBox to student pane 
				vPane.getChildren().addAll(studentIDTextField,coursesRegistered,notRegCourses);
				studentPane.setCenter(vPane);       
				
				AtomicInteger  selectedStudent = new AtomicInteger(1);
				
				
				getCourseNames(selectedStudent.get(),studentIDTextField,coursesRegistered,notRegCourses);
				
				nextButton.setOnAction(e -> {
					 
					coursesRegistered.getItems().clear();
					if (selectedStudent.get() < TestClass.getStudents().size())
					getCourseNames(selectedStudent.incrementAndGet(),studentIDTextField,coursesRegistered,notRegCourses);
					
					else
						getCourseNames(TestClass.getStudents().size()-1,studentIDTextField,coursesRegistered,notRegCourses);
				});
				
				previousButton.setOnAction(e ->{
					coursesRegistered.getItems().clear();
					if(selectedStudent.get() > 0)
					getCourseNames(selectedStudent.decrementAndGet(),studentIDTextField,coursesRegistered,notRegCourses);
					else
						getCourseNames(0,studentIDTextField,coursesRegistered,notRegCourses);
					
				});
				

				registerButton.setOnAction(e -> {
//					Student selectedObj = null;
//					Course selected = notRegCourses.getSelectionModel().getSelectedItem();
//					coursesRegistered.getItems().add(selected);
					int i = notRegCourses.getSelectionModel().getSelectedIndex();
					coursesRegistered.getItems().add(notRegCourses.getSelectionModel().getSelectedItem());
					CommonClass.studentList.get(selectedStudent.get()).getCourses().add(CommonClass.courseList.get(i));
					CommonClass.courseList.get(i).register();
				});
				
				dropButton.setOnAction(e -> {
//					Course selected = coursesRegistered.getSelectionModel().getSelectedItem();
//					coursesRegistered.getItems().remove(selected);

					int ii = coursesRegistered.getSelectionModel().getSelectedIndex();
					coursesRegistered.getItems().remove(coursesRegistered.getSelectionModel().getSelectedItem());
					CommonClass.studentList.get(selectedStudent.get()).getCourses().remove(ii);
					CommonClass.courseList.get(ii).drop();
					
				});
				
				searchButton.setOnAction(e -> {
					String enteredSutudentID = studentIDTextField.getText();
					coursesRegistered.getItems().clear();
					ArrayList<Student> studentsList = TestClass.getStudents();
					int index = 0;
					for(int i=0; i<studentsList.size();i++) {
						if(studentsList.get(i).getStudID().equals(enteredSutudentID)) {
							break;
						}
						else {
							index++;
						}
					}
					getCourseNames(index,studentIDTextField,coursesRegistered,notRegCourses);
				});
				
				save.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

		            @Override
		            public void handle(ActionEvent g) {
		            	TestClass.save() ;
		            }
		        });
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//defining a method to give course details.
	public static void idList(String selectedItem, TextField id, TextField name, TextField days, TextField location,
 TextField time,TextField status, ListView<String> courses, BorderPane Pane) {
		id.setText(selectedItem);
		for(Course e1: TestClass.getCourses()) {
			if(e1.getCourseID().equals(selectedItem)) {
				name.setText(e1.getCourseName());
				days.setText(e1.getCourseDays());
				location.setText(e1.getCourseLocation());
				time.setText(e1.getCourseTime());
				if(e1.getAvailableSeats() == 0) {
					status.setText("Closed");
				}
				else status.setText("Open");
				
				ArrayList<String> registeredStu = new ArrayList<>();
				for(Student e2: TestClass.getStudents()) {
					for(Course e3:e2.getCourses()) {
						if(e3.getCourseID().equals(selectedItem)) {
							registeredStu.add(e2.getStudID());							}
						
					}
				}
					
				ListView<String> idsList = new ListView<>();
				courses.setPrefSize(200, 900);
				Label numOfStu = new Label("Select a course");
				VBox rVbox = new VBox();
				rVbox.getChildren().addAll(numOfStu,idsList);
				Pane.setRight(rVbox);
				idsList.getItems().addAll(registeredStu);
				numOfStu.setText("There are "+registeredStu.size()+" registered in this course.");
				break;
				}
		}
		if(!TestClass.getCourseNames().contains(selectedItem)) {
			id.setText(selectedItem + " is not a valid course!");
			name.clear(); days.clear(); location.clear(); time.clear(); status.clear(); 
			Pane.setRight(null);
			
		}
	}
	
	

	//defining a method to get registered courses for each student

	public static void getCourseNames(int index, TextField studentIDTextField, ListView<Course> coursesRegistered, ComboBox<Course> notRegCourses){
		ArrayList<Student> studentsList = TestClass.getStudents();
		studentIDTextField.setText(studentsList.get(index).getStudID());
		coursesRegistered.getItems().addAll(studentsList.get(index).getCourses());
		ArrayList<Course> notRegistered = new ArrayList<>();
		for(Course e : TestClass.getCourses()) {
			if (!studentsList.get(index).getCourses().contains(e)) {
				notRegistered.add(e);
			}
		}
		notRegCourses.getItems().addAll(notRegistered);
	}


	
	
}