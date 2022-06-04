package ft.school21.swing.java.model;

import java.util.Random;

public class Map {
    private final Random random;
    private char[][] map;
    private int mapSize;
    private int mapLevel;

    public Map() {
        this.random = new Random();
        initializeMap();
    }

    public void initializeMap()
    {
        mapSize =  (mapLevel - 1) * 5 + 10 - (mapLevel % 2);
        map = new char[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = '.';
            }
        }
        generatedEnemies();
        generatedObstacle();
    }

    private void generatedEnemies()
    {
        int count = (int) (mapSize * mapSize * 0.1);

        for (int i = 0; i < count;) {
            int randX = random.nextInt(mapSize);
            int randY = random.nextInt(mapSize);
            if (randX != mapSize / 2 && randY != mapSize / 2)
            {
                map[randX][randY] = 'E';
                i++;
            }
        }
    }

    private void generatedObstacle()
    {
        int count = (int) (mapSize * mapSize * 0.1);

        for (int i = 0; i < count;) {
            int randX = random.nextInt(mapSize);
            int randY = random.nextInt(mapSize);
            if (randX != mapSize / 2 && randY != mapSize / 2)
            {
                map[randX][randY] = 'O';
                i++;
            }
        }
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapLevel(int mapLevel) {
        this.mapLevel = mapLevel;
    }

    public int getMapLevel() {
        return mapLevel;
    }

    public char getMapSymbol(int i, int j) {
        return map[i][j];
    }

    public void setMapSymbol(int i, int j, char c) {
        map[i][j] = c;
    }

}
