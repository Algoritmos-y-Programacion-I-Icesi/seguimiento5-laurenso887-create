package controller;

import model.*;
import java.util.ArrayList;

public class Parque {

    private ArrayList<Atraccion> atracciones;

    public Parque() {
        atracciones = new ArrayList<>();
    }

    public void registrarAtraccion(Atraccion atraccion) {
        atracciones.add(atraccion);
    }

    public String generarReporteOperaciones() {
        if (atracciones.isEmpty()) {
            return "No hay atracciones registradas.\n";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("    REPORTE DE OPERACIONES - MAGICWORLD  \n");
        sb.append("========================================\n");
        for (Atraccion a : atracciones) {
            sb.append(a.generarReporte()).append("\n");
        }
        return sb.toString();
    }

    public double calcularIngresoTotalDiario() {
        double total = 0;
        for (Atraccion a : atracciones) {
            total += a.calcularIngresoDiario();
        }
        return total;
    }

    public String mostrarClasificacionRiesgo() {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("   ATRACCIONES CON CLASIFICACIÓN RIESGO  \n");
        sb.append("========================================\n");
        boolean hayAlguna = false;
        for (Atraccion a : atracciones) {
            if (a instanceof IClasificableRiesgo) {
                IClasificableRiesgo cr = (IClasificableRiesgo) a;
                sb.append("  ").append(a.getNombre())
                  .append(" -> Nivel: ").append(cr.getNivelRiesgo()).append("\n");
                hayAlguna = true;
            }
        }
        if (!hayAlguna) {
            sb.append("  No hay atracciones con clasificación de riesgo.\n");
        }
        return sb.toString();
    }

    public String mostrarAlertasCapacidad() {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("       ATRACCIONES CON ALERTA CAPACIDAD  \n");
        sb.append("========================================\n");
        boolean hayAlguna = false;
        for (Atraccion a : atracciones) {
            if (a.tieneAlertaCapacidad()) {
                int exceso = a.getVisitantesPorDia() - a.getCapacidadMaxima();
                double porcentaje = (exceso * 100.0) / a.getCapacidadMaxima();
                sb.append("  ").append(a.getNombre())
                  .append(": ").append(exceso).append(" visitantes excedidos (")
                  .append(String.format("%.1f", porcentaje)).append("% sobreocupación)\n");
                hayAlguna = true;
            }
        }
        if (!hayAlguna) {
            sb.append("  No hay atracciones con alerta de capacidad.\n");
        }
        return sb.toString();
    }

    public ArrayList<Atraccion> getAtracciones() {
        return atracciones;
    }
}
