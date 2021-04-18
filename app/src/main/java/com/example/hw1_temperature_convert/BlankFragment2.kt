package com.example.hw1_temperature_convert

import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Person.fromBundle
import androidx.databinding.DataBindingUtil
import androidx.media.AudioAttributesCompat.fromBundle
import com.example.hw1_temperature_convert.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentBlank2Binding>(inflater,
            R.layout.fragment_blank2, container, false)

        val args = BlankFragment2Args.fromBundle(requireArguments())
        binding.TVShow.text = args.temp
        // Inflate the layout for this fragment
        return binding.root
    }

 }