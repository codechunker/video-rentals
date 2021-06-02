package energy.rensource.videorentals.repository.sql.mapper;

import energy.rensource.videorentals.model.VideoGenre;
import energy.rensource.videorentals.model.VideoType;
import energy.rensource.videorentals.payload.VideoResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoRowMapper implements RowMapper<VideoResponse> {


    @Override
    public VideoResponse mapRow(ResultSet resultSet, int i) throws SQLException {
        String title = resultSet.getString("title");
        VideoType type = new VideoType(resultSet.getLong("type_id"), resultSet.getString("name"), resultSet.getDouble("price"));
        VideoGenre genre = new VideoGenre(resultSet.getLong("genre_id"), resultSet.getString("genre_name"));

        return new VideoResponse(title, type, genre);
    }
}
