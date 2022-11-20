package hiiragi283.gohd_tweaks;

import hiiragi283.gohd_tweaks.init.InitItem;
import hiiragi283.gohd_tweaks.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES, acceptedMinecraftVersions = Reference.MC_VERSIONS)
public class GOHDTweaks {

    private static final Logger logger = LogManager.getLogger(Reference.MOD_ID);
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    public static InitItem init;
    @Mod.Instance(Reference.MOD_ID)
    public static GOHDTweaks Instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        InitItem.register();
        proxy.registerRenders();
    }
}
