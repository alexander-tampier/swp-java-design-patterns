package observer;

public class PropertyChangedEventArgs<T>{
  private T source;
  private String propertyName;
  private Object newValue;

  public PropertyChangedEventArgs(T source, String propertyName, Object newValue) {
    this.source = source;
    this.propertyName = propertyName;
    this.newValue = newValue;
  }
}
