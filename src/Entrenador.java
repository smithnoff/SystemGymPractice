import java.util.ArrayList;
import java.util.List;

public class Entrenador extends Persona {
    private List<Boxeador> pupilos;
    private Boolean estaDisponible;

    public Entrenador(){

    }

    public Entrenador(String nombre, String apellido) {
        super(nombre, apellido, Profesion.ENTRENADOR);
        pupilos = new ArrayList<>();
        estaDisponible = true;
    }
//aqui lo que hago es ver si el entrenador aun puede entrenar a u boxeador
    //si es asi lo agrego a los pupilos de ese entrenador
    Boolean agregarPupilo(Boxeador boxeador) {
        if (verDisponibilidad()) {
            pupilos.add(boxeador);
            setEstaDisponible();//aqui llamo al metodo que verifica cuantos tiene registrado bajo su tutela
            System.out.println("Boxeador asignado con exito");
            return true;
        } else {
            System.out.println("Este entrenador no esta diponible");
            return false;
        }
    }

    List<Boxeador> getPupilos() {
        return pupilos;
    }
 // con este metodo puedo ver sin necesidad de contar si ya esta full o puedo agregar uno mas antes de intentarlo
    private Boolean verDisponibilidad() {
        return estaDisponible;
    }

    private void setEstaDisponible() {
        //aqui verifico cuantos boxeadores tiene este entrenador
        // si aun no tiene 5 digo true que significa que esta disponible
        // para agrgar un boxeador si no ndara false y no registrare ese boxeador
        if (pupilos.size() == 5)
            this.estaDisponible = false;
        else
            this.estaDisponible = true;
    }
   // con este metodo imprimo nombre y categoria del pupilo o boxeador
    void imprimirPupilos() {
        pupilos.forEach(pupilo -> {
                   System.out.println(pupilo.toString());
                }
        );
    }
}
