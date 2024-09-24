package com.example.recycledata

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datarecycle.Item
import com.example.datarecycle.ItemAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter
    private val itemList = mutableListOf<Item>()
    private var itemCount = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemList.add(Item("Item 1"))
        itemList.add(Item("Item 2"))
        itemList.add(Item("Item 3"))

        itemAdapter = ItemAdapter(itemList)
        recyclerView.adapter = itemAdapter

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        buttonAdd.setOnClickListener {
            itemList.add(Item("Item $itemCount"))
            itemCount++
            itemAdapter.notifyDataSetChanged()
        }
    }
}
