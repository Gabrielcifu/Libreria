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
public class UsuarioLibreriaJpaController1 implements Serializable {

    public UsuarioLibreriaJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public UsuarioLibreriaJpaController1(){ emf= Persistence.createEntityManagerFactory("JpaLibreriaPU");}
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioLibreria usuarioLibreria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioLibreria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioLibreria usuarioLibreria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioLibreria = em.merge(usuarioLibreria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = usuarioLibreria.getIdUsuario();
                if (findUsuarioLibreria(id) == null) {
                    throw new NonexistentEntityException("The usuarioLibreria with id " + id + " no longer exists.");
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
            UsuarioLibreria usuarioLibreria;
            try {
                usuarioLibreria = em.getReference(UsuarioLibreria.class, id);
                usuarioLibreria.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioLibreria with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioLibreria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioLibreria> findUsuarioLibreriaEntities() {
        return findUsuarioLibreriaEntities(true, -1, -1);
    }

    public List<UsuarioLibreria> findUsuarioLibreriaEntities(int maxResults, int firstResult) {
        return findUsuarioLibreriaEntities(false, maxResults, firstResult);
    }

    private List<UsuarioLibreria> findUsuarioLibreriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioLibreria.class));
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

    public UsuarioLibreria findUsuarioLibreria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioLibreria.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioLibreriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioLibreria> rt = cq.from(UsuarioLibreria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
