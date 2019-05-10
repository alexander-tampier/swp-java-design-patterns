package observer;

public interface Observer<T>{
  void handle(PropertyChangedEventArgs<T> args);
}
