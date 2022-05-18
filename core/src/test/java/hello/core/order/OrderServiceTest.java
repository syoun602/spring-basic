package hello.core.order;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    private final MemberServiceImpl memberService = new MemberServiceImpl();
    private final OrderServiceImpl orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        // given
        final Long memberId = 1L;
        final Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        final Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        assertThat(order).usingRecursiveComparison()
                .isEqualTo(new Order(1L, "itemA", 10000, 1000));
    }

}
