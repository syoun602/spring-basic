package hello.core.member;

public interface MemberRepository {

    void save(final Member member);

    Member findById(final Long memberId);
}
