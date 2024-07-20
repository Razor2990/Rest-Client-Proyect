package com.proyect.client.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.proyect.client.model.MessageResponse;

public class Handle {
	
	/**
	 * metodo que nos ayuda a manejar la respuesta de la entidad de un restTemplate
	 * @param responseEntity
	 * @return Map
	 */
	public static Map<String, Object> response(ResponseEntity<Map<String, Object>> responseEntity) {
	    if (responseEntity.getStatusCode().is2xxSuccessful()) {
	        return responseEntity.getBody();
	    } else {
	        return handleOtherStatus(responseEntity.getStatusCode().value());
	    }
	}

	private static Map<String, Object> handleOtherStatus(int statusCode) {
	    // Lógica para manejar otros códigos de estado utilizando EnumStatusResponse
	    EnumStatusResponse statusResponse = getStatusResponse(statusCode);
	    
	    Map<String, Object> errorMap = new HashMap<>();
	    errorMap.put("messageResponse", new MessageResponse(statusResponse.getCode(), statusResponse.getMessage()));
	    
	    return errorMap;
	}

	private static EnumStatusResponse getStatusResponse(int statusCode) {
	    // Obtener EnumStatusResponse según el código de estado
	    for (EnumStatusResponse statusResponse : EnumStatusResponse.values()) {
	        if (statusResponse.getCode() == statusCode) {
	            return statusResponse;
	        }
	    }
	    // Devolvemos un valor predeterminado si no se encuentra el código de estado
	    return EnumStatusResponse.INTERNAL_SERVER_ERROR;
	}
}
