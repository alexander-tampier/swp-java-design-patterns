package components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import mediator.Mediator;

public class DeleteButton extends Button implements EventHandler<ActionEvent>, Component {

  private Mediator mediator;

  public DeleteButton() {
    super("Delete");
    setDisable(true);
  }

  @Override
  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }


  @Override
  public void handle(ActionEvent event) {
    // click delete button
  }
}
