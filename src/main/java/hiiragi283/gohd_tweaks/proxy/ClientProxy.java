package hiiragi283.gohd_tweaks.proxy;

import hiiragi283.gohd_tweaks.init.ItemRagi;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        ItemRagi.registerRenders();
    }
}
