package com.example.labandr2


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResultFragment : Fragment() {

    private var activityCallback: MainActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            activityCallback = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        val textViewResult: TextView = view.findViewById(R.id.textViewResult)
        val buttonCancel: Button = view.findViewById(R.id.buttonCancel)

        val selectedCompany = arguments?.getString("company")
        val selectedProduct = arguments?.getString("product")

        textViewResult.text = "Компанія: $selectedCompany\nТовар: $selectedProduct"

        buttonCancel.setOnClickListener {
            activityCallback?.goBackToInput()
        }


        return view
    }

    companion object {
        fun newInstance(company: String, product: String): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            args.putString("company", company)
            args.putString("product", product)
            fragment.arguments = args
            return fragment
        }
    }
}