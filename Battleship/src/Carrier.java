public class Carrier extends Ship {



     boolean placeShip(char[][] placer, String orientation, int x, int y) {
         setSize_of_ship(getShipSizeOf(ShipType.CARRIER));
         return super.placeShip(placer, orientation, x, y);

    }
}

