package listener;

import event.Event;
import response.Response;

public interface EventSender {
    Response send(Event event);

    void close();
}
