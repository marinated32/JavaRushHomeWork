package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score, maxTile;

    public Model() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        this.score = 0;
        this.maxTile = 0;
        resetGameTiles ();
    }

    public void resetGameTiles() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile (  );
            }
        }
        addTile ();
        addTile ();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<> (  );
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty ()) {
                    list.add ( gameTiles[i][j] );
                }
            }
        }
        return list;
    }

    private void addTile() {
        List<Tile> list = getEmptyTiles ();
        if (list.size () < 1) return;
        int randomId = (int) (list.size () * Math.random ());
        list.get ( randomId ).value = Math.random() < 0.9 ? 2 : 4;
    }

    private boolean compressTiles(Tile[] tiles) {
        int zeroId = Integer.MAX_VALUE;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].value == 0 && i < zeroId) {
                zeroId = i;
            }
            if (tiles[i].value != 0 && zeroId != Integer.MAX_VALUE) {
                tiles[zeroId] = tiles[i];
                tiles[i] = new Tile ( 0 );
                compressTiles ( tiles );
                return true;
            }
        }
        return false;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < tiles.length; i++) {
            try {
                if (tiles[i].value == tiles[i+1].value &&
                        tiles[i].value != 0) {
                    tiles[i].value = tiles[i].value * 2;
                    score += tiles[i].value;
                    isChanged = true;
                    tiles[i+1] = new Tile ( 0 );
                    if (maxTile < tiles[i].value) {
                        maxTile = tiles[i].value;
                    }
                    compressTiles ( tiles );
                }
            } catch (Exception e) {
            }
        }
        return isChanged;
    }

    public void left() {
        boolean flag = false;
        for (int i = 0; i < gameTiles.length; i++) {
            boolean comprRes = compressTiles ( gameTiles[i] );
            boolean merRes = mergeTiles ( gameTiles[i] );
            if (comprRes || merRes) {
                flag = true;
            }
        }
        if (flag) addTile ();
    }

    private Tile[][] rotate(Tile[][] array) {
        Tile[][] result = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                result[j][FIELD_WIDTH - i - 1] = array[i][j];
            }
        }
        return result;
    }

    public void right() {
        gameTiles = rotate ( gameTiles );
        gameTiles = rotate ( gameTiles );
        left ();
        gameTiles = rotate ( gameTiles );
        gameTiles = rotate ( gameTiles );
    }

    public void down() {
        gameTiles = rotate ( gameTiles );
        left ();
        gameTiles = rotate ( gameTiles );
        gameTiles = rotate ( gameTiles );
        gameTiles = rotate ( gameTiles );
    }

    public void up() {
        gameTiles = rotate ( gameTiles );
        gameTiles = rotate ( gameTiles );
        gameTiles = rotate ( gameTiles );
        left ();
        gameTiles = rotate ( gameTiles );
    }

    public boolean canMove() {
        boolean flag = false;
        if (getEmptyTiles ().size () > 0)
            flag = true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                try {
                    if (gameTiles[i][j].value == gameTiles[i][j+1].value ||
                            gameTiles[i][j].value == gameTiles[i+1][j].value) {
                        flag = true;
                        break;
                    }
                } catch (Exception e) {
                }
            }
        }
        return flag;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }
}
