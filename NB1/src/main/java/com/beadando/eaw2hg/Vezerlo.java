package com.beadando.eaw2hg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller


public class Vezerlo {
    @Autowired
    private labdarugoRepo labdarugoRepo;
    @Autowired
    private klubRepo klubRepo;
    @Autowired
    private posztRepo posztRepo;
    @GetMapping("/")
    public String Fooldal(Model model, String uzenet) {
        String str = A();
        model.addAttribute("str", str);
        return "index";
    }
    String A(){
        String str="";
        for(labdarugo labdarugo: labdarugoRepo.findAll()){
            str+=labdarugo.getId()+"; "+labdarugo.getMezszám()+"; "+labdarugo.getKlubid()+"; "+labdarugo.getPosztid()+"; "+labdarugo.getUtónév()+"; "+labdarugo.getVezetéknév()+"; "+labdarugo.getSzületési_idő()+"; "+labdarugo.getMagyar()+"; "+labdarugo.getKülföldi()+"; "+labdarugo.getÉrték();
            str+="<br>";
        }
        str+="<br>";
        for(klub klub: klubRepo.findAll()){
            str+=klub.getId()+"; "+klub.getCsapatnév();
            str+="<br>";
        }
        str+="<br>";
        for(poszt poszt: posztRepo.findAll()){
            str+=poszt.getId()+"; "+poszt.getNév();
            str+="<br>";
        }
        return str;
    }
}


