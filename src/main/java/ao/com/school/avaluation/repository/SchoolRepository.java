package ao.com.school.avaluation.repository;

import ao.com.school.avaluation.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
