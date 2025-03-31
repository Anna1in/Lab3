package com.example.labandr2


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class InputFragment : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        val radioGroupCompany: RadioGroup = view.findViewById(R.id.radioGroupCompany)
        val radioGroupProduct: RadioGroup = view.findViewById(R.id.radioGroupProduct)
        val buttonOk: Button = view.findViewById(R.id.buttonok)

        buttonOk.setOnClickListener {
            val selectedCompanyId = radioGroupCompany.checkedRadioButtonId
            val selectedProductId = radioGroupProduct.checkedRadioButtonId

            if (selectedCompanyId == -1 || selectedProductId == -1) {
                Toast.makeText(activity, "Оберіть компанію та товар", Toast.LENGTH_SHORT).show()
            } else {
                val selectedCompany = view.findViewById<RadioButton>(selectedCompanyId).text.toString()
                val selectedProduct = view.findViewById<RadioButton>(selectedProductId).text.toString()
                activityCallback?.showResult(selectedCompany, selectedProduct)
            }


        }

        return view
    }

}