Aquí tienes la estructura en formato Markdown lista para el `README.md` de este código de **Simulación de Servidor de Impresión y Periféricos (Clases Abstractas, Herencia y Polimorfismo en Java)**, manteniendo el enfoque exclusivo de **Programación Orientada a Objetos en memoria** (sin bases de datos):

---

# 🖨️ Simulación de Servidor de Impresión y Periféricos (Clases Abstractas y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema de gestión de impresión en red, implementando una arquitectura basada en clases abstractas y herencia para administrar distintos tipos de impresoras (láser, de inyección de tinta y matriciales) con reglas especializadas para el consumo de consumibles (tóner, tinta o cinta), validaciones de estado y despacho centralizado de trabajos a través de un servidor. Pone en práctica conceptos fundamentales de la **Programación Orientada a Objetos (POO)** como la **generalización de atributos protegidos (`protected`)**, la utilización de constructores mediante `super`, la implementación obligatoria de contratos en clases abstractas (`abstract`), la sobrescritura polimórfica de comportamiento (`@Override`), el uso de colecciones dinámicas (`ArrayList<Impresora>`) y la inyección de dependencias en componentes de control en memoria.

---

## 🧩 Clases y Estructura del Sistema

El diseño del software se organiza a través de una clase base abstracta, sus respectivas subclases especializadas, un componente servidor gestor y un punto de ejecución:

* **`Impresora` (Clase Abstracta)**: Centraliza los atributos y comportamientos comunes de cualquier periférico de impresión conectado a la red.
* **Atributos protegidos (`protected`)**: `modelo` y `nivelTinta`, permitiendo que las clases hijas accedan directamente a la identificación del equipo y al recurso consumible disponible.
* **Constructor**: Inicializa el modelo y el nivel inicial de tóner, tinta o cinta.
* **Métodos operativos**:
* `abstract void imprimirDocumento(String documento)`: Método abstracto que obliga de forma contractual a cada tecnología de impresión a implementar su propia lógica de validación y consumo de recursos.
* `mostrarEstado()`: Método concreto compartido que imprime por consola el modelo actual y el nivel restante del consumible.




* **`ImpresoraLaser`**: Extiende de `Impresora` para modelar equipos láser de alta velocidad basados en tóner.
* **Sobrescritura (`@Override`)**:
* `impresoraDocumento(String documento)`: Valida que el nivel de tóner sea de al menos 5 unidades, procesa la impresión, descuenta el recurso y confirma el éxito de la tarea.




* **`ImpresoraTinta`**: Extiende de `Impresora` para modelar dispositivos de inyección de tinta a color.
* **Sobrescritura (`@Override`)**:
* `impresoraDocumento(String documento)`: Comprueba la disponibilidad de tinta (requiere un mínimo de 10 unidades), ejecuta la impresión, actualiza el nivel y emite el comprobante.




* **`ImpresoraMatricial`**: Extiende de `Impresora` para modelar impresoras de impacto basadas en cinta entintada.
* **Sobrescritura (`@Override`)**:
* `impresoraDocumento(String documento)`: Verifica que el nivel de la cinta sea suficiente (al menos 3 unidades), realiza la operación de impresión por impacto y reduce el recurso disponible.




* **`ServidorImpresion`**: Componente controlador encargado de gestionar la cola de dispositivos y la distribución de trabajos.
* **Atributo privado (`private`)**: `ArrayList<Impresora> impresoras`.
* **Métodos operativos**:
* `agregarImpresora(Impresora impresora)`: Registra un nuevo periférico en la red interna del servidor.
* `enviarTrabajo(String documento)`: Recorre de forma polimórfica la lista de impresoras y despacha simultáneamente el documento a cada unidad conectada.
* `mostrarEstados()`: Solicita de manera uniforme el estado operativo y los consumibles remanentes de toda la flota de impresión.




* **`Main`**: Punto de entrada del programa. Instancia un servidor de impresión, crea tres modelos diferentes de impresoras con sus niveles iniciales de consumibles, los registra en el servidor y ejecuta el envío secuencial de dos documentos de prueba, cerrando con un reporte completo de los estados finales.

---

## ⚙️ Reglas de Negocio y Control de Validación

1. **Gestión Defensiva de Consumibles:** Cada tipo de impresora implementa su propia regla de control en el método `impresirarDocumento()`, validando estrictamente umbrales mínimos de tóner, tinta o cinta antes de permitir la ejecución del trabajo.
2. **Distribución Polimórfica de Trabajos:** El `ServidorImpresion` opera de manera completamente desacoplada mediante una colección tipada de la clase base (`ArrayList<Impresora>`), aplicando ligadura dinámica para enviar tareas a dispositivos con lógicas internas radicalmente distintas.
3. **Encapsulamiento y Reutilización:** Las subclases heredan los atributos identificatorios y el comportamiento común de visualización de estados a través de la superclase abstracta, manteniendo un código limpio y modular.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
===== ENVIANDO TRABAJO DE IMPRESION =====

--------------------------
Impresora laser: imprimiendo con toner...
Documento: Informe de ventas.pdf
Impresion realizada correctamente.

--------------------------
Impresora de tinta: imprimiendo a color...
Documento: Informe de ventas.pdf
Impresion realizada correctamente.

--------------------------
Impresora matricial: imprimiendo con cinta...
Documento: Informe de ventas.pdf
Impresion realizada correctamente.

===== ENVIANDO TRABAJO DE IMPRESION =====

--------------------------
Impresora laser: imprimiendo con toner...
Documento: Factura de compra.pdf
Impresion realizada correctamente.

--------------------------
Impresora de tinta: imprimiendo a color...
Documento: Factura de compra.pdf
Impresion realizada correctamente.

--------------------------
Impresora matricial: imprimiendo con cinta...
Documento: Factura de compra.pdf
Impresion realizada correctamente.

===== ESTADO DE LAS IMPRESORAS =====

--------------------------
Modelo: HP LaserJet
Nivel de tinta: 70

--------------------------
Modelo: Epson EcoTank
Nivel de tinta: 30

--------------------------
Modelo: Epson LX-300
Nivel de tinta: 14

```

---

## 🚀 Conceptos de Programación Aplicados

* **Abstracción y Polimorfismo de Periféricos:** Modelado unificado de dispositivos de hardware heterogéneos mediante contratos en clases abstractas.
* **Separación de Responsabilidades:** Clara división entre las reglas internas de cada impresora, el componente servidor de red (`ServidorImpresion`) y la inicialización cliente (`Main`).
* **Diseño Extensible (OCP):** Facilidad absoluta para añadir nuevas tecnologías de impresión al sistema corporativo (como impresoras 3D o plotters) simplemente extendiendo la clase abstracta, sin modificar el código del servidor de red.
