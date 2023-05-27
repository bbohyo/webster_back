package webster.back.webster.back.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import webster.back.webster.back.domain.Member;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member){
    em.persist(member);
    }
    public Member findOne(Long id){
        return em.find(Member.class, id);
    }
    public List<Member> findAll(){
        return  em.createQuery("select m from Member m",Member.class)
                .getResultList();

    }
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name=:name",Member.class)
                .setParameter("name",name)
                .getResultList();
    }
    public List<Member> findByEmail(String email){
        return em.createQuery("select m from Member m where m.email=:email",Member.class)
                .setParameter("email",email)
                .getResultList();
    }

    public  List<Member> findByEmailAndPassword(String email, String password){
        return em.createQuery("select m from Member m where m.email=:email and m.password=:password",Member.class)
                .setParameter("email",email)
                .setParameter("password",password)
                .getResultList();
    }


}
