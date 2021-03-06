package codesmells;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> _plays = new ArrayList<>();
    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile(i, j, ' ');
                _plays.add(tile);
            }
        }
    }

    public Tile TileAt(int x, int y) {
        for (Tile t : _plays) {
            if (t.getFirstCoordinate() == x && t.getSecondCoordinate() == y) {
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, int x, int y) {
        TileAt(x, y).setSymbol(symbol);
    }

    public char GetSymbolTile(int x, int y) {
        return TileAt(x, y).getSymbol();
    }
}
