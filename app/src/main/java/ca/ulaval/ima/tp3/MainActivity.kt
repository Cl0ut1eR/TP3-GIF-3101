package ca.ulaval.ima.tp3

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import ca.ulaval.ima.tp3.databinding.ActivityMainBinding
import ca.ulaval.ima.tp3.ui.main.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

      /*  tabs.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // Get the position of the selected tab
                val position = tab.position

                println(position)
                // Perform the necessary action to show your layout or fragment
                if (position == 0) {
                    // Show the first fragment
                   /* supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FirstFragment())
                        .commit()*/
                } else if (position == 1) {
                    // Show the second layout
                  //  setContentView(R.layout.offers)
                } else if (position == 2) {
                    // Show the third fragment
                   /* supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ThirdFragment())
                        .commit()*/
                }
            }
        })*/
    }
}