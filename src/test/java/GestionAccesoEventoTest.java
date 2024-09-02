import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class GestionAccesoEventoTest {

    private static String[][] matrizPersonas;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        matrizPersonas = new String[10][5];
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Juan", "15", "False", "0", "False");
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Pedro", "22", "VIP", "2", "True");
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Leandro", "20", "VIP", "4", "False");
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Sebastian", "30", "General", "0", "True");
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Francisco", "19", "VIP", "2", "True");
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Benjamin", "21", "VIP", "2", "False");
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Alison", "24", "General", "0", "False");
    }


    @BeforeEach
    void setUp() throws Exception {
        String[][] matrizPersonas = new String[10][5];
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Juan", "15", "False", "0", "False");
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Pedro", "22", "VIP", "2", "True");
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Leandro", "20", "VIP", "4", "False");
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Sebastian", "30", "General", "0", "True");
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Francisco", "19", "VIP", "2", "True");
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Benjamin", "21", "VIP", "2", "False");
        GestionAccesoEvento.agregarPersonas(matrizPersonas, "Alison", "24", "General", "0", "False");
    }

    @Test
    void verificarEdadTest1() { //Caso 1
        assert GestionAccesoEvento.verificarEdad(matrizPersonas, "Juan") == false;
    }

    @Test
    void verificarEdadTest2() { //Caso 2
        assert GestionAccesoEvento.verificarEdad(matrizPersonas, "Francisco") == true;
    }
    @Test
    void convertirAEntero() {
        assert GestionAccesoEvento.convertirTextoAEntero("20") == 20;
    }

    @Test
    void verificarEdadTest3() { //Caso 3
        assert GestionAccesoEvento.verificarEdad(matrizPersonas, "Persona Inexistente") == false;
    }

    @Test
    void verificarBoleto1() { //Caso1
        assert GestionAccesoEvento.verificarBoleto(matrizPersonas, "Leandro") == "VIP";
    }

    @Test
    void verificarBoleto2() { //Caso2
        assert GestionAccesoEvento.verificarBoleto(matrizPersonas, "Alison") == "General";
    }

    @Test
    void verificarBoleto3() { //Caso3
        assert GestionAccesoEvento.verificarBoleto(matrizPersonas, "Persona Imaginaria") == "False";
    }

    @Test
    void validarInvitados1() { //Caso1

    }
}