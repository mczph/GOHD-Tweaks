package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.util.ItemBlockCommon;

import static hiiragi283.gohd_tweaks.GOHDTweaks.BlockGroutFormed;

public class ItemGroutFormed extends ItemBlockCommon {
    public ItemGroutFormed() {
        super(BlockGroutFormed);
    }

    public int getMaxMeta() {
        return 2;
    }
}
