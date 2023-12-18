package com.ilya.last_lab;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.functions.Consumer;
import java.util.List;
public class ApiManager {
    private ApiService apiService;

    public ApiManager() {
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    public Disposable getBerriesList(
            int limit, int offset,
            Consumer<List<ApiData>> onSuccess,
            Consumer<Throwable> onError
    ) {
        return apiService.getBerriesList(limit, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(ApiResponse::getResults)
                .subscribe(onSuccess, onError);
    }

    public Disposable getBerryByName(
            String berryName,
            Consumer<ApiData> onSuccess,
            Consumer<Throwable> onError
    ) {
        return apiService.getBerryByName(berryName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onSuccess, onError);
    }
}
