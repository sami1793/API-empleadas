package ar.com.ada.api.empleadas.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.*;
@Entity
@Table(name="categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categoria_id")
    private Integer categoria_Id;

    private String nombre;

    @Column(name="sueldo_base")
    private BigDecimal sueldoBase;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Empleada> empleadas= new ArrayList<>();

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
