package de.neb.event.events;

import de.neb.event.Event;

public class TickEvent extends Event {
    public static class Pre extends TickEvent{
        private static final Event INSTANCE = new TickEvent.Pre();

        public static Event get(){
            return INSTANCE;
        }
    }

    public static class Post extends TickEvent{
        private static final Event INSTANCE = new TickEvent.Post();

        public static Event get(){
            return INSTANCE;
        }
    }
}
