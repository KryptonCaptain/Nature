package mods.natura.blocks;

import mods.natura.Natura;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NPressurePlate extends BlockPressurePlate
{
    Block modelBlock;
    int modelMeta;

    public NPressurePlate(Material material, Sensitivity s, Block block, int meta, String name)
    {
        super("", material, s);
        modelBlock = block;
        modelMeta = meta;
        this.setCreativeTab(Natura.tab);
        this.setHardness(0.5F);
        this.setStepSound(Block.soundTypeWood);
        this.setBlockName("pressureplate." + name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons (IIconRegister iconRegister)
    {
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (int side, int meta)
    {
        return modelBlock.getIcon(side, modelMeta);
    }
}