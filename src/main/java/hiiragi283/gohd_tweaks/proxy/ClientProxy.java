package hiiragi283.gohd_tweaks.proxy;

import hiiragi283.gohd_tweaks.init.InitItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {
    @Override
    @SideOnly(Side.CLIENT)
    public void registerRenders() {
        InitItem.registerRenders();
    }
}
