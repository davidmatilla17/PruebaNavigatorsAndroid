package com.davidmatillacode.pruebanavigations.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.davidmatillacode.pruebanavigations.R
import com.davidmatillacode.pruebanavigations.databinding.FragmentMainSubABinding

class MainSubAFragment : Fragment() {

    private var navController: NavController? = null
    private var _binding : FragmentMainSubABinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainSubABinding.inflate(inflater,container,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        _binding?.boton?.setOnClickListener {
            goToNextView()
        }
    }

    fun goToNextView(){
        navController?.navigate(R.id.action_mainSubAFragment_to_mainSubBFragment)
    }
}