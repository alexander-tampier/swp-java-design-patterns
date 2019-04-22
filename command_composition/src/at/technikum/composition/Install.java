package at.technikum.composition;

import at.technikum.state.GameControl;

public class Install extends OneClick {

  public Install(GameControl gameControl) {
    super(gameControl);
  }

  @Override
  public void execute() {
    this.gameControl.install();
  }
}
