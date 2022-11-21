/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.daoImpl;

import com.company.daoInter.UserDaoInter;
import com.company.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anar
 */

@Repository()
public class UserDaoImpl implements UserDaoInter {
    
    @PersistenceContext
    EntityManager em;
    
        @Override
        public List<User> getAllUser(String name, String surname, Integer nationalityId) {

            String jpql = "select u from User u where 1=1";

            if(name != null && !name.trim().isEmpty()){
                jpql += " and u.name=:name";
            }
            if(surname != null && !surname.trim().isEmpty()){
                jpql += " and u.surname=:surname ";
            }
            if(nationalityId != null){
                jpql += " and u.nationality.id=:nid ";
            }
            Query query =  em.createQuery(jpql,User.class);

            if(name != null && !name.trim().isEmpty()){
                query.setParameter("name", name);
            }
            if(surname != null && !surname.trim().isEmpty()){
                query.setParameter("surname", surname);
            }
            if(nationalityId !=null){
                query.setParameter("nid", nationalityId);
            }

            return query.getResultList();
        }
    
     @Override
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
                
    }
    
     @Override
    public boolean removeUser(int Id) {
        User u = em.find(User.class, Id);
        em.remove(u);
        return true;
    }
    
     @Override
    public User getById(int userId) {
        User u = em.find(User.class, userId);
        return u;
    }

    @Override
    public boolean addUser(User u) {
        em.persist(u);
        return true;
    }


//    @Override
//    public User findByEmailAndPassword(String email, String password) {
//       Query query = em.createQuery("select u from User u where u.email =:e and u.password =:p",User.class);
//       query.setParameter("e", email);
//       query.setParameter("p", password);
//       List<User> list = query.getResultList();
//       if(list.size() == 1){
//           return list.get(0);
//       }
//       return null;
//    }
    
     @Override
    public User findByEmailAndPassword(String email, String password) {
       CriteriaBuilder cb = em.getCriteriaBuilder();
       CriteriaQuery<User> cq = cb.createQuery(User.class);
       Root<User> rr = cq.from(User.class);
       CriteriaQuery<User> cq2 = cq.where(cb.equal(rr.get("email"), email),cb.equal(rr.get("password"),password));
       Query query = em.createQuery(cq2);
       List<User> list = query.getResultList();
       if(list.size() == 1){
           return list.get(0);
       }
       return null;
    }

//    @Override
//    public User findByEmail(String email) {
//       Query query = em.createQuery("select u from User u where u.email =:e",User.class);
//       query.setParameter("e", email);
//       List<User> list = query.getResultList();
//       if(list.size() == 1){
//           return list.get(0);
//       }
//       return null;
//    }
    
//    @Override
//    public User findByEmail(String email) {
//       CriteriaBuilder cb = em.getCriteriaBuilder();
//       CriteriaQuery<User> cq = cb.createQuery(User.class);
//       Root<User> rr = cq.from(User.class);
//       CriteriaQuery<User> cq2 = cq.where(cb.equal(rr.get("email"), email));
//       Query query = em.createQuery(cq2);
//       List<User> list = query.getResultList();
//       if(list.size() == 1){
//           return list.get(0);
//       }
//       return null;
//    }
    
//    @Override
//    public User findByEmail(String email) {
//        Query query = em.createNamedQuery("User.findByEmail",User.class);
//        query.setParameter("email", email);
//      List<User> list = query.getResultList();
//       if(list.size() == 1){
//           return list.get(0);
//       }
//       return null;
//    }
    
    @Override
    public User findByEmail(String email) {
        Query query = em.createNativeQuery("select * from user where email = ?", User.class);
        query.setParameter(1, email);
        List<User> list = query.getResultList();
       if(list.size() == 1){
           return list.get(0);
       }
       return null;
    }

}
