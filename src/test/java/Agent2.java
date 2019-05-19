import java.util.Scanner;

/**
 * Try to deal as much damage to the boss as possible and survive its onslaught !
 **/
public class Agent2 {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    for (int i = 0; i < 16; i++) {
      String mapLine = in.next(); // the map of the fight
    }

    // game loop
    while (true) {
      for (int i = 0; i < 3; i++) {
        int id = in.nextInt(); // 0 is you, 1 is the other player, 2 is the boss
        int eX = in.nextInt(); // horizontal position of the entity
        int eY = in.nextInt(); // vertical position of the entity
        int health = in.nextInt(); // current health of the entity
        int state = in.nextInt(); // state of the entity
        int weapon = in.nextInt(); // equipped weapon of the entity
      }
      int nbProjectiles = in.nextInt(); // number of projectiles
      for (int i = 0; i < nbProjectiles; i++) {
        int pX = in.nextInt(); // horizontal position of the projectile
        int pY = in.nextInt(); // vertical position of the projectile
        int pVX = in.nextInt(); // the horizontal speed of the projectile
        int pVY = in.nextInt(); // the vertical speed of the projectile
        int pType = in.nextInt(); // the type of the projectile
      }
      int nbExplosions = in.nextInt(); // number of explosions
      for (int i = 0; i < nbExplosions; i++) {
        int expX = in.nextInt(); // horizontal position of the explosion
        int expY = in.nextInt(); // vertical position of the explosion
        int turns = in.nextInt();
      }
      int nbBarrels = in.nextInt(); // number of barrels
      for (int i = 0; i < nbBarrels; i++) {
        int bX = in.nextInt(); // horizontal position of the barrel
        int bY = in.nextInt(); // vertical position of the barrel
      }
      int nbPotions = in.nextInt(); // number of potions
      for (int i = 0; i < nbPotions; i++) {
        int pX = in.nextInt(); // horizontal position of the potion
        int pY = in.nextInt(); // vertical position of the potion
      }

      // Write an action using System.out.println()
      // To debug: System.err.println("Debug messages...");

      System.out.println("MOVE 8 8"); // MOVE x y | FIRE x y | EQUIP weapon

      // Write an action using System.out.println()
      // To debug: System.err.println("Debug messages...");

      System.out.println("MOVE 8 8"); // MOVE x y | FIRE x y | EQUIP weapon
    }
  }
}
