package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.Board;

public interface BoardRespository extends CrudRepository<Board, Long> {
}
