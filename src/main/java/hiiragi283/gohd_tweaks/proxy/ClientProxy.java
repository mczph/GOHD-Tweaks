package hiiragi283.gohd_tweaks.proxy;

import hiiragi283.gohd_tweaks.init.RagiItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {
    @Override
    @SideOnly(Side.CLIENT)
    public void registerRenders() {
        RagiItem.registerRenders();
    }
}
