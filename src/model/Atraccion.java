package model;

/**
 * Clase abstracta que representa una atracción del parque MagicWorld.
 * Define los atributos y comportamientos comunes a todos los tipos de atracciones.
 */
public abstract class Atraccion {

    protected String nombre;
    protected String zona;
    protected int capacidadMaxima;
    protected int edadMinima;
    protected int visitantesPorDia;
    protected double precioEntrada;

    /**
     * Constructor de la clase Atraccion.
     * @param nombre nombre de la atracción
     * @param zona zona de ubicación dentro del parque
     * @param capacidadMaxima capacidad máxima de visitantes
     * @param edadMinima edad mínima permitida para ingresar
     * @param visitantesPorDia número de visitantes registrados en el día
     * @param precioEntrada precio de la entrada en pesos
     */
    public Atraccion(String nombre, String zona, int capacidadMaxima,
                     int edadMinima, int visitantesPorDia, double precioEntrada) {
        this.nombre = nombre;
        this.zona = zona;
        this.capacidadMaxima = capacidadMaxima;
        this.edadMinima = edadMinima;
        this.visitantesPorDia = visitantesPorDia;
        this.precioEntrada = precioEntrada;
    }

    /**
     * Calcula el ingreso diario generado por la atracción.
     * Cada subclase implementa su propia lógica de cálculo.
     * @return ingreso diario en pesos (double)
     */
    public abstract double calcularIngresoDiario();

    /**
     * Determina si la atracción requiere mantenimiento especial.
     * Cada subclase implementa sus propias reglas.
     * @return true si requiere mantenimiento, false en caso contrario
     */
    public abstract boolean requiereMantenimiento();

    /**
     * Genera un reporte del estado general de la atracción.
     * Puede ser sobreescrito por las subclases para incluir información específica.
     * @return String con el reporte completo de la atracción
     */
    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(nombre).append(" ===\n");
        sb.append("  Zona: ").append(zona).append("\n");
        sb.append("  Capacidad máxima: ").append(capacidadMaxima).append("\n");
        sb.append("  Edad mínima: ").append(edadMinima).append(" años\n");
        sb.append("  Visitantes hoy: ").append(visitantesPorDia).append("\n");
        sb.append("  Precio entrada: $").append(String.format("%.0f", precioEntrada)).append("\n");
        sb.append("  Ingreso diario: $").append(String.format("%.0f", calcularIngresoDiario())).append("\n");
        sb.append("  Requiere mantenimiento: ").append(requiereMantenimiento() ? "Sí" : "No").append("\n");
        if (tieneAlertaCapacidad()) {
            int exceso = visitantesPorDia - capacidadMaxima;
            double porcentaje = (exceso * 100.0) / capacidadMaxima;
            sb.append("  ⚠ ALERTA: ").append(exceso).append(" visitantes sobre el límite (")
              .append(String.format("%.1f", porcentaje)).append("% de sobreocupación)\n");
        }
        return sb.toString();
    }

    /**
     * Verifica si el número de visitantes supera la capacidad máxima.
     * @return true si hay sobreocupación, false en caso contrario
     */
    public boolean tieneAlertaCapacidad() {
        return visitantesPorDia > capacidadMaxima;
    }

    public String getNombre() { return nombre; }
    public String getZona() { return zona; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public int getEdadMinima() { return edadMinima; }
    public int getVisitantesPorDia() { return visitantesPorDia; }
    public double getPrecioEntrada() { return precioEntrada; }

    public void setVisitantesPorDia(int visitantesPorDia) {
        this.visitantesPorDia = visitantesPorDia;
    }
}
