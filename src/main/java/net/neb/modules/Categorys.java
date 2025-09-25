package net.neb.modules;

import java.util.ArrayList;
import java.util.List;

public class Categorys {

    public List<Category> Categorys = new ArrayList<>();

    public static final Category combat = new Category("combat", 10,100);
    public static final Category misc = new Category("misc", 70,100);
    public static final Category player = new Category("player",130,100);
    public static final Category render = new Category("render",190,100);
    public static final Category world = new Category("world",250,100);

    public Categorys(){
        Categorys.add(combat);
        Categorys.add(misc);
        Categorys.add(player);
        Categorys.add(render);
        Categorys.add(world);
    }
}
