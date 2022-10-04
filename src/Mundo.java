

public class Mundo {
    // Atributos
    private int COLS = 10;
    private int ROWS = 10;
    private int mundo[][] = new int[COLS][ROWS];
    private int mundoTemp[][];
    private int mundoNew[][] = new int[COLS][ROWS];

    public Mundo(){
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                mundo[i][j] = (int)Math.round(Math.random());
            }
        }
        mundoTemp = mundo;
    }
    public void mostrarMundo(int numGen){
        System.out.println("Mundo original");
        for (int i = 0; i < COLS; i++) {
            // System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
            for (int j = 0; j < ROWS; j++) {
                System.out.print("| "+mundo[i][j]+ " ");
            }
            System.out.println("|");
            // System.out.println();
            // System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
        }
        for (int i = 0; i < numGen; i++) {
            nextGen(mundoTemp);
            mundoTemp = mundoNew;
        }
    }

    public void nextGen(int mundoTemp[][]) {
        int estado;
        int vecinos;
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                estado = mundoTemp[i][j];
                vecinos = vecinosVivos(mundoTemp, i, j);
                if (estado == 0 && vecinos == 3) {
                    mundoNew[i][j] = 1;
                }else if (estado == 1 && (vecinos < 2 || vecinos > 3)) {
                    mundoNew[i][j] = 0;
                }else{
                    mundoNew[i][j] = estado;
                }
            }
        }
        System.out.println("Siguiente Generación");
        for (int i = 0; i < COLS; i++) {
            // System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
            for (int j = 0; j < ROWS; j++) {
                System.out.print("| "+mundoNew[i][j]+ " ");
            }
            System.out.println("|");
        }
    }

    public int vecinosVivos(int mundo[][], int x, int y) {
        int vecinos = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int col = (x + i + COLS) % COLS;
                int row = (x + i + ROWS) % ROWS;
                vecinos += mundo[col][row];
            }
        }
        vecinos -= mundo[x][y];
        return vecinos;
    }
}
