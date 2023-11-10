package myanswer01.presentation;

import myanswer01.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("/")
public class MyController {
    @PostMapping("person")
//    @ResponseStatus(code = OK)
    public void postPerson(@RequestBody @Validated Person person) {
        System.out.println(person);
    }
}
