package hiiragi283.gohd_tweaks.util;

import com.google.common.collect.Lists;
import hiiragi283.gohd_tweaks.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemCommon extends Item {
    public ItemCommon(String ID) {
        super();
        this.setRegistryName(Reference.MOD_ID, ID);
        this.setCreativeTab(CreativeTabs.MISC);
        this.setUnlocalizedName(ID);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return Math.min(damage, getMaxMeta());
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int j = Math.min(stack.getMetadata(), getMaxMeta());
        return super.getUnlocalizedName() + "." + j;
    }

    public int getMaxMeta() {
        return 15;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        if (this.isInCreativeTab(tab)) {
            List<ItemStack> list = Lists.newArrayList();
            for (int i = 0; i < getMaxMeta() + 1; i++) {
                list.add(new ItemStack(this, 1, i));
            }
            subItems.addAll(list);
        }
    }
}
