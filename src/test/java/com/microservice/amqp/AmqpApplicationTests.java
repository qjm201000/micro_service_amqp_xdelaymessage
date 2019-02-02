package com.microservice.amqp;

import com.microservice.amqp.send.XdelaySender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpApplicationTests {

    @Autowired
    XdelaySender xdelaySender;

    /**
     * 发送三条消息，设置延时时间，谁时间到了，谁就消费
     */
    @Test
    public void test() {
        xdelaySender.send("我来发一个测试消息,10秒", 10000);//10秒
        xdelaySender.send("我来发一个测试消息，2秒", 2000);//2秒
        xdelaySender.send("我来发一个测试消息，1秒", 2000);//1秒

        //让服务一直挂起，不然，接收消息时，服务已经停了
        while(true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

