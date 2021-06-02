package energy.rensource.videorentals.repository;

import energy.rensource.videorentals.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRentalRepository extends JpaRepository<Video, Long> {
}
