package com.example.delivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionMenuView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.delivery.databinding.ActivityMainBinding;
import com.example.delivery.viewModels.RestaurantsViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NavHostFragment navHostFragment;
    private NavController navController;
    private RestaurantsViewModel restaurantsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        navHostFragment=(NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController=navHostFragment.getNavController();
        setSupportActionBar(binding.toolbarUp);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        // View Models
        restaurantsViewModel = new ViewModelProvider(this).get(RestaurantsViewModel.class);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cart:
                Loger.log("cart is clicked");
                break;
            case R.id.menu:
                navController.navigate(R.id.fragmentMenu);
                Loger.log("menu is clicked");
                break;
            case R.id.favorites:
                navController.navigate(R.id.fragmentFavorites);
                Loger.log("favorites is clicked");
                break;
            case R.id.orders:
                navController.navigate(R.id.fragmentOrders);
                Loger.log("orders is clicked");
                break;
            case R.id.restaurants:
                navController.navigate(R.id.fragmentRestaurants);
                Loger.log("restaurants is clicked");
                break;
            case R.id.profile:
                navController.navigate(R.id.fragmentProfile);
                Loger.log("profile is clicked");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the toolbar menu
        getMenuInflater().inflate(R.menu.toolbar_menu_up, menu);

        // Inflate and initialize the bottom menu
        ActionMenuView bottomBar = binding.toolbarDown;
        Menu bottomMenu = bottomBar.getMenu();
        getMenuInflater().inflate(R.menu.toolbar_menu_down, bottomMenu);
        for (int i = 0; i < bottomMenu.size(); i++) {
            bottomMenu.getItem(i).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    return onOptionsItemSelected(item);
                }
            });
        }
        return true;
    }
}