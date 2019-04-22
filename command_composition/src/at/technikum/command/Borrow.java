package at.technikum.command;

import at.technikum.state.GameControl;

public class Borrow extends Order {


  public Borrow(GameControl gameControl) {
    super(gameControl);
  }

  @Override
  public void execute() {
    this.gameControl.borrow();
  }

  @Override
  public void undo() {
    this.gameControl.returnToOwner();
  }
}
