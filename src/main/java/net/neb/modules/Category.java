package net.neb.modules;

import java.util.ArrayList;
import java.util.List;

public class Category{

    public String name;
    public int x;
    public int y;
    public boolean showModules;

    List<Module> Modules = new ArrayList<>();


    public Category(String name, int x, int y){
        this.name = name;

        this.x = x;
        this.y = y;

        this.showModules = true;
    }

    public void add(Module module){
        Modules.add(module);
    }

    public List<Module> getModuleList(){
        return Modules;
    }

}
