package hiiragi283.gohd_tweaks.util;

import hiiragi283.gohd_tweaks.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockCommon extends Block {

    public static final PropertyInteger type4 = PropertyInteger.create("type", 0, 3);
    public static final PropertyInteger type8 = PropertyInteger.create("type", 0, 7);
    public static final PropertyInteger type16 = PropertyInteger.create("type", 0, 15);
    public final int maxMeta;

    public BlockCommon(Material Material, String ID, int max) {
        super(Material);
        this.setRegistryName(Reference.MOD_ID, ID);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(type16, 0));
        this.setUnlocalizedName(ID);
        this.maxMeta = max;
    }

    public int getMaxMeta() {
        return 15;
    }

    //Blockstate
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, type16);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = state.getValue(type16);
        if (i > maxMeta)
            i = maxMeta;
        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        int i = meta & 15;
        IBlockState state = this.getDefaultState().withProperty(type16, i);
        return state;
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state;
    }

    //Item Drop
    @Override
    public int damageDropped(IBlockState state) {
        int i = state.getValue(type16);
        if (i > maxMeta)
            i = maxMeta;
        return i;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(state.getBlock());
    }

}
