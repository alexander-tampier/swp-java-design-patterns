package observer;

import java.util.ArrayList;
import java.util.List;

public class Observable<T>{
  private List<Observer<T>> observers = new ArrayList<>();

  public void subscribe(Observer<T> observer){
    observers.add(observer);
  }

  public void propertyChanged(T source, String propertyName, Object newValue){
    for(Observer<T> o:observers){
      o.handle(new PropertyChangedEventArgs<>(source, propertyName, newValue));
    }
  }
}
