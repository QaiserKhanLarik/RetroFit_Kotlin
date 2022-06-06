package com.example.first.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Users : Serializable {

    var name:String ?= null;
    var email:String ?= null;
    var gender:String ?= null;

}