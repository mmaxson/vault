package com.murun.vault.repository;

import com.murun.vault.model.Member;
import com.murun.vault.model.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query("select site from Site as site where site.member.memberId = :memberId and site.userId = :userId")
    Set<Site> getMemberSitesFilterByUserId(@Param("memberId") Integer memberId, @Param("userId") String userId);

}


