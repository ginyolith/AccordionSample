package com.ginyolith.accordionsample

import android.view.View
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.ginyolith.accordionsample.databinding.ItemAccordionChildBinding
import com.ginyolith.accordionsample.databinding.ItemAccordionParentBinding

@EpoxyModelClass(layout = R.layout.item_accordion_parent)
abstract class ParentModel : DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var parent: AccordionValues.Parent

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var onClick: (AccordionValues.Parent) -> Unit

    private var isExpandedForView : Boolean = false

    override fun setDataBindingVariables(binding: ViewDataBinding?) {
        require(binding is ItemAccordionParentBinding)

        binding.text.text = parent.text
        isExpandedForView = parent.isExpanded

        binding.root.setOnClickListener {
            onClick.invoke(parent)
            isExpandedForView = !isExpandedForView
            changeIconVisibility(binding)
        }

        changeIconVisibility(binding)
    }

    private fun changeIconVisibility(binding : ItemAccordionParentBinding) {
        binding.iconClose.visibility = if(isExpandedForView) View.GONE else View.VISIBLE
        binding.iconOpen.visibility = if(isExpandedForView) View.VISIBLE else View.GONE
    }
}