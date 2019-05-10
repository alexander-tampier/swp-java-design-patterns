package components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import mediator.Mediator;

public class CreateButton extends Button implements EventHandler<ActionEvent>, Component {

  private Mediator mediator;

  public CreateButton() {
    super("Create");
  }

  @Override
  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void handle(ActionEvent event) {
    // handle create button clicked..
  }
}
