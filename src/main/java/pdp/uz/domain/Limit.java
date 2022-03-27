package pdp.uz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pdp.uz.enums.Currency;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "limits")
public class Limit implements Serializable {

    @Transient
    public final String sequenceName = "limit_id_seq";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequenceName)
    private Long id;

    @Column(name = "operation_code", unique = true)
    private String operationCode;

    @Column(name = "min_limit")
    private Long minLimit;

    @Column(name = "max_limit")
    private Long maxLimit;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Currency currency = Currency.UZS;
}
