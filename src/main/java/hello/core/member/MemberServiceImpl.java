package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //("여기에 이름을 넣어줄 수 있음")
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired  // ac.getBean(MemberRepository.class)의 느낌
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getmemberRepository(){
        return memberRepository;
    }
}
