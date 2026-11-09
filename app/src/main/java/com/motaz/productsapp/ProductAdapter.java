package com.motaz.productsapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/** RecyclerView adapter that binds {@link Product} items to item_product.xml. */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final List<Product> allProducts;
    private final List<Product> shownProducts;

    public ProductAdapter(List<Product> products) {
        this.allProducts = new ArrayList<>(products);
        this.shownProducts = new ArrayList<>(products);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = shownProducts.get(position);
        String price = String.format(Locale.US, "US$%.2f", product.getPrice());
        holder.image.setImageResource(product.getImageRes());
        holder.title.setText(product.getTitle());
        holder.price.setText(price);
        holder.cart.setOnClickListener(v -> Toast.makeText(v.getContext(),
                "Added to cart: " + price, Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return shownProducts.size();
    }

    /** Filters the list by product title (case-insensitive). */
    @SuppressLint("NotifyDataSetChanged")
    public void filter(String query) {
        shownProducts.clear();
        String q = query == null ? "" : query.trim().toLowerCase(Locale.US);
        for (Product p : allProducts) {
            if (q.isEmpty() || p.getTitle().toLowerCase(Locale.US).contains(q)) {
                shownProducts.add(p);
            }
        }
        notifyDataSetChanged();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView title;
        final TextView price;
        final ImageButton cart;

        ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivProduct);
            title = itemView.findViewById(R.id.tvTitle);
            price = itemView.findViewById(R.id.tvPrice);
            cart = itemView.findViewById(R.id.btnCart);
        }
    }
}
