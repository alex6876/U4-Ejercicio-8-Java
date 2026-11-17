public class ImpresoraTinta extends Impresora {

    public ImpresoraTinta(String modelo, int nivelTinta) {
        super(modelo, nivelTinta);
    }

    @Override
    public void imprimirDocumento(String documento) {

        if (nivelTinta >= 10) {
            System.out.println("Impresora de tinta: imprimiendo a color...");
            System.out.println("Documento: " + documento);

            nivelTinta -= 10;

            System.out.println("Impresion realizada correctamente.");
        } else {
            System.out.println("Error: tinta insuficiente.");
        }
    }
}