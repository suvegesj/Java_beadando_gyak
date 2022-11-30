package com.beadando.eaw2hg;

import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String getMain() { return "index";  }

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationFrom(Model model) {
        model.addAttribute("user", new User());
        return "registration_form";
    }
    @PostMapping("/registering")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "register_success";
    }

    @GetMapping("/contact")
    public String getContact(Model model) {
        model.addAttribute("messagetext", new Message());
        return "contact"; }

    @PostMapping("/sending")
    public String sendMessage(Message messagetext, Model model) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        messagetext.setDate(formatter.format(date));
        model.addAttribute(messagetext);
        messageRepository.save(messagetext);
        //return "redirect:/messages";
        return "message_sent";
    }

    @GetMapping("/messages")
    public String listMessages(Model model) {
        List<Message> listMessages = messageRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
        model.addAttribute("listMessages", listMessages);
        return "messages";

    }


}
