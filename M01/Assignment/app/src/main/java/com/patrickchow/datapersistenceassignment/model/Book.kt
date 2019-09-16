package com.patrickchow.datapersistenceassignment.model

class Book{

    var title: String ?= null
    var reasonToRead: String ?= null
    var hasBeenRead: Boolean ?= null
    var id: String ?= null

    constructor(title:String, reasonToRead: String, hasBeenRead: Boolean, id:String){
        this.title = title
        this.reasonToRead = reasonToRead
        this.hasBeenRead = hasBeenRead
        this.id = id
    }

    constructor(csvString: String){
        //split takes in a string and separates them into separate values based on the delimiters
        //Ex: If string = People,Animal,Insect, it would return People Animal Insect in a list
        val values = csvString.split(",")

        //Check to see if the amount of values is correct or not
        if(values.size == 4){
            this.title = values[0]
            this.reasonToRead = values[1].replace("~@", ",")
            this.hasBeenRead = values[2].toBoolean()
            this.id = values[3]
        }
    }

    fun toCvsString(): String{
        return "$title,${reasonToRead?.replace(",","~@")},$hasBeenRead,$id"
    }

}