package com.medmapper.v33001

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutInflater.inflate(R.layout.main_activity, null))
        setSupportActionBar(findViewById(R.id.toolbar))
        setFragment(ScheduleFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.schedule_menu_item -> {
                setFragment(ScheduleFragment())
            }
            R.id.medication_menu_item -> {
                setFragment(MedicationsFragment())
            }
            R.id.share_menu_item -> {
                //todo: share()
            }
            else -> return false
        }

        return true
    }

    private fun setFragment(fragment: Fragment){
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_view, fragment).commit()
    }
}