package com.ruchira.content.negotiation.router;

import com.ruchira.content.negotiation.constant.EndPointConstant;
import com.ruchira.content.negotiation.handler.FunctionalRouterHandler;
import com.ruchira.content.negotiation.vo.ResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class RouterConfig {

    @Bean
    @RouterOperations(
            {
                    @RouterOperation(path = EndPointConstant.FUNCTIONAL_API_PATH, produces = {
                            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                            consumes = {
                                    MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                            beanClass = FunctionalRouterHandler.class, method = RequestMethod.POST, beanMethod = "sendResponse",
                            operation = @Operation(operationId = "sendResponse", responses = {
                                    @ApiResponse(responseCode = "200", description = "Successful Operation",
                                            content = @Content(schema = @Schema(implementation = ResponseVo.class))),
                            }
                            )),
            })
    public RouterFunction<ServerResponse> routes(FunctionalRouterHandler routerHandler) {
        return RouterFunctions
                .route(POST(EndPointConstant.FUNCTIONAL_API_PATH)
                        , routerHandler::functionalBasedAPI)
                ;
    }
}
