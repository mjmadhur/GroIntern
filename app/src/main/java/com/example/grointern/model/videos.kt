package com.example.grointern.model

class videos :java.io.Serializable {
    var creat:String=""
    var clipurl:String=""
var videourl:String=""
    var liks:String=""
    fun setcretorname(mj:String){
        creat=mj
    }
    fun getcreatorname():String{
        return creat
    }
    fun setvideourl(vurrl:String){
        videourl=vurrl
    }
    fun getvideourl():String{
        return videourl
    }
    fun setclipurl(vu:String){
        clipurl=vu
    }
    fun getclipurl():String{
        return clipurl
    }
    fun setlikes(like:String){
        liks=like
    }
    fun getlikes():String{
        return liks
    }
}