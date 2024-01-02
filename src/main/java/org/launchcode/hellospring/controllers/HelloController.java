package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    //handles path at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //handles path at /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("german")) {
            greeting = "Hallo";
        }

        return greeting + " " + n;
    }


}
