package com.example.dutrendezvous
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class CartActivity : AppCompatActivity() {
    private lateinit var listViewCartItems: ListView
    private lateinit var textViewTotal: TextView
    private lateinit var buttonCheckout: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Connect this Kotlin file to activity_cart.xml
        setContentView(R.layout.activity_cart)
        // Connect Kotlin variables to the views in the XML
        listViewCartItems = findViewById<ListView>(R.id.listViewCartItems)
        textViewTotal = findViewById<TextView>(R.id.tvCartTotal)
        buttonCheckout = findViewById<Button>(R.id.btnCartCheckout)
        // Items currently in the cart, NEED ACTUAL ITEMS
        val cartItems = arrayOf(
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
            "Item 6",
            "Item 7",
            "Item 8",
            "Item 9",
            "Item 10",
            "Item 11"
        )
        // Display the items in the ListView
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            cartItems
        )

        //CHECK THIS WHEN MERGING
        //listViewCartItems.adapter = adapter
        //val itemsPrices = listof(actual prices on page)
        //val total = itemsPrices.sum()
        //textViewTotal.text = "TOTAL: R${"%.2f".format(total)"}"
        // Checkout button
        buttonCheckout.setOnClickListener {
            Toast.makeText(
                this@CartActivity, "Proceeding to checkout...", Toast.LENGTH_SHORT
            ).show()

            val cartButton = findViewById<Button>(R.id.btnCartButton)
            cartButton.setOnClickListener {
                val intent = Intent(this, CartActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

/* WHAT THE ACTUAL CODE SHOULD LOOK LIKE WITH ACTUAL DATA
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_cart)

    // Initialize views
    listViewCartItems = findViewById(R.id.listViewCartItems)
    textViewTotal = findViewById(R.id.tvCartTotal)
    buttonCheckout = findViewById(R.id.btnCartCheckout)

    // 1. Get the cart items (Example: from an Intent or a database)
    // For now, let's pretend we have a list of items with prices
    val cartItems = listOf("Burger - R50.00", "Fries - R20.00", "Drink - R15.00")

    // 2. Setup the ListView
    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cartItems)
    listViewCartItems.adapter = adapter

    // 3. Calculate the total dynamically
    // In a real app, you would sum the actual prices of the items in the cart
    val totalAmount = 85.00 // This would be calculated, not hardcoded

    // 4. Update the TextView
    textViewTotal.text = "TOTAL: R${"%.2f".format(totalAmount)}"

    // 5. Setup Checkout Button
    buttonCheckout.setOnClickListener {
        Toast.makeText(this@CartActivity, "Proceeding to checkout...", Toast.LENGTH_SHORT).show()
        // Pass the totalAmount to the next activity if needed
    }
}

 */