package hello.core.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        final Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        final Member foundMember = memberService.findMember(1L);

        // then
        assertThat(member).usingRecursiveComparison()
                .isEqualTo(foundMember);
    }
}
