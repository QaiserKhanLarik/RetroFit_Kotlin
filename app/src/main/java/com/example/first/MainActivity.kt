package com.example.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.first.Controller.MyApiCall
import com.example.first.Model.Users
import com.example.first.View.RecyclerAdapter
import com.google.gson.JsonElement
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.progress_circular);

        val recyclerView = findViewById<RecyclerView>(R.id.data);
        val recyclerAdapter = RecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val apiInterface = MyApiCall.create().getUsers();
        var list = ArrayList<Users> ()


        apiInterface.enqueue( object : Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>?, response: Response<JsonElement>?) {


                if(response!!.isSuccessful)
                {
                    var gson = JSONObject(response.body().toString())
                    var data = gson.getJSONArray("contacts");


                    for (i in 0..(data.length() - 1)) {

                        var name = data.getJSONObject(i).getString("name");
                        var email = data.getJSONObject(i).getString("email");
                        var gender = data.getJSONObject(i).getString("gender");

                       // Log.e("Name:",name );

                        var users = Users();
                        users.name = name
                        users.email = email
                        users.gender = gender

                        list.add(users);

                    }

                    recyclerView.adapter = recyclerAdapter;
                    recyclerAdapter.setUsersListItems(list);

                    progressBar.visibility = View.GONE;
                }

            }

            override fun onFailure(call: Call<JsonElement>?, t: Throwable?) {
                progressBar.visibility = View.GONE;

            }
        })




    }
}