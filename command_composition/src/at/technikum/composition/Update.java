package at.technikum.composition;

import at.technikum.state.GameControl;

public class Update extends OneClick {

  public Update(GameControl gameControl) {
    super(gameControl);
  }

  @Override
  public void execute() {
    this.gameControl.update();
  }
}
