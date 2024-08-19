package org.delivery.api.config.rabbitmq;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// 반드시 패키지를 불러올때, amqp 시작하는 패키지에 있는 클래스를 불러와야함.
@Configuration
public class RabbitMqConfig {

    // exchange 생성(이름 설정 가능)
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("delivery.exchange");
    }

    // Message Queue 생성(amqp 패키지에 있는 큐를 가져와야 함)
    @Bean
    public Queue queue(){
        return new Queue("delivery.queue");
    }

    // exchange와 queue를 키를 가지고 연결
    @Bean
    public Binding binding(DirectExchange directExchange, Queue queue){
        return BindingBuilder.bind(queue).to(directExchange).with("delivery.key");
    }

    // 이 위까지 queue 기본 설정


    /**
     * RabbitTemplate은 메시지를 송신하거나 수신할 때 사용되는 주요 객체입니다.
     * 이 메서드는 RabbitMQ와의 연결을 설정하는 ConnectionFactory와
     * 메시지 변환을 담당하는 MessageConverter를 받아서 RabbitTemplate을 설정합니다.
     * @param connectionFactory (application.yaml에서 별도로 설정)
     * @param messageConverter
     * @return
     */
    public RabbitTemplate rabbitTemplate(
            ConnectionFactory connectionFactory,
            MessageConverter messageConverter
    ){
        var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    /**
     * 메시지를 JSON 형식으로 변환하는 MessageConverter를 설정합니다.
     * ObjectMapper는 JSON 변환에 사용되며,
     * Jackson2JsonMessageConverter는 이를 활용하여 메시지를 직렬화 및 역직렬화합니다.
     * ObjectMapperConfig에서 설정한 mapper bean을 연결
     * @param objectMapper
     * @return
     */
    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper){
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
