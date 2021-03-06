package sa.thiqah.emanbasahel.popularmovies_1.data.webservice;

/**
 * Created by emanbasahel on 30/11/2017 AD.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import sa.thiqah.emanbasahel.popularmovies_1.data.model.MovieDetailsModel;
import sa.thiqah.emanbasahel.popularmovies_1.data.model.MovieModel;
import sa.thiqah.emanbasahel.popularmovies_1.data.model.MovieReviews;
import sa.thiqah.emanbasahel.popularmovies_1.data.model.MovieTrailers;


public interface ApiInterface {
    @GET ("popular")
    Call <MovieModel> getPopularMovie (@Query("api_key") String apiKey);

    @GET("top_rated")
    Call<MovieModel> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("{id}")
    Call<MovieDetailsModel> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("{id}/reviews")
    Call<MovieReviews> getMovieReviews(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("{id}/videos")
    Call<MovieTrailers> getMovieTrailers(@Path("id") int id, @Query("api_key") String apiKey);
}