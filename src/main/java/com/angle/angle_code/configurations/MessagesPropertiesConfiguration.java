package com.angle.angle_code.configurations;

import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:messages.properties")
public class MessagesPropertiesConfiguration extends MessageSourceAutoConfiguration {

    // .....
}