public class Main {

    public static void main(String[] args) {

        ServidorImpresion servidor = new ServidorImpresion();

        ImpresoraLaser laser = new ImpresoraLaser("HP LaserJet", 80);

        ImpresoraTinta tinta = new ImpresoraTinta("Epson EcoTank", 50);

        ImpresoraMatricial matricial = new ImpresoraMatricial("Epson LX-300", 20);


        servidor.agregarImpresora(laser);
        servidor.agregarImpresora(tinta);
        servidor.agregarImpresora(matricial);


        servidor.enviarTrabajo("Informe de ventas.pdf");

        servidor.enviarTrabajo("Factura de compra.pdf");


        servidor.mostrarEstados();
    }
}