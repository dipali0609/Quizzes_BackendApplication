package com.quiz.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.quiz.dao.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>
{
	
//	@Query(value=" select * from quiz where start_date<=NOW()  AND  end_date> NOW();", nativeQuery = true)
//	Optional<Quiz> findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndStatus(
//            LocalDateTime startDate, LocalDateTime endDate, QuizStatus status);

	
	@Query(value=" select * from quiz where status=?1", nativeQuery = true)
	List<Quiz> findByStatus(String string);

}
	


