/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 *clase que hace referencia a la tabla inversor de la base de datos con todos sus atributos
 * @author Jonathan
 */
@Entity
@Table
@NamedQueries({
    @NamedQuery(name = "buscaPorNombreInv",query = "SELECT inv FROM Inversor inv WHERE inv.nombre = :nombre")
})
public class Inversor implements Serializable{
    
    /**
     * atributo que hace referencia al id de la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    /**
     * atributo que hace referencia al nombre dle inversor
     */
    @Column
    private String nombre;
    
    /**
     * objeto que hace referencia a la conexion entre inversor y cuenta
     */
    @OneToOne(mappedBy = "inversor",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Cuenta cuenta;

    /**
     * constructor de la clase vacio
     */
    public Inversor() {
    }

    /**
     * constructor de la clase
     * @param nombre 
     */
    public Inversor(String nombre) {
        this.nombre = nombre;
    }

    /**
     * retorna el id de la tabla
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * modifica el id de la tabla
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * retorna el valor del nombre del inversor
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * modifica el nombre del inversor
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * retorna los datos relacionados a la cuenta del inversor
     * @return Cuenta
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * modifica los datos de la cuenta del inversor
     * @param cuenta 
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    
    
}
