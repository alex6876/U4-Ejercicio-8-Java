public abstract class Impresora {

    protected String modelo;
    protected int nivelTinta;

    public Impresora(String modelo, int nivelTinta) {
        this.modelo = modelo;
        this.nivelTinta = nivelTinta;
    }

    public abstract void imprimirDocumento(String documento);

    public void mostrarEstado() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Nivel de consumible: " + nivelTinta + "%");
    }
}