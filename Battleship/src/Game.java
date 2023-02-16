
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *It is essentially the body of the game calling all the methods from the Board and Player classes
 */
public class Game {


    private static final int N = 3;
    private static String[] game_info = new String[N];

    public static void setGameInfo(String dir) throws IOException {
        BufferedReader file_r = new BufferedReader(new FileReader(dir));
        String a = file_r.readLine(),b=a.trim();

        while((a = file_r.readLine()) != null){
            if(!a.equals("")){
                b = b + " " + a.trim();
            }


        }


        Game.game_info = b.split(" ");



        try {
            if(Integer.parseInt(Game.game_info[0]) < 7 || Game.game_info.length > Game.N){
                Game.game_info[0] = "error";
            }
        }catch (NumberFormatException o){
            Game.game_info[0] = "error";
        }

        System.out.println(Arrays.asList(Game.game_info));
        file_r.close();
    }
    public static void setGameInfo(String[] user_in){
        for(int i = 0; i < Game.N; i++){
            Game.game_info[i] = user_in[i];
        }

            if(Integer.parseInt(Game.game_info[0]) < 7){
                Game.game_info[0] = "error";
            }

    }

    static void Initialize() throws IOException {
        Scanner input = new Scanner(System.in);
        String user_in;
        String[] array;
        do{

                System.out.print("give the following: the size of the fields (must be 7 or higher), the player name and the bot name (both names must not be blank) through your keyboard or via a file that contains that information (separated by spaces and/or change lines) in that order, \n~>>");
                user_in = input.nextLine();
                try{
                    new BufferedReader(new FileReader(user_in));
                    setGameInfo(user_in);


                }catch (FileNotFoundException p){

                    array = user_in.split(" ");
                    try{
                        Integer.parseInt(array[0]);
                        setGameInfo(array);

                    }catch (Exception o){
                        Game.game_info[0] = "error";
                    }
                }
                if(Game.game_info[0].equals("error")){
                    System.out.println("error, did not give valid input (it has to be in the mentioned order regardless if it is inside a text file or given through the terminal, or, make sure the path to the text file is given correctly)\n");
                }

        }while(Game.game_info[0].equals("error"));



    }

    /**
     * generic input of coordinates(currently used for attacking only)
     *
     * @param turn_player
     * @param tile
     */
    static void getInput(String turn_player, Tile tile) {
        Scanner input = new Scanner(System.in);
        String[] array;
        String coards;


        System.out.print(turn_player+", give coordinates[x y]\n(you can also type 'BLIND' to give these at random)\n~>>");
        coards = input.nextLine();
        try{


                    array = coards.split(" ");
                    tile.setCoards(Integer.parseInt(array[0]), Integer.parseInt(array[1]));


        }catch (Exception e){
            if(coards.toUpperCase().trim().equals("BLIND")){
                do{
                    getRandInput(tile);
                }while(tile.getTile(tile.x, tile.y) == 'o' || tile.getTile(tile.x, tile.y) == 'X');
            }else{
                tile.setCoards(tile.n, tile.n);
            }

        }

    }

