package humanera.content;

import humanera.entities.bullet.blMissile;
import mindustry.ctype.ContentList;
import mindustry.entities.bullet.BulletType;

public class SBullets implements ContentList {
    public static BulletType
    missile1;
    @Override
    public void load(){
        missile1 = new blMissile (20, 200){{
            accelScl = 0.3f;
            lifetime = 240f;

        }};
    }
}
