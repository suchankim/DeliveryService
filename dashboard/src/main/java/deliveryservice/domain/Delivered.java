package deliveryservice.domain;

import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Delivered extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String address;
    private String status;
}
