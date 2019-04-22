package at.technikum.command;

import at.technikum.state.GameControl;

public class Return extends Order {

  public Return(GameControl gameControl) {
    super(gameControl);
  }

  @Override
  public void execute() {
  this.gameControl.returnToOwner();
  }

  @Override
  public void undo() {

  }
}
