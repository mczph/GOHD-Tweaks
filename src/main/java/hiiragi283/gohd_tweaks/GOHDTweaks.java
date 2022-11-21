package hiiragi283.gohd_tweaks;

import hiiragi283.gohd_tweaks.blocks.*;
import hiiragi283.gohd_tweaks.items.*;
import hiiragi283.gohd_tweaks.proxy.CommonProxy;
import hiiragi283.gohd_tweaks.util.ItemBlockCommon;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES, acceptedMinecraftVersions = Reference.MC_VERSIONS)
public class GOHDTweaks {

    public static final Block BlockGroutFormed = new BlockGroutFormed();
    public static final Item ItemBookSpawn = new ItemBookSpawn();
    public static final Item ItemBookSyntax = new ItemBookSyntax();
    public static final Item ItemGroutFormed = new ItemBlockCommon(BlockGroutFormed);
    public static final Item ItemPartsAssembly = new ItemPartsAssembly();
    public static final Item ItemRagiTicket = new ItemRagiTicket();
    public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    @Mod.Instance(Reference.MOD_ID)
    public static GOHDTweaks Instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        ForgeRegistries.BLOCKS.register(BlockGroutFormed);
        ForgeRegistries.ITEMS.register(ItemBookSpawn);
        ForgeRegistries.ITEMS.register(ItemBookSyntax);
        ForgeRegistries.ITEMS.register(ItemGroutFormed);
        ForgeRegistries.ITEMS.register(ItemPartsAssembly);
        ForgeRegistries.ITEMS.register(ItemRagiTicket);
        proxy.register();
    }
}
