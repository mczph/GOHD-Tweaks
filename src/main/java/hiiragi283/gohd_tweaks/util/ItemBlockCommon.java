package hiiragi283.gohd_tweaks.util;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemBlockCommon extends ItemBlock {
    public ItemBlockCommon(Block block) {
        super(block);
        this.setRegistryName(block.getRegistryName());
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    public int getMaxMeta() {
        return 15;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int j = Math.min(stack.getMetadata(), getMaxMeta());
        return super.getUnlocalizedName() + "." + j;
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
