package de.neb.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {

    public Map<Class<?>, ArrayList<Listener>> Listeners = new HashMap<>();

    public void register(Object obj){
        System.out.println("Test1");
        for(Method method : obj.getClass().getDeclaredMethods()){

            System.out.println("Test2");
            if (method.isAnnotationPresent(EventHandler.class)){

                System.out.println("Test3");
                method.setAccessible(true);

                Class<?>[] params = method.getParameterTypes();
                if (params.length != 1) continue;

                System.out.println("Test4");
                Class<?>  eventType = params[0];

                Listeners
                        .computeIfAbsent(eventType, k -> new ArrayList<>())
                        .add(new Listener(obj, method));
            }
        }
    }

    public void unregister(Object obj){Listeners.remove(obj);}

    public  void post(Object event){
        List<Listener> listeners = Listeners.get(event.getClass());
        if(listeners == null) return;
        for (Listener listener : listeners){
            try {
                listener.method.invoke(listener.owner, event);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
