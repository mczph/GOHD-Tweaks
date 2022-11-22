package hiiragi283.gohd_tweaks.util;

import hiiragi283.gohd_tweaks.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCommon extends Block {

    public static final PropertyInteger typeGOHD = PropertyInteger.create("type", 0, 15);
    public final int maxMeta;

    public BlockCommon(Material Material, String ID, int max) {
        super(Material);
        this.setRegistryName(Reference.MOD_ID, ID);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(typeGOHD, 0));
        this.setUnlocalizedName(ID);
        this.maxMeta = max;
    }

    public int getMaxMeta() {
        return 15;
    }

    /*@Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }*/

    @Override
    public IBlockState getStateFromMeta(int meta) {
        int i = meta & 15;
        IBlockState state = this.getDefaultState().withProperty(typeGOHD, i);
        return state;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = state.getValue(PropertyInteger.create("type", 0, 15));
        if (i > maxMeta)
            i = maxMeta;
        return i;
    }

    /*@Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state;
    }*/

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, typeGOHD);
    }
}
