package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.SessionService;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/events/{eventId}/sessions")
@RestController
public class SessionController extends BaseReadWriteController<MemberPayload, Member, Integer> {

        @Autowired
       private SessionService sessionService;

        //add session


}
