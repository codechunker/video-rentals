package energy.rensource.videorentals.repository;

import energy.rensource.videorentals.model.VideoGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGenreRepository extends JpaRepository<VideoGenre, Long> {
}
