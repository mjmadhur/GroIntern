package com.example.grointern

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.grointern.TriedExoplaYER.VideoAdap
import com.example.grointern.adapter.VideoAdapter
import com.example.grointern.model.MediaObject
import com.example.grointern.model.videos
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException

class MainActivity :BaseActivity() {
    private var mRequestQueue: RequestQueue? = null
    private var mStringRequest: StringRequest? = null
    private var requestQueue: RequestQueue? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: VideoAdapter
    var firstName:String=""
    lateinit var nj:TextView
    lateinit var thnl:String

    lateinit var medurl:String
    lateinit var likess:String
    var adap: VideoAdap? = null
    var vilist:ArrayList<MediaObject> = ArrayList<MediaObject>()
    var list:ArrayList<videos> = ArrayList<videos>()
    var vurls:ArrayList<String> = ArrayList<String>()
    private val url = "https://internship-service.onrender.com/videos?page=2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        requestQueue = Volley.newRequestQueue(this)
        setContentView(R.layout.activity_main)



showLoadingDialog()
        getData()




    }



    fun getData() {
        // RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this)

        // String Request initialized
        val request = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            try {
                val jsonArray = response.getJSONObject("data")
                val jb=jsonArray.getJSONArray("posts")

                for (i in 0 until jb.length()) {

                    var pm:videos= videos()

var bj=jb.getJSONObject(i)

                    val njj=bj.getJSONObject("creator")
                    firstName=njj.getString("name")
                    pm.setcretorname(firstName)
val thumb=bj.getJSONObject("submission")
                    thnl=thumb.getString("thumbnail")
pm.setvideourl(thnl)
                    medurl=thumb.getString("mediaUrl")
pm.setclipurl(medurl)
val rcn=bj.getJSONObject("reaction")
                    likess=rcn.getString("count")
                    pm.setlikes(likess)

                    list.add(pm)
vurls.add(medurl)
                    }

                Toast.makeText(this,list[0].getvideourl().toString(),Toast.LENGTH_LONG).show()
                for (agil in 0 until list.size)  // using for loop
                {
                    Log.e("Agil_Limits - ", list[agil].getcreatorname().toString()+"\n"+list[agil].getvideourl().toUri())
                }
               // Log.e("mj",list.size.toString())
                setadap()

hideLoading()








            }


            catch (e: JSONException) {
                e.printStackTrace()
            }
        }, { error -> error.printStackTrace()
        })
        requestQueue?.add(request)
    }
    /*fun initvideos() {

        /*rvvideos.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val ver=VerticalSpacingItemDecorator(10)
        rvvideos.addItemDecoration(ver)
        val source:ArrayList<MediaObject> = ArrayList()
        rvvideos.setMediaObjects(
            source
        )
        val adapp=VideoPlayerRecyclerAdapter(source,initglide())
        rvvideos.adapter=adapp
        getData()


    }*/

    private fun initglide():RequestManager {
        val op=RequestOptions().placeholder(edmt.dev.videoplayer.R.drawable.white_background).error(edmt.dev.videoplayer.R.drawable.white_background)
        return Glide.with(this).setDefaultRequestOptions(op)
    }*/

        fun setadap() {
            adap = VideoAdap(this, list)
            val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            rvvideos.layoutManager = linearLayoutManager
            rvvideos.adapter = adap

        }
    fun setvideo(){

        recyclerView = findViewById(R.id.rvvideos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = VideoAdapter(this,list)
        recyclerView.adapter = adapter
    }
    }


