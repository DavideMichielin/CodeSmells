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
        //if first move, O player can't player
        if (_lastSymbolPlayed == ' ' && symbol == 'O') {
            throw new Exception("Invalid first player");
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbolPlayed) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.TileAt(x, y).Symbol != ' ') {
            throw new Exception("Invalid position");
        }
    }

    public char Winner() {
        if (WinRow(0)) return _board.TileAt(0, 0).Symbol;

        //if the positions in first row are taken
        if (WinRow(1)) return _board.TileAt(1, 0).Symbol;

        //if the positions in first row are taken
        if (WinRow(2)) return _board.TileAt(2, 0).Symbol;

        return ' ';
    }

    private boolean WinRow(int i) {
        //if the positions in first row are taken
        if (_board.TileAt(i, 0).Symbol != ' ' &&
                _board.TileAt(i, 1).Symbol != ' ' &&
                _board.TileAt(i, 2).Symbol != ' ') {
            //if first row is full with same symbol
            if (_board.TileAt(i, 0).Symbol ==
                    _board.TileAt(i, 1).Symbol &&
                    _board.TileAt(i, 2).Symbol == _board.TileAt(i, 1).Symbol) {
                return true;
            }
        }
        return false;
    }
}

