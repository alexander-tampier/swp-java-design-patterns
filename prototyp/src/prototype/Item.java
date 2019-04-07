package prototype;

public abstract class Item<E> implements Cloneable {
  private long id;
  private String objectName;
  private int hitpoints;
  private int length;
  private float weight;
  private String material;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getObjectName() {
    return objectName;
  }

  public void setObjectName(String objectName) {
    this.objectName = objectName;
  }

  public int getHitpoints() {
    return hitpoints;
  }

  public void setHitpoints(int hitpoints) {
    this.hitpoints = hitpoints;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public float getWeight() {
    return weight;
  }

  public void setWeight(float weight) {
    this.weight = weight;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public E clone() {
    Object clone = null;

    try {
      clone = super.clone();
    } catch (CloneNotSupportedException e) {
      System.err.println("Clone not supported : " + e.getMessage());
    }

    return (E) clone;
  }

  @Override
  public String toString() {
    return
        "id=" + id +
        ", objectName='" + objectName + '\'' +
        ", hitpoints=" + hitpoints +
        ", length=" + length +
        ", weight=" + weight +
        ", material='" + material + '\'';
  }
}
