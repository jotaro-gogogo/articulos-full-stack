package labs.akagi.articulos.events.dao;

import labs.akagi.articulos.events.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EventDao extends JpaRepository<Event, Integer> {
    @Transactional
    @Query(nativeQuery = true, value = "SELECT * FROM events_log WHERE txn = :txn")
    List<Event> showTxn(String txn);
}
