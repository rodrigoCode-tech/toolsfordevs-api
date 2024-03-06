package com.rodrigobragadev.tools;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.util.Collections;

public class CpfGeneratorHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setHeaders(Collections.singletonMap("Access-Control-Allow-Origin", "*"));
        response.setStatusCode(200);
        String type = apiGatewayProxyRequestEvent.getQueryStringParameters().getOrDefault("type", "cpf");

        if ("cpf".equalsIgnoreCase(type)) {
            response.setBody(CpfGenerator.generateCPF());
        } else if ("cnpj".equalsIgnoreCase(type)) {
            response.setBody(CpfGenerator.generateCNPJ());
        } else {
            response.setStatusCode(400);
            response.setBody("Invalid document type. Use 'cpf' or 'cnpj'.");
        }

        return response;
    }
}
