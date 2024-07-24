package Project.Spring.Boot.Project.UniversityControllers;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

