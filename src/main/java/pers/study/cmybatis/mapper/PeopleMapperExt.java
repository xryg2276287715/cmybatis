package pers.study.cmybatis.mapper;

import org.apache.ibatis.annotations.Param;
import pers.study.cmybatis.model.People;

public interface PeopleMapperExt extends PeopleMapper {

    People selectByFirstName(@Param("firstName")String firstName);
}