package energy.rensource.videorentals.repository.sql.mapper;

import energy.rensource.videorentals.model.Video;
import energy.rensource.videorentals.model.VideoDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class VideoDetailsMapper implements RowMapper<VideoDetails> {


    @Override
    public VideoDetails mapRow(ResultSet resultSet, int i) throws SQLException {
        VideoDetails video = new VideoDetails();
        video.setTitle(resultSet.getString("title"));
        video.setMaxAge(resultSet.getInt("maxAge"));
        video.setReleaseYear(resultSet.getInt("releaseYear"));
        video.setVideoType(resultSet.getInt("type_id"));
        video.setVideoGenre(resultSet.getInt("genre_id"));
        video.setPrice(resultSet.getDouble("price"));

        return video;
    }
}
