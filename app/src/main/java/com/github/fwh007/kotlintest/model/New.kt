package com.github.fwh007.kotlintest.model

/**
 * TODO 类说明
 *
 * @author : Winter
 */
data class New(
        var item_id: Long,
        val title: String?,
        val abstract: String,
        val source: String,
        val has_image:Boolean,
        val image_url: String?,
        val large_image_url:String?,
        val image_list: List<Map<String,String>>?,
        val content: String
){
    constructor(map:Map<String,Any?>) : this(1,"","","",false,"","",null,"") {

    }
}
