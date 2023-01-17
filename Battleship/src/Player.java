/**
 * contains the player characteristics as non-static
 * variables
 */
public class Player extends Game{
    private int misses = 0;
    private int hits = 0;

    private int totalshots = 0;
    String name;

    /**
     * sets the name for the player and bot with the parameter:
     * @param name
     */
    Player(String name){

        this.name = name;
    }
    public int getHits() {
        return hits;
    }public void addHits() {
        hits++;
    }

    public int getMisses() {
        return misses;
    }public void addMisses() {
        misses++;
    }

    public int getTotalShots() {
        return totalshots;
    }public void setTotalShots() {
        totalshots = hits + misses;
    }
    public void getStats(){
         setTotalShots();
        System.out.println("total shots: " + getTotalShots() + " hits: " + getHits() + " misses: " + getMisses() );


   }


    /**
     * the logic goes as follows:
     *
     *attack at the following x y coordinates towards the enemy
     *
     * @param attacker
     * @param enemy_x
     * @param enemy_y
     * @param enemy
     */

   public void fire(Player attacker, int enemy_x, int enemy_y, Tile enemy){

        if(enemy.getTile(enemy_x, enemy_y) == 's'){
            enemy.setTile(enemy_x, enemy_y, 'X');
            attacker.addHits();
        }else{
            enemy.setTile(enemy_x, enemy_y, 'o');
            attacker.addMisses();
        }
   }
}
