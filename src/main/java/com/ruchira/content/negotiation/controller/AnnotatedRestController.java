package com.ruchira.content.negotiation.controller;

import com.ruchira.content.negotiation.vo.RequestVo;
import com.ruchira.content.negotiation.vo.ResponseVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
public class AnnotatedRestController {

    @PostMapping(value = "/annotation-based-api")
    public Mono<ResponseVo> annotationBasedAPI(@RequestBody Mono<RequestVo> requestVoMono) {
        return requestVoMono.map(requestVo -> {
            final ResponseVo  responseVo = new ResponseVo();
            responseVo.setId(1L);
            responseVo.setPayload(requestVo.getPayload());
            responseVo.setLocalDateTime(LocalDateTime.now());

            return responseVo;
        });
    }
}
