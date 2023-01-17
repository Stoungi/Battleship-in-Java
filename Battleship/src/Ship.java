

enum ShipType{
    CARRIER(5),
    BATTLESHIP(4),

    CRUISER(3),
    SUBMARINE(3),
    DESTROYER(2);

    final int shipsize;

    ShipType(int size) {
        this.shipsize = size;
    }


}



/**
 * an abstract class that contains 5 ship type classes
 *
 * all 5 classes do the same but with different sizes given on the final array by the name of "size_of_ships"
 */

public abstract class Ship extends Board{


    static final private ShipType[] ships = {ShipType.CARRIER, ShipType.BATTLESHIP, ShipType.CRUISER, ShipType.SUBMARINE, ShipType.DESTROYER};

    public static int getShipSizeOf(ShipType ship_type){
        switch (ship_type){
            case CARRIER:
                return ships[0].shipsize;
            case BATTLESHIP:
                return ships[1].shipsize;
            case CRUISER:
                return ships[2].shipsize;
            case SUBMARINE:
                return ships[3].shipsize;
            case DESTROYER:
                return ships[4].shipsize;
            default:
                return -1;
        }

    }




    public static ShipType getShipType(int index){
            return ships[index];

    }


    public static ShipType[] getShipType(){
        return ships;
    }

    public static int getNumberOfShips(){
        return ships.length;

    }
    /**
     * this variation of the method is to give the option of instead of calling each subclass individually to
     * the Game class it can be looped through like it is shown in the main method of the class Game
     *
     *
     * @param placer
     * @param orientation
     * @param ship_type
     * @param x
     * @param y
     * @return
     */
    public static boolean placeShip(Tile placer, String orientation, ShipType ship_type, int x, int y){

            switch(ship_type){
                case CARRIER:
                  Carrier carrier = new Carrier();

                  return carrier.placeShip(placer.getTiles(), orientation, x, y);

                case BATTLESHIP:
                    Battleship battleship = new Battleship();

                    return  battleship.placeShip(placer.getTiles(), orientation, x, y);

                case CRUISER:
                    Cruiser cruiser = new Cruiser();

                    return  cruiser.placeShip(placer.getTiles(), orientation, x, y);

                case SUBMARINE:
                    Submarine submarine = new Submarine();

                    return submarine.placeShip(placer.getTiles(), orientation, x, y);


                case DESTROYER:
                    Destroyer destroyer = new Destroyer();

                    return destroyer.placeShip(placer.getTiles(), orientation, x, y);

                default:
                    return false;
            }

        }


    public void setSize_of_ship(int size_of_ship) {
        this.size_of_ship = size_of_ship;
    }

    private int size_of_ship;


    boolean placeShip(char[][] placer, String orientation, int x, int y) {

        if (getAjacentTiles(placer, size_of_ship, orientation, x, y)) {
            switch (orientation.toLowerCase().trim()) {
                case "h", "horizontal", "hori":
                    for (int i = x; i < size_of_ship + x; i++) {
                        placer[y][i] = 's';
                    }
                    return true;
                case "v", "vertical", "ver":


                    for (int i = y; i < size_of_ship + y; i++) {
                        placer[i][x] = 's';
                    }
                    return true;
                default:
                    return false;

            }


        }
        return false;

    }






}

