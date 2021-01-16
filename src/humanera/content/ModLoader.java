package humanera.content;

import mindustry.ctype.*;



public class ModLoader implements ContentList{
    private final ContentList[] contents = {
        new HEItems(),
        new HEBlocks()
    };

    public void load(){
        for(ContentList list : contents){
            list.load();
        }
    }
}
