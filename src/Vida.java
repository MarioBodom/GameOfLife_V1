public class Vida {
    final int VIDA = 1;
    final int NO_VIDA = 0;
    private int estado;

    public Vida(){
        if ((int) Math.round(Math.random()) == VIDA) {
            this.estado = VIDA;
        }else{
            this.estado = NO_VIDA;
        }        
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    

}
