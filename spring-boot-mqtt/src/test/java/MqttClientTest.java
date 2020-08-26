import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttClientTest {

    public static final MemoryPersistence dataStore = new MemoryPersistence();
    public static final String serverUrl="tcp://192.168.99.99:2883";
    public static final String clientId="test";
    public static void main(String[] args) throws MqttException {
        MqttClient client=new MqttClient(serverUrl,clientId,dataStore);
        client.setCallback(new MqttCallback() {

            @Override
            public void connectionLost(Throwable cause) {
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws MqttException {
                System.out.println("messageArrived");
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token){
            }
        });
        client.connect();
        client.subscribe("topic",1);
        client.publish("topic",new MqttMessage("hello".getBytes()));
        client.publish("topic",new MqttMessage("world".getBytes()));
    }
}
