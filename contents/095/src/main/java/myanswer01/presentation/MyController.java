package myanswer01.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("/")
public class MyController {
    @GetMapping("hello")
    @ResponseStatus(code = OK)
    public void hello() {
    }

    @GetMapping("goodbye")
    @ResponseStatus(code = OK)
    public void goodbye() {
    }
}
