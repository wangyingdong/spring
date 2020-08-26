package com.f139.mqtt.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@ToString
@Component
@ConfigurationProperties(prefix = "spring.mqtt")
public class MqttProperties {

    private String username;

    private String password;

    private String[] hostUrl;

    private String senderClientId;

    private String receiverClientId;

    private String defaultTopic;

    private int connectionTimeout;


}
