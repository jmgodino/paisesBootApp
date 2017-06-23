package com.picoto;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "paises")
public class Pais {

	@Id ObjectId databaseId;
	
    public Integer id;

    public String des;



    public Pais() {
		super();
    }



	public Pais(Integer id, String des) {
		super();
		this.id = id;
		this.des = des;
	}



	@Override
	public String toString() {
		return "Pais [id=" + id + ", des=" + des + "]";
	}



	
}