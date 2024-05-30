package com.s1511.ticketcine.application.implementations;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.s1511.ticketcine.application.dto.movie.CreateDtoMovie;
import com.s1511.ticketcine.application.dto.movie.ReadDtoMovie;
import com.s1511.ticketcine.application.dto.movie.ReadMovieApiData;
import com.s1511.ticketcine.application.mapper.MovieMapper;
import com.s1511.ticketcine.application.security.AppConfig;
import com.s1511.ticketcine.domain.entities.Movie;
import com.s1511.ticketcine.domain.repository.MovieRepository;
import com.s1511.ticketcine.domain.services.MovieService;
import com.s1511.ticketcine.domain.utils.GenreCombert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final String apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNTM3ZDM1NTI0NDRhOWFkNDY0YTRkMGFiZmE2NDU2OCIsInN1YiI6IjY2NGFiZDZhZGQ5ZDQyN2M0MTkzMjM0NSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.PaUBAej7XojVla0L2N6Lo-eDbXQMrpPvnOgdKMk3H7E";
    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;
    private final AppConfig appConfig;
    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);


    public ResponseEntity<?> saveLastestMovies() {
        LocalDate today = LocalDate.now();
        String urlTemplate = "https://api.themoviedb.org/3/discover/movie?page=%d&primary_release_date.gte=%s&primary_release_date.lte=2024-06-07&sort_by=primary_release_date.asc";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity;
        RestTemplate restTemplate = new RestTemplate();
        List<CreateDtoMovie> movieDtos = new ArrayList<>();

        // Iterar a través de las páginas
        int page = 1;
        boolean hasMorePages = true;

        while (hasMorePages) {
            String url = String.format(urlTemplate, page, today.toString());

            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.setBearerAuth(apiKey);

            entity = new HttpEntity<>("", headers);

            var response = restTemplate.exchange(url, HttpMethod.GET, entity, ReadMovieApiData.class);
            ReadMovieApiData apiData = response.getBody();

            if (apiData != null && apiData.results() != null) {
                movieDtos.addAll(apiData.results());
                hasMorePages = page < apiData.total_pages();
                page++;
            } else {
                hasMorePages = false;
            }
        }

        List<Movie> movies = new ArrayList<>();
        for (CreateDtoMovie dto : movieDtos) {
            if ((dto.original_language().equals("en") || dto.original_language().equals("es")) &&
                    dto.overview() != null && !dto.overview().isEmpty() &&
                    dto.poster_path() != null && !dto.poster_path().isEmpty()) {

                Movie movie = new Movie();
                movie.setImage("https://image.tmdb.org/t/p/w220_and_h330_face"+dto.poster_path());
                movie.setTitle(dto.title());
                movie.setDescription(dto.overview());
                movie.setAdult(dto.adult());
                movie.setReleaseDate(LocalDate.parse(dto.release_date())); // Assuming releaseDate is a String
                movie.setThreeD(true);
                if (dto.original_language().equals("en")) {
                    movie.setSubtitle(true);
                } else {
                    movie.setSubtitle(false);
                }
                movie.setActive(true);
                movie.setComment(null);
                movie.setRate(null);
                movie.setGenre(assignGenre(dto.genre_ids()));
                //
                System.out.println("movie individual ya guardada en objeto movie" + movie);
            movies.add(movie);
            }
        }

        movieRepository.saveAll(movies);

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }


    @Override
    public ReadDtoMovie getMovieById(String id) {
        Optional<Movie> movie = movieRepository.findByIdAndActive(id, true);
        return movieMapper.movieToReadDto(movie.orElse(null));
    }

    @Override
    public List<ReadDtoMovie> getActiveMovieList() {
        List<Movie> movieList = movieRepository.findByActive(true);
        return movieMapper.movieListToReadDtoList(movieList);
    }

    @Override
    public ReadDtoMovie getMovieByTitle(String title) {
        Optional<Movie> movie = movieRepository.findByTitleAndActive(title, true);

        return movieMapper.movieToReadDto(movie.orElse(null));
    }

    @Override
    public List<ReadDtoMovie> findByReleaseDate(LocalDateTime time) {
        List<Movie> movieList = movieRepository.findByReleaseDateAndActive(time, true);

        return movieMapper.movieListToReadDtoList(movieList);
    }

    /*@Override
    public List<ReadDtoMovie> getMovieByGenre(String gendre) {
        List<Movie> movieList = movieRepository.findByGenreAndActive(gendre, true);

        return movieMapper.movieListToReadDtoList(movieList);
    }*/

    @Override
    public List<ReadDtoMovie> getMovieByAge(Boolean agePlus18) {
        List<Movie> movieList = movieRepository.findByAdultAndActive(agePlus18, true);

        return movieMapper.movieListToReadDtoList(movieList);
    }

    @Override
    public List<ReadDtoMovie> getMovieByThreeD(Boolean threeD) {
        List<Movie> movieList = movieRepository.findByThreeDAndActive(threeD, true);

        return movieMapper.movieListToReadDtoList(movieList);
    }

    @Override
    public List<String> assignGenre(List<Integer> genresId) {
        List<String> movieGenres = new ArrayList<>();

        GenreCombert[] genreEnum = GenreCombert.values();
        if (genreEnum != null) {
            for (var genre : genreEnum){
                for(var genreId : genresId ){
                    if(genre.getId() == genreId){
                     movieGenres.add(genre.name());
                    }
            }
        }

    }
        return movieGenres;
    }

    @Override
    public List<Movie> findBySubtitleAndActive(Boolean subtitle) {
        return movieRepository.findBySubtitleAndActive(subtitle, true);
    }

    @Override
    public Double findAvgRateByMovieId(String movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException(movieId));
        var calificationList = movie.getUsersRating();
        calificationList.add(1);
        Double addition = 0.0;
        for (int i = 0; i < calificationList.size(); i++) {
            addition = calificationList.get(i) + addition;
        }
        Double avgRate = addition/calificationList.size();

        return avgRate;
    }

}