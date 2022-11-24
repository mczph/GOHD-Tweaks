package hiiragi283.gohd_tweaks;

import hiiragi283.gohd_tweaks.blocks.BlockGroutFormed;
import hiiragi283.gohd_tweaks.items.*;
import hiiragi283.gohd_tweaks.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Modの定義
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES, acceptedMinecraftVersions = Reference.MC_VERSIONS)
public class GOHDTweaks {

    //Blockの定義
    public static final Block BlockGroutFormed = new BlockGroutFormed();
    //Itemの定義
    public static final Item ItemBookSpawn = new ItemBookSpawn();
    public static final Item ItemBookSyntax = new ItemBookSyntax();
    public static final Item ItemGroutFormed = new ItemGroutFormed();
    public static final Item ItemPartsAssembly = new ItemPartsAssembly();
    public static final Item ItemRagiTicket = new ItemRagiTicket();
    //ログ出力用
    public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);
    //Proxyの定義
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    //Instanceの定義
    @Mod.Instance(Reference.MOD_ID)
    public static GOHDTweaks Instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //このクラスとイベントに登録
        MinecraftForge.EVENT_BUS.register(this);
        //Blockの登録
        ForgeRegistries.BLOCKS.register(BlockGroutFormed);
        //Itemの登録
        ForgeRegistries.ITEMS.register(ItemBookSpawn);
        ForgeRegistries.ITEMS.register(ItemBookSyntax);
        ForgeRegistries.ITEMS.register(ItemGroutFormed);
        ForgeRegistries.ITEMS.register(ItemPartsAssembly);
        ForgeRegistries.ITEMS.register(ItemRagiTicket);
        //Modelの登録
        proxy.register();
    }

    @SubscribeEvent
    public void onRightClickBlock(RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        EntityPlayer player = event.getEntityPlayer();
        World world = event.getWorld();
        if (item == Items.BOOK && !world.isRemote) {
            player.sendMessage(new TextComponentString("SUCCESS!"));
        }
    }
}
