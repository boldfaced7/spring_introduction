package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-mvc";
    }
    @GetMapping("hello-string")
    @ResponseBody // http 통신 프로토콜에는 헤더와 바디가 존재하는데, 응답 바디에 해당 메소드의 반환값을 데이터를 직접 넣어주겠다는 것
    public String helloString(@RequestParam("name") String name) {
        return "hello + " + name;
    }
}
