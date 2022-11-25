package hiiragi283.gohd_tweaks;

import hiiragi283.gohd_tweaks.blocks.BlockGroutFormed;
import hiiragi283.gohd_tweaks.items.*;
import hiiragi283.gohd_tweaks.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
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

    //Pre-Initializationの段階で呼ばれるevent
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //このクラスをイベントに登録
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

    //ブロックを右クリックすると呼ばれるevent
    @SubscribeEvent
    public void onRightClickBlock(RightClickBlock event) {
        //各値の取得
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        EntityPlayer player = event.getEntityPlayer();
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        IBlockState blockstate = world.getBlockState(pos);
        Block block = blockstate.getBlock();
        //サーバー側のみで実行
        if (!world.isRemote) {
            //デバッグ用
            if (item.getRegistryName().toString().equals("minecraft:book")) {
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
                //ブロックの翻訳名をチャットに表示
                player.sendMessage(new TextComponentString("§lName:§r " + block.getPickBlock(blockstate, player.rayTrace(0,0), world, pos, player).getDisplayName()));
                //ブロックのIDをチャットに表示
                player.sendMessage(new TextComponentString("§lID:§r " + block.getRegistryName()));
                //ブロックのHardnessをチャットに表示
                player.sendMessage(new TextComponentString("§lHardness:§r " + block.getBlockHardness(blockstate, world, pos)));
                //ブロックのResistanceをチャットに表示
                player.sendMessage(new TextComponentString("§lResistance:§r " + block.getExplosionResistance(player)));
                //適正ツールをチャットに表示
                player.sendMessage(new TextComponentString("§lHarvest Tool:§r " + block.getHarvestTool(blockstate)));
                //適正レベルをチャットに表示
                player.sendMessage(new TextComponentString("§lHarvest Level:§r " + block.getHarvestLevel(blockstate)));
            }
        }
    }
}
