package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.util.ItemCommon;
import net.minecraft.item.Item;

public class ItemRagiTicket extends ItemCommon {
    private final int maxMeta;

    public ItemRagiTicket() {
        super("ragi_ticket");
        maxMeta = 0;
    }

    public int getMaxMeta() {
        return maxMeta;
    }
}
