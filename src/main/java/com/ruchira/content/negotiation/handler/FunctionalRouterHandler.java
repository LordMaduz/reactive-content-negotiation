package com.ruchira.content.negotiation.handler;

import com.ruchira.content.negotiation.vo.RequestVo;
import com.ruchira.content.negotiation.vo.ResponseVo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
@RequiredArgsConstructor
public class FunctionalRouterHandler {

    public Mono<ServerResponse> functionalBasedAPI(final ServerRequest serverRequest) {

        final Mono<ResponseVo> mono = serverRequest.bodyToMono(RequestVo.class).flatMap(this::sendResponse);
        final AtomicReference<MediaType> mediaType = new AtomicReference<>(MediaType.APPLICATION_JSON);
        serverRequest.headers().accept().stream().filter(type-> !type.equals(MediaType.ALL)).findFirst().ifPresent(mediaType::set);

        return Mono
                .from(mono)
                .flatMap(p -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(mediaType.get())
                        .body(fromValue(p))
                );
    }

    public Mono<ResponseVo> sendResponse(@RequestBody final RequestVo requestVo){
        final ResponseVo responseVo = new ResponseVo();
        responseVo.setId(1L);
        responseVo.setPayload(requestVo.getPayload());
        responseVo.setLocalDateTime(LocalDateTime.now());
        return Mono.just(responseVo);
    }
}
