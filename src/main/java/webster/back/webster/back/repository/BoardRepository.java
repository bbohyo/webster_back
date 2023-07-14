package webster.back.webster.back.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import webster.back.webster.back.domain.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<GroupEntity, Long> {

}

