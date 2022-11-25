package hiiragi283.gohd_tweaks;

import hiiragi283.gohd_tweaks.blocks.BlockGroutFormed;
import hiiragi283.gohd_tweaks.items.*;
import hiiragi283.gohd_tweaks.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
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
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

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

    //プレイヤーがログインすると呼ばれるevent
    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        //各値の取得
        EntityPlayer player = event.player;
        World world = player.world;
        //サーバー側のみで実行
        if (!world.isRemote) {
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.welcome.name"));
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
        }
    }

    //各tickにおいてプレイヤーを対象に呼ばれるevent
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        //各値の取得
        EntityPlayer player = event.player;
        World world = player.world;
        BlockPos pos = player.getPosition();
        IBlockState blockstate = world.getBlockState(pos);
        Block block = blockstate.getBlock();
        //20tickに1回実行する (負荷対策) && サーバー側のみで実行
        if (world.getWorldTime() % 20 == 0 && !world.isRemote) {
            //プレイヤーが利き手にアイテムを持っている場合
            if (Objects.isNull(player.getHeldItemMainhand())) {
                //アイテムの値を取得する
                ItemStack stackMain = player.getHeldItemMainhand();
                Item itemMain = stackMain.getItem();
            }
            //プレイヤーが利き手ではない方の手にアイテムを持っている場合
            if (Objects.isNull(player.getHeldItemOffhand())) {
                //アイテムの値を取得する
                ItemStack stackOff = player.getHeldItemOffhand();
                Item itemOff = stackOff.getItem();
            }
            //プレイヤーと同じ座標にあるブロックのIDが"dcs_climate:dcs_fluidblock_hotspring"と一致する場合
            if (block.getRegistryName().toString().equals("dcs_climate:dcs_fluidblock_hotspring")) {
                //プレイヤーに再生Iのバフを5秒与える
                player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:regeneration"), 110, 0));
            }
            //プレイヤーと同じ座標にあるブロックのIDが"dcs_climate:dcs_fluidblock_mazai"と一致する場合
            if (block.getRegistryName().toString().equals("dcs_climate:dcs_fluidblock_mazai")) {
                //プレイヤーに吐き気Iのバフを5秒与える
                player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:nausea"), 110, 0));
            }
            //プレイヤーと同じ座標にあるブロックのIDが"construct:blueslime"と一致する場合
            if (block.getRegistryName().toString().equals("tconstruct:blueslime")) {
                //プレイヤーに跳躍力IIIのバフを5秒与える
                player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:jump_boost"), 110, 2));
            }
            //プレイヤーと同じ座標にあるブロックのIDが"tconstruct:purpleslime"と一致する場合
            if (block.getRegistryName().toString().equals("tconstruct:purpleslime")) {
                //プレイヤーに幸運IIIのバフを5秒与える
                player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:luck"), 110, 2));
            }
        }
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
            if (item.getRegistryName().toString().equals("theoneprobe:creativeprobe")) {
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
                //ブロックの翻訳名をチャットに表示
                player.sendMessage(new TextComponentString("§lName:§r " + block.getPickBlock(blockstate, player.rayTrace(0, 0), world, pos, player).getDisplayName()));
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
