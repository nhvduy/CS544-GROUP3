package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.service.contract.MemberPayload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Member;


@RestController
@RequestMapping("/members")
public class MemberController extends BaseReadWriteController<MemberPayload, Member, Integer> {


}
