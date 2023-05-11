package deliveryservice.domain;

import deliveryservice.domain.*;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cookings", path = "cookings")
public interface CookingRepository
    extends PagingAndSortingRepository<Cooking, Long> {

    Optional<Cooking> findByOrderId(Long id);}
