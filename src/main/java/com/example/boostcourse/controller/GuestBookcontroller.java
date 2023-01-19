package com.example.boostcourse.controller;

import com.example.boostcourse.domain.Guestbook;
import com.example.boostcourse.service.Guestbookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;


@Controller
public class GuestBookcontroller {
    
    @GetMapping("/guestbooks")//로컬호스트뒤에 guestbooks붙으면 guestbooks.html로이동시킴
    public String guestbook(Model model){
        model.addAttribute("data", "hello!!!");//암것도아님
        List<Guestbook> guestbooks = guestbookservice.findGuestbook();
        model.addAttribute("guestbook", guestbooks);
        return "guestbooks";
        
    }
    private final Guestbookservice guestbookservice;
    @Autowired
    public GuestBookcontroller(Guestbookservice guestbookservice) {
        this.guestbookservice = guestbookservice;
    }
    
    @PostMapping("/guestbooks")
    public String create(Guestbookform guestbookform)
    {
        Guestbook guestbook = new Guestbook();
        guestbook.setName(guestbookform.getName());
        guestbook.setContent(guestbookform.getContent());
        Date date = new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        guestbook.setRegdate(sqldate);
        guestbookservice.join(guestbook);
        return "redirect:/guestbooks";
    }
    
}
