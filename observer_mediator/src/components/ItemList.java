package components;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import mediator.Mediator;

public class ItemList extends ListView implements EventHandler<MouseEvent>, Component {

  private Mediator mediator;

  public ItemList() {
    ObservableList<String> data = FXCollections.observableArrayList();
    data.addAll("A", "B", "C", "D", "E");
    getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    setItems(data);
  }

  @Override
  public void setMediator(Mediator mediator) {
  this.mediator = mediator;
  }

  @Override
  public void handle(MouseEvent event) {
    final List<String> stringList = new ArrayList<>();
    ObservableList<String> observableList = this.getSelectionModel().getSelectedItems();

    for (String s : observableList) {
      stringList.add(s);
    }

    //this.meadiator.melde(a;b;c);
    this.mediator.call(stringList);
    stringList.clear();
  }
}
