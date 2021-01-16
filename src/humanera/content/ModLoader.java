package humanera.content;

import arc.util.Log;
import mindustry.ctype.*;



public class ModLoader implements ContentList{
    private final ContentList[] contents = {
        new HEItems(),
        new HEBlocks()
    };

    public void load(){
        for(ContentList list : contents){
            list.load();

            Log.info("@: Loaded content list: @", getClass().getSimpleName(), list.getClass().getSimpleName());
        }
    }
}
