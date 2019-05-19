package com.codingame.game;

import java.util.Arrays;
import java.util.List;

import com.codingame.game.elements.PlayerElement;
import com.codingame.game.elements.Reaper;
import com.codingame.gameengine.core.AbstractPlayer.TimeoutException;
import com.codingame.gameengine.core.AbstractReferee;
import com.codingame.gameengine.core.MultiplayerGameManager;
import com.codingame.gameengine.module.entities.GraphicEntityModule;
import com.google.inject.Inject;

public class Referee extends AbstractReferee {

  private final static List<String> MAP = Arrays.asList(//
      "......##################......", //
      "....###................###....", //
      "..###....................###..", //
      ".##........................##.", //
      ".##........................##.", //
      ".##........................##.", //
      ".##........................##.", //
      ".##........................##.", //
      ".##........................##.", //
      ".##........................##.", //
      ".##........................##.", //
      ".##........................##.", //
      ".##........................##.", //
      "..###....................###..", //
      "....###................###....", //
      "......##################......");

  @Inject
  private MultiplayerGameManager<Player> gameManager;
  @Inject
  private GraphicEntityModule graphicEntityModule;
  private GameState gameState;

  private Player player1;
  private Player player2;

  @Override
  public void init() {
    // Initialize your game here.
    gameManager.setMaxTurns(250);
    for (Player player : gameManager.getActivePlayers()) {
      MAP.forEach(player::sendInputLine);
    }
    List<Player> activePlayers = gameManager.getActivePlayers();
    player1 = activePlayers.get(0);
    player2 = activePlayers.get(1);
    player1.setPlayerElement(new PlayerElement(12, 11));
    player2.setPlayerElement(new PlayerElement(19, 11));
    gameState = new GameState(MAP, new Reaper(16, 5));
  }

  @Override
  public void gameTurn(int turn) {
    sendInput(player1, player2);
    sendInput(player2, player1);
    player1.execute();
    player2.execute();

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

  public void sendInput(Player p1, Player p2) {
    p1.sendInputLine(p1.toInput(0));
    p1.sendInputLine(p2.toInput(1));
    p1.sendInputLine(gameState.getReaper().toInput());
    p1.sendInputLine("" + 0);
    p1.sendInputLine("" + 0);
    p1.sendInputLine("" + 0);
    p1.sendInputLine("" + 0);
  }

}
