package com.murun.vault.service;

import com.murun.vault.model.Member;
import com.murun.vault.model.Site;
import com.murun.vault.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;


@Service
@Transactional
public class MemberService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    MemberRepository memberRepository;

    public Member getMemberByMemberId(Integer memberId) {
        logger.info("getMemberByMemberId  " + memberId );
        return memberRepository.getOne(memberId);
    }

    public Set<Site> getSitesByMemberId(Integer memberId) {
    //    logger.info("getSitesByMemberId (pageRequest) " + pageRequest.getPageNumber() + ':' + pageRequest.getPageSize() );
        return memberRepository.getOne(memberId).getSites();
    }
}