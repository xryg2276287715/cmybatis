package pers.study.cmybatis.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import pers.study.cmybatis.mapper.PeopleMapperExt;
import pers.study.cmybatis.model.People;

import javax.annotation.Resource;
import java.util.concurrent.Future;

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


    @Async
    public Future<People> queryByIdBlock(int id){
        try {
            System.out.println("call queryByIdBlock begin--"+System.currentTimeMillis());
            Thread.sleep(60*1000);
            return new AsyncResult(queryById(id));
        } catch (InterruptedException e) {
            e.printStackTrace();
            return new AsyncResult(null);
        }finally {
            System.out.println("call queryByIdBlock end--"+System.currentTimeMillis());
        }
    }

}
