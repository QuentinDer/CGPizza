package com.codingame.game.elements;

public class Collider extends Position {

  private int size;

  public Collider(int x, int y, int size) {
    super(x, y);
    this.size = size;
  }

  public int getSize() {
    return this.size;
  }
}
