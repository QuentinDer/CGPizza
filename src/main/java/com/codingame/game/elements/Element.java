package com.codingame.game.elements;

public class Element {

  protected int x, y;

  public Element(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public float distanceTo(Element element) {
    return (float)Math.sqrt((element.getX() - x) * (element.getX() - x) + (element.getY() - y) * (element.getY() - y));
  }

}
