package labs.akagi.articulos.events.service;

import labs.akagi.articulos.events.dao.EventDao;
import labs.akagi.articulos.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

public class EventImp implements EventMethods {
    @Autowired
    EventDao eDao;

    @Override
    public Response eShow() {
        if (eDao.findAll().isEmpty())
            return new Response("Events log empty, nothing to show.", null, false);
        else
            return new Response("Found next entries:", eDao.findAll(), true);
    }

    public Response eShowTxn(String txn) {
        if (eDao.findAll().isEmpty())
            return new Response("Events log empty, nothing to show.", null, false);
        else {
            // Could be done with a findbyTxn() function too.
            String msg;

            if (eDao.showTxn(txn).isEmpty()) {
                msg = "No " + txn.toLowerCase() + " transactions on the log registered yet.";
                return new Response(msg, null, false);
            } else {
                msg = "Found next " + txn.toLowerCase() + " transactions:";
                return new Response(msg, eDao.showTxn(txn), true);
            }
        }
    }

    @Override
    public Response eSearch(Integer id) {
        if (eDao.findAll().isEmpty())
            return new Response("Events log empty, nothig to search.", null, false);
        else if (eDao.existsById(id))
            return new Response("Found next entry:", eDao.findById(id), true);
        else
            return new Response("Could not find the ID on database, please verify your information.", null, false);
    }
}
