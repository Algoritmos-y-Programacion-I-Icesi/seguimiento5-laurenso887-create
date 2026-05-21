package model;

/**
 * Clase que representa un simulador de realidad virtual en el parque MagicWorld.
 * Extiende Atraccion e implementa IClasificableRiesgo.
 */
public class SimuladorVR extends Atraccion implements IClasificableRiesgo {

    private int numEstaciones;
    private boolean requiereAnteojos;

    /**
     * Constructor del SimuladorVR.
     * @param nombre nombre de la atracción
     * @param zona zona de ubicación
     * @param capacidadMaxima capacidad máxima de visitantes
     * @param edadMinima edad mínima permitida
     * @param visitantesPorDia visitantes registrados en el día
     * @param precioEntrada precio de la entrada en pesos
     * @param numEstaciones número de estaciones del simulador
     * @param requiereAnteojos indica si se requieren anteojos especiales
     */
    public SimuladorVR(String nombre, String zona, int capacidadMaxima, int edadMinima,
                       int visitantesPorDia, double precioEntrada,
                       int numEstaciones, boolean requiereAnteojos) {
        super(nombre, zona, capacidadMaxima, edadMinima, visitantesPorDia, precioEntrada);
        this.numEstaciones = numEstaciones;
        this.requiereAnteojos = requiereAnteojos;
    }

    /**
     * Calcula el ingreso diario del simulador.
     * Precondición: visitantesPorDia >= 0 y precioEntrada >= 0
     * Postcondición: retorna visitantesPorDia * precioEntrada; si no requiere anteojos,
     *                se aplica un descuento del 10% sobre el ingreso base.
     * @return ingreso diario en pesos
     */
    @Override
    public double calcularIngresoDiario() {
        double ingreso = visitantesPorDia * precioEntrada;
        if (!requiereAnteojos) {
            ingreso = ingreso * 0.90;
        }
        return ingreso;
    }

    /**
     * Determina si el simulador requiere mantenimiento especial.
     * Postcondición: retorna true si numEstaciones > 20 o visitantesPorDia > capacidadMaxima.
     * @return true si requiere mantenimiento
     */
    @Override
    public boolean requiereMantenimiento() {
        return numEstaciones > 20 || visitantesPorDia > capacidadMaxima;
    }

    /**
     * Retorna el nivel de riesgo del simulador según normas ARL.
     * Postcondición: "ALTO" si requiere anteojos Y estaciones > 20;
     *                "MEDIO" si solo se cumple una de las condiciones;
     *                "BAJO" si no se cumple ninguna.
     * @return nivel de riesgo como String
     */
    @Override
    public String getNivelRiesgo() {
        boolean condAnteojos = requiereAnteojos;
        boolean condEstaciones = numEstaciones > 20;
        if (condAnteojos && condEstaciones) {
            return "ALTO";
        } else if (condAnteojos || condEstaciones) {
            return "MEDIO";
        } else {
            return "BAJO";
        }
    }

    /**
     * Genera el reporte del simulador incluyendo información específica.
     * @return String con el reporte completo
     */
    @Override
    public String generarReporte() {
        StringBuilder sb = new StringBuilder(super.generarReporte());
        sb.append("  Tipo: Simulador de Realidad Virtual\n");
        sb.append("  Estaciones: ").append(numEstaciones).append("\n");
        sb.append("  Requiere anteojos: ").append(requiereAnteojos ? "Sí" : "No").append("\n");
        sb.append("  Nivel de riesgo: ").append(getNivelRiesgo()).append("\n");
        return sb.toString();
    }

    public int getNumEstaciones() { return numEstaciones; }
    public boolean isRequiereAnteojos() { return requiereAnteojos; }
}
