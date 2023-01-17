public class Cruiser extends Ship {

    boolean placeShip(char[][] placer, String orientation, int x, int y) {

        setSize_of_ship(getShipSizeOf(ShipType.CRUISER));

        return super.placeShip(placer, orientation, x, y);

    }

}
