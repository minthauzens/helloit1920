package lv.helloit.bootcamp.sweeter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SweetController {

    private final SweetService sweetService;

    public SweetController(SweetService sweetService) {
        this.sweetService = sweetService;
    }

    @GetMapping("/sweets")
    String getSweets(Model model) {
        model.addAttribute("sweets", sweetService.getAllSweets());
        return "sweets";
    }

    @GetMapping("/sweet/{id}")
    String getSweet(Model model, @PathVariable("id") Long id) {
        model.addAttribute("sweet", sweetService.getSweetById(id));
        return "sweet";
    }

}
