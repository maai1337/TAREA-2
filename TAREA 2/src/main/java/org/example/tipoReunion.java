package org.example;

/**
 * ENUM CON LOS TIPOS DE REUNION
 */
public enum tipoReunion {

    TECNICA(1),
    SOCIAL(2),
    OTRO(3);

    private final int tipo;

    tipoReunion(int tipo) {
        this.tipo = tipo;
    }
}
