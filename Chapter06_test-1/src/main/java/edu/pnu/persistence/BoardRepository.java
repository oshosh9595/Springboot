package edu.pnu.persistence;

import org.springframework.data.repository.CrudRepository;

import edu.pnu.domin.DBoard;

public interface BoardRepository extends CrudRepository<DBoard, Long> {

}
