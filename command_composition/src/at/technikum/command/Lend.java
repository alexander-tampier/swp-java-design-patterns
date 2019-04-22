package at.technikum.command;

import at.technikum.state.GameControl;

public class Lend extends Order {

  public Lend(GameControl gameControl) {
    super(gameControl);
  }

  @Override
  public void execute() {
    this.gameControl.lend();
  }

  @Override
  public void undo() {
    this.gameControl.reclaim();
  }
}
