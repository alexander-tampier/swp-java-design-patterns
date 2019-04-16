package state;

import java.util.logging.Logger;

public class Play implements State {

  private static final Logger LOGGER = Logger.getLogger(Play.class.getName());

  @Override
  public void process() {
    LOGGER.info("GameState will be played");
  }
}
