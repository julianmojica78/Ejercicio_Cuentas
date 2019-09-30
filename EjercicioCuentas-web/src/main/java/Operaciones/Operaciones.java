/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Entity.Cuenta;
import Entity.Inversor;
import Interfaces.CuentaFacadeLocal;
import Interfaces.InversorFacadeLocal;
import Pojo.CuentaUser;
import Pojo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *clase que contiene las operaciones realizadas con los datos de inversores y cuentas
 * @author Jonathan
 */
@Named(value = "operaciones")
@SessionScoped
public class Operaciones implements Serializable {

    /**
     * atibuto que hace referencia a la clase CuentaFacadeLocal del paquete EJB 
     */
    @EJB
    CuentaFacadeLocal cuentaLocal;

    /**
     * atibuto que hace referencia a la clase InversorFacadeLocal del paquete EJB 
     */
    @EJB
    InversorFacadeLocal inversor;

    /**
     * objeto que hace referencia a la clase Usuario
     */
    Usuario usuario;

    /**
     * objeto que hace referencia a la clase CuentaUser
     */
    CuentaUser cuentaUser;
/**
 * objeto que hace referecia a la clase Inversor
 */
    Inversor inver;

    /**
     * objeto que hace referencia  a la clase Cuenta
     */
    Cuenta cuenta;

    /**
     * atributos que son utilizados para dar control a componentes de la vista
     */
    String nombreUsuario = "", nombreEditar, inversorCuenta;

    /**
     * atributos que son utilizados para dar control a componentes de la vista
     */
    int cuentaUsuario,cuentaNueva;

    /**
     * lista que recibe objetos del tipo Cuenta
     */
    List<Cuenta> cuentas;

    /**
     * constructor de la clase
     */
    public Operaciones() {
        usuario = new Usuario();
        cuentaUser = new CuentaUser();
    }

    /**
     * metodo que agrega un inersor solo
     * @param nombre 
     */
    public void agregarInversor(String nombre) {
        inver = new Inversor(nombre);
        inversor.create(inver);
    }

    /**
     * metodo que trae de base de datos los inversores guardados
     * @return 
     */
    public List<Inversor> traerInversores() {
        List<Inversor> lista = inversor.findAll();
        return lista;
    }

    /**
     * metodo uqe trae los nombres solamente de los inversores guardados en base de datos
     * @return 
     */
    public List<String> traerNombres() {
        List<Inversor> lista = inversor.findAll();
        List<String> lista2 = new ArrayList();
        for (Inversor lista1 : lista) {
            lista2.add(lista1.getNombre());
        }
        return lista2;
    }

    /**
     * metodo que trae de base de datos las cuentas creadas
     * @return 
     */
    public List<Cuenta> traerCuentas() {
        List<Cuenta> cuent = cuentaLocal.findAll();
        return cuent;
    }

    /**
     * metodo qe agrega una cuenta solamente
     * @param nombre
     * @param numero 
     */
    public void agregarCuentaSolo(String nombre, int numero) {
        Inversor inversor1 = inversor.findName(nombre);
        if (inversor1.getCuenta() == null) {
            Cuenta cuenta = new Cuenta(numero, inversor1);
            cuentaLocal.create(cuenta);
        } else {
            FacesMessage message = new FacesMessage("Ya existe una cuenta asociada a ese inversor");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    /**
     * metodo quee agrega un inversor y una cuenta simultaneamente
     * @param nombre
     * @param numero 
     */
    public void agregarCuenta(String nombre, int numero) {
        Inversor inversor1 = new Inversor(nombre);
        Cuenta cuenta = new Cuenta(numero, inversor1);
        inversor1.setCuenta(cuenta);
        inversor.create(inversor1);
    }

    /**
     * metodo que edita desde el inversor
     * @param nombre
     * @param nombreNuevo 
     */
    public void editarDesdeInversor(String nombre, String nombreNuevo) {
        inver = inversor.findName(nombre);
        inver.setNombre(nombreNuevo);
        inversor.edit(inver);

    }
/**
 * metodo que edita desde la cuenta
 * @param cuentaUser
 * @param cuentaNueva 
 */
    public void editarDesdeCuenta(int cuentaUser, int cuentaNueva) {
        cuenta = cuentaLocal.findCuentaEspecifica(cuentaUser);
        cuenta.setCuenta(cuentaNueva);
        cuentaLocal.edit(cuenta);
    }

    /**
     * metodo que se ejecuta al seleccionar algun elemento en un componente especifico de la vista
     */
    public void onCountryChange() {
        inver = inversor.findName(nombreUsuario);
        if (nombreUsuario != null && !nombreUsuario.equals("")) {
            cuentas = cuentaLocal.findCuentasInversor(inver.getId());
        } else {
            cuenta = new Cuenta();
        }
    }

    /**
     * metodo que elimina desde el inversor
     * @param inv 
     */
    public void eliminarDesdeInversor(Inversor inv) {
        Inversor inversor1 = inversor.find(inv.getId());
        inversor.remove(inversor1);
    }

    /**
     * metodo que elimina desde la cuenta
     * @param cuenta1 
     */
    public void eliminarDesdeCuenta(Cuenta cuenta1) {
        Cuenta cuenta = cuentaLocal.find(cuenta1.getId());
        cuentaLocal.remove(cuenta);
    }

    public InversorFacadeLocal getInversor() {
        return inversor;
    }

    public void setInversor(InversorFacadeLocal inversor) {
        this.inversor = inversor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CuentaUser getCuentaUser() {
        return cuentaUser;
    }

    public void setCuentaUser(CuentaUser cuentaUser) {
        this.cuentaUser = cuentaUser;
    }

    public Inversor getInver() {
        return inver;
    }

    public void setInver(Inversor inver) {
        this.inver = inver;
    }

    public CuentaFacadeLocal getCuentaLocal() {
        return cuentaLocal;
    }

    public void setCuentaLocal(CuentaFacadeLocal cuentaLocal) {
        this.cuentaLocal = cuentaLocal;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(int cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public int getCuentaNueva() {
        return cuentaNueva;
    }

    public void setCuentaNueva(int cuentaNueva) {
        this.cuentaNueva = cuentaNueva;
    }

    public String getNombreEditar() {
        return nombreEditar;
    }

    public void setNombreEditar(String nombreEditar) {
        this.nombreEditar = nombreEditar;
    }

    public String getInversorCuenta() {
        return inversorCuenta;
    }

    public void setInversorCuenta(String inversorCuenta) {
        this.inversorCuenta = inversorCuenta;
    }

}
