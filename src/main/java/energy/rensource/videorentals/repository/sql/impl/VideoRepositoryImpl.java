package energy.rensource.videorentals.repository.sql.impl;

import energy.rensource.videorentals.model.Video;
import energy.rensource.videorentals.model.VideoDetails;
import energy.rensource.videorentals.payload.VideoResponse;
import energy.rensource.videorentals.repository.sql.VideoRepository;
import energy.rensource.videorentals.repository.sql.mapper.VideoDetailsMapper;
import energy.rensource.videorentals.repository.sql.mapper.VideoRowMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VideoRepositoryImpl implements VideoRepository {

    final NamedParameterJdbcTemplate template;

    public VideoRepositoryImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<VideoResponse> getVideos(Pageable pageable) {
        String query = "SELECT video_genres.id as genre_id, videos.id as video_id, video_types.id as type_id, video_genres.name as genre_name, * FROM videos" +
                "  INNER JOIN video_types  " +
                "ON videos.type = video_types.id " +
                "INNER JOIN video_genres " +
                "ON videos.genre = video_genres.id LIMIT "+pageable.getPageSize() +
                " OFFSET "+pageable.getOffset();
        return template.query(query, new VideoRowMapper());
    }

    @Override
    public Optional<VideoDetails> findVideoById(Long id) {
        String query = "SELECT video_genres.id as genre_id, videos.id as video_id, video_types.id as type_id, " +
                "video_genres.name as genre_name, videos.release_year as releaseYear, videos.max_age as maxAge, * FROM videos, video_genres, video_types "+
                "WHERE videos.id ="+id + " AND video_types.id = videos.type" +" AND video_genres.id = videos.genre " + " LIMIT 1";
        return Optional.of(template.query(query, new VideoDetailsMapper()).get(0));
    }
}
