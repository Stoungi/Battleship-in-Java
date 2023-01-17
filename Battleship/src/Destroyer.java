public class Destroyer extends Ship {

    boolean placeShip(char[][] placer, String orientation, int x, int y) {

        setSize_of_ship(getShipSizeOf(ShipType.DESTROYER));

        return super.placeShip(placer, orientation, x, y);

    }
}
