package codesmells;

public class Game {
    private char _lastSymbolPlayed = ' ';
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        ControlCorrectMove(symbol, x, y);
        // update game state
        _lastSymbolPlayed = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    private void ControlCorrectMove(char symbol, int x, int y) throws Exception {
        //if first move, O player can't play
        if (_lastSymbolPlayed == ' ' && symbol == 'O') {
            throw new Exception("Invalid first player");
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbolPlayed) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.GetSymbolTile(x, y) != ' ') {
            throw new Exception("Invalid position");
        }
    }

    public char Winner() {
        //if the positions in first row are taken
        if (TileEmptyInARow(0) && ThreeSymbolInARow(0)) return _board.GetSymbolTile(0, 0);

        //if the positions in second row are taken
        if (TileEmptyInARow(1) && ThreeSymbolInARow(1)) return _board.GetSymbolTile(1, 0);

        //if the positions in third row are taken
        if (TileEmptyInARow(2) && ThreeSymbolInARow(2)) return _board.GetSymbolTile(2, 0);

        return ' ';
    }

    private boolean TileEmptyInARow(int row) {
        //if row is not empty
        for (int col = 0; col < 3; col++) {
            if (_board.GetSymbolTile(row, col) == ' ') {
                return false;
            }
        }
        return true;
    }

    private boolean ThreeSymbolInARow(int row) {
        //Verify if a row is composed by same symbol
        for (int col = 0; col < 2; col++) {
            if (_board.GetSymbolTile(row, col) != _board.GetSymbolTile(row, col + 1)) {
                return false;
            }
        }
        return true;
    }
}

