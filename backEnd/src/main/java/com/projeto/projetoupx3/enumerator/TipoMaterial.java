package com.projeto.projetoupx3.enumerator;



public enum TipoMaterial {

    PAPEL("PAPEL"),
    METAL("METAL"),
    PLASTICO("PLASTICO"),
    VIDRO("VIDRO");

    private String tipoMaterial;

    TipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }
}
