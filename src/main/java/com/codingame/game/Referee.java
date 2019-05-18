package com.codingame.game;

import java.util.List;

import com.codingame.gameengine.core.AbstractPlayer.TimeoutException;
import com.codingame.gameengine.core.AbstractReferee;
import com.codingame.gameengine.core.MultiplayerGameManager;
import com.codingame.gameengine.module.entities.GraphicEntityModule;
import com.google.inject.Inject;

public class Referee extends AbstractReferee {

  private final static String LINE_0 = "......################......";

  @Inject
  private MultiplayerGameManager<Player> gameManager;
  @Inject
  private GraphicEntityModule graphicEntityModule;

  @Override
  public void init() {
    // Initialize your game here.
    gameManager.setMaxTurns(250);
    for (Player player : gameManager.getActivePlayers()) {
      player.sendInputLine("input");
    }
  }

  @Override
  public void gameTurn(int turn) {
    for (Player player : gameManager.getActivePlayers()) {
      player.sendInputLine("input");
      player.execute();
    }

    for (Player player : gameManager.getActivePlayers()) {
      try {
        List<String> outputs = player.getOutputs();
        // Check validity of the player output and compute the new game state
      } catch (TimeoutException e) {
        player.deactivate(String.format("$%d timeout!", player.getIndex()));
      }
    }
    if (gameManager.getActivePlayers().size() <= 1) {
      gameManager.endGame();
    }
  }
}
