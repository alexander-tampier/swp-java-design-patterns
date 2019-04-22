package at.technikum.state;

import at.technikum.dto.Person;

public interface GameState {
  void purchase(GameControl control, Person person);
  void download(GameControl control);
  void install(GameControl control);
  void start(GameControl control);
  void play(GameControl control);
  void update(GameControl control);
  void uninstall(GameControl control);
  void readyForPlaying(GameControl control);
  void block(GameControl control);
}
