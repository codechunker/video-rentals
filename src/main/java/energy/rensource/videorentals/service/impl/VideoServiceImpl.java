package energy.rensource.videorentals.service.impl;



import energy.rensource.videorentals.enums.Genre;
import energy.rensource.videorentals.enums.Type;
import energy.rensource.videorentals.model.Video;
import energy.rensource.videorentals.model.VideoGenre;
import energy.rensource.videorentals.model.VideoType;
import energy.rensource.videorentals.payload.VideoResponse;
import energy.rensource.videorentals.repository.hibernate.VideoGenreRepository;
import energy.rensource.videorentals.repository.hibernate.VideoRentalRepository;
import energy.rensource.videorentals.repository.hibernate.VideoTypeRepository;
import energy.rensource.videorentals.repository.sql.VideoRepository;
import energy.rensource.videorentals.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    final VideoRepository repository;
    final VideoTypeRepository typeRepository;
    final VideoGenreRepository genreRepository;

    //Needed this to populate the db easily with Hibernate
    final VideoRentalRepository rentalRepository;

    @PostConstruct
    void init() {
        List<Video> videos = createDummyVideos();
        List<VideoType> types = createDummyType();
        List<VideoGenre> genres = createDummyGenre();
        populateDummyVideos(videos);
        populateDummyVideoGenre(genres);
        populateDummyVideoTypes(types);
    }

    @Autowired
    public VideoServiceImpl(VideoRepository repository, VideoTypeRepository typeRepository,
                            VideoGenreRepository genreRepository, VideoRentalRepository rentalRepository) {
        this.repository = repository;
        this.typeRepository = typeRepository;
        this.genreRepository = genreRepository;
        this.rentalRepository = rentalRepository;
    }



    private List<Video> createDummyVideos() {
        List<Video> videos = new ArrayList<>();
        Video ff7 = new Video("Fast and Furious 7", Type.REGULAR.getType(), Genre.ACTION.getGenre());
        videos.add(ff7);

        Video kingsMen = new Video("Kings Men", Type.REGULAR.getType(), Genre.ACTION.getGenre());
        videos.add(kingsMen);

        Video naruto = new Video("Naruto", Type.CHILDREN.getType(), Genre.DRAMA.getGenre());
        videos.add(naruto);

        Video ff9 = new Video("Fast and Furious 9", Type.NEW.getType(), Genre.ACTION.getGenre());
        videos.add(ff9);

        Video thm = new Video("Two and Half Men", Type.REGULAR.getType(), Genre.COMEDY.getGenre());
        videos.add(thm);

        Video annabel = new Video("Annabel", Type.REGULAR.getType(), Genre.HORROR.getGenre());
        videos.add(annabel);

        Video fiftyShadesOfGray = new Video("Fifty Shades of Gray", Type.REGULAR.getType(), Genre.ROMANCE.getGenre());
        videos.add(fiftyShadesOfGray);

        return videos;
    }

    private List<VideoGenre> createDummyGenre() {
        List<VideoGenre> videoGenres = new ArrayList<>();
        VideoGenre action = new VideoGenre( "Action");
        videoGenres.add(action);

        VideoGenre drama = new VideoGenre( "Drama");
        videoGenres.add(drama);

        VideoGenre romance = new VideoGenre("Romance");
        videoGenres.add(romance);

        VideoGenre comedy = new VideoGenre( "Comedy");
        videoGenres.add(comedy);

        VideoGenre horror = new VideoGenre( "Horror");
        videoGenres.add(horror);

        return videoGenres;
    }

    private List<VideoType> createDummyType() {
        List<VideoType> videoTypes = new ArrayList<>();

        VideoType regular = new VideoType("Regular", 10.0);
        videoTypes.add(regular);

        VideoType children = new VideoType("Children", 8.0);
        videoTypes.add(children);

        VideoType newRelease = new VideoType("New Release", 15.0);
        videoTypes.add(newRelease);

        return videoTypes;
    }


    @Override
    public List<VideoResponse> getAllVideo(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,  pageSize);
        return repository.getVideos(pageable);
    }

    public void populateDummyVideos(List<Video> videos) {
        rentalRepository.saveAll(videos);
    }

    public void populateDummyVideoTypes(List<VideoType> videoTypes) {
        typeRepository.saveAll(videoTypes);
    }

    public void populateDummyVideoGenre(List<VideoGenre> genres) {
        genreRepository.saveAll(genres);
    }


}
