public class ImpresoraLaser extends Impresora {

    public ImpresoraLaser(String modelo, int nivelTinta) {
        super(modelo, nivelTinta);
    }

    @Override
    public void imprimirDocumento(String documento) {

        if (nivelTinta >= 5) {
            System.out.println("Impresora laser: imprimiendo con toner...");
            System.out.println("Documento: " + documento);

            nivelTinta -= 5;

            System.out.println("Impresion realizada correctamente.");
        } else {
            System.out.println("Error: toner insuficiente.");
        }
    }
}