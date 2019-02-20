package com.example.gyc.libdemo.bean

/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-20 下午 3:33
 */
data class ClientBean(
    val clients: Clients,
    val numreturned: Int,
    val result: String,
    val startnumber: Int,
    val totalresults: Int
)

data class Clients(
    val client: List<Client>
)

data class Client(
    val companyname: String,
    val datecreated: String,
    val email: String,
    val firstname: String,
    val groupid: Int,
    val id: Int,
    val lastname: String,
    val status: String
)