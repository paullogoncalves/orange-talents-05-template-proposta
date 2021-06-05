package br.com.orangetalent5.proposta.clientfeign.exception;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class CustomErrorDecoder implements ErrorDecoder {


    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        if (response.status() >= 400 && response.status() <= 499) {
           
            System.out.println("chegou o erro");
        }
        
        return new ResponseStatusException(HttpStatus.valueOf(response.status()), "NAO_ELEGIVEL"); 
}
    
} 