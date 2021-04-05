package com.example.deliverykotlin

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.deliverykotlin.components.menu.MenuViewModel
import com.example.deliverykotlin.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewModel : MenuViewModel by viewModel()
    private var textCartItemCount: TextView? = null
    var itemCart:MenuItem?=null
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        textCartItemCount=findViewById(R.id.textCartItemCount)

        val binding=setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val appBarConfiguration = AppBarConfiguration.Builder(
                R.id.navigation_menu, R.id.navigation_favorites, R.id.navigation_orders, R.id.navigation_points, R.id.navigation_profile
        ).build()

        val navView = binding.navView
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)

        viewModel.getMenuList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val item: MenuItem = menu.findItem(R.id.cart)

        itemCart=item
        //itemCart!!.setVisible(false)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            android.R.id.home -> {
                navController.popBackStack(); true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}