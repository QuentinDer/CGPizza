package com.codingame.game.elements;

public class Reaper extends Collider {

  private int health;

  public Reaper(int x, int y) {
    super(x, y, 50);
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getHealth() {
    return health;
  }

  public String toInput() {
    return String.format("%d %d %d %d %d %d", 2, x, y, health, 0, 0);
  }

}
