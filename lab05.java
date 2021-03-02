import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class lab05 extends Application 
{
	
	public class StudentRecord
	{
		private String id;
		private float assignments;
		private float midterm;
		private float finalExam;
		private float finalMark;
		private String letterGrade;
		
		public StudentRecord(String id, float assignment, float midterm, float finalExam)
		{
			this.id = id;
			this.assignments = assignment;
			this.midterm = midterm;
			this.finalExam = finalExam;
			
			this.finalMark = (this.assignments * 0.2f) + (this.midterm * 0.3f) + (this.finalExam * 0.5f);
			
			if (this.finalMark >= 80)
			{
				this.letterGrade = "A";
			}
			else if (this.finalMark >= 70)
			{
				this.letterGrade = "B";
			}
			else if (this.finalMark >= 60)
			{
				this.letterGrade = "C";
			}
			else if (this.finalMark >= 50)
			{
				this.letterGrade = "D";
			}
			else
			{
				this.letterGrade = "F";
			}
		}
		
		public String getId() {
			return id;
		}
		
		public float getAssignments() {
			return assignments;
		}
		
		public float getMidterm() {
			return midterm;
		}
		
		public float getFinalExam() {
			return finalExam;
		}
		
		public float getFinalMark() {
			return finalMark;
		}
		
		public String() getLetterGrade() {
			return letterGrade;
		}
	}
	
	public class DataSource 
	{
		public ObservableList<StudentRecord> getAllMarks()
		{
			ObservableList<StudentRecord> marks = FXCollections.observableArrayList();
			// Student ID, Assignments, Midterm, Final exam
			marks.add(new StudentRecord("100100100", 75.0f, 68.0f,54.25f));
			marks.add(new StudentRecord("100100101",70.0f,69.25f, 51.5f));
			marks.add(new StudentRecord("100100102",100.0f, 97.0f, 92.5f));
			marks.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
			marks.add(new StudentRecord("100100104", 72.25f, 74.75f,58.25f));
			marks.add(new StudentRecord("100100105", 85.0f, 56.0f,62.5f));
			marks.add(new StudentRecord("100100106",70.0f,66.5f, 61.75f));
			marks.add(new StudentRecord("100100107",55.0f, 47.0f, 50.5f));
			marks.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
			marks.add(new StudentRecord("100100109", 82.5f, 77.0f,74.25f));
			return marks;
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Lab 05 Solution");
		
		TableView view = new TableView();
		
		TableColumn<StudentRecord, String> column1 = new TableColumn<>("Student ID");
		column1.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<StudentRecord, String> column2 = new TableColumn<>("Assignment Grade");
		column2.setCellValueFactory(new PropertyValueFactory<>("assignments"));
		
		TableColumn<StudentRecord, String> column3 = new TableColumn<>("Midterm Grade");
		column3.setCellValueFactory(new PropertyValueFactory<>("midterm"));
		
		TableColumn<StudentRecord, String> column4 = new TableColumn<>("Final Exam Grade");
		column4.setCellValueFactory(new PropertyValueFactory<>("finalExam"));
		
		TableColumn<StudentRecord, String> column5 = new TableColumn<>("Final Mark");
		column5.setCellValueFactory(new PropertyValueFactory<>("finalMark"));
		
		TableColumn<StudentRecord, String> column6 = new TableColumn<>("Letter Grade");
		column6.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));
		
		view.getColumns().add(column1);
		view.getColumns().add(column2);
		view.getColumns().add(column3);
		view.getColumns().add(column4);
		view.getColumns().add(column5);
		view.getColumns().add(column6);
		
		for (StudentRecord s : new DataSource().getAllMarks())
		{
			view.getItems().add(s);
		}
		
		VBox vbox = new VBox(view);
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
