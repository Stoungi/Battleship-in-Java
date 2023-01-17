
import java.util.Random;

public class Board extends Tile {

    Board(){

    }


    /***
     * the following chain of nested try-catch cases are there, so it can check every possible
     * case of going out of the array index while also checking if a ship is in the adjacent tiles (neighbors)
     */
    static boolean getAjacentTiles(char[][] neighborhood, int n, String orientation, int x, int y) {
        switch (orientation.toLowerCase().trim()) {
            case "h", "horizontal", "hori":
                try {
                    for (int i = x; i < n + x; i++) {
                        if (neighborhood[y - 1][i] == 's' || neighborhood[y + 1][i] == 's' || neighborhood[y][i+1] == 's' || neighborhood[y][i-1] == 's') {
                            return false;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    try {
                        for (int i = x; i < n + x; i++) {
                            if (neighborhood[y + 1][i] == 's' || neighborhood[y][i+1] == 's' || neighborhood[y][i-1] == 's') {
                                return false;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException o) {
                        try {
                            for (int i = x; i < n + x; i++) {
                                if (neighborhood[y - 1][i] == 's' || neighborhood[y][i+1] == 's' || neighborhood[y][i-1] == 's') {
                                    return false;
                                }
                            }

                        } catch (ArrayIndexOutOfBoundsException q) {
                            try {
                                for (int i = x; i < n + x; i++) {
                                    if (neighborhood[y + 1][i] == 's' || neighborhood[y - 1][i] == 's'|| neighborhood[y][i+1] == 's') {
                                        return false;
                                    }
                                }

                            } catch (ArrayIndexOutOfBoundsException p) {
                                try {
                                    for (int i = x; i < n + x; i++) {
                                        if (neighborhood[y - 1][i] == 's' || neighborhood[y][i+1] == 's') {
                                            return false;
                                        }
                                    }

                                } catch (ArrayIndexOutOfBoundsException f) {
                                    try {
                                        for (int i = x; i < n + x; i++) {
                                            if (neighborhood[y + 1][i] == 's' || neighborhood[y][i+1] == 's') {
                                                return false;
                                            }
                                        }
                                    }catch (ArrayIndexOutOfBoundsException l){
                                        try {
                                            for (int i = x; i < n + x; i++) {
                                                if (neighborhood[y + 1][i] == 's' || neighborhood[y - 1][i] == 's'|| neighborhood[y][i] == 's') {
                                                    return false;
                                                }
                                            }

                                        } catch (ArrayIndexOutOfBoundsException ef) {
                                            try {
                                                for (int i = x; i < n + x; i++) {
                                                    if (neighborhood[y + 1][i] == 's' || neighborhood[y][i] == 's') {
                                                        return false;
                                                    }
                                                }

                                            } catch (ArrayIndexOutOfBoundsException af) {
                                                try {
                                                    for (int i = x; i < n + x; i++) {
                                                        if (neighborhood[y - 1][i] == 's' || neighborhood[y][i] == 's') {
                                                            return false;
                                                        }
                                                    }

                                                } catch (ArrayIndexOutOfBoundsException al) {
                                                    return false;
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }




                    }
                }

                break;
            case "v", "vertical", "ver":
                try {
                    for (int i = y; i < n + y; i++) {
                        if (neighborhood[i][x - 1] == 's' || neighborhood[i][x + 1] == 's' || neighborhood[i+1][x] == 's' || neighborhood[i-1][x] == 's') {
                            return false;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    try {
                        for (int i = y; i < n + y; i++) {
                            if (neighborhood[i][x + 1] == 's' || neighborhood[i+1][x] == 's' || neighborhood[i-1][x] == 's') {
                                return false;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException o) {
                        try {
                            for (int i = y; i < n + y; i++) {
                                if (neighborhood[i][x - 1] == 's' || neighborhood[i+1][x] == 's' || neighborhood[i-1][x] == 's') {
                                    return false;
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException p) {
                            try {
                                for (int i = y; i < n + y; i++) {
                                    if (neighborhood[i][x - 1] == 's' || neighborhood[i][x + 1] == 's' || neighborhood[i+1][x] == 's' ) {
                                        return false;
                                    }
                                }
                            } catch (ArrayIndexOutOfBoundsException q) {
                                try {
                                    for (int i = y; i < n + y; i++) {
                                        if (neighborhood[i][x + 1] == 's' || neighborhood[i+1][x] == 's' ) {
                                            return false;
                                        }
                                    }
                                } catch (ArrayIndexOutOfBoundsException f) {
                                    try {
                                        for (int i = y; i < n + y; i++) {
                                            if (neighborhood[i][x - 1] == 's' || neighborhood[i+1][x] == 's' ) {
                                                return false;
                                            }
                                        }
                                    }catch (ArrayIndexOutOfBoundsException l){
                                        try {
                                            for (int i = y; i < n + y; i++) {
                                                if (neighborhood[i][x - 1] == 's' || neighborhood[i][x+1] == 's' || neighborhood[i][x] == 's') {
                                                    return false;
                                                }
                                            }
                                        }catch (ArrayIndexOutOfBoundsException al){
                                            try {
                                                for (int i = y; i < n + y; i++) {
                                                    if (neighborhood[i][x - 1] == 's' || neighborhood[i][x+1] == 's' || neighborhood[i][x] == 's') {
                                                        return false;
                                                    }
                                                }
                                            }catch (ArrayIndexOutOfBoundsException fl){
                                                try {
                                                    for (int i = y; i < n + y; i++) {
                                                        if (neighborhood[i][x - 1] == 's' || neighborhood[i][x+1] == 's' || neighborhood[i][x] == 's') {
                                                            return false;
                                                        }
                                                    }
                                                }catch (ArrayIndexOutOfBoundsException ol){
                                                    try {
                                                        for (int i = y; i < n + y; i++) {
                                                            if (neighborhood[i][x - 1] == 's' || neighborhood[i][x] == 's') {
                                                                return false;
                                                            }
                                                        }
                                                    }catch (ArrayIndexOutOfBoundsException io){
                                                        try {
                                                            for (int i = y; i < n + y; i++) {
                                                                if (neighborhood[i][x + 1] == 's' || neighborhood[i][x] == 's') {
                                                                    return false;
                                                                }
                                                            }
                                                        }catch (ArrayIndexOutOfBoundsException fo){
                                                            return false;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }


                }


                break;
            default:
                return false;

        }






        return true;
    }
    Board(char[][] t) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                t[i][j] = '~';//tile[i][j]

            }
        }
    }
    Board(char[][] pc_t, char[][] npc_t) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                pc_t[i][j] = '~';
                npc_t[i][j] = '~';

            }
        }
    }

    public void drawboards(Player Name, char[][] t, boolean hidden) {
        State state;
        System.out.println("\n\\ "+Name.name+" / "); Name.getStats();
        System.out.print("   ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + "  ");
        }
        for (int i = 0; i < n; i++) {//<- y
            System.out.print("\n|" + i);
            for (int j = 0; j < n; j++) {//<- x
                if (t[i][j] == 'o') {
                    state = State.Miss;
                } else if (t[i][j] == 's' && !hidden) {
                    state = State.Ship;
                } else if (t[i][j] == 'X') {
                    state = State.Hit;
                } else {
                    state = State.Sea;
                }

                draw(state);//tile[y][x]
            }


        }
        System.out.println();
    }


    public boolean allShipsSunk(char[][] t) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (t[i][j] == 's') {
                    return false;
                }
            }


        }
            return true;
    }



    public void placeAllShips(Tile placer){

        Random position = new Random();
        String orian[] = {"v", "h"};


        for(int i = 0; i < Ship.getNumberOfShips(); i++){
            do{
                Game.getRandInput(placer);
            }while(!Ship.placeShip(placer, orian[position.nextInt(2)], Ship.getShipType(i), placer.x, placer.y));
        }



    }

}