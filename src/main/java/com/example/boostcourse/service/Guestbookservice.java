package com.example.boostcourse.service;

import com.example.boostcourse.domain.Guestbook;
import com.example.boostcourse.repository.Guestbookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Guestbookservice {
    
    private final Guestbookrepository guestbookrepository;
    @Autowired
    public Guestbookservice(Guestbookrepository guestbookrepository) {
        
        this.guestbookrepository = guestbookrepository;
    }
    
    public void join(Guestbook guestbook) {
        
        guestbookrepository.save(guestbook);
    }
    
    public List<Guestbook> findGuestbook(){
        return guestbookrepository.find();
    }
}
