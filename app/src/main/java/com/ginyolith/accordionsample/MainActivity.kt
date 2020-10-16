package com.ginyolith.accordionsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ginyolith.accordionsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val controller = AccordionEpoxyController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.setController(controller)

        controller.setData(
            AccordionValues(
            parents = listOf(
                AccordionValues.Parent(
                    id = "1",
                    text = "親カテゴリ１",
                    children = listOf(
                        AccordionValues.Child(
                            id = "1",
                            text = "子要素1"
                        ),
                        AccordionValues.Child(
                            id = "2",
                            text = "子要素2"
                        )
                    )
                ),
                AccordionValues.Parent(
                    id = "2",
                    text = "親カテゴリ2",
                    children = listOf(
                        AccordionValues.Child(
                            id = "1",
                            text = "子要素1"
                        ),
                        AccordionValues.Child(
                            id = "2",
                            text = "子要素2"
                        )
                    )
                )
            )
        )

        )
    }
}