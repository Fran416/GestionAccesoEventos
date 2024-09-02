

public class GestionAccesoEvento {

    public static boolean verificarEdad(String [][] matrizPersonas, String nombrePersona) {
        if (existenciaPersona(matrizPersonas, nombrePersona)){
            int edad = convertirTextoAEntero(matrizPersonas[filaPersona(matrizPersonas, nombrePersona)][1]);
            return 18<=edad;
        } else {
            return false;
        }
    }

    public static String verificarBoleto(String [][] matrizPersonas, String nombrePersona) {
        if (existenciaPersona(matrizPersonas, nombrePersona)){
            return matrizPersonas[filaPersona(matrizPersonas, nombrePersona)][2];
        } else {
            return "False";
        }
    }

    public static boolean validarInvitados(String [][] matrizPersonas, String nombrePersona) {
        if (existenciaPersona(matrizPersonas, nombrePersona)){
            if (matrizPersonas[filaPersona(matrizPersonas, nombrePersona)][2] == "VIP"){
                return convertirTextoAEntero(matrizPersonas[filaPersona(matrizPersonas, nombrePersona)][3]) <= 2;
            }
        }
        return false;
    }

    public static int aforoDisponible (String[][] matrizPersonas, String tipoSala) {
        if (tipoSala == "VIP"){
            int aforoMaximoVIP = 15;
            int espacioOcupadoVIP = 0;
            for (String[] matrizPersona : matrizPersonas) {
                if (matrizPersona[2] == "VIP" && matrizPersona[3] == "True") {
                    espacioOcupadoVIP += sumarEnteros(convertirTextoAEntero(matrizPersona[3]), 1);
                }
            }
            return aforoMaximoVIP - espacioOcupadoVIP;
        } else if (tipoSala == "General"){
            int aforoMaximoGeneral = 5;
            int espacioOcupadoGeneral = 0;
            for (String[] matrizPersona : matrizPersonas) {
                if (matrizPersona[2] == "General" && matrizPersona[3] == "True") {
                    espacioOcupadoGeneral += 1;
                }
            }
            return aforoMaximoGeneral - espacioOcupadoGeneral;
        }
        return -1;
    }

    public static String ingresarPersona(String[][] matrizPersonas, String nombrePersona) {
        if (existenciaPersona(matrizPersonas, nombrePersona)){
            if (matrizPersonas[filaPersona(matrizPersonas, nombrePersona)][4] == "False"){
                matrizPersonas[filaPersona(matrizPersonas, nombrePersona)][4] = "True";
                return "Persona Ingresada";
            }
            return "La persona ya se encuentra dentro del local";
        }
        return "La persona no existe";
    }

    public static boolean permitirEntrada(String[][] matrizPersonas, String nombrePersona) {
        if (existenciaPersona(matrizPersonas, nombrePersona)){
            if (verificarEdad(matrizPersonas, nombrePersona)){
                if (verificarBoleto(matrizPersonas, nombrePersona) == "VIP"){
                    return validarInvitados(matrizPersonas, nombrePersona) && aforoDisponible(matrizPersonas, "VIP") > 1 + convertirTextoAEntero(matrizPersonas[filaPersona(matrizPersonas, nombrePersona)][3]);
                } else if (verificarBoleto(matrizPersonas, nombrePersona) == "General") {
                    return aforoDisponible(matrizPersonas, "General") > 0;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static void removerPersona (String[][] matrizPersonas, String nombrePersona) {
        if (existenciaPersona(matrizPersonas, nombrePersona)){
            if (matrizPersonas[filaPersona(matrizPersonas, nombrePersona)][4] == "True"){
                matrizPersonas[filaPersona(matrizPersonas, nombrePersona)][4] = "False";
                System.out.println("Persona Eliminada");
            }
        } else {
            System.out.println("Persona no existe");
        }
    }

    public static int convertirTextoAEntero(String string){
        return Integer.parseInt(string);
    }

    public static boolean existenciaPersona(String [][] matrizPersonas, String nombrePersona){
        for (int fila = 0; fila< matrizPersonas.length; fila++) {
            if (matrizPersonas[fila][0] == nombrePersona) {
                return true;
            }
        }
        return false;

    }

    public static int filaPersona(String[][] matrizPersonas, String nombrePersona) {
        for (int fila=0; fila<matrizPersonas.length; fila++) {
            if (matrizPersonas[fila][0] == nombrePersona) {
                return fila;
            }
        }
        return -1;
    }

    public static int sumarEnteros(int primerNumero, int segundoNumero) {
        return primerNumero + segundoNumero;
    }

    public static void agregarPersonas(String[][] matrizPersonas, String nombrePersona, String edad, String tipoEntrada, String invitados, String estaEnSala) {
        for (int fila=0; fila<matrizPersonas.length; fila++) {
            if (matrizPersonas[fila][0] == null) {
                matrizPersonas[fila][0] = nombrePersona;
                matrizPersonas[fila][1] = edad;
                matrizPersonas[fila][2] = tipoEntrada;
                matrizPersonas[fila][3] = invitados;
                matrizPersonas[fila][4] = estaEnSala;
                return;
            }
        }
    }
}
