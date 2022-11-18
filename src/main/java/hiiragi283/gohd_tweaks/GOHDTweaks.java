package hiiragi283.gohd_tweaks;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

@Mod(modid = GOHDTweaks.MOD_ID, name = GOHDTweaks.MOD_NAME, version = GOHDTweaks.VERSION)
public class GOHDTweaks
{
    public static final String MOD_ID = "gohd_tweaks";
    public static final String MOD_NAME = "GOHD Tweaks";
    public static final String VERSION = "v0.0.1";

    private static Logger logger;

    public static final Item ItemRagiTicket = new ItemRagi("ragi_ticket");

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(ItemRagiTicket);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ItemRagiTicket, 0, new ModelResourceLocation(new ResourceLocation("gohd_tweaks", "ragi_ticket"), "inventory"));
    }
}
