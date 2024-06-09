package com.projeto.projetoupx3.enumerator;


// Enumeração que define os tipos de materiais disponíveis
public enum TipoMaterial {

    PAPEL("PAPEL"),
    METAL("METAL"),
    PLASTICO("PLASTICO"),
    VIDRO("VIDRO");

    private String tipoMaterial;

    TipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    // Obtém o nome do tipo de material
    public String getTipoMaterial() {
        return tipoMaterial;
    }
}
