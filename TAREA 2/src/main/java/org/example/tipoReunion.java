package org.example;

/**
 * ENUM CON LOS TIPOS DE REUNION
 */
public enum tipoReunion {
    TECNICA(1),
    MARKETING(2),
    OTRO(3);

    private final int tipo;

    /**
     * Constructor del ENUM, que relaciona un número con cada tipo de reunión.
     * @param tipo de reunión identificada con un número.
     */
    tipoReunion(int tipo) {
        this.tipo = tipo;
    }
}
