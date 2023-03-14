package com.clinical.metamorfose.models.enums;

public enum Perfil {
    ADM(0, "ROLE_ADM"), ESPECIALISTA(1,"ROLE_ESPECIALISTA"), RECEPCIONISTA(2, "ROLE_RECEPCIONISTA"), PACIENTE(3, "ROLE_´PACIENTE");

    Perfil(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    private Integer codigo;
    private String descricao;

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum(Integer codigo) {
        if (codigo == null){
            return null;
        }
        for (Perfil perfil : Perfil.values()){
            if (codigo.equals(perfil.getCodigo())){
                return perfil;
            }
        }
        throw  new IllegalArgumentException("Perfil inválido");
    }
}
