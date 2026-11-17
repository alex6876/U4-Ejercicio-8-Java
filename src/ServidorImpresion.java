import java.util.ArrayList;

public class ServidorImpresion {

    private ArrayList<Impresora> impresoras = new ArrayList<>();

    public void agregarImpresora(Impresora impresora) {
        impresoras.add(impresora);
    }

    public void enviarTrabajo(String documento) {

        System.out.println("\n===== ENVIANDO TRABAJO DE IMPRESION =====");

        for (Impresora impresora : impresoras) {

            System.out.println("\n--------------------------");

            impresora.imprimirDocumento(documento);
        }
    }

    public void mostrarEstados() {

        System.out.println("\n===== ESTADO DE LAS IMPRESORAS =====");

        for (Impresora impresora : impresoras) {

            System.out.println("\n--------------------------");

            impresora.mostrarEstado();
        }
    }
}