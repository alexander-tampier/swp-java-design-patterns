package state;

import java.util.logging.Logger;

public class Start implements State {

  private static final Logger LOGGER = Logger.getLogger(Start.class.getName());

  @Override
  public void process() {
    LOGGER.info("GameState will be started");
  }
}
