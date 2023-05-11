package deliveryservice.domain;

import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Paid extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Integer price;
}
