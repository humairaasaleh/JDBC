package com.main;

public class Runner {

	public static void main(String[] args) {

//		SETUP AND CONNECTION
		SetUp setup = new SetUp("root", "root");
//		setup.testConnection();
		
//		CREATE
//		Animals elephant = new Animals("Elephant","Grey");
//		setup.create(elephant);
		
//		CREATE PREPARED
//		Animals shark = new Animals("Shark", "White");
//		setup.createPrepared(shark);
		
		
// 		DELETE		
//		setup.delete(3);
		
//		DELETE PREPARED
//		setup.deletePrepared(10);
		
//		UPDATE
//		Animals z = new Animals(1, "Zebra", "Black and White");
//		setup.update(z, 1);
		
//		UPDATE PREPARED
//		Animals shark = new Animals(13,"Shark","Grey");
//		setup.updatePrepared(shark);
		
//		READ BY ID
//		System.out.println(setup.readById(6));
		
//		READ BY ID PREPARED
//		System.out.println(setup.readByIdPrepared(13));
		
//		READ ALL
		System.out.println(setup.readAll());
		
//		READ LATEST
//		System.out.println(setup.readLatest());
		


	}

}