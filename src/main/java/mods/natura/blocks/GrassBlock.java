package mods.natura.blocks;

import java.util.List;

import mods.natura.client.GrassColorizerAlternate;
import mods.natura.Natura;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GrassBlock extends NBlock
{
    public GrassBlock()
    {
        super(Material.grass, 0.6f, null, -1, -1, 3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons (IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon("natura:grass_top");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (int side, int meta)
    {
        return this.blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBlockColor ()
    {
        return ColorizerGrass.getGrassColor(0.5D, 1.0D);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderColor (int meta)
    {
        return meta == 1 ?
        		GrassColorizerAlternate.getBlueGrassColor(0.5D, 0.5D)
        		: meta == 2 ?
        				GrassColorizerAlternate.getOrangeGrassColor(1.0D, 1.0D)
        				: ColorizerGrass.getGrassColor(0.5D, 1.0D);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier (IBlockAccess world, int x, int y, int z)
    {
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int meta = world.getBlockMetadata(x, y, z);

        for (int k1 = -1; k1 <= 1; ++k1)
            for (int l1 = -1; l1 <= 1; ++l1)
            {
                BiomeGenBase biome = world.getBiomeGenForCoords(x + l1, z + k1);
                int grassColor = 0;
                if (meta == 1 || meta == 2)
                {
                    double temp = MathHelper.clamp_float(biome.getFloatTemperature(x, y, z), 0.0F, 1.0F);
                    double rainfall = MathHelper.clamp_float(biome.getFloatRainfall(), 0.0F, 1.0F);
                    grassColor = meta == 1 ? GrassColorizerAlternate.getBlueGrassColor(temp, rainfall) : GrassColorizerAlternate.getOrangeGrassColor(temp, rainfall);
                }
                else
                    grassColor = biome.getBiomeGrassColor(x, y, z);
                l += (grassColor & 16711680) >> 16;
                i1 += (grassColor & 65280) >> 8;
                j1 += grassColor & 255;
            }
        return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
    }

	@Override
	public void reg() {
		// TODO Auto-generated method stub
	}
}
