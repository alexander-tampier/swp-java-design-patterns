package at.technikum.command;

import at.technikum.state.GameControl;

public class Reclaim extends Order {

  public Reclaim(GameControl gameControl) {
    super(gameControl);
  }

  @Override
  public void execute() {
    this.gameControl.reclaim();
  }

  @Override
  public void undo() {

  }
}
