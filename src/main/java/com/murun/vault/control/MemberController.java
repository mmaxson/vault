package com.murun.vault.control;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.murun.vault.model.Member;
import com.murun.vault.model.Site;
import com.murun.vault.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

@RestController
@RequestMapping(value="/member",  produces = MediaType.APPLICATION_JSON_VALUE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private MemberService memberService;


    @GetMapping(value = "/id/{memberId}")
    public ResponseEntity<Member> getMemberByMemberId(@PathVariable("memberId") Integer memberId) {
        if (memberId <= 0) {
            throw new IllegalArgumentException(memberId + " is not a valid member id.");
        }

        Member member = memberService.getMemberByMemberId(memberId);
        return new ResponseEntity<Member>(member, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping(value = "/sites/id/{memberId}")
    public ResponseEntity<Set<Site>> getSitesByMemberId(@PathVariable("memberId") Integer memberId) {
        if (memberId <= 0) {
            throw new IllegalArgumentException(memberId + " is not a valid member id.");
        }

        Set<Site> memberSites = memberService.getSitesByMemberId(memberId);
        return new ResponseEntity<Set<Site>>(memberSites, new HttpHeaders(), HttpStatus.OK);
    }
}
