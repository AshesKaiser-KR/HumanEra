package humanera.core;

import arc.Core;
import arc.func.Func;
import mindustry.Vars;
import mindustry.mod.Mod;
import humanera.content.*;
import mindustry.mod.Mods;

public class Main extends Mod {

    @Override
    public void init() {
        Vars.enableConsole = true;

        if(!Vars.headless){
            //Partial credits to BetaMindy(credits to ProjectUnity)
            Mods.LoadedMod mod = Vars.mods.locateMod("humanera");
            Func<String, String> stringf = value -> Core.bundle.get("mod." + value);

            mod.meta.displayName = stringf.get(mod.meta.name + ".name");
            mod.meta.description = stringf.get(mod.meta.name + ".description");
            mod.meta.version = mod.meta.version + "\n" + stringf.get(mod.meta.name + ".short");
            mod.meta.author = "[royal]" + mod.meta.author + "[]";
        }
    }



    @Override
    public void loadContent() {
        new ModLoader().load();
    }


}