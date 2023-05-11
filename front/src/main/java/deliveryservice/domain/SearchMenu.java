package deliveryservice.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SearchMenu_table")
@Data
public class SearchMenu {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
