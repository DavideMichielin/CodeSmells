package codesmells;

public class Tile {
    Coordinate xy = new Coordinate();
    private char Symbol;

    public Tile(int x, int y, char symbol) {
        xy.setX(x);
        ;
        xy.setY(y);
        this.Symbol = symbol;
    }

    public int getFirstCoordinate() {
        return xy.getX();
    }

    public int getSecondCoordinate(){
        return xy.getY();
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }
}
