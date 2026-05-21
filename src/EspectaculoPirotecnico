package model;

/**
 * Clase que representa un espectáculo pirotécnico en el parque MagicWorld.
 * Extiende Atraccion e implementa IClasificableRiesgo.
 */
public class EspectaculoPirotecnico extends Atraccion implements IClasificableRiesgo {

    private int duracionMinutos;
    private boolean materialPeligrosoCertificado;

    /**
     * Constructor del EspectaculoPirotecnico.
     * @param nombre nombre de la atracción
     * @param zona zona de ubicación
     * @param capacidadMaxima capacidad máxima de visitantes
     * @param edadMinima edad mínima permitida
     * @param visitantesPorDia visitantes registrados en el día
     * @param precioEntrada precio de la entrada en pesos
     * @param duracionMinutos duración del espectáculo en minutos
     * @param materialPeligrosoCertificado indica si usa material peligroso certificado
     */
    public EspectaculoPirotecnico(String nombre, String zona, int capacidadMaxima, int edadMinima,
                                   int visitantesPorDia, double precioEntrada,
                                   int duracionMinutos, boolean materialPeligrosoCertificado) {
        super(nombre, zona, capacidadMaxima, edadMinima, visitantesPorDia, precioEntrada);
        this.duracionMinutos = duracionMinutos;
        this.materialPeligrosoCertificado = materialPeligrosoCertificado;
    }

    /**
     * Calcula el ingreso diario del espectáculo pirotécnico.
     * Precondición: visitantesPorDia >= 0 y precioEntrada >= 0
     * Postcondición: retorna visitantesPorDia * precioEntrada; si usa material peligroso
     *                certificado, se aplica un recargo del 20% sobre el ingreso base.
     * @return ingreso diario en pesos
     */
    @Override
    public double calcularIngresoDiario() {
        double ingreso = visitantesPorDia * precioEntrada;
        if (materialPeligrosoCertificado) {
            ingreso = ingreso * 1.20;
        }
        return ingreso;
    }

    /**
     * Determina si el espectáculo requiere mantenimiento.
     * Postcondición: retorna true si usa material peligroso o la duración supera 60 minutos.
     * @return true si requiere mantenimiento
     */
    @Override
    public boolean requiereMantenimiento() {
        return materialPeligrosoCertificado || duracionMinutos > 60;
    }

    /**
     * Retorna el nivel de riesgo del espectáculo según normas ARL.
     * Postcondición: "ALTO" si usa material peligroso certificado;
     *                "MEDIO" si duración > 60 minutos (sin material peligroso);
     *                "BAJO" si no se cumple ninguna condición.
     * @return nivel de riesgo como String
     */
    @Override
    public String getNivelRiesgo() {
        if (materialPeligrosoCertificado) {
            return "ALTO";
        } else if (duracionMinutos > 60) {
            return "MEDIO";
        } else {
            return "BAJO";
        }
    }

    /**
     * Genera el reporte del espectáculo pirotécnico incluyendo información específica.
     * @return String con el reporte completo
     */
    @Override
    public String generarReporte() {
        StringBuilder sb = new StringBuilder(super.generarReporte());
        sb.append("  Tipo: Espectáculo Pirotécnico\n");
        sb.append("  Duración: ").append(duracionMinutos).append(" minutos\n");
        sb.append("  Material peligroso certificado: ").append(materialPeligrosoCertificado ? "Sí" : "No").append("\n");
        sb.append("  Nivel de riesgo: ").append(getNivelRiesgo()).append("\n");
        return sb.toString();
    }

    public int getDuracionMinutos() { return duracionMinutos; }
    public boolean isMaterialPeligrosoCertificado() { return materialPeligrosoCertificado; }
}
