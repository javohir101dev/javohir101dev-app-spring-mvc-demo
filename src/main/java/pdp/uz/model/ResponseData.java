package pdp.uz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData<T> implements Serializable {
    private T data;
    private String errorMessage;
    private HttpStatus status;
    private LocalDateTime dateTime;

    public ResponseData(T data, HttpStatus status) {
        this.data = data;
        this.errorMessage = "";
        this.status = status;
        this.dateTime = LocalDateTime.now();
    }

    public ResponseData(String errorMessage, HttpStatus status) {
        this.data = null;
        this.errorMessage = errorMessage;
        this.status = status;
        this.dateTime = LocalDateTime.now();
    }
}
