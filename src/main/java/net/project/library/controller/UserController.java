//package net.project.library.controller;
//
//import net.project.library.config.PasswordConfig;
//import net.project.library.model.Reader;
//import net.project.library.model.User;
//import net.project.library.service.ReaderService;
//import net.project.library.service.UserEntityService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class UserController {
//    private final ReaderService readerService;
//    //private final TutorService tutorService;
//    //private final AdminService adminService;
//    private final UserEntityService userEntityService;
//    private final PasswordConfig passwordConfig;
//
//
//    public UserController(ReaderService readerService,
//                          UserEntityService userEntityService,
//                          PasswordConfig passwordConfig) {
//        this.readerService = readerService;
//        this.userEntityService = userEntityService;
//        this.passwordConfig = passwordConfig;
//    }
//
//    @GetMapping("/registration")
//    public String getRegisterReader(Model model) {
//        model.addAttribute("registerRequestReader", new Reader());
//        return "registration";
//
//    }
//
//    @GetMapping("/login")
//    public String getLoginReader(Model model) {
//        model.addAttribute("loginRequestStudent", new Reader());
//        return "login";
//    }
//
//    @PostMapping("/registration")
//    public String registerReader(@ModelAttribute Reader reader) {
//        System.out.println("register post request = " + reader);
//        User registeredStudent = userEntityService.register(reader.getUsername(), reader.getPassword());
//        System.out.println(registeredStudent);
//        System.out.println(registeredStudent.getRole() + "role ---------value it is");
//        System.out.println("register post works");
//        return registeredStudent == null ? "registration" : "redirect:/login";
//    }
//
//    @PostMapping("/login")
//    public String loginReader(@ModelAttribute Reader reader, Model model) {
//        System.out.println("login post request = " + reader);
//        User authenticatedReader = userEntityService.authenticate(reader.getUsername(), reader.getPassword());
//        System.out.println("second post works");
//        if (authenticatedReader != null) {
//            model.addAttribute("au", readerService.findById(reader.getId()));
//            System.out.println("login second post works");
//            return "home";
//        } else return "login";
//    }

//}
