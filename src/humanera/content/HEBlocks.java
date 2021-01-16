package humanera.content;


import humanera.world.blocks.*;
import humanera.content.*;

import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.*;

import static mindustry.type.ItemStack.with;

public class HEBlocks implements ContentList {
    public static Block rotaryHoe, woodBreaker;

    public void load(){
        rotaryHoe = new HoeBlock("rotary-hoe"){{
            requirements(Category.crafting, with(Items.copper, 75, Items.lead, 30));

            outputItem = new ItemStack(HEItems.wood, 1);
            targetBlock = Blocks.pine;
            hoeTime = 1.5f * 60;
        }};

        woodBreaker = new HoeBreaker("wood-breaker"){{
            requirements(Category.crafting, with(Items.copper, 75, Items.lead, 30));

            outputItem = new ItemStack(HEItems.wood, 1);
            targetBlock = Blocks.pine;
            hoeTime = 1.5f * 60;
        }};
    }
}
