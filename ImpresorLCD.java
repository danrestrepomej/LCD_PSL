package lcdtester;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImpresorLCD {

    // Puntos fijos
    private final int[] PuntoReferenteArribaIzquierda;
    private final int[] PuntoReferenteCentroIzquierda;
    private final int[] PuntoReferenteAbajoIzquierda;
    private final int[] PuntoReferenteCentroDerecha;
    private final int[] PuntoReferenteArribaDerecha;
    private String[][] matrizParaImprimir;

    static final String CARACTER_VERTICAL = "|";
    static final String CARACTER_HORIZONTAL = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y";

    private int tamanoFuente;
    
    private int espacioEntreDigitos;

    
    private int filasPorDigito;
    private int columnasPorDigito;
    private int totalFilasMatriz;
    private int totalColumnasMatriz;

    public ImpresorLCD() {
        // Inicializa variables
        this.PuntoReferenteArribaIzquierda = new int[2];
        this.PuntoReferenteCentroIzquierda = new int[2];
        this.PuntoReferenteAbajoIzquierda = new int[2];
        this.PuntoReferenteCentroDerecha = new int[2];
        this.PuntoReferenteArribaDerecha = new int[2];
    }
    
    private String[][] getMatrizParaImprimir(){
        return this.matrizParaImprimir;
    }
    
    private int getEspacioEntreDigitos(){
        return this.espacioEntreDigitos;
    }
    
    private void setEspacioEntreDigitos(int espacioEntreDigitos){
        this.espacioEntreDigitos= espacioEntreDigitos;
    }
    
    private void setTamanoFuente(int tamanoFuente){
        this.tamanoFuente=tamanoFuente;
    }
    
    private int getTamanoFuente(){
        return this.tamanoFuente;
    }
    
    private void setPuntoReferenteArribaIzquierda(int fila, int columna){
        this.PuntoReferenteArribaIzquierda[0] = fila;
        this.PuntoReferenteArribaIzquierda[1] = columna;
    }
    
    private int[] getPuntoReferenteArribaIzquierda(){
        return this.PuntoReferenteArribaIzquierda;
        
    }
    
    private void setPuntoReferenteCentroIzquierda(int fila, int columna){
        this.PuntoReferenteCentroIzquierda[0] = fila;
        this.PuntoReferenteCentroIzquierda[1] = columna;
    }
    
    private int[] getPuntoReferenteCentroIzquierda(){
        return this.PuntoReferenteCentroIzquierda;
        
    }
    
    private void setPuntoReferenteAbajoIzquierda(int fila, int columna){
        this.PuntoReferenteAbajoIzquierda[0] = fila;
        this.PuntoReferenteAbajoIzquierda[1] = columna;
    }
    
    private int[] getPuntoReferenteAbajoIzquierda(){
        return this.PuntoReferenteAbajoIzquierda;
        
    }
    
    private void setPuntoReferenteCentroDerecha(int fila, int columna){
        this.PuntoReferenteCentroDerecha[0] = fila;
        this.PuntoReferenteCentroDerecha[1] = columna;
    }
    
    private int[] getPuntoReferenteCentroDerecha(){
        return this.PuntoReferenteCentroDerecha;
        
    }
    
    private void setPuntoReferenteArribaDerecha(int fila, int columna){
        this.PuntoReferenteArribaDerecha[0] = fila;
        this.PuntoReferenteArribaDerecha[1] = columna;
    }
    
    private int[] getPuntoReferenteArribaDerecha(){
        return this.PuntoReferenteArribaDerecha;
        
    }
   
    private void setFilasPorDigito(int filasPorDigito){
        this.filasPorDigito = filasPorDigito;
    }
    
    private int getFilasPorDigito(){
        return this.filasPorDigito;
    }
    
    private void setColumnasPorDigito(int columnasPorDigito){
        this.columnasPorDigito = columnasPorDigito;
    }
    
    private int getColumnasPorDigito(){
        return this.columnasPorDigito;
    }
    
    private void setTotalFilasMatriz(int totalFilasMatriz){
        this.totalFilasMatriz = totalFilasMatriz;
    }
    
    private int getTotalFilasMatriz(){
        return this.totalFilasMatriz;
    }
    
    private void setTotalColumnasMatriz(int totalColumnasMatriz){
        this.totalColumnasMatriz = totalColumnasMatriz;
    }
    
    private int getTotalColumnasMatriz(){
        return this.totalColumnasMatriz;
    }
    
    public void setFilasColumnas(String numeroPorImprimir){
         // Calculo de filas y columnas que ocupara un digito dentro de la matriz
                
        setFilasPorDigito((2 * getTamanoFuente()) + 3);

        
        setColumnasPorDigito(getTamanoFuente()+2);

        // Calculo de filas y columnas de la matriz
        setTotalFilasMatriz(getFilasPorDigito());
    
   
        setTotalColumnasMatriz((getColumnasPorDigito() * numeroPorImprimir.length())
                + (getEspacioEntreDigitos() * numeroPorImprimir.length()));
    }
    
    //Inicia seccion de metodos para validacion
    
    static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    private boolean validarCadenaIngresadaContieneComa(String NumeroPorImprimir){
        if (!NumeroPorImprimir.contains(",")) {
            throw new IllegalArgumentException("Cadena " + NumeroPorImprimir
                    + " no contiene caracter ,");
        }
        else{
            return true;
        }
    }

    private boolean validarCantidadElementosIngresados(String[] tamanoYNumeroPorImprimir, String NumeroPorImprimir){
        //Valida la cantidad de tamanoYNumeroPorImprimir
        if(tamanoYNumeroPorImprimir.length>2)
        {
           throw new IllegalArgumentException("Cadena " + NumeroPorImprimir
                    + " contiene mas caracter ,"); 
        }
        
        //Valida la cantidad de tamanoYNumeroPorImprimir
        else if(tamanoYNumeroPorImprimir.length<2)
        {
           throw new IllegalArgumentException("Cadena " + NumeroPorImprimir
                    + " no contiene los parametros requeridos"); 
        }
        else{
            return true;
        }
    }
   
    private boolean validarTamanoNumero(int tamanoNumero){
        if(tamanoNumero <1 || tamanoNumero >10)
            {
                throw new IllegalArgumentException("El parametro size ["+tamanoNumero
                        + "] debe estar entre 1 y 10");
            }
        else{
            return true;
        }
    }
    
    private boolean validarDigitoImprimir(char digito){
        if( ! Character.isDigit(digito))
            {
                throw new IllegalArgumentException("Caracter " + digito
                    + " no es un digito");
            }
        else{
            return true;
        }
    }
    
    //Finaliza seccion de metodos de validacion
    
    public void procesar(String NumeroPorImprimir, int espacioEntreDigitos) {
        
        
        String[] tamanoYNumeroPorImprimir;
        
        setEspacioEntreDigitos(espacioEntreDigitos);
        
        int tamanoNumero;

        validarCadenaIngresadaContieneComa(NumeroPorImprimir);
        //Se hace el split de la cadena
        tamanoYNumeroPorImprimir = NumeroPorImprimir.split(",");
        
        validarCantidadElementosIngresados(tamanoYNumeroPorImprimir, NumeroPorImprimir);
        
        tamanoNumero = calcularTamanoNumerico(tamanoYNumeroPorImprimir[0]);
        
        imprimirNumero(tamanoNumero, tamanoYNumeroPorImprimir[1]);

    }
    
    private int calcularTamanoNumerico(String tamanoYNumeroPorImprimir){
        if(isNumeric(tamanoYNumeroPorImprimir))
        {
            int tamanoNumero = Integer.parseInt(tamanoYNumeroPorImprimir);
            // se valida que el tamanoNumero este entre 1 numeroLineasColumna 10
            validarTamanoNumero(tamanoNumero);
            return tamanoNumero;
        }
        else
        {
            throw new IllegalArgumentException("Parametro Size [" + tamanoYNumeroPorImprimir
                    + "] no es un numero");
        }
    }
    
    private void imprimirNumero(int tamanoFuente, String numeroPorImprimir) 
    {      
        setTamanoFuente(tamanoFuente);
        setFilasColumnas(numeroPorImprimir);
        impresionMatriz(numeroPorImprimir);        
    }
    
    private void impresionMatriz(String numeroPorImprimir){
        
        inicializarMatrizImpresion();
        
        digitosPorImprimir(numeroPorImprimir, getEspacioEntreDigitos());
        
        imprimir();
    }
    
    private void imprimir(){
        for (int fila = 0; fila < getTotalFilasMatriz(); fila++) {
            for (int columna = 0; columna < getTotalColumnasMatriz(); columna++) {
                System.out.print(getMatrizParaImprimir()[fila][columna]);
            }
            System.out.println();
        }
    }
    
    private void inicializarMatrizImpresion(){
        this.matrizParaImprimir = new String[getTotalFilasMatriz()][getTotalColumnasMatriz()];
        
        //Inicializar matriz
        for (int fila = 0; fila < getTotalFilasMatriz(); fila++) {
            for (int columna = 0; columna < getTotalColumnasMatriz(); columna++) {
                this.matrizParaImprimir[fila][columna] = " ";
            }
        }
        
    }
    
    private void digitosPorImprimir(String numeroPorImprimir, int espacioEntreDigitos){
        char[] digitosDeNumeroPorImprimir = numeroPorImprimir.toCharArray();
        int puntoDeReferenciaParaImprimir = 0;
        int digitoImprimir;
        
        for (char digito : digitosDeNumeroPorImprimir) {
            
           
            validarDigitoImprimir(digito);            
                        
            digitoImprimir = Integer.parseInt(String.valueOf(digito));
            
            puntoDeReferenciaParaImprimir = calcularPuntosReferencia(espacioEntreDigitos, puntoDeReferenciaParaImprimir);
        
            
            dibujarDigito(digitoImprimir);
        }
    }    
        
    //Los puntos referencia son los limites entre los cuales se dibujara un digito dentro de la matriz
    
    private int calcularPuntosReferencia(int espacioEntreDigitos, int puntoDeReferenciaParaImprimir){
        
        setPuntoReferenteArribaIzquierda(0, 0 + puntoDeReferenciaParaImprimir);
        setPuntoReferenteCentroIzquierda(getFilasPorDigito()/2, 0 + puntoDeReferenciaParaImprimir);
        setPuntoReferenteAbajoIzquierda(getFilasPorDigito() - 1, 0 + puntoDeReferenciaParaImprimir);
        setPuntoReferenteCentroDerecha(getColumnasPorDigito() - 1, (getFilasPorDigito() / 2) + puntoDeReferenciaParaImprimir);
        setPuntoReferenteArribaDerecha(0,(getColumnasPorDigito() - 1) + puntoDeReferenciaParaImprimir );


        puntoDeReferenciaParaImprimir = puntoDeReferenciaParaImprimir + getColumnasPorDigito() + espacioEntreDigitos;
        
        return puntoDeReferenciaParaImprimir;
    }

    private void dibujarDigito(int numero) {

        
        List<Integer> lineas = new ArrayList<>();

        switch (numero) {
            case 1:
                lineas.add(3);
                lineas.add(4);
                break;
            case 2:
                lineas.add(5);
                lineas.add(3);
                lineas.add(6);
                lineas.add(2);
                lineas.add(7);
                break;
            case 3:
                lineas.add(5);
                lineas.add(3);
                lineas.add(6);
                lineas.add(4);
                lineas.add(7);
                break;
            case 4:
                lineas.add(1);
                lineas.add(6);
                lineas.add(3);
                lineas.add(4);
                break;
            case 5:
                lineas.add(5);
                lineas.add(1);
                lineas.add(6);
                lineas.add(4);
                lineas.add(7);
                break;
            case 6:
                lineas.add(5);
                lineas.add(1);
                lineas.add(6);
                lineas.add(2);
                lineas.add(7);
                lineas.add(4);
                break;
            case 7:
                lineas.add(5);
                lineas.add(3);
                lineas.add(4);
                break;
            case 8:
                lineas.add(1);
                lineas.add(2);
                lineas.add(3);
                lineas.add(4);
                lineas.add(5);
                lineas.add(6);
                lineas.add(7);
                break;
            case 9:
                lineas.add(1);
                lineas.add(3);
                lineas.add(4);
                lineas.add(5);
                lineas.add(6);
                lineas.add(7);
                break;
            case 0:
                lineas.add(1);
                lineas.add(2);
                lineas.add(3);
                lineas.add(4);
                lineas.add(5);
                lineas.add(7);
                break;
            default:
                break;
        }

        Iterator<Integer> iterator = lineas.iterator();

        while (iterator.hasNext()) {
            dibujarLineasEnMatriz(iterator.next());
        }
    }
   
    private void dibujarLineasEnMatriz(int linea) {

        switch (linea) {
            case 1:
                insertarCaracterEnMatriz(getPuntoReferenteArribaIzquierda(), POSICION_Y, CARACTER_VERTICAL);
                break;
            case 2:
                insertarCaracterEnMatriz(getPuntoReferenteCentroIzquierda(), POSICION_Y, CARACTER_VERTICAL);
                break;
            case 3:
                insertarCaracterEnMatriz(getPuntoReferenteArribaDerecha(), POSICION_Y, CARACTER_VERTICAL);
                break;
            case 4:
                insertarCaracterEnMatriz(getPuntoReferenteCentroDerecha(), POSICION_Y, CARACTER_VERTICAL);
                break;
            case 5:
                insertarCaracterEnMatriz(getPuntoReferenteArribaIzquierda(), POSICION_X, CARACTER_HORIZONTAL);
                break;
            case 6:
                insertarCaracterEnMatriz(getPuntoReferenteCentroIzquierda(), POSICION_X, CARACTER_HORIZONTAL);
                break;
            case 7:
                insertarCaracterEnMatriz(getPuntoReferenteAbajoIzquierda(), POSICION_X, CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
    }
   
    private void insertarCaracterEnMatriz(int[] puntoReferente, String ejeFijo, String caracter) {

        if (ejeFijo.equalsIgnoreCase(POSICION_X)) 
        {
            for (int numeroLineasColumna = 1; numeroLineasColumna <= getTamanoFuente(); numeroLineasColumna++) 
            {
                int columna = puntoReferente[1] + numeroLineasColumna;
                getMatrizParaImprimir()[puntoReferente[0]][columna] = caracter;
            }
        } 
        else 
        {
            for (int numeroLineasFila = 1; numeroLineasFila <= getTamanoFuente(); numeroLineasFila++) 
            {
                int fila = puntoReferente[0] + numeroLineasFila;
                getMatrizParaImprimir()[fila][puntoReferente[1]] = caracter;
            }
        }
    }  
    
}