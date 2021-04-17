package com.example.hw1_temperature_convert

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.hw1_temperature_convert.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentBlankBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_blank, container, false
        )

        // enable option menu
        setHasOptionsMenu(true)

        binding.tempConvert.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_blankFragment_to_blankFragment2)
            //convert(view)
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
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

//    fun convert(view: View) {
//        binding.apply {
//            //var temp: Double ?= Double.parseDouble(tempInput.text)
//            var temp: Double = tempInput.text.toString().toDouble()
//
//            val df = DecimalFormat("0.00")  //設定四捨五入的位數
//            temp = (temp - 32) * 5 / 9
//            var TEMP = df.format(temp)
//
//            answer.text = TEMP.toString()
//            //answer.text = ".2f".format(TEMP).toString()
//        }
//        //隱藏鍵盤
//        val inputMethodManager =
//            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
//    }
}