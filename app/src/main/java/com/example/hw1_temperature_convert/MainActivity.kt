package com.example.hw1_temperature_convert

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.hw1_temperature_convert.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding  //ActivityMainBinding表示跟隨哪個layout
    private lateinit var drawerLayout: DrawerLayout //Display the navigation drawer from the drawer button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //DataBinding的必要條件 (相對於 setContentView)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //DataBinding的必要條件 (相對於 setContentView)
        drawerLayout = binding.drawerLayout

        ///// 設定up button(返回鈕）/////
        val navController = this.findNavController(R.id.myNavHostFragment)
        //NavigationUI.setupActionBarWithNavController(this, navController)
        ///// 設定up button(返回鈕）/////

        ///// 啟用側拉選單 /////
        NavigationUI.setupWithNavController(binding.navView, navController)

        ///// 將 返回鈕&側拉選單都出現在toolbar/////
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

    }

    //單純設定返回鈕
//    override fun onSupportNavigateUp(): Boolean {
//        ///// 設定up button(返回鈕）/////
//        val navController = this.findNavController(R.id.myNavHostFragment)
//        return navController.navigateUp()
//        ///// 設定up button(返回鈕）/////
//    }

    //同時設定返回鈕&側拉選單
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}





