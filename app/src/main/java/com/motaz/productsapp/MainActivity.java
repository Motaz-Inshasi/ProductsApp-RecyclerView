package com.motaz.productsapp;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int SPAN_COUNT = 2;
    private static final String TITLE = "Bitzwolf B-CC1 Camera 1080P Hd Webcame";

    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rvProducts);
        // The design shows products in a two-column grid, so GridLayoutManager is used.
        recyclerView.setLayoutManager(new GridLayoutManager(this, SPAN_COUNT));
        adapter = new ProductAdapter(buildProducts());
        recyclerView.setAdapter(adapter);

        EditText search = findViewById(R.id.etSearch);
        findViewById(R.id.btnSearch).setOnClickListener(v -> adapter.filter(search.getText().toString()));
        search.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                adapter.filter(search.getText().toString());
                return true;
            }
            return false;
        });

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
        findViewById(R.id.tvFilter).setOnClickListener(v ->
                Toast.makeText(this, R.string.filter, Toast.LENGTH_SHORT).show());
    }

    private List<Product> buildProducts() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(TITLE, 48.89, R.drawable.product_360_camera));
        list.add(new Product(TITLE, 55.89, R.drawable.product_instant_camera));
        list.add(new Product(TITLE, 78.89, R.drawable.product_smart_speaker));
        list.add(new Product(TITLE, 88.55, R.drawable.product_action_camera));
        list.add(new Product(TITLE, 23.67, R.drawable.product_webcam));
        list.add(new Product(TITLE, 44.89, R.drawable.product_360_camera));
        list.add(new Product(TITLE, 62.40, R.drawable.product_action_camera));
        list.add(new Product(TITLE, 39.99, R.drawable.product_webcam));
        list.add(new Product(TITLE, 71.25, R.drawable.product_instant_camera));
        list.add(new Product(TITLE, 59.10, R.drawable.product_smart_speaker));
        return list;
    }
}
