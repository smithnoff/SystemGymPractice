import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaGimnasio {
    private List<Entrenador> entrenadorsBD = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Gimnasio gimnasio = new Gimnasio();


    public static void main(String[] args) {
        SistemaGimnasio sg = new SistemaGimnasio();
        //este metodo lo llamo solo pq no tengo bd y pueda funcionar cuando conectes la bd este metodo no deberia existir
        sg.entrenadoresDummy();

        sg.traerEntrenadoresEnBD();// este metodo debe traer los entrenadores de la BD
        int opcion ;
        do {
            System.out.println("Bienvenidos al Gym Anaco fitness");
            System.out.println("ingrese 1 para registrar un boxeador");
            System.out.println("ingrese 2 para ver los boxeadores recibidos en el dia");
            System.out.println("ingrese 3 para mostrar boxeadores atendidos por entrenador");
            System.out.println("ingrese 4 para salir");
            opcion = sg.scanner.nextInt();

            if(opcion == 1) {
                sg.registrarUnBoxeador();

            }
            if(opcion == 2) {
                sg.boxeadoresTotales();
            }
            if(opcion == 3) {
                sg.boxeadoresPorEntrenador();
            }
        } while (opcion != 4);

    }

    private void traerEntrenadoresEnBD() {
        //aqui se supone que vas a crear un arreglo
        //con los entrenadores de la bd
        // entrenadorsBD debe tener los de la bd
        // luego ese arreglo debe sustituir a gimnasio.getEntrenadores()1
        // que es un arreglo falso que hice
        gimnasio.setEntrenadores(gimnasio.getEntrenadores());
    }

    private void registrarUnBoxeador() {
        System.out.println("Ingrese Nombre:");
        String nombre = scanner.next();
        System.out.println("Ingrese Apellido:");
        String apellido = scanner.next();
        System.out.println("Ingrese Edad:");
        int edad = scanner.nextInt();
        System.out.println("Ingrese peso:");
        double peso = scanner.nextDouble();
        System.out.println("Ingrese altura:");
        double altura = scanner.nextDouble();
        Boxeador boxeadorNuevo = new Boxeador(
                nombre,
                apellido,
                Profesion.BOXEADOR,
                edad,
                altura,
                peso
        );
        Entrenador entrenador = gimnasio.asignarEntrenador(boxeadorNuevo.getCategoria());
        if (entrenador.agregarPupilo(boxeadorNuevo)) {
            boxeadorNuevo.setEntrenador(entrenador);
            gimnasio.setBoxeadores(boxeadorNuevo);
            //aqui despues mandas el boxeador a la bd no se como tu sabras
        }
    }

    void entrenadoresDummy(){
        for (int i = 0; i < 4; i++) {
            gimnasio.crearEntrenador(new Entrenador("Entrenador","numero "+i));
        }
    }

    private void boxeadoresTotales() {
        System.out.println("La cantidad de boxeadores hoy fue = " + gimnasio.getBoxeadores());
    }

    private void boxeadoresPorEntrenador() {
        gimnasio.getEntrenadores().forEach(entrenador -> {
            System.out.println(entrenador.toString());
            System.out.println("Entreno a " + entrenador.getPupilos().size() + " boxeadores");
            entrenador.imprimirPupilos();
            System.out.println("------------------------------------------------------");
        });
    }
}
