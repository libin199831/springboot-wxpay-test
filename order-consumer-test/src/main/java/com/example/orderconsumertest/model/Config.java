package com.example.orderconsumertest.model;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    //随机  模型和配置应该有区别把？
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }

    /**
     * 轮询
     * @Bean
     *     public IRule iRule(){
     *         return new RoundRobinRule();
     *     }
     */
}
