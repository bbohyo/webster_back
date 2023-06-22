package webster.back.webster.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import webster.back.webster.back.domain.Member;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value="SELECT * FROM member WHERE email=email AND password=password", nativeQuery = true)
    Optional<Member> findByEmailAndPassword(@Param("email")String email, @Param("password")String password);

    @Query(value="SELECT * FROM member WHERE email=email",nativeQuery = true)
    Optional<Member> findByEmail(@Param("email")String email);
}
