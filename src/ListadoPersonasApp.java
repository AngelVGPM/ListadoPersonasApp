import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {

    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);
        //Definir el listado de personas
        //Definimos la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();

        //Empezamos con el menu
        var salir = false;
        while (!salir) {
            mostarMenu();
            try {
            salir = ejecutarOperacion(consola, personas);
                  } catch (Exception e){
                System.out.println("Ocurrio un error:" + e.getMessage());
            }

            System.out.println();
        }

    }
    private static void mostarMenu(){


        // Mostrar las opciones

        System.out.print("""
                *** Listado de personas App ***
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Proporcione la opcion?: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        // Revisamos la opcion proporcionada
        switch (opcion){
            case 1 -> {//Agregar persona a la lista
                System.out.print("Proporciona el nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Proporciona el telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Proporciona el email de la persona: ");
                var email = consola.nextLine();
                // Crear el objeto Persona
                var persona = new Persona(nombre,telefono,email);
                // Lo agregamos a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + "elementos");
            } // Fin caso 1
            case 2 -> {
                System.out.println("Listado de personas: ");
                // Mejora usando lambda y metodo de referencia
                // personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
                // Metodo de referencia
            }
            case 3 ->{ // Salimos del ciclor
                System.out.println("Hasta pronto...");
                salir = true;

            }
            default -> System.out.println("Opcion erronea: " + opcion);
        }
        return salir;
    }// Fin switch
}
