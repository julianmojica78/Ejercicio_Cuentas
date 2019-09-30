/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *clase que hace referencia  ala tabla cuenta de la base de datos con todos sus atributos
 * @author Jonathan
 */
@Entity
@Table
@NamedQueries({
    @NamedQuery(name = "traeCuentas",query = "SELECT inv.cuenta FROM Cuenta inv WHERE inv.inversor.id = :inversor" ),
    @NamedQuery(name = "buscaCuentas",query = "SELECT inv FROM Cuenta inv "),
    @NamedQuery(name = "cuentaEditar",query = "SELECT inv FROM Cuenta inv  WHERE inv.cuenta = :cuenta")
})

public class Cuenta implements Serializable{
    /**
     * atributo autoincrementable que hace referencia al id de la tabla en base de datos
     */
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    /**
     * atributo que hace referencia al numero de cuenta perteneciente a un inversor
     */
    @Column
    private int cuenta;

    /**
     * atributo que hace referencia al inversor propietario de la cuenta
     */
    @OneToOne
    @JoinColumn(name = "inversor_id")
    private Inversor inversor;

    /**
     * constructor vacio de la clase
     */
    public Cuenta() {
    }
/**
 * constructor de la clase
 * @param cuenta numero que se le asignara a la cuenta
 * @param inversor datos del inversor propietario de la cuenta
 */
    public Cuenta(int cuenta, Inversor inversor) {
        this.cuenta = cuenta;
        this.inversor = inversor;
    }   
    
    /**
     * retorna el valor del id de la cuenta en base de datos
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * modifica el valor del id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * retorna el numero de cuenta
     * @return int
     */
    public int getCuenta() {
        return cuenta;
    }

    /**
     * modifica el numero de la cuenta
     * @param cuenta 
     */
    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * retorna el objeto con los datos del inversor propietario de la cuenta
     * @return  Inversor
     */
    public Inversor getInversor() {
        return inversor;
    }

    /**
     * modifica los datos del inversor
     * @param inversor 
     */
    public void setInversor(Inversor inversor) {
        this.inversor = inversor;
    }
    
    
}
