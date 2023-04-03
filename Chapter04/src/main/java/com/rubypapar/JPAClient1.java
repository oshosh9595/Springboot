package com.rubypapar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypapar.domain.Board;

public class JPAClient1 {

	public static void main(String[] args) {
		
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		insertBoard(emf);
		emf.close();
	}

	private static void insertBoard(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Board board = new Board();
			board.setTitle("JPA제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 되네요");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			em.persist(board);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();;
		}finally {
			em.close();
		}
		
	}

}
