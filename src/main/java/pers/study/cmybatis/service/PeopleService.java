package pers.study.cmybatis.service;

import org.springframework.stereotype.Service;
import pers.study.cmybatis.mapper.PeopleMapperExt;
import pers.study.cmybatis.model.People;

import javax.annotation.Resource;

@Service
public class PeopleService {


    @Resource
    PeopleMapperExt peopleMapperExt;

    public People queryByIdName(int id){
      return  peopleMapperExt.selectByPrimaryKey(id);
    }
}
