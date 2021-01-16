package com.enigma.restservice.exception;

public class PathNotFoundException extends ApplicationException {

    public PathNotFoundException() {
        super("exception.page.not.found", ErrorCodes.PATH_NOT_FOUND);
    }
}
