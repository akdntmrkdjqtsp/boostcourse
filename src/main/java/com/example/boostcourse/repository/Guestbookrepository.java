package com.example.boostcourse.repository;

import com.example.boostcourse.domain.Guestbook;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class Guestbookrepository {
    private final EntityManager em;
    @Autowired
    public Guestbookrepository(EntityManager em) {
        this.em = em;
    }
    
    public Guestbook save (Guestbook guestbook)
    {
        em.persist(guestbook);
        return guestbook;
    }
    
    public List<Guestbook> find()
    {
        List<Guestbook> result = em.createQuery("select g from Guestbook g", Guestbook.class).getResultList();
        return result;
    }
    
}
