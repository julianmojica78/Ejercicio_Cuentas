/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.io.Serializable;

/**
 *metodo que contiene los datos de la tabla usuario
 * @author Jonathan
 */
public class Usuario implements Serializable{
    
    /**
     * atributo que contiene el id de la base de datos
     */
    private int id;
    
    /**
     * metodo que contiene el nombre del inverosr
     */
    private String nombre;

    /**
     * atributo que contiene los datos de la cuenta del inversor
     */
    private CuentaUser cuentaUser;
    /**
     * costructor de la clase
     */
    public Usuario() {
    }

    /**
     * constructor de la clase
     * @param nombre 
     */
    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CuentaUser getCuentaUser() {
        return cuentaUser;
    }

    public void setCuentaUser(CuentaUser cuentaUser) {
        this.cuentaUser = cuentaUser;
    }
    
    
    
}
