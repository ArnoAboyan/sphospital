package com.hospital.sphospital.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

//    @PostMapping("/registerdoctor")
//    public ResponseEntity<AuthenticationResponse> registerDoctor(
//            @RequestBody RegisterRequest request
//    )
//    {
//        return ResponseEntity.ok(service.registerDoctor(request));
//    }

    @PostMapping("/registeradmin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody RegisterRequest request
    )
    {
        return ResponseEntity.ok(service.registerAdmin(request));
    }

    @GetMapping("/authenticate")
    public String authenticate(@RequestParam("login") String login,
                               @RequestParam("password") String password
    )
    {

        AuthenticationRequest authenticate = new AuthenticationRequest(login, password);
        System.out.println(authenticate);
        service.authenticate(authenticate);
        return "redirect:/doctors";
    }

    @GetMapping("/authpage")
    public String loginPage()
    {


        return "auth";
    }


//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> authenticate(
//            @RequestBody AuthenticationRequest request
//    )
//    {
//        return ResponseEntity.ok(service.authenticate(request));
//    }




}
