package com.example.hw1_temperature_convert

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.hw1_temperature_convert.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    private lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_blank, container, false
        )

        // enable option menu
        setHasOptionsMenu(true)

        binding.tempConvert.setOnClickListener {
            val temp =

            //// Using directions to navigate
            view?.findNavController()
                ?.navigate(BlankFragmentDirections.actionBlankFragmentToBlankFragment2(convert(it)))

        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    /***
     *Tip: Make sure that the ID of the menu item that you just added is
     * exactly the same as the ID of the AboutFragment
     * that you added in the navigation graph. T
     * his will make the code for the onClick handler much simpler.
     * 各個menu的id一定要對應navigation path裡面需要之fragment的id
     */

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    fun convert(view: View): String {
        binding.apply {
            var temp: Double = tempInput.text.toString().toDouble()
            temp = (temp - 32) * 5 / 9
            //val answer = ".2f".format(temp)
            return temp.toString()
        }
    }
        //隱藏鍵盤
//        val inputMethodManager =
//            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)


}