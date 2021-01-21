package humanera.content;

import arc.graphics.Color;
import mindustry.ctype.ContentType;
import mindustry.ctype.UnlockableContent;

//hhhhhhhh//

public class Era extends UnlockableContent{
    public Era(String name){
        super(name);
    }
    
    public void active(){
        
    }
    @Override
    public ContentType getContentType(){
        
        return ContentType.typeid_UNUSED;
}
