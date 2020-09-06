package pers.study.cmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.study.cmybatis.model.People;
import pers.study.cmybatis.service.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @RequestMapping("getPeople/id/{id}")
    public String GetUser(@PathVariable Integer id) {
        People p = peopleService.queryById(id);
        People p2 = peopleService.queryById(id);
        System.out.println(p==p2);
        return p.getFirstName() + "." + p.getLastName();
    }

    @RequestMapping("getPeople/name/{fname}")
    public String GetUser(@PathVariable String fname) {
        People p = peopleService.queryByFName(fname);
        People p2 = peopleService.queryByFName(fname);
        System.out.println(p==p2);
        return p.getFirstName() + "." + p.getLastName();
    }
}
