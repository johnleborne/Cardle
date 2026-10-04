package cardle;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://johnleborne.github.io")
public class GameController {

    @GetMapping("/api/test")
    public String test() {
        return "Cardle backend is working!";
    }
}