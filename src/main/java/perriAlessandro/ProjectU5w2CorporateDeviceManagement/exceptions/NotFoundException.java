package perriAlessandro.ProjectU5w2CorporateDeviceManagement.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {

    public NotFoundException(UUID id) {
        super("Elemento con id " + id + " non è stato trovato.");
    }
}
