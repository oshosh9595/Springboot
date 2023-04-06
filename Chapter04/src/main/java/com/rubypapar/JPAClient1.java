package com.rubypapar;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.rubypapar.domain.Board;


public class JPAClient1 {

	public static void main(String[] args) {
		
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		//EntityManager em = emf.createEntityManager();
		
		// Transaction 생성
		//EntityTransaction tx = em.getTransaction();
		
		// 데이터 입력
		insertBoard(emf);
		// id가 1인 데이터를 출력
		findBoardOne(emf, 1L);
		// 입력된 전체 데이터를 출력(JPA Query = JPA 에서만 사용하는 쿼리문)
		findBoardManyJPAQuery(emf);
		// 입력된 전체 데이터를 출력(Native Query = 데이터베이스에서 사용햇던 쿼리 흔히쓰는 SQL) 
		findBoardManyNativeQuery(emf);
		
		// id가 1인 데이터를 수정
		updateBoard(emf, 1L);
		// 수정된 정보를 확인
		//findBoardOne(emf, 1L);
		
		// id가 2인 데이터를 삭제
		deleteBoard(emf, 2L);
		// 삭제 결과를 확인
		//findBoardManyJPAQuery(emf);
		
		emf.close();
	}

	private static void insertBoard(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			for(int i = 0; i < 10; i ++) {
				tx.begin();
				
				Board board = new Board();
				board.setTitle("JPA제목");
				board.setWriter("관리자");
				board.setContent("JPA 글 등록 잘 되네요");
				board.setCreateDate(new Date());
				board.setCnt(0L);
				
				em.persist(board);
				
				tx.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();;
		}finally {
			em.close();
		}
	}

	private static void findBoardOne(EntityManagerFactory emf, long seq) {
		EntityManager em = emf.createEntityManager();
		try {
			//글상세 조회
			Board searchBoard = em.find(Board.class, 1L);
			System.out.println("--->" + searchBoard.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.clear();
			//emf.close();
		}
		
	}
	
	private static void findBoardManyJPAQuery(EntityManagerFactory emf) {

		System.out.println("findBoardManyJPAQuery");
		
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Board> result = em.createQuery("select b from Board b", Board.class);
		List<Board> list = result.getResultList();
		//List<Board> list = createQuery("select b from Board b", Board.class);
		for(Board b : list) {
			System.out.println(b);
		}
		//.repeat(80)"은 문자열을 반복해서 출력하는 기능을 수행하는 메소드입니다
		System.out.println("=".repeat(80));
		
		em.close();
	}
	
	private static void findBoardManyNativeQuery(EntityManagerFactory emf) {
		
		System.out.println("findBoardManyNativeQuery");
		
		EntityManager em = emf.createEntityManager();
		
		//방법1
		List<?> list1 = em.createNativeQuery("select * from Board", Board.class).getResultList();
		for(Object b : list1) {
			System.out.println(b);
		}
		System.out.println("-".repeat(80));
		
		//방법2
		@SuppressWarnings("unchecked")
		List<Object[]> list2 = em.createNativeQuery("select * from Board").getResultList();
		for(Object[] b : list2) {
			for(int i = 0; i < b.length; i++) {
				if(i != 0) System.out.println(",");
				System.out.println(b[i]);
			}
			System.out.println();
		}
		System.out.println("=".repeat(80));
		em.close();
	}
	
	private static void updateBoard(EntityManagerFactory emf, long seq) {
		
		System.out.println("updateBoard");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Board board = em.find(Board.class, 1L);
			board.setTitle("검색한 게시글의 제목 수정");
		
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			
			tx.rollback();
		}finally {
			em.close();
		}
	}
	
	private static void deleteBoard(EntityManagerFactory emf, long seq) {
		System.out.println("deleteBoard");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			// 삭제 게시글 조회
			Board board1 = em.find(Board.class, 2L);
			board1.setSeq(2L);
			
			// 게시글 삭제
			board1.setSeq(2L);
			em.remove(board1);
			
			//Transaction commit
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		
	}
	
}
