package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        // EntityManger를 가져오기 위한 EntityManagerFactory 변수 선언
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // EntityManagerFactory에서 EntityManger를 가져온다.
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 얻어오기
        EntityTransaction tx = em.getTransaction();

        // 트랜잭션 시작
        tx.begin();

        try {
//            Member findMember = em.find(Member.class, 2L); // PK를 통해 member 조회
//            findMember.setName("HelloJPA");

//            List<Member> result = em.createQuery("select m from Member m", Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }

            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속
//            em.persist(member);
//
//            final Member findMember = em.find(Member.class, 101L);
//            System.out.println("findmember.getId() = " + findMember.getId());
//            System.out.println("findmember.getName() = " + findMember.getName());

//            final Member findMember1 = em.find(Member.class, 101L);
//            final Member findMember2 = em.find(Member.class, 101L);
//            System.out.println("result = " + (findMember1 == findMember2));

//            final Member member1 = new Member(150L, "A");
//            final Member member2 = new Member(160L, "B");
//            System.out.println("=================");
//
//            em.persist(member1);
//            em.persist(member2);

//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAA");

            // 영속 -> 준영속 상태로 변경
//            em.detach(member);

            // 엔티티 매니저의 영속성 모두 지우기
//            em.clear();
//            Member member2 = em.find(Member.class, 150L);
//
//
//
//            System.out.println("=================");

//            final Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();

//            final Member member = new Member();
//            member.setName("C");
//
//            em.persist(member);

//            final Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            final Member member = new Member();
//            member.setUsername("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            final Member findMember = em.find(Member.class, member.getId());
//
//            final Long findTeamId = findMember.getTeamId();
//            final Team findTeam = em.find(Team.class, findTeamId);

//            final Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            final Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            final Member findMember = em.find(Member.class, member.getId());
//
//            final Team findTeam = findMember.getTeam();
//            System.out.println("findTeam.getId() = " + findTeam.getId());

//            final Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            final Member member = new Member();
//            member.setUsername("member1");
//            member.changeTeam(team);
//            em.persist(member);

//            em.flush();
//            em.clear();

//            final Team findTeam = em.find(Team.class, team.getId());
//            final List<Member> members = findTeam.getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }

//            final Member findMember = em.find(Member.class, member.getId());
//            final List<Member> members = findMember.getTeam().getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }

//            final Member member = new Member();
//            member.setUsername("member1");
//
//            em.persist(membRer);
//
//            final Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//
//            em.persist(team);


//            final Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getUsername() = " + findMember.getUsername());

//            final Member findMember = em.find(Member.class, member.getId());
//
//            System.out.println(findMember.getTeam().getClass());
//
//            // team proxy object initialize
//            findMember.getTeam().getName();
//            final Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            final Member member = new Member();
//            member.setUsername("jinpyo");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            final List<Member> members = em.createQuery("select m from Member m", Member.class)
//                    .getResultList();

//            final Child child1 = new Child();
//            final Child child2 = new Child();
//
//            final Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//
//            em.flush();
//            em.clear();
//
//            final Parent findParent = em.find(Parent.class, parent.getId());
//            em.remove(findParent );

//            final Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(new Address("homeCity1", "street1", "10000"));
//
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("족발");
//            member.getFavoriteFoods().add("피자");
//
//            member.getAddressHistory().add(new Address("old1", "street1", "10000"));
//            member.getAddressHistory().add(new Address("old2", "street1", "10000"));
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

            //값 타입 컬렉션은 지연 로딩
//            System.out.println("============================");
//            final Member findMember = em.find(Member.class, member.getId());

//            findMember.setHomeAddress(new Address("newCity", "street1", "10000"));

//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("불고기");

            // equals와 hashcode를 이용해 동등한 객체를 지운다.
//            findMember.getAddressHistory().remove(new Address("old1", "street1", "10000"));
//            findMember.getAddressHistory().add(new Address("newCity", "street1", "10000"));

//            final List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address = " + address);
//            }
//
//            final Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

//            final List<Member> members = em.createQuery(
//                    "select m from Member m where m.username like '%hello%'", Member.class
//            ).getResultList();
//
//            for (Member member : members) {
//                System.out.println("member = " + member);
//            }

//            final CriteriaBuilder cb = em.getCriteriaBuilder();
//            final CriteriaQuery<Member> query = cb.createQuery(Member.class);
//
//            final Root<Member> m = query.from(Member.class);
//            final CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
//            final List<Member> members = em.createQuery(cq).getResultList();

            em.createNativeQuery("select member_id, city, street, zipcode, username from member", Member.class)
                    .getResultList();

            // 트랜잭션 커밋
            tx.commit();
        } catch (Exception e) {
            // 예외 발생 시, 트랜잭션 롤백
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close(); // 자원 정리
        }

        emf.close(); // 자원 정리
    }
}
