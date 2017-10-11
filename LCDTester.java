package lcdtester;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester {

    static final String CADENA_FINAL = "0,0";
    
    public static void main(String[] args) {

        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        String datosIngresadosPorUsuario;
        int espacioEntreDigitos;
        
        try {

            try (Scanner lector = new Scanner(System.in)) {
                
                System.out.print("Espacio entre Digitos (0 a 5): ");
                datosIngresadosPorUsuario = lector.next();

               
                espacioEntreDigitos = calcularEspacioEntreDigitos(datosIngresadosPorUsuario);
                
                listaComando = solicitarDigitosParaDibujar(datosIngresadosPorUsuario, lector, listaComando);
                
                
                 
            }

            ImpresorLCD impresorLCD = new ImpresorLCD();

            Iterator<String> iterador = listaComando.iterator();
            while (iterador.hasNext()) 
            {
                try 
                {
                    impresorLCD.procesar(iterador.next(), espacioEntreDigitos);
                } catch (Exception ex) 
                {
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        } catch (Exception ex) 
        {
            System.out.println("Error: "+ex.getMessage());
        }

    }
    
    static int calcularEspacioEntreDigitos(String datosIngresadosPorUsuario){
        if (ImpresorLCD.isNumeric(datosIngresadosPorUsuario)){
            int espacioEntreDigitos = Integer.parseInt(datosIngresadosPorUsuario);

            validarEspacioEntreDigitos(espacioEntreDigitos);
            return espacioEntreDigitos;
        } 
        else{
            throw new IllegalArgumentException("Cadena " + datosIngresadosPorUsuario
                    + " no es un entero");
        }
    }
    
    static boolean validarEspacioEntreDigitos(int espacioEntreDigitos){
        if(espacioEntreDigitos <0 || espacioEntreDigitos >5){
            throw new IllegalArgumentException("El espacio entre "
                        + "digitos debe estar entre 0 y 5");
        }
        else{
            return true;
        }
    }
    
    static List solicitarDigitosParaDibujar(String datosIngresadosPorUsuario, Scanner lector, List listaComando){
        do{
            System.out.print("Entrada: ");
            datosIngresadosPorUsuario = lector.next();
            if(!datosIngresadosPorUsuario.equalsIgnoreCase(CADENA_FINAL))
            {
                listaComando.add(datosIngresadosPorUsuario);
            }
        }while(!datosIngresadosPorUsuario.equalsIgnoreCase(CADENA_FINAL));
        return listaComando;
    }

}
