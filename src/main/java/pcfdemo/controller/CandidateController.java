package pcfdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pcfdemo.repository.CandidateRepository;

@RestController
public class CandidateController {
    private Environment environment;

    public CandidateController() {
    }

    @RequestMapping("/")
    public String getMessage() {
        String message = environment.getProperty("message");
        return String.format("Message: %s", message);
    }}
