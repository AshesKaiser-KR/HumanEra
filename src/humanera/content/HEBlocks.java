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
    public static Block 
        
    //HoeBlock
    rotaryHoe, 
    //HoeBreaker
    woodBreaker, 
    //production
    formWork, steelForge;

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
        
        formWork = new GenericSmelter("Formwork"){{
            requirements(Category.crafting, with(Items.wood, 100, Items.stone, 50));
            
            craftEffect = Fx.smeltsmoke;
            ouputItem = new Itemstack(HEItems.bronze, 1);
            size = 2;
            craftTime = 50f;
            hasPower = false;
            hasItems = true;
            hasLiquids = false;
            
            flameColor = Color.valueOf("e25822");
            
            consumes.items(with(Items.copper, 3, HEItems.tin, 1));
        }};
        
        firepit = new GenericCrafter("Firepit"){{
            requirements(Category.crafting, with(Items.wood, 50, Items.stone, 30));
            
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.coal, 1);
            size = 1;
            craftTime = 75f;
            hasPower = false;
            hasItems = true;
            hasLiquids = false;
            
            flameColor = Color.valueof("000000");
            
           consumes.items(with(HEItems.wood, 1));
        }};
    }
}
