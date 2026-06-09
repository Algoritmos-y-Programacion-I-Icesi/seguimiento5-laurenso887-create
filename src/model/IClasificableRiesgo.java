package model;

/**
 * Interfaz que define el contrato para atracciones que tienen clasificación de nivel de riesgo
 * según las normas de la ARL.
 */
public interface IClasificableRiesgo {

    /**
     * Retorna el nivel de riesgo de la atracción según las normas de la ARL.
     * @return String con el nivel de riesgo: "ALTO", "MEDIO" o "BAJO"
     */
    String getNivelRiesgo();
}
