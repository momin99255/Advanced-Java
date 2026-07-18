package com.momin.classproject1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String indexPage(){
        return "index";
    }

    @GetMapping("contact-us")
    public  String contactPage(){
        return "contact";
    }

   // @PostMapping("contact-us")
  /*  public String submitForm
            (@RequestParam String name,
            // @RequestParam String emailAddress, Names should be same in both backend and frontend
             @RequestParam(name = "email", required = false) String emailAddress,
            // @RequestParam String email, //Right approach
             @RequestParam(required = true) String message){*/
     //   System.out.println(name);
       // System.out.println(emailAddress);
        //System.out.println(email);
      //  System.out.println(message);

   @PostMapping("submit-form")
   public String submitForm(@ModelAttribute Contact contact){
       IO.println(contact);
       //System.out.println(contact);
       log.info("submit form {}", contact);
        return "redirect:/contact-us";
    }

}
