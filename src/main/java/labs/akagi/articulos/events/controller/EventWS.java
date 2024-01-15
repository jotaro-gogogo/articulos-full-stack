package labs.akagi.articulos.events.controller;

import labs.akagi.articulos.events.service.EventImp;
import labs.akagi.articulos.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("events")
@CrossOrigin
public class EventWS {
    @Autowired
    EventImp imp;

    @GetMapping("show")
    public Response show() {
        return imp.eShow();
    }

    @GetMapping("show-txn")
    public Response showTxn(@RequestBody String txn) {
        return imp.eShowTxn(txn);
    }

    @GetMapping("search")
    public Response search(@RequestBody Integer id) {
        return imp.eSearch(id);
    }
}
