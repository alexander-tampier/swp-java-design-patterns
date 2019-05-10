package mediator;

import components.Component;
import components.CreateButton;
import components.DeleteButton;
import components.EditButton;
import components.ItemList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConcreteMediator implements Mediator {

  private Button createButton;
  private Button editButton;
  private Button deleteButton;

  private ItemList itemList;

  private Map<Integer, Handler> handlerMap = new HashMap<>(){{
    put(0, () -> toggleButton(true, true, false));
    put(1, () -> toggleButton(false, false, true));
    put(-1, () -> toggleButton(true, false, true));
  }};

  @Override
  public void registerComponent(Component component) {
    component.setMediator(this);
    switch (component.getName()) {
      case "CreateButton":
        this.createButton = (CreateButton) component;
        break;
      case "EditButton":
        this.editButton = (EditButton) component;
        break;
      case "DeleteButton":
        this.deleteButton = (DeleteButton) component;
        break;
      case "ItemList":
        this.itemList = (ItemList) component;
        this.itemList.setOnMouseClicked(itemList);
        break;
    }
  }

  @Override
  public Parent createGUI() {
    final VBox leftVbox = new VBox(10);
    leftVbox.setPadding(new Insets(20, 20, 20, 20));
    leftVbox.getChildren().addAll(itemList);

    final VBox rightVbox = new VBox(10);
    rightVbox.setPadding(new Insets(20, 20, 20, 20));
    rightVbox.getChildren().addAll(editButton, deleteButton, createButton);

    final HBox root = new HBox(10);
    root.setPadding(new Insets(20, 20, 20, 20));
    root.getChildren().addAll(leftVbox, rightVbox);

    return root;
  }

  @Override
  public void toggleButton(boolean... args) {
    editButton.setDisable(args[0]);
    deleteButton.setDisable(args[1]);
    createButton.setDisable(args[2]);
  }

  @Override
  public void call(List<String> itemList) {
    int itemCount = itemList.size();
    Optional.ofNullable(handlerMap.get(itemCount)).ifPresentOrElse(Handler::handle, handlerMap.get(-1)::handle);
  }
}
