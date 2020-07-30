package ojt.thanhnl4.loginservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse<T> {
    private String error_message;
    private int error_code;
    private T response_object;
}
