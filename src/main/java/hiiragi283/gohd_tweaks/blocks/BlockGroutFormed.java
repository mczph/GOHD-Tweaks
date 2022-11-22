package hiiragi283.gohd_tweaks.blocks;

import hiiragi283.gohd_tweaks.util.BlockCommon;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockGroutFormed extends BlockCommon {
    public BlockGroutFormed() {
        super(Material.GRASS, "grout_formed", 3);
        //this.setDefaultState(this.blockState.getBaseState().withProperty(type4, 0));
        this.setHardness(3.0F);
        this.setResistance(0.5F);
        this.setSoundType(SoundType.GROUND);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}