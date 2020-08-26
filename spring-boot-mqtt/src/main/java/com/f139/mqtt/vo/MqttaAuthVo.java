package com.f139.mqtt.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MqttaAuthVo {


    private String username;
    private String clientid;
    private String protocol;
    private String password;
    private String ipaddress;


}
