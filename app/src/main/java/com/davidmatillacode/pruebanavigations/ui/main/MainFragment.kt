package com.davidmatillacode.pruebanavigations.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.davidmatillacode.pruebanavigations.R

class MainFragment : Fragment() {


    private var navController: NavController? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nestedNavHostFragment = childFragmentManager.findFragmentById(R.id.nav_host_fragment_subfragment) as? NavHostFragment
        navController = nestedNavHostFragment?.navController
        listenBackStack()
    }

    private fun listenBackStack() {

        // Get NavHostFragment
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_host_fragment_subfragment)

        // ChildFragmentManager of the current NavHostFragment
        val navHostChildFragmentManager = navHostFragment?.childFragmentManager

        navHostChildFragmentManager?.addOnBackStackChangedListener {

            val backStackEntryCount = navHostChildFragmentManager.backStackEntryCount
            val fragments = navHostChildFragmentManager.fragments

            Toast.makeText(
                requireContext(),
                "HomeNavHost backStackEntryCount: $backStackEntryCount, fragments: $fragments",
                Toast.LENGTH_SHORT
            ).show()
        }


        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

                val backStackEntryCount = navHostChildFragmentManager!!.backStackEntryCount

                Toast.makeText(
                    requireContext(),
                    "HomeNavHost backStackEntryCount: $backStackEntryCount",
                    Toast.LENGTH_SHORT
                ).show()


                if (backStackEntryCount == 0) {
                    OnBackPressedCallback@ this.isEnabled = false
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                } else {
                    navController?.navigateUp()
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

    }
}