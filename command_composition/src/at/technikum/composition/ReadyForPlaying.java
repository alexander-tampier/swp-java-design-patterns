package at.technikum.composition;

import at.technikum.state.GameControl;

public class ReadyForPlaying extends OneClick {

  public ReadyForPlaying(GameControl gameControl) {
    super(gameControl);
  }

  @Override
  public void execute() {
    this.gameControl.readyForPlaying();
  }
}
