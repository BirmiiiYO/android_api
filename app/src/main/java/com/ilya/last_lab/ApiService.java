package com.ilya.last_lab;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import java.util.List;
public interface ApiService {
    @GET("berry")
    Observable<ApiResponse<List<ApiData>>> getBerriesList(
            @Query("limit") int limit,
            @Query("offset") int offset
    );

    @GET("berry/{name}")
    Observable<ApiData> getBerryByName(
            @Path("name") String berryName
    );
}
