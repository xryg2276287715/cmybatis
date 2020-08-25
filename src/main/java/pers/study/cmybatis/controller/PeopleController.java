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

    @RequestMapping("getPeople/{id}")
    public String GetUser(@PathVariable Integer id) {
        People p = peopleService.queryByIdName(id);
        return p.getFirstName() + "." + p.getLastName();
    }
}
