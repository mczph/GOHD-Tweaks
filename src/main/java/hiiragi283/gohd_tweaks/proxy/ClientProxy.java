package hiiragi283.gohd_tweaks.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static hiiragi283.gohd_tweaks.GOHDTweaks.*;

public class ClientProxy extends CommonProxy {

    //代入されたItemとmetaに応じてモデルファイルのパスを登録するメソッド
    @SideOnly(Side.CLIENT)
    public static void setModel(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName() + "_" + meta, "inventory"));
    }

    //各Itemのモデルファイルのパスを指定するメソッド
    public void setModels() {
        setModel(ItemBookSpawn, 0);
        setModel(ItemBookSyntax, 0);
        setModel(ItemPartsAssembly, 0);
        setModel(ItemPartsAssembly, 1);
        setModel(ItemPartsAssembly, 2);
        setModel(ItemPartsAssembly, 3);
        setModel(ItemPartsAssembly, 4);
        setModel(ItemRagiTicket, 0);
        setModel(ItemGroutFormed, 0);
        setModel(ItemGroutFormed, 1);
        setModel(ItemGroutFormed, 2);
    }

    //Client側のProxyで行われる処理をまとめたメソッド
    public void register() {
        setModels();
    }
}
