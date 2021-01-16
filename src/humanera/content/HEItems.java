package humanera.content;

import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class HEItems implements ContentList {
    public static Item wood, stone, cassiterite;

    public void load(){
        wood = new Item("wood");
        stone = new Item("Stone");
        cassiterite = new Item("Cassiterite");
    }
}
