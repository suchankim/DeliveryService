package deliveryservice.infra;

import deliveryservice.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "searchMenus",
    path = "searchMenus"
)
public interface SearchMenuRepository
    extends PagingAndSortingRepository<SearchMenu, Long> {}
