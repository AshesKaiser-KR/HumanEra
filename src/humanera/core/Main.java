package humanera.core;

import mindustry.mod.Mod;
import humanera.content.*;

public class Main extends Mod{

    @Override
    public void init(){
    }

    @Override
    public void loadContent(){
        new ModLoader().load();
    }
}
