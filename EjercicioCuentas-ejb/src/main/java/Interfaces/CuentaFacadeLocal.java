/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Cuenta;
import Entity.Inversor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jonathan
 */
@Local
public interface CuentaFacadeLocal {

    void create(Cuenta cuenta);

    void edit(Cuenta cuenta);

    void remove(Cuenta cuenta);

    Cuenta find(Object id);

    List<Cuenta> findAll();

    List<Cuenta> findRange(int[] range);

    int count();
    
    List<Cuenta> findCuentas();
    
    List<Cuenta> findCuentasInversor(int id);
    
    Cuenta findCuentaEspecifica(int cuenta);
}
