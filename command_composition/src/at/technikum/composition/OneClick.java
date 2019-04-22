package at.technikum.composition;

import at.technikum.command.Order;
import at.technikum.dto.Person;
import at.technikum.state.GameControl;
import java.util.ArrayList;
import java.util.List;

public class OneClick extends Order {

  private String name;
  private List<OneClick> childComponents = null;


  public OneClick(GameControl gameControl) {
    super(gameControl);
    this.childComponents = new ArrayList<>();
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<OneClick> getChildComponents() {
    return childComponents;
  }

  @Override
  public void execute() {
    for(OneClick child:childComponents){
      child.execute();
    }
  }

  public void addChild(OneClick oneClick){
    childComponents.add(oneClick);
  }

  public void removeChild(OneClick oneClick){
    childComponents.remove(oneClick);
  }

  public OneClick getChild(String name){
    for(OneClick child:childComponents){
      if(child.getName().equals(name)){
        return child;
      }
    }

    return null;
  }

  @Override
  public void undo() {

  }
}
