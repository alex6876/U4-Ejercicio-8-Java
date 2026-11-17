public class ImpresoraMatricial extends Impresora {

    public ImpresoraMatricial(String modelo, int nivelTinta) {
        super(modelo, nivelTinta);
    }

    @Override
    public void imprimirDocumento(String documento) {

        if (nivelTinta >= 3) {
            System.out.println("Impresora matricial: imprimiendo con cinta...");
            System.out.println("Documento: " + documento);

            nivelTinta -= 3;

            System.out.println("Impresion realizada correctamente.");
        } else {
            System.out.println("Error: cinta insuficiente.");
        }
    }
}
