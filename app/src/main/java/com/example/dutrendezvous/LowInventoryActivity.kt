package com.example.dutrendezvous

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LowInventoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_low_inventory)

        val itemName =
            findViewById<EditText>(R.id.etItemName)

        val quantity =
            findViewById<EditText>(R.id.etQuantity)

        val addButton =
            findViewById<Button>(R.id.btnAddItem)

        val inventoryList =
            findViewById<TextView>(R.id.tvInventoryList)

        val prefs =
            getSharedPreferences(
                "InventoryData",
                MODE_PRIVATE
            )

        inventoryList.text =
            prefs.getString(
                "inventoryList",
                ""
            )

        addButton.setOnClickListener {

            val item =
                itemName.text.toString().trim()

            val qty =
                quantity.text.toString().trim()

            if (item.isNotEmpty() &&
                qty.isNotEmpty()
            ) {

                val currentList =
                    inventoryList.text.toString()

                val updatedList =
                    "$currentList\n$item - $qty left"

                inventoryList.text =
                    updatedList

                prefs.edit()
                    .putString(
                        "inventoryList",
                        updatedList
                    )
                    .apply()

                itemName.text.clear()
                quantity.text.clear()
            }
        }
    }
}