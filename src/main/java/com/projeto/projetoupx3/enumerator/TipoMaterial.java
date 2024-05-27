package com.projeto.projetoupx3.enumerator;

public enum TipoMaterial {

    PAPEL("Papel"),
    PLASTICO("Plastico"),
    METAL("Metal"),
    VIDRO("Vidro");

    private String tipoMaterial;

    TipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getTipoMaterial(){
        return tipoMaterial;
    }


}
