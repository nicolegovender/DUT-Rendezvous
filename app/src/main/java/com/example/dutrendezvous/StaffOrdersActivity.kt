package com.example.dutrendezvous

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StaffOrdersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        val tvFilterAll = findViewById<TextView>(R.id.tvFilterAll)
        val tvFilterPending = findViewById<TextView>(R.id.tvFilterPending)
        val tvFilterCompleted = findViewById<TextView>(R.id.tvFilterCompleted)

        val order1 = findViewById<LinearLayout>(R.id.order1)
        val order2 = findViewById<LinearLayout>(R.id.order2)
        val order3 = findViewById<LinearLayout>(R.id.order3)
        val order4 = findViewById<LinearLayout>(R.id.order4)
        val order5 = findViewById<LinearLayout>(R.id.order5)

        // Default tab = Pending
        showPendingOrders(order1, order2, order3, order4, order5)
        selectTab(tvFilterPending, tvFilterAll, tvFilterCompleted)

        tvFilterAll.setOnClickListener {

            order1.visibility = View.VISIBLE
            order2.visibility = View.VISIBLE
            order3.visibility = View.VISIBLE
            order4.visibility = View.VISIBLE
            order5.visibility = View.VISIBLE

            selectTab(
                tvFilterAll,
                tvFilterPending,
                tvFilterCompleted
            )
        }

        tvFilterPending.setOnClickListener {

            showPendingOrders(
                order1,
                order2,
                order3,
                order4,
                order5
            )

            selectTab(
                tvFilterPending,
                tvFilterAll,
                tvFilterCompleted
            )
        }

        tvFilterCompleted.setOnClickListener {

            order1.visibility = View.GONE
            order2.visibility = View.GONE
            order3.visibility = View.GONE

            order4.visibility = View.VISIBLE
            order5.visibility = View.VISIBLE

            selectTab(
                tvFilterCompleted,
                tvFilterAll,
                tvFilterPending
            )
        }
    }

    private fun showPendingOrders(
        order1: LinearLayout,
        order2: LinearLayout,
        order3: LinearLayout,
        order4: LinearLayout,
        order5: LinearLayout
    ) {

        order1.visibility = View.VISIBLE
        order2.visibility = View.VISIBLE
        order3.visibility = View.VISIBLE

        order4.visibility = View.GONE
        order5.visibility = View.GONE
    }

    private fun selectTab(
        selected: TextView,
        other1: TextView,
        other2: TextView
    ) {

        selected.setBackgroundColor(
            Color.parseColor("#4CAF50")
        )
        selected.setTextColor(Color.WHITE)

        other1.setBackgroundColor(Color.TRANSPARENT)
        other1.setTextColor(Color.GRAY)

        other2.setBackgroundColor(Color.TRANSPARENT)
        other2.setTextColor(Color.GRAY)
    }
}
