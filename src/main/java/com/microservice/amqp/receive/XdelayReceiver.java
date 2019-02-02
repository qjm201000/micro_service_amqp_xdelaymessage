package com.microservice.amqp.receive;

import com.microservice.amqp.config.XdelayConfig;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableRabbit
@Configuration
public class XdelayReceiver {

    @RabbitListener(queues = XdelayConfig.IMMEDIATE_QUEUE_XDELAY)
    public void get(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("收到延时消息时间："+sdf.format(new Date()) + " Delay sent.");
        System.out.println("收到延时消息:" + msg);
    }
}
