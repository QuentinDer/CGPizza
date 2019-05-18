package com.codingame.game.elements;

public class Position {

  private int x, y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public float distanceTo(Position position) {
    return (float)Math
        .sqrt((position.getX() - x) * (position.getX() - x) + (position.getY() - y) * (position.getY() - y));
  }

}
