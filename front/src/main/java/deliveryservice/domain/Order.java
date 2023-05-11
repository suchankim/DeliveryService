package deliveryservice.domain;

import deliveryservice.FrontApplication;
import deliveryservice.domain.OrderCanceled;
import deliveryservice.domain.OrderPlaced;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerId;
    private String storeId;
    private String foodCode;
    private String address;

    @ElementCollection
    private List<String> options;
    private String status;
    private Integer price;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();       
    }

    @PreRemove
    public void onPreRemove() {
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void updateStatus(Paid paid) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);
        */

        /** Example 2:  finding and process*/
        
        repository().findById(paid.getOrderId()).ifPresent(order->{
            
            order.setStatus("PAID"); // do something
            repository().save(order);
         });
        
    }

    public static void updateStatus(OrderAccepted orderAccepted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);
        */

        /** Example 2:  finding and process*/
        
        repository().findById(orderAccepted.getOrderId()).ifPresent(order->{
            
            order.setStatus("ACCEPTED"); // do something
            repository().save(order);

         });
        
    }

    public static void updateStatus(OrderRejected orderRejected) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);
        */

        /** Example 2:  finding and process*/
        
        repository().findById(orderRejected.getOrderId()).ifPresent(order->{
            
            order.setStatus("REJECTED"); // do something
            repository().save(order);

         });
        
    }

    public static void updateStatus(CookStarted cookStarted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);
        */

        /** Example 2:  finding and process*/
        
        repository().findById(cookStarted.getOrderId()).ifPresent(order->{
            
            order.setStatus("COOKING"); // do something
            repository().save(order);

         });
        
    }

    public static void updateStatus(CookFinished cookFinished) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);
        */

        /** Example 2:  finding and process*/
        
        repository().findById(cookFinished.getOrderId()).ifPresent(order->{
            
            order.setStatus("COOKED"); // do something
            repository().save(order);

         });
        
    }
}