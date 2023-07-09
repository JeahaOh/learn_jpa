package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by jeaha on 2023/07/09
 */
@Controller
public class HellController {
    
    @GetMapping("/hell")
    public String hell(Model model) {
        model.addAttribute("data", "hell");
        return "hell";
    }
}
