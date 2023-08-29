package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.sample_1,"가가가","010-1111-1111",false))
        dataList.add(MyItem(R.drawable.sample_2,"나나나","010-2222-2222",false))
        dataList.add(MyItem(R.drawable.sample_3,"다다다","010-3333-3333",false))
        dataList.add(MyItem(R.drawable.sample_4,"라라라","010-4444-4444",false))
        dataList.add(MyItem(R.drawable.sample_5,"마마마","010-5555-5555",false))
        dataList.add(MyItem(R.drawable.sample_6,"바바바","010-6666-6666",false))
        dataList.add(MyItem(R.drawable.sample_7,"사사사","010-7777-7777",false))
        dataList.add(MyItem(R.drawable.sample_8,"아아아","010-8888-8888",false))
        dataList.add(MyItem(R.drawable.sample_9,"자자자","010-9999-9999",false))
        dataList.add(MyItem(R.drawable.sample_10,"차차차","010-1212-1212",false))

        val adapter = Adapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}