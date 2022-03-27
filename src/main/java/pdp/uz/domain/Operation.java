package pdp.uz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pdp.uz.enums.Currency;
import pdp.uz.enums.OperationStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "operations")
public class Operation implements Serializable {

    @Transient
    public final String sequenceName = "operation_id_seq";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequenceName)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_status")
    private OperationStatus operationStatus;

    @Column(name = "operation_code")
    private String operationCode;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Card sender;

    @Column(name = "sender_amount")
    private Long senderAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "sender_currency")
    private Currency senderCurrency;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Card receiver;

    @Column(name = "receiver_amount")
    private Long receiverAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "receiver_currency")
    private Currency receiverCurrency;

    /**
     * Commission amount
     */
    @Column(name = "commission")
    private Long commission;

    /**
     * Commission rate
     */
    @Column(name = "commission_rate")
    private Short commissionRate;

    @Column(name = "operation_date", columnDefinition = "timestamp default now()")
    private LocalDateTime operationDate = LocalDateTime.now();
}
