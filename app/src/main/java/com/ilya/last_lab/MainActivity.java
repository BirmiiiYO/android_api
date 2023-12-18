package com.ilya.last_lab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private ApiManager apiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiManager = new ApiManager();

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, new ListFragment())
                        .commit();
            }
        }
    }

    @Override
    public void onItemClick(ApiData apiData) {
        apiManager.getBerryByName(apiData.getName(),
                berryDetails -> {
                    Log.d("MainActivity", "Berry details loaded successfully: " + berryDetails.getName());
                    openDetailFragment(berryDetails);
                },
                throwable -> {
                    Log.e("MainActivity", "Error loading berry details", throwable);
                });

    }

    private void openDetailFragment(ApiData berryDetails) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString("name", berryDetails.getName());
        args.putInt("id", berryDetails.getId());
        args.putInt("max_harvest", berryDetails.getMaxHarvest());
        args.putInt("growth_time", berryDetails.getGrowthTime());
        args.putInt("Size", berryDetails.getSize());
        args.putInt("Smoothness", berryDetails.getSmoothness());
        args.putInt("SoilDryness", berryDetails.getSoilDryness());
        detailFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit();
    }
}
