package at.technikum.composition;

import at.technikum.dto.Person;
import at.technikum.state.GameControl;

public class Purchase extends OneClick {

  private Person person;

  public Purchase(GameControl gameControl, Person person) {
    super(gameControl);
    this.person = person;
  }

  @Override
  public void execute() {
    this.gameControl.purchase(person);
  }
}
