package de.neb.Nyx.client.util.ModuleUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModuleManager {
    public static List<Module> Modules = new ArrayList<>();

    public static List<Module> ActiveModules = new ArrayList<>();

    public static void disableHack(Module module){
        module.onDisable();
    }

    public static void enableHack(Module module){
        module.onEnable();
    }

    public static Module getHack(String name){
        for (Module module : Modules){
            if (Objects.equals(module.getName(), name)){
               return module;
            }
        }

        return null;
    }




}
