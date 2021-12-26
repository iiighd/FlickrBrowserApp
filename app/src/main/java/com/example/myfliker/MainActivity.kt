package com.example.myfliker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.myfliker.Adapter
class MainActivity : AppCompatActivity() {
    lateinit var photoList: PhotoCollection
    lateinit var photosRecyclerView: RecyclerView
    lateinit var searchEditText: EditText
    lateinit var searchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        photosRecyclerView = findViewById(R.id.photos_rv)
        photosRecyclerView.layoutManager = LinearLayoutManager(this)

        searchEditText = findViewById(R.id.search_et)
        searchButton = findViewById(R.id.search_btn)
        searchButton.setOnClickListener{
            if (searchEditText.text.toString().isNotEmpty()){
                getPhotos(searchEditText.text.toString())
                searchEditText.setText("")
            } else
                Toast.makeText(this, "Please enter a search KEYWORD", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getPhotos(searchKey: String) {
        val apiInterface = APIClient().getClient()?.create(APIInterface:: class.java)
        val call: Call<PhotoCollection?>? = apiInterface!!.getPhotos(searchKey)
        call?.enqueue(object : Callback<PhotoCollection?>{
            override fun onResponse(
                call: Call<PhotoCollection?>,
                response: Response<PhotoCollection?>
            ) {
                TODO("Not yet implemented")
                photoList = response.body()!!
                photosRecyclerView.adapter = Adapter(this@MainActivity, photoList)
            }

            override fun onFailure(call: Call<PhotoCollection?>, t: Throwable) {
                TODO("Not yet implemented")
                Toast.makeText(this@MainActivity,t.message , Toast.LENGTH_SHORT).show()
                Log.d("THE ERROR MeSSAGE, ${t.message}","")
                call.cancel()

            }
        })
    }

}