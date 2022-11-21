package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.util.ItemCommon;

public class ItemPartsMagic extends ItemCommon {

    private final int maxMeta;

    public ItemPartsMagic() {
        super("parts_magic");
        maxMeta = 1;
    }

    public int getMaxMeta() {
        return maxMeta;
    }
}
