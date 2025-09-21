package de.neb.modules;

public class Module {

    String name;
    Category ModuleCategory;

    public Module(String name, Category category){
        this.name = name;
        this.ModuleCategory = category;
    }

    public void onEnable(){}
    public void onDisable(){}
}
