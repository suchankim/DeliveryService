package deliveryservice.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import deliveryservice.config.kafka.KafkaProcessor;
import deliveryservice.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_Notify(@Payload CookStarted cookStarted) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener Notify : " + cookStarted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Picked'"
    )
    public void wheneverPicked_Notify(@Payload Picked picked) {
        Picked event = picked;
        System.out.println("\n\n##### listener Notify : " + picked + "\n\n");
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Delivered'"
    )
    public void wheneverDelivered_Notify(@Payload Delivered delivered) {
        Delivered event = delivered;
        System.out.println("\n\n##### listener Notify : " + delivered + "\n\n");
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderAccepted'"
    )
    public void wheneverOrderAccepted_Notify(
        @Payload OrderAccepted orderAccepted
    ) {
        OrderAccepted event = orderAccepted;
        System.out.println(
            "\n\n##### listener Notify : " + orderAccepted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderRejected'"
    )
    public void wheneverOrderRejected_Notify(
        @Payload OrderRejected orderRejected
    ) {
        OrderRejected event = orderRejected;
        System.out.println(
            "\n\n##### listener Notify : " + orderRejected + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookFinished'"
    )
    public void wheneverCookFinished_Notify(
        @Payload CookFinished cookFinished
    ) {
        CookFinished event = cookFinished;
        System.out.println(
            "\n\n##### listener Notify : " + cookFinished + "\n\n"
        );
        // Sample Logic //

    }
}
