package com.ilya.last_lab;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import io.reactivex.disposables.Disposable;


public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    private ApiAdapter apiAdapter;
    private ApiManager apiManager;
    private Disposable apiDisposable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        apiAdapter = new ApiAdapter(new ArrayList<>(), apiData -> ((OnItemClickListener) requireActivity()).onItemClick(apiData));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(apiAdapter);

        apiManager = new ApiManager();
        loadData();

        return view;
    }

    private void loadData() {
        int limit = 50;
        int offset = 0;
        apiDisposable = apiManager.getBerriesList(
                limit,
                offset,
                BerriesList -> {
                    apiAdapter.setData(BerriesList);
                    apiAdapter.notifyDataSetChanged();
                    Log.d("ListFragment", "Data loaded successfully: " + BerriesList.size() + " items");
                },
                throwable -> Log.e("ListFragment", "Error loading data", throwable)
        );
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        if (apiDisposable != null && !apiDisposable.isDisposed()) {
            apiDisposable.dispose();
        }
    }
}
