package sample;

import components.CreateButton;
import components.DeleteButton;
import components.EditButton;
import components.ItemList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mediator.ConcreteMediator;
import mediator.Mediator;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Mediator & Observer");

    Mediator mediator = new ConcreteMediator();

    mediator.registerComponent(new CreateButton());
    mediator.registerComponent(new EditButton());
    mediator.registerComponent(new DeleteButton());
    mediator.registerComponent(new ItemList());

    Parent parent = mediator.createGUI();

    primaryStage.setScene(new Scene(parent, 500, 500));
    primaryStage.show();
  }




  public static void main(String[] args) {
    launch(args);
  }
}
