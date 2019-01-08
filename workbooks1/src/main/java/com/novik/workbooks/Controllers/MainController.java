package com.novik.workbooks.Controllers;

import com.novik.workbooks.domain.User;
import com.novik.workbooks.domain.Workbook;
import com.novik.workbooks.repositories.WBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;

@Controller
    public class MainController {

    @Autowired
    private WBookRepo wbookrepo;

        @GetMapping("/")
        public String main(Map<String, Object> model) {

 return "main";
        }


        @GetMapping("/wbooks")
    public String wbooks(Map<String, Object> model){
           Iterable<Workbook> workbooks = wbookrepo.findAll();
            model.put("messages", workbooks);
          return "wbooks";
        }

       @GetMapping("/createWB")
       public String createWb(){
            return "createWB";
       }

       @PostMapping("/createWB")
    public String addWB(@AuthenticationPrincipal User user,
            @RequestParam String name, @RequestParam String spec, @RequestParam String description,
                        @RequestParam String tag, @RequestParam String body) {

            Workbook workbook = new Workbook(name, spec, description, tag, body, user);

            wbookrepo.save(workbook);
          return "redirect:/wbooks";
       }


}
