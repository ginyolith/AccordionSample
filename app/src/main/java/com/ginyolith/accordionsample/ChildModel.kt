package com.ginyolith.accordionsample

import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.ginyolith.accordionsample.databinding.ItemAccordionChildBinding

@EpoxyModelClass(layout = R.layout.item_accordion_child)
abstract class ChildModel : DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var child: AccordionValues.Child

    override fun setDataBindingVariables(binding: ViewDataBinding?) {
        require(binding is ItemAccordionChildBinding)

        binding.text.text = child.text
    }
}