package net.javaguides.springboot.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourcesNotFoundException extends RuntimeException {
    public ResourcesNotFoundException(String message){
        super(message);
    }

    public ResourcesNotFoundException(String message, Throwable throwable){
        super(message,throwable);
    }
}