    /**
     * input of coordinates for ship placement
     *
     * @param turn_player
     * @param tile
     * @param ship
     * @return
     */
    static String getInput(String turn_player, Tile tile, ShipType ship) {
        Random blind = new Random();
        Scanner input = new Scanner(System.in);
        String[] array, orientation = {"h","v"};
        String coards;



        System.out.print(turn_player+", give coordinates and either [H]orizontal or [V]ertical orientation[x y <orientation>]\n(you can also type 'BLIND' to give these at random)\n~>>");
        coards = input.nextLine();
        try{


            array = coards.split(" ");
            tile.setCoards(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
            return array[2];

        }catch (Exception e){
            String check;
            if(coards.toUpperCase().trim().equals("BLIND")){
                do{
                    check = orientation[blind.nextInt(2)];
                    getRandInput(tile);
                }while(!Board.getAjacentTiles(tile.getTiles(), Ship.getShipSizeOf(ship), check, tile.x, tile.y));
                return check;

            }else{
                tile.setCoards(tile.n, tile.n);
                return "error";
            }

        }

    }
    static void getRandInput(Tile tile) {
        Random blindfire = new Random();

        tile.setCoards(blindfire.nextInt(0, tile.n ), blindfire.nextInt(0, tile.n ));

    }



    public static void main(String[] args) throws IOException {
        Initialize();

        Scanner input = new Scanner(System.in);
        int n =Integer.parseInt(Game.game_info[0]), which;
        boolean onemore;
        String o, c;
        Tile pc = new Tile(n);//<- player character
        Tile npc = new Tile(n);//<- non-player character
        Player player = new Player(Game.game_info[1]);
        Player bot = new Player(Game.game_info[2]);
        Board field = new Board(pc.getTiles(), npc.getTiles());
        field.drawboards(player, pc.getTiles(), false);

        field.placeAllShips(npc);




        do {
            System.out.print("would you like to place your ships yourself [1] or let lady luck decide[2]?\n~>>");
            c = input.nextLine();


            switch (c.trim()) {
                case "1":

                    //===================================================================================================
                    for (int i = 0; i < Ship.getNumberOfShips(); i++) {//loops through every item in the array and depending on the item, the Ship class with it's placeShip method will
                                                            //call the placeShip method of the subclass that is synonymous with the item of the array



                        do {

                            System.out.println("for the " + Ship.getShip(i));
                            o = getInput(player.name, pc, Ship.getShip(i));
                            onemore = Ship.placeShip(pc, o, Ship.getShip(i), pc.x, pc.y);
                            if (onemore) {                                              //sets the player's ships by the player manually
                                System.out.println("ship placed successfully");
                                field.drawboards(player, pc.getTiles(), false);

                            } else {
                                System.out.println("ship couldn't be placed");
                                field.drawboards(player, pc.getTiles(), false);
                            }
                        } while (pc.x > n - 1 || pc.y > n - 1 || !onemore);



                    }

                    break;
                //===================================================================================================
                case "2":

                    field.placeAllShips(pc);



                    break;
                default:
                    System.out.println("error, did not give a valid option (type 1 or 2)\n");
                    c = "0";
            }
        }while(c.equals("0"));








        do{








            field.drawboards(player, pc.getTiles(), false);
            field.drawboards(bot, npc.getTiles(), true);



//=======================================================================================

            System.out.println("Attack!");
     do {

        do {
            getInput(player.name, npc);
        } while (npc.x > n - 1 || npc.y > n - 1 || npc.getTile(npc.x, npc.y) == 'o' || npc.getTile(npc.x, npc.y) == 'X');

        player.fire(player, npc.x, npc.y, npc);                                                 // player shooting

        if (npc.getTile(npc.x, npc.y) == 'X' && !field.allShipsSunk(npc.getTiles())) {

            field.drawboards(bot, npc.getTiles(), true);
            System.out.println("looking cool " + player.name + ", pass the baton and follow up for another hit!");
            onemore = true;

        } else {
            onemore = false;
        }

    } while (onemore);

//=======================================================================================


    if(field.allShipsSunk(npc.getTiles()) || field.allShipsSunk(pc.getTiles())) {
        break;
    }do{


        do{
            getRandInput(pc);
        }while(npc.getTile(pc.x, pc.y) == 'o' || pc.getTile(pc.x, pc.y) == 'X');
                bot.fire(bot, pc.x, pc.y, pc);
        if(pc.getTile(pc.x, pc.y) == 'X' && !field.allShipsSunk(pc.getTiles())){       // bot shooting
            field.drawboards(player, pc.getTiles(), false);
            onemore = true;
        }else{
            onemore = false;
        }
    }while(onemore);
//=======================================================================================
        System.out.println("==========================================");
        }while(!field.allShipsSunk(npc.getTiles()) && !field.allShipsSunk(pc.getTiles()));
        System.out.println("==========================================");
        if(field.allShipsSunk(npc.getTiles())){


            field.drawboards(player, pc.getTiles(), false);

            field.drawboards(bot, npc.getTiles(), false);

            System.out.println(player.name+", that's the last of em'");


        } else if (field.allShipsSunk(pc.getTiles())) {


            field.drawboards(player, pc.getTiles(), false);

            field.drawboards(bot, npc.getTiles(), false);

            System.out.println("I, "+bot.name+", stand victorious against the likes of you!");


        }

    }
