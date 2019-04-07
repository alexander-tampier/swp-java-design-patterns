package prototype;

import org.w3c.dom.Element;

public class Sword extends Item<Sword> {
  private float speed;
  private boolean cuttingAbility;

  public float getSpeed() {
    return speed;
  }

  public void setSpeed(float speed) {
    this.speed = speed;
  }

  public boolean isCuttingAbility() {
    return cuttingAbility;
  }

  public void setCuttingAbility(boolean cuttingAbility) {
    this.cuttingAbility = cuttingAbility;
  }

  public static Sword createFromXML(Element element){
    Sword sword = new Sword();

    final long id = Long.valueOf(element.getAttribute("id"));
    final String name = element.getAttribute("name");
    final int hitpoints = Integer
        .valueOf(element.getElementsByTagName("hitpoints").item(0).getTextContent());
    final int length = Integer
        .valueOf(element.getElementsByTagName("length").item(0).getTextContent());
    final float weight = Float.valueOf(element.getElementsByTagName("weight").item(0).getTextContent());
    final String material = element.getElementsByTagName("material").item(0).getTextContent();
    final float speed = Float.valueOf(element.getElementsByTagName("speed").item(0).getTextContent());
    final boolean cuttingAbility = Boolean
        .valueOf(element.getElementsByTagName("cuttingAbility").item(0).getTextContent());

    sword.setId(id);
    sword.setObjectName(name);
    sword.setHitpoints(hitpoints);
    sword.setLength(length);
    sword.setWeight(weight);
    sword.setMaterial(material);
    sword.setSpeed(speed);
    sword.setCuttingAbility(cuttingAbility);

    return sword;
  }

  @Override
  public Sword clone() {
    return super.clone();
  }

  @Override
  public String toString() {
    return "Sword{" +
        super.toString()+
        "speed=" + speed +
        ", cuttingAbility=" + cuttingAbility +
        '}';
  }
}
