package at.technikum.composition;

import at.technikum.state.GameControl;

public class Download extends OneClick {

  public Download(GameControl gameControl) {
    super(gameControl);
  }

  @Override
  public void execute() {
    this.gameControl.download();
  }
}
