/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectolibreria1;

import com.mycompany.proyectolibreria1.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author gabom
 */
public class PrestamoLibroJpaController implements Serializable {

    public PrestamoLibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public PrestamoLibroJpaController(){ emf= Persistence.createEntityManagerFactory("JpaLibreriaPU");}
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PrestamoLibro prestamoLibro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(prestamoLibro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PrestamoLibro prestamoLibro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            prestamoLibro = em.merge(prestamoLibro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = prestamoLibro.getIdPrestamo();
                if (findPrestamoLibro(id) == null) {
                    throw new NonexistentEntityException("The prestamoLibro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PrestamoLibro prestamoLibro;
            try {
                prestamoLibro = em.getReference(PrestamoLibro.class, id);
                prestamoLibro.getIdPrestamo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The prestamoLibro with id " + id + " no longer exists.", enfe);
            }
            em.remove(prestamoLibro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PrestamoLibro> findPrestamoLibroEntities() {
        return findPrestamoLibroEntities(true, -1, -1);
    }

    public List<PrestamoLibro> findPrestamoLibroEntities(int maxResults, int firstResult) {
        return findPrestamoLibroEntities(false, maxResults, firstResult);
    }

    private List<PrestamoLibro> findPrestamoLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PrestamoLibro.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public PrestamoLibro findPrestamoLibro(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PrestamoLibro.class, id);
        } finally {
            em.close();
        }
    }

    public int getPrestamoLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PrestamoLibro> rt = cq.from(PrestamoLibro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
