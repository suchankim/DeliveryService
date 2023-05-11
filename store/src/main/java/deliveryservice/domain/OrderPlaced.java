package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String customerId;
    private String storeId;
    private String foodCode;
    private String address;
    private List<String> options;
    private String status;
    private Integer price;
}
