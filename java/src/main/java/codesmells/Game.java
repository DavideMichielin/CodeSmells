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
        else if (_board.GetSymbolTile(x,y) != ' ') {
            throw new Exception("Invalid position");
        }
    }

    public char Winner() {
        //if the positions in first row are taken
        if (WinRow(0)) return _board.GetSymbolTile(0,0);

        //if the positions in second row are taken
        if (WinRow(1)) return _board.GetSymbolTile(1,0);

        //if the positions in third row are taken
        if (WinRow(2)) return _board.GetSymbolTile(2,0);

        return ' ';
    }

    private boolean WinRow(int i) {
        if (_board.TileAt(i, 0).Symbol != ' ' &&
                _board.TileAt(i, 1).Symbol != ' ' &&
                _board.TileAt(i, 2).Symbol != ' ') {
            //if row is full with same symbol
            if (_board.TileAt(i, 0).Symbol ==
                    _board.TileAt(i, 1).Symbol &&
                    _board.TileAt(i, 2).Symbol == _board.TileAt(i, 1).Symbol) {
                return true;
            }
        }
        return false;
    }
}

