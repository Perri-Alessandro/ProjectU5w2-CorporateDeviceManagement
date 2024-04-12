package perriAlessandro.ProjectU5w2CorporateDeviceManagement.payloads;

import java.time.LocalDateTime;

public record ErrorsResponseDTO(String message, LocalDateTime timestamp) {
}
