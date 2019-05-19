package com.codingame.game;

import com.codingame.game.elements.PlayerElement;
import com.codingame.gameengine.core.AbstractMultiplayerPlayer;

public class Player extends AbstractMultiplayerPlayer {

  public enum Weapon {
    PISTOL
  }

  private PlayerElement playerElement;
  private Weapon weapon = Weapon.PISTOL;
  private int health = 20;

  @Override
  public int getExpectedOutputLines() {
    return 2;
  }

  public void setPlayerElement(PlayerElement playerElement) {
    this.playerElement = playerElement;
  }

  public PlayerElement getPlayerELement() {
    return this.playerElement;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getHealth() {
    return health;
  }

  public String toInput(int id) {
    return String.format("%d %d %d %d %d %d", id, playerElement.getX(), playerElement.getY(), health, 0,
        weapon.ordinal());
  }

}
