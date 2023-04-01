package ca.ulaval.ima.tp3.ui.main

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ca.ulaval.ima.tp3.databinding.FragmentMainBinding
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.*


/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentMainBinding? = null

    private var action = "brand"

    // This property is only valid between onCreateView and
    // onDestroyView.
    public val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }
    fun readStream(inputStream: InputStream): String {
       /* val reader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        var line: String? = null
        while ({line = reader.readLine(); line}() != null) {
            stringBuilder.append(line)
        }
        return stringBuilder.toString()*/
        return "helo"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val root = binding.root

        var mainListView = binding.mainListView


        val mutableList = mutableListOf<String>()

        mutableList.add("Brand 1")
        mutableList.add("Brand 2")
        mutableList.add("Brand 3")
        mutableList.add("Brand 4")


        /*api tp3.infomobile.app/api/v1/brand/
        for items
            brands[name] = id
            mutableList.add(name)
         */


        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, mutableList)
        mainListView.adapter = adapter





        mainListView.setOnItemClickListener { parent, view, position, id ->
            val selectedItemName = parent.getItemAtPosition(position).toString()
            if(action == "brand") {
                /*
            api call tp3.infomobile.app/api/v1/modal/
            for items
                modal[name] = id
                mutableList.add(name)
             */
                mutableList.clear()
                mutableList.add("Model 1")
                mutableList.add("Model 2")
                mutableList.add("Model 3")
                mutableList.add("Model 4")

                val adapter = ArrayAdapter<String>(
                    requireContext(),
                    android.R.layout.simple_list_item_1,
                    mutableList
                )

                mainListView.adapter = adapter

                action = "modal"
            }else if(action == "modal"){
                mutableList.clear()

            }

        }

        return root
    }


    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**<
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}