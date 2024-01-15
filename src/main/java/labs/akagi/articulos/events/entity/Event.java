package labs.akagi.articulos.events.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Table(name = "events_log")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "txn")
    private String txn;
    @Column(name = "txn_date")
    private Timestamp txnDate;
}
