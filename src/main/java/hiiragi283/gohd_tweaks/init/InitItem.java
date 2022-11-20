package hiiragi283.gohd_tweaks.init;

import hiiragi283.gohd_tweaks.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static hiiragi283.gohd_tweaks.items.ItemRagiTicket.ItemRagiTicket;

public class InitItem {

    public static void register() {
        ForgeRegistries.ITEMS.register(ItemRagiTicket);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName() + "_" + meta, "inventory"));
    }

    public static void registerRenders() {
        registerRender(ItemRagiTicket, 0);
    }
}
