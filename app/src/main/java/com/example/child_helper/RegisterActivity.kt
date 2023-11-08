package com.example.child_helper

import Regi_ItemData
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.child_helper.Adapter.RegisterAdapter

class RegisterActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // 리사이클러 뷰
        val recyclerView = findViewById<RecyclerView>(R.id.Regiser_recyclerview)
        // 리니어 레이아웃 매니저.
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // 주소 초기 데이터 설정이 없다는 뜻.
        val data_address = mutableListOf<String>()
        // Adapter 기본 설정.
        val adapter_address = RegisterAdapter(data_address)
        recyclerView.adapter = adapter_address

        // 주소, 연락처, 메세지 추가 버튼.
        val address_Button = findViewById<Button>(R.id.Btn_address)
        val phone_Button = findViewById<Button>(R.id.Btn_Call)
        val message_Button = findViewById<Button>(R.id.Btn_message)


        // 연락처를 위한 변수.
        val data_phnone = mutableListOf<String>()

        // 등록 버튼
        val regi_Complete = findViewById<Button>(R.id.Regi_Complete)

        // 등록 누를 때에 데이터가 저장되는 변수
        val modifiedTextList = mutableListOf<String>()

        val a = 0;

        // 주소, 번호  리니어 레이아웃 추가를 위한 함수.
        address_Button.setOnClickListener {
            val newItem = Regi_ItemData("", "주소")
            adapter_address.addItem(newItem, "주소")
        }

        phone_Button.setOnClickListener {
            val newItem = Regi_ItemData("", "연락처")
            adapter_address.addItem(newItem, "연락처")
        }

        message_Button.setOnClickListener {
            val newItem = Regi_ItemData("", "메세지")
            adapter_address.addItem(newItem, "메세지 ")
        }

        // 주소 아이템 수정 버튼 클릭 이벤트에서 EditText의 값을 가져와 업데이트
        regi_Complete.setOnClickListener {

            val modifiedTextList = mutableListOf<String>()

            for (i in 0 until adapter_address.itemCount) {
                val viewHolder = recyclerView.findViewHolderForAdapterPosition(i) as RegisterAdapter.RegiViewHolder
                val modifiedText = viewHolder.regi_edt_address.text.toString()
                Toast.makeText(applicationContext, "$modifiedText", Toast.LENGTH_SHORT).show()
                modifiedTextList.add(modifiedText)
            }
        }

        // RecyclerView에서 주소 아이템 제거하기
        adapter_address.setOnItemClickListener(object : RegisterAdapter.OnItemClickListener {
            override fun onDeleteButtonClick(position: Int) {
                adapter_address.removeItem(position)
            }
        })


    }


}