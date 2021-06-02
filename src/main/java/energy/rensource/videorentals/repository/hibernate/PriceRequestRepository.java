package energy.rensource.videorentals.repository.hibernate;

import energy.rensource.videorentals.model.PriceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRequestRepository extends JpaRepository<PriceRequest, Long> {
}
