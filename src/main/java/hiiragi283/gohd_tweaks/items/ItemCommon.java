package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.Reference;
import net.minecraft.item.Item;

import javax.annotation.Nonnull;

public class ItemCommon extends Item {
    public ItemCommon(@Nonnull String ID) {
        super();
        this.setRegistryName(Reference.MOD_ID, ID);
        this.setUnlocalizedName(ID);
    }

}
