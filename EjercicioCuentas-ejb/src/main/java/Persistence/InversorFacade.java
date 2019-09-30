/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Entity.Inversor;
import Interfaces.AbstractFacade;
import Interfaces.InversorFacadeLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jonathan
 */
@Stateless
public class InversorFacade extends AbstractFacade<Inversor> implements InversorFacadeLocal {

    @PersistenceContext(unitName = "Udec_EjercicioCuentas-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InversorFacade() {
        super(Inversor.class);
    }

    @Override
    public Inversor findName(String nombre) {
        TypedQuery<Inversor> consulta = em.createNamedQuery("buscaPorNombreInv", Inversor.class);
        consulta.setParameter("nombre", nombre);
        return consulta.getSingleResult();
    }

}
