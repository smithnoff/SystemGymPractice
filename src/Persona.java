abstract class Persona {

    private String nombre;
    private String apellido;
    private Profesion profesion;

    public Persona(){
    }

    public Persona(String nombre, String apellido, Profesion profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
    }


    @Override
    public String toString() {
        return nombre+ " "+apellido+" es "+profesion;
    }
}
