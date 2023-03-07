package com.davidmatillacode.pruebanavigations.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.davidmatillacode.pruebanavigations.R
import com.davidmatillacode.pruebanavigations.databinding.FragmentMainSubBBinding

class MainSubBFragment : Fragment() {


    private var navController: NavController? = null
    private var parentController: NavController? = null
    private var _binding : FragmentMainSubBBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainSubBBinding.inflate(inflater,container,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        parentController =
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_main)
        _binding?.boton?.setOnClickListener {
            goToNextView()
        }

        _binding?.botonPopup?.setOnClickListener {
            goToNextViewCleaningBackStack()
        }
    }

    fun goToNextView(){
        parentController?.navigate(R.id.action_global_secondaryFragment)
    }

    fun goToNextViewCleaningBackStack(){
        parentController?.navigate(R.id.action_mainFragment_to_secondaryFragment)
    }
}