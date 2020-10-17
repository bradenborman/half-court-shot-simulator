package borman.halfcourtshotsimulator.controllers;

import borman.halfcourtshotsimulator.exceptions.InvalidStartingLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler({InvalidStartingLocation.class})
    public ResponseEntity<String> handleCityNotFoundException(Exception e) {
        logger.info("Exception caught: {}", e.getClass());
        logger.error("Exception: {}", e.getLocalizedMessage());
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

}