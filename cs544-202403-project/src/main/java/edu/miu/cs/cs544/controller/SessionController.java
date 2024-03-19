package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.service.EventService;
import edu.miu.cs.cs544.service.SessionService;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/events/{eventId}/sessions")
@RestController
public class SessionController extends BaseReadWriteController<MemberPayload, Member, Integer> {

        @Autowired
       private SessionService sessionService;

        @Autowired
        private EventService eventService;

        //add session


        @GetMapping("/{sessionId}")
        public Session getSession(@PathVariable("eventId") Integer eventId,@PathVariable("sessionId") Integer sessionId){
           List<Session> sessionList =  eventService.getEventById(eventId).getSchedule();
           for(Session session : sessionList){
               if(session.getSessionId() == sessionId){
                   return ResponseEntity(session,HttpStatus.OK);
               }
           }
        }
}
