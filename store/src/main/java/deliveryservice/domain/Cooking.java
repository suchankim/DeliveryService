package deliveryservice.domain;

import deliveryservice.StoreApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cooking_table")
@Data
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String foodCode;
    private String storeId;
    private String customerId;
    private String status;

    @ElementCollection
    private List<String> options;

    @PostPersist
    public void onPostPersist() {}

    public static CookingRepository repository() {
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }

    public void accept() {
        
        OrderAccepted orderAccepted = new OrderAccepted(this);
        repository().findByOrderId(orderAccepted.getOrderId()).ifPresent(cooking->{
            
            cooking.setStatus("ACCEPTED"); // do something
            repository().save(cooking);
         });
        orderAccepted.publishAfterCommit();
    }

    public void reject() {
        OrderRejected orderRejected = new OrderRejected(this);
        repository().findByOrderId(orderRejected.getOrderId()).ifPresent(cooking->{
            
            cooking.setStatus("REJECTED"); // do something
            repository().save(cooking);
         });
        orderRejected.publishAfterCommit();
    }

    public void start() {
        CookStarted cookStarted = new CookStarted(this);
        repository().findByOrderId(cookStarted.getOrderId()).ifPresent(cooking->{
            
            cooking.setStatus("STARTED"); // do something
            repository().save(cooking);
         });
        cookStarted.publishAfterCommit();
    }

    public void finish() {
        CookFinished cookFinished = new CookFinished(this);
        repository().findByOrderId(cookFinished.getOrderId()).ifPresent(cooking->{
            
            cooking.setStatus("COOKED"); // do something
            repository().save(cooking);
         });
        cookFinished.publishAfterCommit();
    }

    public static void updateStatus(Paid paid) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);
        */

        /** Example 2:  finding and process*/
        
        repository().findByOrderId(paid.getOrderId()).ifPresent(cooking->{
            
            cooking.setStatus("PAID"); // do something
            repository().save(cooking);
         });
        

    }

    public static void updateStatus(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process*/
        
        repository().findByOrderId(orderCanceled.getId()).ifPresent(cooking->{
            
            cooking.setStatus("CANCELED"); // do something
            repository().save(cooking);
         });
    }

    public static void sendOrderData(OrderPlaced orderPlaced) {
        /** Example 1:  new item */
        Cooking cooking = new Cooking();
        cooking.setOrderId(orderPlaced.getId());
        cooking.setFoodCode(orderPlaced.getFoodCode());
        cooking.setStoreId(orderPlaced.getStoreId());
        cooking.setCustomerId(orderPlaced.getCustomerId());
        cooking.setStatus("ORDERED");
        cooking.setOptions(orderPlaced.getOptions());
        repository().save(cooking);

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);
         });
        */

    }
}