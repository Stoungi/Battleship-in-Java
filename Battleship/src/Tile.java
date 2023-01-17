public class Tile{


    public Tile() {
    }

    enum State{
        Sea,
        Ship,
        Hit,
        Miss
    }
    private char[][] tiles;
    static int n;
    int x, y;

    public void setCoards(int x,int y){
        if(x>=0 && y>=0){
            this.x = x;
            this.y = y;
        }else{
            this.x = this.n;
            this.y = this.n;
        }

    }
    Tile(int size){
        tiles = new char[size][size];
        n = size;
    }public char[][] getTiles(){
        return tiles;
    }
    public char getTile(int x, int y){
        return  tiles[y][x];
    }public void setTile(int x, int y, char type){
        tiles[y][x] = type;
    }
    public void draw(State t){
        switch (t){
            case Hit:
                System.out.print(" X ");
                break;
            case Miss:
                System.out.print(" o ");
                break;
            case Ship:
                System.out.print(" s ");
                break;
            case Sea:
                System.out.print(" ~ ");
                break;

        }
    }

}
