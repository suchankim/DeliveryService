package deliveryservice.domain;

import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class CookFinished extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String foodCode;
    private String storeId;
    private String customerId;
    private String status;
    private List<String> options;
}
