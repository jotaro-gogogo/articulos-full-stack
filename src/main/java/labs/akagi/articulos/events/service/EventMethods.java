package labs.akagi.articulos.events.service;

import labs.akagi.articulos.response.Response;

public interface EventMethods {
    // Only search and show, as I dont think the events table should be modified by end user.
    Response show();

    Response search(Integer id);
}
