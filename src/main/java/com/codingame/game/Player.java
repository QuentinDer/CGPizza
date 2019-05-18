package com.codingame.game;

import com.codingame.game.elements.PlayerElement;
import com.codingame.gameengine.core.AbstractMultiplayerPlayer;

public class Player extends AbstractMultiplayerPlayer {

  private PlayerElement playerElement;

  @Override
  public int getExpectedOutputLines() {
    return 1;
  }

  public void setPlayerElement(PlayerElement playerElement) {
    this.playerElement = playerElement;
  }

  public PlayerElement getPlayerELement() {
    return this.playerElement;
  }

}
