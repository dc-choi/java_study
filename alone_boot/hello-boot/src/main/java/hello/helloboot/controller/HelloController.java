package hello.helloboot.controller;

import hello.helloboot.model.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping(value = "hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello"; // viewResolver가 템플릿을 찾음.
    }

    @GetMapping(value = "mvc")
    public String mvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "mvc";
    }

    @GetMapping(value = "string")
    @ResponseBody
    public String getString(@RequestParam(value = "name") String name) {
        return "hello " + name;
    }

    @GetMapping(value = "api")
    @ResponseBody
    public Hello api(@RequestParam(value = "name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        // 기본적으로 @ResponseBody를 선언하고 객체를 반환해주면 JSON으로 처리됨.
        return hello;
        /**
         * @ResponseBody 동작 원리
         *
         * @ResponseBody가 붙게되면 viewResolver 대신에 HttpMessageConverter가 동작함.
         * 문자는 StringHttpMessageConverter, 객체는 MappingJackson2HttpMessageConverter를 사용
         */
    }
}
