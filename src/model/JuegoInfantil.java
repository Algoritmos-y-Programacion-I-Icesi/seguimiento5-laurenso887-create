package model;

/**
 * Clase que representa un juego infantil en el parque MagicWorld.
 * Extiende Atraccion. No tiene clasificación de nivel de riesgo.
 */
public class JuegoInfantil extends Atraccion {

    private int edadMaxima;
    private boolean supervisionPermanente;

    /**
     * Constructor del JuegoInfantil.
     * @param nombre nombre de la atracción
     * @param zona zona de ubicación
     * @param capacidadMaxima capacidad máxima de visitantes
     * @param edadMinima edad mínima permitida
     * @param visitantesPorDia visitantes registrados en el día
     * @param precioEntrada precio de la entrada en pesos
     * @param edadMaxima edad máxima permitida
     * @param supervisionPermanente indica si hay supervisión permanente de personal
     */
    public JuegoInfantil(String nombre, String zona, int capacidadMaxima, int edadMinima,
                         int visitantesPorDia, double precioEntrada,
                         int edadMaxima, boolean supervisionPermanente) {
        super(nombre, zona, capacidadMaxima, edadMinima, visitantesPorDia, precioEntrada);
        this.edadMaxima = edadMaxima;
        this.supervisionPermanente = supervisionPermanente;
    }

    /**
     * Calcula el ingreso diario del juego infantil.
     * Precondición: visitantesPorDia >= 0 y precioEntrada >= 0
     * Postcondición: retorna visitantesPorDia * precioEntrada; si hay supervisión permanente,
     *                se suma un bono de $50.000 por visitante.
     * @return ingreso diario en pesos
     */
    @Override
    public double calcularIngresoDiario() {
        double ingreso = visitantesPorDia * precioEntrada;
        if (supervisionPermanente) {
            ingreso += visitantesPorDia * 50000;
        }
        return ingreso;
    }

    /**
     * Determina si el juego infantil requiere mantenimiento.
     * Postcondición: retorna true si no hay supervisión permanente
     *                o si visitantesPorDia > capacidadMaxima.
     * @return true si requiere mantenimiento
     */
    @Override
    public boolean requiereMantenimiento() {
        return !supervisionPermanente || visitantesPorDia > capacidadMaxima;
    }

    /**
     * Genera el reporte del juego infantil incluyendo información específica.
     * @return String con el reporte completo
     */
    @Override
    public String generarReporte() {
        StringBuilder sb = new StringBuilder(super.generarReporte());
        sb.append("  Tipo: Juego Infantil\n");
        sb.append("  Edad máxima: ").append(edadMaxima).append(" años\n");
        sb.append("  Supervisión permanente: ").append(supervisionPermanente ? "Sí" : "No").append("\n");
        sb.append("  Nivel de riesgo: No aplica\n");
        return sb.toString();
    }

    public int getEdadMaxima() { return edadMaxima; }
    public boolean isSupervisionPermanente() { return supervisionPermanente; }
}
