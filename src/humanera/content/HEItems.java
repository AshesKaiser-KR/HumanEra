package humanera.content;

import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class HEItems implements ContentList {
    public static Item wood;

    public void load(){
        wood = new Item("wood");
    }
}
