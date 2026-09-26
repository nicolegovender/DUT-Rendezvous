package com.example.dutrendezvous

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(
        context,
        "DUTRendezvous.db",
        null,
        1
    ) {

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL(
            """
            CREATE TABLE Users (
                userId INTEGER PRIMARY KEY AUTOINCREMENT,
                fullName TEXT NOT NULL,
                phone TEXT NOT NULL,
                email TEXT NOT NULL,
                password TEXT NOT NULL
            )
            """
        )

        db.execSQL(
            """
            CREATE TABLE MenuItems (
                menuItemId INTEGER PRIMARY KEY AUTOINCREMENT,
                itemName TEXT NOT NULL,
                category TEXT NOT NULL,
                price REAL NOT NULL
            )
            """
        )

        db.execSQL(
            """
            CREATE TABLE Reservations (
                reservationId INTEGER PRIMARY KEY AUTOINCREMENT,
                fullName TEXT NOT NULL,
                reservationDate TEXT NOT NULL,
                reservationTime TEXT NOT NULL,
                guests INTEGER NOT NULL,
                specialRequests TEXT
            )
            """
        )

        db.execSQL(
            """
            CREATE TABLE Orders (
                orderId INTEGER PRIMARY KEY AUTOINCREMENT,
                userId INTEGER,
                orderDate TEXT,
                totalAmount REAL,
                status TEXT
            )
            """
        )

        db.execSQL(
            """
            CREATE TABLE OrderItems (
                orderItemId INTEGER PRIMARY KEY AUTOINCREMENT,
                orderId INTEGER,
                menuItemId INTEGER,
                quantity INTEGER
            )
            """
        )

        db.execSQL(
            """
            CREATE TABLE Inventory (
                inventoryId INTEGER PRIMARY KEY AUTOINCREMENT,
                itemName TEXT NOT NULL,
                quantity INTEGER NOT NULL
            )
            """
        )
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS Users")
        db.execSQL("DROP TABLE IF EXISTS MenuItems")
        db.execSQL("DROP TABLE IF EXISTS Reservations")
        db.execSQL("DROP TABLE IF EXISTS Orders")
        db.execSQL("DROP TABLE IF EXISTS OrderItems")
        db.execSQL("DROP TABLE IF EXISTS Inventory")

        onCreate(db)
    }

    fun insertUser(
        fullName: String,
        phone: String,
        email: String,
        password: String
    ): Boolean {

        val db = writableDatabase

        val values = ContentValues()
        values.put("fullName", fullName)
        values.put("phone", phone)
        values.put("email", email)
        values.put("password", password)

        val result = db.insert(
            "Users",
            null,
            values
        )

        db.close()

        return result != -1L
    }

    fun checkUser(
        email: String,
        password: String
    ): Boolean {

        val db = readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM Users WHERE email=? AND password=?",
            arrayOf(email, password)
        )

        val exists = cursor.count > 0

        cursor.close()
        db.close()

        return exists
    }
}