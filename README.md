# Products App – RecyclerView Grid

Android app that recreates a shop "Most Popular" product screen using a **RecyclerView**.

## Design
- Top bar: back arrow, search field with blue search button, grid-view icon
- Header row: **Most Popular** and **Filter**
- Product cards: image, two-line title, price (`US$48.89`) and a cart button

## Implementation
- `RecyclerView` + **`GridLayoutManager` (2 columns)**, because the design shows products in a two-column grid
- `Product` – model class (title, price, image)
- `ProductAdapter` – RecyclerView adapter + ViewHolder, binds `item_product.xml` (CardView)
- `MainActivity` – sets up the layout manager, adapter and search filtering
- Product images are vector drawables, so no internet is needed

## Build
Open the project in Android Studio and press **Run**, or:

```bash
./gradlew assembleDebug
```

- Language: Java
- minSdk 26, targetSdk 36
- Android Gradle Plugin 9.2.1, Gradle 9.4.1

## Screenshots
See the `screenshots/` folder.

By: Motaz Inshasi
