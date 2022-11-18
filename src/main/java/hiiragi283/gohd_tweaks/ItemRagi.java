package hiiragi283.gohd_tweaks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRagi extends Item {
    public ItemRagi(String ID) {
        super();
        this.setRegistryName("gohd_tweaks", ID);
        this.setCreativeTab(CreativeTabs.MISC);
        this.setUnlocalizedName(ID);
    }
}
