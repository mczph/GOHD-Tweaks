package hiiragi283.gohd_tweaks.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static hiiragi283.gohd_tweaks.GOHDTweaks.ItemRagiTicket;

public class ClientProxy extends CommonProxy {
    @SideOnly(Side.CLIENT)
    public static void setModel(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName() + "_" + meta, "inventory"));
    }

    public static void setModels() {
        setModel(ItemRagiTicket, 0);
    }

    public void register() {
        setModels();
    }
}
