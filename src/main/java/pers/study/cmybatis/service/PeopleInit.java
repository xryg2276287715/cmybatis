package pers.study.cmybatis.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class PeopleInit implements InitializingBean {

    BlockingQueue<Integer> idQueue = new LinkedBlockingQueue<>();

    @Resource
    private PeopleService peopleService;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("call afterPropertiesSet begin --" + System.currentTimeMillis());
//        Future<People> pf = peopleService.queryByIdBlock(1);
//        People p = pf.get();
//        System.out.println("call afterPropertiesSet end --" + System.currentTimeMillis()+"-people="+ (Objects.isNull(p)?"":p));

        dealIds();
        putIds();
        System.out.println("call afterPropertiesSet end --" + System.currentTimeMillis());
    }


    private void dealIds() {
        System.out.println("call dealIds --" + System.currentTimeMillis());

        ExecutorService announcementExecutor = Executors.newSingleThreadExecutor();
        announcementExecutor.execute(() -> {
            for (; ; ) {
                try {
                    Integer id = idQueue.take();
                    System.out.println("+++++dealIds:" + id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void putIds() {
        try {
            System.out.println("call putIds --" + System.currentTimeMillis());
            Thread.sleep(60 * 1000);
            List<Integer> ids0 = IntStream.range(1, 5).boxed().collect(Collectors.toList());
            for (Integer id : ids0) {
                idQueue.put(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
