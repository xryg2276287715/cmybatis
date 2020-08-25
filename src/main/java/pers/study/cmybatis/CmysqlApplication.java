package pers.study.cmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("pers.study.cmybatis.mapper")
@SpringBootApplication
public class CmysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmysqlApplication.class, args);
	}

}
