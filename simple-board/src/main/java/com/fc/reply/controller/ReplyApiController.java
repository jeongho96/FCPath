package com.fc.reply.controller;

import com.fc.crud.CRUDAbstractApiController;
import com.fc.reply.db.ReplyEntity;
import com.fc.reply.model.ReplyDto;
import com.fc.reply.model.ReplyRequest;
import com.fc.reply.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyApiController extends CRUDAbstractApiController<ReplyDto, ReplyEntity> {

//    private final ReplyService replyService;
//
//    @PostMapping("")
//    public ReplyEntity create(
//            @Valid
//            @RequestBody ReplyRequest replyRequest
//    ){
//        return replyService.create(replyRequest);
//    }

}