package com.ginyolith.accordionsample

data class AccordionValues(
    val parents: List<Parent>
) {
    data class Parent(val id: String, val text :String, val children: List<Child>, val isExpanded: Boolean = false) {
        fun toggleIsExpanded() : Parent {
            return this.copy(isExpanded = !isExpanded)
        }

        override fun equals(other: Any?): Boolean {
            return if (other is Parent) {
                other.id == id
            } else {
                false
            }
        }

        override fun hashCode(): Int {
            return id.hashCode()
        }
    }

    data class Child(val id: String, val text :String)

    fun toggleExpanded(parent: Parent): AccordionValues {
        val toggledParents = parents
            .map {
                if (it == parent) {
                    it.toggleIsExpanded()
                } else {
                    it
                }
            }

        return this.copy(
            parents = toggledParents
        )
    }
}