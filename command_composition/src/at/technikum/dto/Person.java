package at.technikum.dto;

/**
 * Builder-Pattern
 */
public class Person {

  private final Gender gender;
  private final String firstName;
  private final String lastName;
  private final String middleName;
  private final String telephone;
  private final String streetAddress;
  private final String city;
  private final String state;

  public Person(Builder builder) {
    this.gender = builder.gender;
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.middleName = builder.middleName;
    this.telephone = builder.telephone;
    this.streetAddress = builder.streetAddress;
    this.city = builder.city;
    this.state = builder.state;
  }

  public Gender getGender() {
    return gender;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getTelephone() {
    return telephone;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  @Override
  public String toString() {
    return "Person{" +
        "gender=" + gender +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", telephone=" + telephone +
        ", streetAddress='" + streetAddress + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        '}';
  }

  public static class Builder{
    private Gender gender;
    private String firstName;
    private String lastName;
    private String middleName;
    private String telephone;
    private String streetAddress;
    private String city;
    private String state;

    /**
     * Compulsory fields
     * @param gender
     * @param firstName
     * @param lastName
     */
    public Builder(Gender gender, String firstName, String lastName) {
      this.gender = gender;
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public Builder setMiddleName(String middleName) {
      this.middleName = middleName;
      return this;
    }

    public Builder setTelephone(String telephone) {
      this.telephone = telephone;
      return this;
    }

    public Builder setStreetAddress(String streetAddress) {
      this.streetAddress = streetAddress;
      return this;
    }

    public Builder setCity(String city) {
      this.city = city;
      return this;
    }

    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    public Person build(){
      return new Person(this);
    }
  }
}
