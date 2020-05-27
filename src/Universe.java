import java.util.Random;

public class Universe {

    int size;
    int generation;
    int aliveCells;
    //    int seed;
    char[][] currentStateOfTheUniverse;
    Random random;

    public Universe(int size) {
        this.size = size;
        this.generation = 0;
        this.aliveCells = 0;
//        this.seed = seed;
        this.currentStateOfTheUniverse = new char[size][size];
        this.random = new Random();
    }

    public void createTheUniverse() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (random.nextBoolean() == true) {
                    currentStateOfTheUniverse[i][j] = 'O';
                    this.aliveCells++;
                } else {
                    currentStateOfTheUniverse[i][j] = ' ';
                }
            }
        }
    }

    public void createNextGenerationOfTheUniverse() {
        char[][] newStateOfTheUniverse = new char[size][size];
        this.aliveCells = 0;
        char[][] cellNeighbours;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cellNeighbours = new char[3][];
                cellNeighbours[0] = new char[3];
                cellNeighbours[1] = new char[2];
                cellNeighbours[2] = new char[3];

                if (i > 0 &&  i < size - 1 && j > 0 && j < size - 1) {
                    cellNeighbours[0][0] = currentStateOfTheUniverse[i - 1][j - 1];
                    cellNeighbours[0][1] = currentStateOfTheUniverse[i - 1][j];
                    cellNeighbours[0][2] = currentStateOfTheUniverse[i - 1][j + 1];

                    cellNeighbours[1][0] = currentStateOfTheUniverse[i][j - 1];
                    cellNeighbours[1][1] = currentStateOfTheUniverse[i][j + 1];

                    cellNeighbours[2][0] = currentStateOfTheUniverse[i + 1][j - 1];
                    cellNeighbours[2][1] = currentStateOfTheUniverse[i + 1][j];
                    cellNeighbours[2][2] = currentStateOfTheUniverse[i + 1][j + 1];


                } else if (i == 0 && j > 0 && j < size - 1) {
                    cellNeighbours[0][0] = currentStateOfTheUniverse[size - 1][j - 1];
                    cellNeighbours[0][1] = currentStateOfTheUniverse[size - 1][j];
                    cellNeighbours[0][2] = currentStateOfTheUniverse[size - 1][j + 1];

                    cellNeighbours[1][0] = currentStateOfTheUniverse[i][j - 1];
                    cellNeighbours[1][1] = currentStateOfTheUniverse[i][j + 1];

                    cellNeighbours[2][0] = currentStateOfTheUniverse[i + 1][j - 1];
                    cellNeighbours[2][1] = currentStateOfTheUniverse[i + 1][j];
                    cellNeighbours[2][2] = currentStateOfTheUniverse[i + 1][j + 1];
                } else if (i > 0 && i < size - 1 && j == 0) {
                    cellNeighbours[0][0] = currentStateOfTheUniverse[i - 1][size - 1];
                    cellNeighbours[0][1] = currentStateOfTheUniverse[i - 1][j];
                    cellNeighbours[0][2] = currentStateOfTheUniverse[i - 1][j + 1];

                    cellNeighbours[1][0] = currentStateOfTheUniverse[i][size - 1];
                    cellNeighbours[1][1] = currentStateOfTheUniverse[i][j + 1];

                    cellNeighbours[2][0] = currentStateOfTheUniverse[i + 1][size - 1];
                    cellNeighbours[2][1] = currentStateOfTheUniverse[i  + 1][j];
                    cellNeighbours[2][2] = currentStateOfTheUniverse[i + 1][j + 1];

                } else if(i > 0 && i < size - 1 && j == size - 1) {
                    cellNeighbours[0][0] = currentStateOfTheUniverse[i - 1][j - 1];
                    cellNeighbours[0][1] = currentStateOfTheUniverse[i - 1][j];
                    cellNeighbours[0][2] = currentStateOfTheUniverse[i - 1][0];

                    cellNeighbours[1][0] = currentStateOfTheUniverse[i][j - 1];
                    cellNeighbours[1][1] = currentStateOfTheUniverse[i][0];

                    cellNeighbours[2][0] = currentStateOfTheUniverse[i + 1][j - 1];
                    cellNeighbours[2][1] = currentStateOfTheUniverse[i + 1][j];
                    cellNeighbours[2][2] = currentStateOfTheUniverse[i + 1][0];
                } else if (i == size - 1 && j > 0 && j < size - 1) {
                    cellNeighbours[0][0] = currentStateOfTheUniverse[i - 1][j - 1];
                    cellNeighbours[0][1] = currentStateOfTheUniverse[i - 1][j];
                    cellNeighbours[0][2] = currentStateOfTheUniverse[i - 1][j + 1];

                    cellNeighbours[1][0] = currentStateOfTheUniverse[i][j - 1];
                    cellNeighbours[1][1] = currentStateOfTheUniverse[i][j + 1];

                    cellNeighbours[2][0] = currentStateOfTheUniverse[0][j - 1];
                    cellNeighbours[2][1] = currentStateOfTheUniverse[0][j];
                    cellNeighbours[2][2] = currentStateOfTheUniverse[0][j + 1];

                } else if (i == 0 && j == 0) {
                    cellNeighbours[0][0] = currentStateOfTheUniverse[size - 1][size - 1];
                    cellNeighbours[0][1] = currentStateOfTheUniverse[size - 1][j];
                    cellNeighbours[0][2] = currentStateOfTheUniverse[size - 1][j + 1];

                    cellNeighbours[1][0] = currentStateOfTheUniverse[i][size - 1];
                    cellNeighbours[1][1] = currentStateOfTheUniverse[i][j + 1];

                    cellNeighbours[2][0] = currentStateOfTheUniverse[i + 1][size - 1];
                    cellNeighbours[2][1] = currentStateOfTheUniverse[i + 1][j];
                    cellNeighbours[2][2] = currentStateOfTheUniverse[i + 1][j + 1];
                } else if (i == 0 && j == size - 1) {
                    cellNeighbours[0][0] = currentStateOfTheUniverse[size - 1][j - 1];
                    cellNeighbours[0][1] = currentStateOfTheUniverse[size - 1][j];
                    cellNeighbours[0][2] = currentStateOfTheUniverse[size - 1][0];

                    cellNeighbours[1][0] = currentStateOfTheUniverse[i][j - 1];
                    cellNeighbours[1][1] = currentStateOfTheUniverse[i][0];

                    cellNeighbours[2][0] = currentStateOfTheUniverse[i + 1][j - 1];
                    cellNeighbours[2][1] = currentStateOfTheUniverse[i + 1][j];
                    cellNeighbours[2][2] = currentStateOfTheUniverse[i + 1][0];
                } else if (i == size - 1 && j == 0) {
                    cellNeighbours[0][0] = currentStateOfTheUniverse[i - 1][size - 1];
                    cellNeighbours[0][1] = currentStateOfTheUniverse[i - 1][j];
                    cellNeighbours[0][2] = currentStateOfTheUniverse[i - 1][j + 1];

                    cellNeighbours[1][0] = currentStateOfTheUniverse[i][size - 1];
                    cellNeighbours[1][1] = currentStateOfTheUniverse[i][j + 1];

                    cellNeighbours[2][0] = currentStateOfTheUniverse[0][size - 1];
                    cellNeighbours[2][1] = currentStateOfTheUniverse[0][j];
                    cellNeighbours[2][2] = currentStateOfTheUniverse[0][j + 1];
                } else if (i == size - 1 && j == size - 1) {
                    cellNeighbours[0][0] = currentStateOfTheUniverse[i - 1][j - 1];
                    cellNeighbours[0][1] = currentStateOfTheUniverse[i - 1][j];
                    cellNeighbours[0][2] = currentStateOfTheUniverse[i - 1][0];

                    cellNeighbours[1][0] = currentStateOfTheUniverse[i][j - 1];
                    cellNeighbours[1][1] = currentStateOfTheUniverse[i][0];

                    cellNeighbours[2][0] = currentStateOfTheUniverse[0][j - 1];
                    cellNeighbours[2][1] = currentStateOfTheUniverse[0][j];
                    cellNeighbours[2][2] = currentStateOfTheUniverse[0][0];
                }
                boolean isCurrentCellAlive = currentStateOfTheUniverse[i][j] == 'O';
                int numberOfNeighbourCells = 0;
                for (int k = 0; k < cellNeighbours.length; k++) {
                    for (int l = 0; l < cellNeighbours[k].length; l++) {
                        if (cellNeighbours[k][l] == 'O') {
                            numberOfNeighbourCells++;
                        }
                    }
                }

                if (isCurrentCellAlive) {
                    if (numberOfNeighbourCells == 2 || numberOfNeighbourCells == 3) {
                        newStateOfTheUniverse[i][j] = 'O';
                        this.aliveCells++;
                    } else {
                        newStateOfTheUniverse[i][j] = ' ';
                    }
                } else {
                    if (numberOfNeighbourCells == 3) {
                        newStateOfTheUniverse[i][j] = 'O';
                        this.aliveCells++;
                    } else {
                        newStateOfTheUniverse[i][j] = ' ';
                    }
                }



            }
        }

        generation++;
        currentStateOfTheUniverse = newStateOfTheUniverse;


    }

    public void showTheUniverse() {
        System.out.println("Generation " + "#" + generation  + "\n Alive: " + aliveCells);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(currentStateOfTheUniverse[i][j]);
            }
            System.out.println();
        }
        System.out.println();

    }

    public int getGeneration() {
        return generation;
    }

    public int getAliveCells() {
        return aliveCells;
    }

    public char[][] getCurrentStateOfTheUniverse() {
        return currentStateOfTheUniverse;
    }

    public int getSize() {
        return size;
    }
}


