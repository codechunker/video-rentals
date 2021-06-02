package energy.rensource.videorentals.repository.sql.impl;

import energy.rensource.videorentals.payload.VideoResponse;
import energy.rensource.videorentals.repository.sql.VideoRepository;
import energy.rensource.videorentals.repository.sql.mapper.VideoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
