/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo2.controllers;

import equipo2.models.RankingRepositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author indiana
 */
@Stateless
public class RankingRepositorioFacade extends AbstractFacade<RankingRepositorio> {

    @PersistenceContext(unitName = "pi-equipo2-5DPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RankingRepositorioFacade() {
        super(RankingRepositorio.class);
    }
    
}
