package pers.study.cmybatis.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
        RowBounds.class, ResultHandler.class }) })
public class CxPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("+++++call CxPlugin#intercept");
        return invocation.proceed();
    }

//    @Override
//    public Object plugin(Object target) {
//        System.out.println("+++++++call CxPlugin#plugin");
//        return null;
//    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("+++++++call CxPlugin#setProperties");
    }
}
