package energy.rensource.videorentals.repository.hibernate;

import energy.rensource.videorentals.model.VideoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface VideoTypeRepository extends JpaRepository<VideoType, Long> {
}
