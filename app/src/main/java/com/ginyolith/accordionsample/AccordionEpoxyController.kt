package com.ginyolith.accordionsample

import com.airbnb.epoxy.TypedEpoxyController

class AccordionEpoxyController : TypedEpoxyController<AccordionValues>() {

    private val executeExpand : (AccordionValues.Parent) -> Unit = {
        val expanded = currentValues?.toggleExpanded(it)
        setData(expanded)
    }

    private var currentValues : AccordionValues? = null

    override fun buildModels(data: AccordionValues?) {
        currentValues = data
        if (data == null) {
            return
        }

        data.parents.forEach { parent ->
            parent {
                id(parent.hashCode())
                onClick(executeExpand)
                parent(parent)
            }

            if (parent.isExpanded) {
                parent.children.forEach { child ->
                    child {
                        id(child.hashCode())
                        child(child)
                    }
                }
            }
        }
    }
}