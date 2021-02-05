package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    public Model() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
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
}
