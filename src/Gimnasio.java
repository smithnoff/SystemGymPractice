import java.util.ArrayList;
import java.util.List;

public class Gimnasio {
    private List<Entrenador> entrenadores;
    private List<Boxeador> boxeadores;

    public Gimnasio() {
        this.boxeadores = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
    }
//esta clase es para agregar entrenadores a la lista de entrenadores del gym
    // si registra 4 entrenadores ya no debe agregar mas
    // esto deberia hacerse llamando a la base de datos
    public void crearEntrenador(Entrenador entrenador) {
        if (entrenadores.size() == 4) {
            System.out.println("No se pueden registrar mas entrenadores");
        } else {
            entrenadores.add(entrenador);
        }
    }
//aqui envio un categoria y me devuelve cual entrenador es el que deberia entrenar
    // en esa categoria en este caso no especifica quien debe a que por ello los asigne
    // a cada entrenador a mi antojo
    Entrenador asignarEntrenador(Categoria categoria) {

        switch (categoria){

            case MOSCA:
            case GALLO:
                return entrenadores.get(0);

            case PLUMA:
            case LIGERO:
                return entrenadores.get(1);

            case WELTER:
            case MEDIANO:
                return entrenadores.get(2);

            case MEDIOPESADO:
            case PESADO:
                return entrenadores.get(3);

            default:
                return new Entrenador();// en caso que haya un error devuelve un entrenador vacio
        }
    }


    List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    int getBoxeadores() {
        return boxeadores.size();
    }

    void setBoxeadores(Boxeador boxeador) {
        boxeadores.add(boxeador);
    }
}
