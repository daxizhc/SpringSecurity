package com.imooc.security.asyn;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder resultHolder;

    @Override
    // spring 容器初始化完毕的事件
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(() -> {
            while (true){
                if(StringUtils.isNoneBlank(mockQueue.getCompleteOrder())){
                    String orderNum = mockQueue.getCompleteOrder();
                    logger.info("返回订单处理结果: " + orderNum);
                    resultHolder.getMap().get(orderNum).setResult("place order success");
                    mockQueue.setCompleteOrder(null);
                }else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }
}
