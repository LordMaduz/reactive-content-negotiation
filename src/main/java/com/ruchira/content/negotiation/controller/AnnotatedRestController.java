package com.ruchira.content.negotiation.controller;

import com.ruchira.content.negotiation.constant.EndPointConstant;
import com.ruchira.content.negotiation.vo.RequestVo;
import com.ruchira.content.negotiation.vo.ResponseVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping(EndPointConstant.ANNOTATED_CONTROLLER_API_PATH)
public class AnnotatedRestController {

    @PostMapping()
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
