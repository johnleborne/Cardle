package cardle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @GetMapping("/api/test")
    public String test() {
        return "Cardle backend is working!";
    }
}