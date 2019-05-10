package mediator;

import components.Component;
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public interface Mediator {
  void registerComponent(Component component);

  public void toggleButton(boolean... args);

  void call(List<String> itemList);

  Parent createGUI();
}
