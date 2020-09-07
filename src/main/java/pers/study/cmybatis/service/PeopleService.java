package pers.study.cmybatis.service;

import org.springframework.stereotype.Service;
import pers.study.cmybatis.mapper.PeopleMapperExt;
import pers.study.cmybatis.model.People;

import javax.annotation.Resource;

@Service
public class PeopleService {


    @Resource
    PeopleMapperExt peopleMapperExt;

    public People queryById(int id){
      return  peopleMapperExt.selectByPrimaryKey(id);
    }

    public People queryByFName(String firstName){
//        firstName=";DROP DATABASE (settlement_tmp_cx) --";
        return  peopleMapperExt.selectByFirstName(firstName);
    }

}
