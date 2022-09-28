public class Mundo {
    // Atributos
    private Vida mundo[][] = new Vida[8][8];
    private Vida copiaTempMundo[][];

    public Mundo(){
        for (int i = 0; i < mundo.length; i++) {
            for (int j = 0; j < mundo.length; j++) {
                mundo[i][j] = new Vida();
            }
        }
    }
    public void mostrarMundo(int numGen){
        System.out.println("Mundo original");
        for (int i = 0; i < mundo.length; i++) {
            // System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
            for (int j = 0; j < mundo.length; j++) {
                System.out.print("| "+mundo[i][j].getEstado()+ " ");
            }
            System.out.println("|");
            // System.out.println();
            // System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
        }
        if (numGen > 0) {
            nextGen(numGen);
        }
    }

    public void nextGen(int numGen) {
        System.out.println("copia mundo");
        copiaTempMundo = new Vida[8][8];
        for (int i = 0; i < numGen; i++) {
            for (int j = 0; j < mundo.length; j++) {
                for (int j2 = 0; j2 < mundo.length; j2++) {
                    if ((mundo[j][j2].getEstado() == 1) && (vecinosVivos() < 2)) {
                        copiaTempMundo[j][j2].setEstado(0);
                    }
                    else if ((mundo[j][j2].getEstado() == 1) && (vecinosVivos() > 3)) {
                        copiaTempMundo[j][j2].setEstado(0);
                    }
                    else if ((mundo[j][j2].getEstado() == 0) && (vecinosVivos() == 3)) {
                        copiaTempMundo[j][j2].setEstado(1);
                    }
                    else{
                        copiaTempMundo[j][j2] = mundo[j][j2];
                    }
                }
            }
        }

        System.out.println("siguiente generacion");
        for (int i = 0; i < copiaTempMundo.length; i++) {
            for (int j = 0; j < copiaTempMundo.length; j++) {
                System.out.print("| "+copiaTempMundo[i][j].getEstado()+ " ");
            }
        }
    }

    public int vecinosVivos() {
        int vecinos = 0;
        for (int i = 0; i < mundo.length; i++) {
            for (int j = 0; j < mundo.length; j++) {
                for (int j2 = -1; j2 <= 1; j2++) {
                    for (int k = -1; k <= 1; k++) {
                        if ((i+j2>=0 && j+j2<mundo.length) && (j+k>=0 && j+k<mundo.length)) {
                            vecinos += mundo[i+j2][k+k].getEstado();
                        }
                    }
                }
                vecinos -= mundo[i][j].getEstado();
            }
        }

        return vecinos;
    }
}
