package at.technikum.command;

import at.technikum.state.GameControl;
import java.util.ArrayList;
import java.util.List;

public class LocalSteam {

  private List<Order> orderList = null;

  public LocalSteam() {
    this.orderList = new ArrayList<>();
  }

  public void placeOrders(){
    for (Order order : orderList) {
      order.execute();
    }
    orderList.clear();
  }

  public void addOrder(Order order){
    orderList.add(order);
  }

  public List<Order> getOrderList() {
    return orderList;
  }
}
