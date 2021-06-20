package ar.com.ada.api.empleadas.entities;

import java.math.BigDecimal;

public class Categoria {
    private Integer categoria_Id;

    private String nombre;

    private BigDecimal sueldoBase;

    public Integer getCategoria_Id() {
        return categoria_Id;
    }

    public void setCategoria_Id(Integer categoria_Id) {
        this.categoria_Id = categoria_Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(BigDecimal sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    

}
