import Models.Task;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TasksWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //GLOBAL DEFINITIONS
        List<Task> tasksList = new ArrayList<>();
        int tasksIdCounter = 0;

        //STAGE
        primaryStage.setTitle("To-do List"); // names the stage (like file name)
        Pane layout = new Pane(); // Pane allows exact positioning

        // SCENE
        layout.setStyle("-fx-background-color: #FFE6F3;"); // background color of the window
        Scene scene = new Scene(layout, 1200, 800);
        scene.setFill(Color.web("#FFE6F3"));
        primaryStage.setScene(scene);
        primaryStage.show();

        //DETAILS
        Line dividerLine = new Line(800, 0, 800, 800);
        dividerLine.setStroke(Color.web("#CC96AF"));
        dividerLine.setStrokeWidth(3);

        //BUTTONS
        Button createNewTask = new Button("Add task");
        createNewTask.setBackground(Background.fill(Color.web("#74445E")));
        createNewTask.setTextFill(Color.web("#FFFBFD"));
        createNewTask.setPrefWidth(70);
        createNewTask.setPrefHeight(30);
        createNewTask.setLayoutX(1050);
        createNewTask.setLayoutY(200);

        TextField taskTitle = new TextField("Today's task is...");
        taskTitle.setPrefWidth(200);
        taskTitle.setPrefHeight(30);
        taskTitle.setLayoutX(850);
        taskTitle.setLayoutY(200);

        /*Button taskDoneButton = new Button();
        taskDoneButton.setPrefWidth(15);
        taskDoneButton.setPrefHeight(15);
        taskDoneButton.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: #74445E;" +
                        "-fx-padding: 0;" +
                        "-fx-background-insets: 0;" +
                        "-fx-border-insets: 0;"
        );
        taskDoneButton.setLayoutX(50);
        taskDoneButton.setLayoutY(200);*/

        //RECTANGLES
        Rectangle newTaskRectangle = new Rectangle(800, 0, 400, 100);
        newTaskRectangle.setFill(Color.web("#CC96AF"));
        newTaskRectangle.setStroke(Color.web("#CC96AF")); // outline color
        newTaskRectangle.setStrokeWidth(3); // thickness

        //TEXTS
        Text newTaskRectangleText = new Text(50, 30, "Create new task");
        newTaskRectangleText.setFill(Color.web("#272727"));
        newTaskRectangleText.setFont(Font.font("Courier New", 22));
        newTaskRectangleText.setLayoutX(850);
        newTaskRectangleText.setLayoutY(25);

        Label titleLabel = new Label("Title");
        titleLabel.setFont(Font.font("Courier New", 16));
        titleLabel.setTextFill(Color.web("#74445E"));
        titleLabel.setLabelFor(taskTitle);
        titleLabel.setLayoutX(850);
        titleLabel.setLayoutY(180);

        Text listOfTasksText = new Text(50, 30, "List of tasks");
        listOfTasksText.setFill(Color.web("#272727"));
        listOfTasksText.setFont(Font.font("Courier New", 22));
        listOfTasksText.setLayoutX(100);
        listOfTasksText.setLayoutY(25);

        //ADD TO SCENE
        layout.getChildren().add(dividerLine);
        layout.getChildren().add(createNewTask);
        layout.getChildren().add(taskTitle);
        layout.getChildren().add(titleLabel);
        layout.getChildren().add(newTaskRectangle);
        layout.getChildren().add(newTaskRectangleText);
        layout.getChildren().add(listOfTasksText);
        //layout.getChildren().add(taskDoneButton);

        //ADD NEW TASK
        createNewTask.setOnAction(e -> {
            try{
                Task task = new Task(taskTitle.getText(), tasksIdCounter);
                tasksList.add(task);
                Text taskText = new Text(task.getTitle());
                taskText.setFont(Font.font("Times New Roman", 14));
                taskText.setFill(Color.web("#74445E"));
                taskText.setLayoutX(50);
                taskText.setLayoutY(200+task.getId()*50);

                Button taskDoneButton = new Button();
                taskDoneButton.setPrefWidth(15);
                taskDoneButton.setPrefHeight(15);
                taskDoneButton.setStyle(
                        "-fx-background-color: transparent;" +
                                "-fx-border-color: #74445E;" +
                                "-fx-padding: 0;" +
                                "-fx-background-insets: 0;" +
                                "-fx-border-insets: 0;"
                );
                taskDoneButton.setLayoutX(50);
                taskDoneButton.setLayoutY(200);

                layout.getChildren().add(taskText);
                layout.getChildren().add(taskDoneButton);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

    }
}
