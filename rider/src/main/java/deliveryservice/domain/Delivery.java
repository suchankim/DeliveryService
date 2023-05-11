package deliveryservice.domain;

import deliveryservice.RiderApplication;
import deliveryservice.domain.Delivered;
import deliveryservice.domain.Picked;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String address;
    private String status;
    private String storeId;

    @PostPersist
    public void onPostPersist() {
        // Picked picked = new Picked(this);
        // picked.publishAfterCommit();    
    }

    @PreUpdate
    public void onPreUpdate() {
        // Delivered delivered = new Delivered(this);
        // delivered.publishAfterCommit();
    }

    public void pick() {
        Picked picked = new Picked(this);
        repository().findByOrderId(picked.getOrderId()).ifPresent(delivery->{
            
            delivery.setStatus("PICKED"); // do something
            repository().save(delivery);
         });
        picked.publishAfterCommit();
    }

    public void confirmdelivery() {
        Delivered delivered = new Delivered(this);
        repository().findByOrderId(delivered.getOrderId()).ifPresent(delivery->{
            
            delivery.setStatus("DELIVERED"); // do something
            repository().save(delivery);
         });
        delivered.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void updateStatus(CookFinished cookFinished) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);
        */

        /** Example 2:  finding and process*/
        
        repository().findByOrderId(cookFinished.getOrderId()).ifPresent(delivery->{
            
            delivery.setStatus("COOKED"); // do something
            repository().save(delivery);
         });

    }

    public static void sendOrderData(OrderPlaced orderPlaced) {
        /** Example 1:  new item */
        Delivery delivery = new Delivery();
        delivery.setOrderId(orderPlaced.getId());
        delivery.setAddress(orderPlaced.getAddress());
        delivery.setStatus("ORDERED");
        delivery.setStoreId(orderPlaced.getStoreId());
        repository().save(delivery);

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);
         });
        */

    }
}