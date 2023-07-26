package webster.back.webster.back.repository;

import org.springframework.stereotype.Repository;
import webster.back.webster.back.domain.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BoardRepository extends JpaRepository<GroupEntity, Long> {

}

