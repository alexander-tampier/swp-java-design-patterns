package state;

import java.util.logging.Logger;

public class Install implements State {

  private static final Logger LOGGER = Logger.getLogger(Install.class.getName());

  @Override
  public void process() {
    LOGGER.info("GameState will be installed");
  }
}
