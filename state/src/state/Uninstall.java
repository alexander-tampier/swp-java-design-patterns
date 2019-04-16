package state;

import java.util.logging.Logger;

public class Uninstall implements State {

  private static final Logger LOGGER = Logger.getLogger(Uninstall.class.getName());

  @Override
  public void process() {
    LOGGER.info("GameState will be uninstalled");
  }
}
