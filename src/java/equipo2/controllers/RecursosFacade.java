/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo2.controllers;

import equipo2.models.Recursos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author indiana
 */
@Stateless
public class RecursosFacade extends AbstractFacade<Recursos> {

    @PersistenceContext(unitName = "pi-equipo2-5DPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecursosFacade() {
        super(Recursos.class);
    }
    
}
