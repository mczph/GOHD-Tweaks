package hiiragi283.gohd_tweaks.init;

import hiiragi283.gohd_tweaks.items.ItemCommon;
import hiiragi283.gohd_tweaks.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRagi {

    public static Item ItemRagiTicket;

    public static void init() {
        ItemRagiTicket = new ItemCommon("ragi_ticket").setCreativeTab(CreativeTabs.MISC);
    }

    public static void register() {
        ForgeRegistries.ITEMS.register(ItemRagiTicket);
    }
    public static void registerRenders()
    {
        registerRender(ItemRagiTicket);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName(), "inventory"));
    }
}
