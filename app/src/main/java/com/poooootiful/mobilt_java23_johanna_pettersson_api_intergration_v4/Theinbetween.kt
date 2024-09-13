package com.poooootiful.mobilt_java23_johanna_pettersson_api_intergration_v4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class Theinbetween : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_theinbetween, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toexchange: Button = view.findViewById(R.id.toex)
        val toother: Button = view.findViewById(R.id.toother)



        toexchange.setOnClickListener(View.OnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.menu, Exchange()).addToBackStack(null).commit()
        })

        toother.setOnClickListener(View.OnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.menu,Other()).addToBackStack(null).commit()
        })
    }

}
