/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Entity.Cuenta;
import Entity.Inversor;
import Interfaces.AbstractFacade;
import Interfaces.CuentaFacadeLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jonathan
 */
@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> implements CuentaFacadeLocal {
    @PersistenceContext(unitName = "Udec_EjercicioCuentas-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaFacade() {
        super(Cuenta.class);
    }

    @Override
    public List<Cuenta> findCuentas() {
        TypedQuery<Cuenta> consulta = em.createNamedQuery("buscaCuentas", Cuenta.class);
        return consulta.getResultList();
    }

    @Override
    public List<Cuenta> findCuentasInversor(int id) {
        TypedQuery<Cuenta> consulta = em.createNamedQuery("traeCuentas", Cuenta.class);
        consulta.setParameter("inversor",id);
        return consulta.getResultList();
    }

    @Override
    public Cuenta findCuentaEspecifica(int cuenta) {
        TypedQuery<Cuenta> consulta = em.createNamedQuery("cuentaEditar", Cuenta.class);
        consulta.setParameter("cuenta",cuenta);
        return consulta.getSingleResult();
    }
    
}
