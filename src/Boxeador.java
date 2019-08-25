public class Boxeador extends Persona {
    private int edad;
    private double altura;
    private double peso;
    private Entrenador entrenador;
    private Categoria categoria;

    public Boxeador(){

    }

    public Boxeador(String nombre, String apellido, Profesion profesion,int edad, double altura, double peso) {
        super(nombre, apellido, profesion);
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
        this.categoria = asignarCategoria(peso); // aqui lo que hago es automaticamente asignar la categoria
        entrenador = new Entrenador();// seteo un entrenador vacio para luego que este creado el boxeador saber
        // si hay un entrenador disponible y asignarselo con el setEntrenador()
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return super.toString()+" "+ categoria.toString();
    }
  // este metodo lo que hace es recibir el peso (como viste ene el constructor)
    // y dependiendo el peso retorna una categoria asi que cuando vamos a crear el objeto es solo hace esa asignacion
    private Categoria asignarCategoria(double peso) {
        if (peso < 52.163) {
           return Categoria.MOSCA;
        }else{
            if (peso >= 52.163 && peso < 55.338) {
               return Categoria.GALLO;
            }  else {
                if (peso >= 55.338 && peso < 58.967) {
                   return Categoria.PLUMA;
                }else{
                    if (peso >= 58.967 && peso < 63.503) {
                       return Categoria.LIGERO;
                    }else{
                        if (peso >= 63.503 && peso < 69.853) {
                           return Categoria.WELTER;
                        }else{
                            if (peso >= 69.853 && peso < 76.205) {
                               return Categoria.MEDIANO;
                            }else{
                                if (peso >= 76.205 && peso < 91) {
                                   return Categoria.MEDIOPESADO;
                                }else{
                                   return Categoria.PESADO;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
