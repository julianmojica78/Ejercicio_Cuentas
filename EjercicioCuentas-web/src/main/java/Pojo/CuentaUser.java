/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.io.Serializable;

/**
 *metodo que contiene los datos de la tabla inversor
 * @author Jonathan
 */
public class CuentaUser implements Serializable{
    /**
     * atributo que contiene el id de la tabla
     */
    private int id;
    
    /**
     * metodo que contiene el numero de cuenta
     */
    private int cuenta;
    
    /***
     * metodo que contiene el usuario de la cuenta
     */
    private Usuario usuario;

    /**
     * constructor de la clase
     */
    public CuentaUser() {
    }

    /**
     * constructor con atributos de la clase
     * @param cuenta
     * @param usuario 
     */
    public CuentaUser(int cuenta, Usuario usuario) {
        this.cuenta = cuenta;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
