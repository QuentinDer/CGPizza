package com.codingame.game;

import java.util.ArrayList;
import java.util.List;

import com.codingame.game.elements.Element;
import com.codingame.game.elements.Reaper;
import com.codingame.game.elements.Wall;

public class GameState {

  private int width, height;
  private List<List<List<Element>>> MAP;
  private Reaper reaper;

  public GameState(List<String> map, Reaper reaper) {
    initMap(map);
    this.reaper = reaper;
  }

  private void initMap(List<String> map) {
    this.MAP = new ArrayList<>();
    this.width = map.get(0).length();
    this.height = map.size();
    for (int i = 0; i < width; i++) {
      List<List<Element>> row = new ArrayList<>();
      for (int j = 0; j < height; j++) {
        row.add(new ArrayList<>());
      }
      MAP.add(row);
    }
    for (int j = 0; j < height; j++) {
      int i = 0;
      for (char c : map.get(j).toCharArray()) {
        switch (c) {
          case '#':
            MAP.get(i).get(j).add(new Wall(i, j));
            break;
        }
        i++;
      }
    }
  }

  public Reaper getReaper() {
    return reaper;
  }

}
