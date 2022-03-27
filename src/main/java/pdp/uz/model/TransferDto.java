package pdp.uz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferDto {
    private Long senderId;
    private Long receiverId;
    private Long amount;
}
