package com.example.dutrendezvous

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StaffReservationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val tvFilterAll = findViewById<TextView>(R.id.tvResFilterAll)
        val tvFilterToday = findViewById<TextView>(R.id.tvResFilterToday)
        val tvFilterUpcoming = findViewById<TextView>(R.id.tvResFilterUpcoming)

        val res1 = findViewById<LinearLayout>(R.id.res1)
        val res2 = findViewById<LinearLayout>(R.id.res2)
        val res3 = findViewById<LinearLayout>(R.id.res3)
        val res4 = findViewById<LinearLayout>(R.id.res4)
        val res5 = findViewById<LinearLayout>(R.id.res5)

        // Default tab = Today
        showTodayReservations(
            res1,
            res2,
            res3,
            res4,
            res5
        )

        selectTab(
            tvFilterToday,
            tvFilterAll,
            tvFilterUpcoming
        )

        tvFilterAll.setOnClickListener {

            res1.visibility = View.VISIBLE
            res2.visibility = View.VISIBLE
            res3.visibility = View.VISIBLE
            res4.visibility = View.VISIBLE
            res5.visibility = View.VISIBLE

            selectTab(
                tvFilterAll,
                tvFilterToday,
                tvFilterUpcoming
            )
        }

        tvFilterToday.setOnClickListener {

            showTodayReservations(
                res1,
                res2,
                res3,
                res4,
                res5
            )

            selectTab(
                tvFilterToday,
                tvFilterAll,
                tvFilterUpcoming
            )
        }

        tvFilterUpcoming.setOnClickListener {

            res1.visibility = View.GONE
            res2.visibility = View.GONE
            res3.visibility = View.GONE

            res4.visibility = View.VISIBLE
            res5.visibility = View.VISIBLE

            selectTab(
                tvFilterUpcoming,
                tvFilterAll,
                tvFilterToday
            )
        }
    }

    private fun showTodayReservations(
        res1: LinearLayout,
        res2: LinearLayout,
        res3: LinearLayout,
        res4: LinearLayout,
        res5: LinearLayout
    ) {

        res1.visibility = View.VISIBLE
        res2.visibility = View.VISIBLE
        res3.visibility = View.VISIBLE

        res4.visibility = View.GONE
        res5.visibility = View.GONE
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
