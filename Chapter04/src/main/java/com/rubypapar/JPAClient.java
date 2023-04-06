package com.rubypapar;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypapar.domain.Board;
import com.rubypapar.domain.Board1;

public class JPAClient {

	public static void main(String[] args) {
		
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			for(int i = 0; i<=10; i++) {
				Board board = Board.builder()
								.title("title" + i)
								.content("content" + i)
								.writer("writer" + i)
								//.creatDate("creatDate" + i)
								.build();
				em.persist(board);
								
			}
			tx.commit();
			
			tx.begin();
			for(int i = 1; i <= 10; i++) {
				Board1 board1 = Board1.builder()
								.title("title" + i)
								.content("content" + i)
								.writer("writer" + i)
								.creatDate(new Date())
								.build();
				em.persist(board1);
			}
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			// Transaction rollback
			tx.rollback();
		}finally {
			em.close();
			emf.close();
		}
	}

}
