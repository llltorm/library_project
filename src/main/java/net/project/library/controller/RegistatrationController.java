package net.project.library.controller;

import net.project.library.model.Reader;

import net.project.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistatrationController {
//    @Autowired
//    private ReaderRepository readerRepository;
//    private final TutorService tutorService;
//    private final AdminService adminService;
//    private final CustomUserService userEntityService;
//    private final PasswordConfig passwordConfig;
//
//    @GetMapping("/registration")
//    public String registration() {
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String registrationNewReader(Reader reader, Map<String, Object> model) {
//        Reader readerFromDB = readerRepository.findByName(reader.getName());
//        if (readerFromDB != null){
//            model.put("message", " User exists");
//            return "registration";
//        }
//        //reader.setRoles(Collections.singleton(Role.USER));
//        reader.setTelegram("telegramAddress");
//        reader.setEmail("emailAddress");
//        readerRepository.save(reader);
//        return "redirect:/login";
//    }

    //    @GetMapping("/logout")
//    @Override
//    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
//        super.logout(request, response, authentication);
//    }

//    @GetMapping("/logout")
//    public String logout1() {
//        SecurityContextHolder.clearContext();
//        return "logout";
//    }

    @GetMapping("/login")
    public String ShowLoginForm() {
        return "login";
    }
//
    @PostMapping ("/login")
    public String loginUser() {
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/")
    public String redirectHomePage() {
        return "home";
    }
//@PostMapping("/login")
//public String loginStudent(@ModelAttribute Student student, Model model) {
//    System.out.println("login post request = " + student);
//    UserEntity authenticatedStudent = userEntityService.authenticate(student.getUsername(), student.getPassword());
//    System.out.println("second post works");
//    if (authenticatedStudent != null) {
//        model.addAttribute("au", studentService.getCertainStudentById(student.getId()));
//        System.out.println("login second post works");
//        return "menuPages/infoPage";
//    } else return "logPages/errorPage";
//}
}
