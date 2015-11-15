package mods.natura.common;

import mods.natura.blocks.NPressurePlate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import mods.natura.Natura;
import mods.natura.blocks.BarricadeBlock;
import mods.natura.blocks.CloudBlock;
import mods.natura.blocks.GrassBlock;
import mods.natura.blocks.GrassSlab;
import mods.natura.blocks.NButton;
import mods.natura.blocks.NFenceGate;
import mods.natura.blocks.NSlabBase;
import mods.natura.blocks.NStairs;
import mods.natura.blocks.NTrapdoor;
import mods.natura.blocks.crops.BerryBush;
import mods.natura.blocks.crops.CropBlock;
import mods.natura.blocks.crops.FlowerBlock;
import mods.natura.blocks.crops.Glowshroom;
import mods.natura.blocks.crops.LargeGlowshroom;
import mods.natura.blocks.crops.NetherBerryBush;
import mods.natura.blocks.crops.ThornVines;
import mods.natura.blocks.nether.HeatSand;
import mods.natura.blocks.nether.NetherGlass;
import mods.natura.blocks.nether.TaintedSoil;
import mods.natura.blocks.overrides.AlternateBookshelf;
import mods.natura.blocks.overrides.AlternateFence;
import mods.natura.blocks.overrides.AlternateWorkbench;
import mods.natura.blocks.tech.BlazeHopper;
import mods.natura.blocks.tech.BlazeRail;
import mods.natura.blocks.tech.BlazeRailDetector;
import mods.natura.blocks.tech.BlazeRailPowered;
import mods.natura.blocks.tech.NetherrackFurnaceBlock;
import mods.natura.blocks.tech.NetherrackFurnaceLogic;
import mods.natura.blocks.tech.RespawnObelisk;
import mods.natura.blocks.trees.DarkTreeBlock;
import mods.natura.blocks.trees.LogTwoxTwo;
import mods.natura.blocks.trees.NDoor;
import mods.natura.blocks.trees.NLeaves;
import mods.natura.blocks.trees.NLeavesDark;
import mods.natura.blocks.trees.NLeavesNocolor;
import mods.natura.blocks.trees.NetherSaplingBlock;
import mods.natura.blocks.trees.OverworldLeaves;
import mods.natura.blocks.trees.RareSaplingBlock;
import mods.natura.blocks.trees.FloraSaplingBlock;
import mods.natura.items.blocks.FloraSaplingItem;
import mods.natura.blocks.trees.OverworldTreeBlock;
import mods.natura.blocks.trees.Planks;
import mods.natura.blocks.trees.SaguaroBlock;
import mods.natura.blocks.trees.SimpleLog;
import mods.natura.blocks.trees.TreeBlock;
import mods.natura.blocks.trees.WillowBlock;
import mods.natura.entity.BabyHeatscarSpider;
import mods.natura.entity.HeatscarSpider;
import mods.natura.entity.ImpEntity;
import mods.natura.entity.NitroCreeper;
import mods.natura.items.BerryItem;
import mods.natura.items.BerryMedley;
import mods.natura.items.BoneBag;
import mods.natura.items.BowlStew;
import mods.natura.items.CactusJuice;
import mods.natura.items.ImpMeat;
import mods.natura.items.NaturaSeeds;
import mods.natura.items.NetherBerryItem;
import mods.natura.items.NetherFoodItem;
import mods.natura.items.PlantItem;
import mods.natura.items.SeedBag;
import mods.natura.items.SeedFood;
import mods.natura.items.SpawnEgg;
import mods.natura.items.blocks.BarricadeItem;
import mods.natura.items.blocks.BerryBushItem;
import mods.natura.items.blocks.CloudItem;
import mods.natura.items.blocks.DarkTreeItem;
import mods.natura.items.blocks.FenceItem;
import mods.natura.items.blocks.GlowshroomItem;
import mods.natura.items.blocks.GrassBlockItem;
import mods.natura.items.blocks.GrassSlabItem;
import mods.natura.items.blocks.LogTwoxTwoItem;
import mods.natura.items.blocks.NAlternateItem;
import mods.natura.items.blocks.NDoorItem;
import mods.natura.items.blocks.NLeavesDarkItem;
import mods.natura.items.blocks.NLeavesItem;
import mods.natura.items.blocks.NetherBerryBushItem;
import mods.natura.items.blocks.NetherSaplingItem;
import mods.natura.items.blocks.NetherGlassItem;
import mods.natura.items.blocks.NoColorLeavesItem;
import mods.natura.items.blocks.OverworldLeavesItem;
import mods.natura.items.blocks.PlankSlab1Item;
import mods.natura.items.blocks.PlankSlab2Item;
import mods.natura.items.blocks.RareSaplingItem;
import mods.natura.items.blocks.OverworldTreeItem;
import mods.natura.items.blocks.PlanksItem;
import mods.natura.items.blocks.RedwoodItem;
import mods.natura.items.blocks.SaguaroItem;
import mods.natura.items.blocks.TreeItem;
import mods.natura.items.blocks.WillowItem;
import mods.natura.items.tools.FlintAndBlaze;
import mods.natura.items.tools.NaturaArmor;
import mods.natura.util.DispenserBehaviorSpawnEgg;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockPressurePlate.Sensitivity;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class NContent implements IFuelHandler
{
    public void preInit ()
    {
        spawnEgg = new SpawnEgg().setUnlocalizedName("natura.spawnegg");
        GameRegistry.registerItem(spawnEgg, "natura.spawnegg");
        //Crops
        plantItem = new PlantItem().setUnlocalizedName("barleyFood");
        GameRegistry.registerItem(plantItem, "barleyFood");
        crops = (CropBlock) new CropBlock().setBlockName("natura.crops");
        GameRegistry.registerBlock(crops, "N Crops");//TODO 1.8 RENAME
        seeds = new NaturaSeeds(crops, Blocks.farmland).setUnlocalizedName("barley.seed");
        GameRegistry.registerItem(seeds, "barley.seed");
        GameRegistry.registerCustomItemStack("seedBarley", new ItemStack(seeds, 1, 0));
        GameRegistry.registerCustomItemStack("seedCotton", new ItemStack(seeds, 1, 1));

        waterDrop = new CactusJuice(false).setUnlocalizedName("waterdrop");
        GameRegistry.registerItem(waterDrop, "waterdrop");

        if (PHNatura.enableSeedBags)
        {
		    wheatBag = new SeedBag(Blocks.wheat, 0, "wheat").setUnlocalizedName("wheatBag");
		    GameRegistry.registerItem(wheatBag, "wheatBag");
		    GameRegistry.registerCustomItemStack("bagWheat", new ItemStack(wheatBag, 1, 0));
		    barleyBag = new SeedBag(crops, 0, "barley").setUnlocalizedName("barleyBag");
		    GameRegistry.registerItem(barleyBag, "barleyBag");
		    GameRegistry.registerCustomItemStack("bagBarley", new ItemStack(barleyBag, 1, 0));
		    potatoBag = new SeedBag(Blocks.potatoes, 0, "potato").setUnlocalizedName("potatoBag");
		    GameRegistry.registerItem(potatoBag, "potatoBag");
		    GameRegistry.registerCustomItemStack("bagPotato", new ItemStack(potatoBag, 1, 0));
		    carrotBag = new SeedBag(Blocks.carrots, 0, "carrot").setUnlocalizedName("carrotBag");
		    GameRegistry.registerItem(carrotBag, "carrotBag");
		    GameRegistry.registerCustomItemStack("bagCarrot", new ItemStack(carrotBag, 1, 0));
		    netherWartBag = new SeedBag(Blocks.nether_wart, 0, "netherwart").setUnlocalizedName("wartBag");
		    GameRegistry.registerItem(netherWartBag, "wartBag");
		    GameRegistry.registerCustomItemStack("bagNetherWart", new ItemStack(netherWartBag, 1, 0));
		    cottonBag = new SeedBag(crops, 4, "cotton").setUnlocalizedName("cottonBag");
		    GameRegistry.registerItem(cottonBag, "cottonBag");
		    GameRegistry.registerCustomItemStack("bagCotton", new ItemStack(cottonBag, 1, 0));
		    boneBag = new BoneBag("bone").setUnlocalizedName("boneBag");
		    GameRegistry.registerItem(boneBag, "boneBag");
		    GameRegistry.registerCustomItemStack("bagBone", new ItemStack(boneBag, 1, 0));
        }
        netherBerryItem = new NetherBerryItem(1).setUnlocalizedName("berry.nether");
        GameRegistry.registerItem(netherBerryItem, "berry.nether");
        GameRegistry.registerCustomItemStack("berryBlight", new ItemStack(netherBerryItem, 1, 0));
        GameRegistry.registerCustomItemStack("berryDusk", new ItemStack(netherBerryItem, 1, 1));
        GameRegistry.registerCustomItemStack("berrySky", new ItemStack(netherBerryItem, 1, 2));
        GameRegistry.registerCustomItemStack("berrySting", new ItemStack(netherBerryItem, 1, 3));
        berryItem = new BerryItem(1).setUnlocalizedName("berry");
        GameRegistry.registerItem(berryItem, "berry");
        GameRegistry.registerCustomItemStack("berryRasp", new ItemStack(berryItem, 1, 0));
        GameRegistry.registerCustomItemStack("berryBlue", new ItemStack(berryItem, 1, 1));
        GameRegistry.registerCustomItemStack("berryBlack", new ItemStack(berryItem, 1, 2));
        GameRegistry.registerCustomItemStack("berryMalo", new ItemStack(berryItem, 1, 3));
        berryMedley = new BerryMedley(5).setUnlocalizedName("berryMedley");
        GameRegistry.registerItem(berryMedley, "berryMedley");
        GameRegistry.registerCustomItemStack("berryMedley", new ItemStack(berryMedley, 1, 0));

        berryBush = new BerryBush();
        GameRegistry.registerBlock(berryBush, BerryBushItem.class, "BerryBush");
        netherBerryBush = new NetherBerryBush();
        GameRegistry.registerBlock(netherBerryBush, NetherBerryBushItem.class, "NetherBerryBush");

        //Clouds
        cloud = new CloudBlock();
        GameRegistry.registerBlock(cloud, CloudItem.class, "Cloud");

        //Trees
        tree = new TreeBlock().setBlockName("natura.treeblock");
        redwood = new SimpleLog().setBlockName("natura.redwood");
        planks = new Planks().setBlockName("natura.planks");
        floraLeaves = (NLeaves) new NLeaves().setBlockName("natura.leaves");
        floraLeavesNoColor = (NLeaves) new NLeavesNocolor().setBlockName("natura.leavesnocolor");

		floraSapling = ((FloraSaplingBlock) new FloraSaplingBlock().setBlockName("natura.sapling"));
		willow = new WillowBlock().setBlockName("willow");

        saguaro = new SaguaroBlock().setBlockName("saguaro.block");
        seedFood = new SeedFood(3, 0.3f, saguaro).setUnlocalizedName("saguaro.fruit");
        GameRegistry.registerItem(seedFood, "saguaro.fruit");

        if (PHNatura.enableDoors)
        {
        	doorItem = new NDoorItem().setUnlocalizedName("redwoodDoorItem");
	        GameRegistry.registerItem(doorItem, "redwoodDoorItem");
	        redwoodDoor = new NDoor(Material.wood, 0, "redwood").setBlockName("door.redwood");
	        eucalyptusDoor = new NDoor(Material.wood, 1, "eucalyptus").setBlockName("door.eucalyptus");
	        hopseedDoor = new NDoor(Material.wood, 2, "hopseed").setBlockName("door.hopseed");
	        sakuraDoor = new NDoor(Material.wood, 3, "sakura").setBlockName("door.sakura");
	        ghostDoor = new NDoor(Material.wood, 4, "ghostwood").setBlockName("door.ghostwood");
	        bloodDoor = new NDoor(Material.wood, 5, "bloodwood").setBlockName("door.bloodwood");
	        redwoodBarkDoor = new NDoor(Material.wood, 6, "redwoodbark").setBlockName("door.redwoodbark");

	        GameRegistry.registerBlock(redwoodDoor, "door.redwood");
	        GameRegistry.registerBlock(eucalyptusDoor, "door.eucalyptus");
	        GameRegistry.registerBlock(hopseedDoor, "door.hopseed");
	        GameRegistry.registerBlock(sakuraDoor, "door.sakura");
	        GameRegistry.registerBlock(ghostDoor, "door.ghostwood");
	        GameRegistry.registerBlock(bloodDoor, "door.bloodwood");
	        GameRegistry.registerBlock(redwoodBarkDoor, "door.redwoodbark");
        }
        if(PHNatura.dropBarley)
            MinecraftForge.addGrassSeed(new ItemStack(seeds, 1, 0), 3);
        if(PHNatura.dropCotton)
            MinecraftForge.addGrassSeed(new ItemStack(seeds, 1, 1), 3);

        GameRegistry.registerBlock(tree, TreeItem.class, "tree");
        GameRegistry.registerBlock(redwood, RedwoodItem.class, "redwood");
        GameRegistry.registerBlock(planks, PlanksItem.class, "planks");
        GameRegistry.registerBlock(floraLeaves, NLeavesItem.class, "floraleaves");
        GameRegistry.registerBlock(floraLeavesNoColor, NoColorLeavesItem.class, "floraleavesnocolor");
        GameRegistry.registerBlock(floraSapling, FloraSaplingItem.class, "florasapling");
        GameRegistry.registerBlock(saguaro, SaguaroItem.class, "Saguaro");
        GameRegistry.registerBlock(willow, WillowItem.class, "willow");

        //Nether
        bloodwood = new LogTwoxTwo(8f, Material.wood).setBlockName("bloodwood");
        GameRegistry.registerBlock(bloodwood, LogTwoxTwoItem.class, "bloodwood");
        taintedSoil = new TaintedSoil().setBlockName("TaintedSoil");
        GameRegistry.registerBlock(taintedSoil, "soil.tainted");
        heatSand = new HeatSand().setBlockName("HeatSand");//.setLightLevel(0.375f);
        GameRegistry.registerBlock(heatSand, "heatsand");
        /*infernalStone = new NBlock(PHNatura.infernalStone, Material.rock, 1.5f, new String[] { "infernal_stone" }).setBlockName("infernalStone");
        GameRegistry.registerBlock(infernalStone, "infernalStone");*/
        netherSapling = ((NetherSaplingBlock) new NetherSaplingBlock().setBlockName("natura.nethersapling"));
        GameRegistry.registerBlock(netherSapling, NetherSaplingItem.class, "nethersapling");

        darkTree = new DarkTreeBlock().setBlockName("Darktree");
        GameRegistry.registerBlock(darkTree, DarkTreeItem.class, "Dark Tree");

        darkLeaves = new NLeavesDark();
        GameRegistry.registerBlock(darkLeaves, NLeavesDarkItem.class, "Dark Leaves");

        thornVines = new ThornVines().setBlockName("Thornvines").setLightLevel(0.625f);
        GameRegistry.registerBlock(thornVines, "Thornvines");
        glowshroom = (Glowshroom) new Glowshroom().setBlockName("Glowshroom").setLightLevel(0.625f);
        GameRegistry.registerBlock(glowshroom, GlowshroomItem.class, "Glowshroom");
        glowshroomBlue = new LargeGlowshroom(Material.wood, "blue").setBlockName("blueGlowshroom").setLightLevel(0.625f);
        GameRegistry.registerBlock(glowshroomBlue, "blueGlowshroom");
        glowshroomPurple = new LargeGlowshroom(Material.wood, "purple").setBlockName("purpleGlowshroom").setLightLevel(0.5f);
        GameRegistry.registerBlock(glowshroomPurple, "purpleGlowshroom");
        glowshroomGreen = new LargeGlowshroom(Material.wood, "green").setBlockName("greenGlowshroom").setLightLevel(0.5f);
        GameRegistry.registerBlock(glowshroomGreen, "greenGlowshroom");

        Blocks.netherrack.setResistance(4f);

        brail = new BlazeRail().setHardness(0.7F).setBlockName("blazerail").setBlockTextureName("natura:brail_normal");
        GameRegistry.registerBlock(brail, "Blazerail");
        brailPowered = new BlazeRailPowered(false).setHardness(0.7F).setBlockName("blazerail.powered").setBlockTextureName("natura:brail_golden");
        GameRegistry.registerBlock(brailPowered, "BrailPowered");
        brailDetector = new BlazeRailDetector().setHardness(0.7F).setBlockName("blazerail.detector").setBlockTextureName("natura:brail_detector");
        GameRegistry.registerBlock(brailDetector, "BrailDetector");
        brailActivator = new BlazeRailPowered(true).setHardness(0.7F).setBlockName("blazerail.activator").setBlockTextureName("natura:brail_activator");
        GameRegistry.registerBlock(brailActivator, "BrailActivator");

        netherrackFurnace = new NetherrackFurnaceBlock().setHardness(3.5F).setCreativeTab(Natura.tab).setBlockName("furnace.netherrack");
        GameRegistry.registerBlock(netherrackFurnace, "NetherFurnace");
        GameRegistry.registerTileEntity(NetherrackFurnaceLogic.class, "netherrackFurnace");
        respawnObelisk = new RespawnObelisk(Material.wood).setHardness(1.0F).setResistance(1000000F).setCreativeTab(Natura.tab).setBlockName("nether.obelisk");
        GameRegistry.registerBlock(respawnObelisk, "Obelisk");
        netherGlass = (NetherGlass) new NetherGlass().setHardness(1.0F).setResistance(3000F).setStepSound(Block.soundTypeGlass).setCreativeTab(Natura.tab).setBlockName("nether.glass");
        GameRegistry.registerBlock(netherGlass, NetherGlassItem.class, "NetherGlass");
        netherHopper = (BlazeHopper) new BlazeHopper().setHardness(3.0F).setResistance(8.0F).setCreativeTab(Natura.tab).setBlockName("nether.hopper");
        GameRegistry.registerBlock(netherHopper, "NetherHopper");

        potashApple = new NetherFoodItem().setUnlocalizedName("Natura.netherfood");
        GameRegistry.registerItem(potashApple, "Natura.netherfood");
        GameRegistry.registerCustomItemStack("applePotash", new ItemStack(potashApple, 1, 0));

        //Rare overworld
        rareTree = new OverworldTreeBlock().setBlockName("RareTree");
        GameRegistry.registerBlock(rareTree, OverworldTreeItem.class, "Rare Tree");

        rareLeaves = new OverworldLeaves();
        GameRegistry.registerBlock(rareLeaves, OverworldLeavesItem.class, "Rare Leaves");//TODO 1.8 rename

        rareSapling = new RareSaplingBlock();
        GameRegistry.registerBlock(rareSapling, RareSaplingItem.class, "Rare Sapling");//TODO 1.8 rename 
		bluebells = (FlowerBlock) new FlowerBlock().setBlockName("bluebells");
        GameRegistry.registerBlock(bluebells, "Bluebells");

        // TODO 1.7 apparently this isn't so simple anymore
        //MinecraftForge.addGrassPlant(bluebells, 0, 18);

        //Vanilla overrides and alternates
		if (PHNatura.enableCraftingTables)
		{
		    alternateWorkbench = new AlternateWorkbench().setHardness(2.5F).setStepSound(Block.soundTypeWood).setBlockName("workbench").setCreativeTab(Natura.tab);
		    GameRegistry.registerBlock(alternateWorkbench, NAlternateItem.class, "Natura.workbench");
		}

		if (PHNatura.enableBookshelves)
		{
		    alternateBookshelf = new AlternateBookshelf().setHardness(1.5F).setStepSound(Block.soundTypeWood).setBlockName("bookshelf").setCreativeTab(Natura.tab);
		    GameRegistry.registerBlock(alternateBookshelf, NAlternateItem.class, "Natura.bookshelf");
		}

		if (PHNatura.enableFences)
		{
			alternateFence = new AlternateFence(Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("fence").setCreativeTab(Natura.tab);
			GameRegistry.registerBlock(alternateFence, FenceItem.class, "Natura.fence"); 
		}

        grassBlock = new GrassBlock().setBlockName("GrassBlock");
        grassBlock.stepSound = Block.soundTypeGrass;
        GameRegistry.registerBlock(grassBlock, GrassBlockItem.class, "GrassBlock");

        /* ###################### */
        if (PHNatura.enableSlabs)
        {
	        grassSlab = new GrassSlab("GrassSlab");
	        grassSlab.stepSound = Block.soundTypeGrass;
	        GameRegistry.registerBlock(grassSlab, GrassSlabItem.class, "GrassSlab");
	
	        plankSlab1 = new NSlabBase(Material.wood, planks, 0, 8, "plankSlab1").setHardness(2.0f);
	        plankSlab1.stepSound = Block.soundTypeWood;
	        GameRegistry.registerBlock(plankSlab1, PlankSlab1Item.class, "plankSlab1");
	
	        plankSlab2 = new NSlabBase(Material.wood, planks, 8, 5, "plankSlab2").setHardness(2.0f);
	        plankSlab2.stepSound = Block.soundTypeWood;
	        GameRegistry.registerBlock(plankSlab2, PlankSlab2Item.class, "plankSlab2"); 
        }


        /* Stairs */
        if (PHNatura.enableStairs)
        {
            /* public String[] stairNames = new String[] { "eucalyptus", "sakura", "ghostwood", "redwood", "bloodwood", "hopseed", "maple", "silverbell", "amaranth", "tiger",
    		"willow", "darkwood", "fusewood"}; */
	        stairEucalyptus = new NStairs(planks, 0, "eucalyptus");
	        GameRegistry.registerBlock(stairEucalyptus, "stair.eucalyptus");
	
	        stairSakura = new NStairs(planks, 1, "sakura");
	        GameRegistry.registerBlock(stairSakura, "stair.sakura");
	
	        stairGhostwood = new NStairs(planks, 2, "ghostwood");
	        GameRegistry.registerBlock(stairGhostwood, "stair.ghostwood");
	
	        stairRedwood = new NStairs(planks, 3, "redwood");
	        GameRegistry.registerBlock(stairRedwood, "stair.redwood");
	
	        stairBloodwood = new NStairs(planks, 4, "bloodwood");
	        GameRegistry.registerBlock(stairBloodwood, "stair.bloodwood");
	
	        stairHopseed = new NStairs(planks, 5, "hopseed");
	        GameRegistry.registerBlock(stairHopseed, "stair.hopseed");
	
	        stairMaple = new NStairs(planks, 6, "maple");
	        GameRegistry.registerBlock(stairMaple, "stair.maple");
	
	        stairSilverbell = new NStairs(planks, 7, "silverbell");
	        GameRegistry.registerBlock(stairSilverbell, "stair.silverbell");
	
	        stairAmaranth = new NStairs(planks, 8, "amaranth");
	        GameRegistry.registerBlock(stairAmaranth, "stair.amaranth");
	
	        stairTiger = new NStairs(planks, 9, "tiger");
	        GameRegistry.registerBlock(stairTiger, "stair.tiger");
	
	        stairWillow = new NStairs(planks, 10, "willow");
	        GameRegistry.registerBlock(stairWillow, "stair.willow");
	
	        stairDarkwood = new NStairs(planks, 11, "darkwood");
	        GameRegistry.registerBlock(stairDarkwood, "stair.darkwood");
	
	        stairFusewood = new NStairs(planks, 12, "fusewood");
	        GameRegistry.registerBlock(stairFusewood, "stair.fusewood");
        }

        if (PHNatura.enableTrapdoors)
        {
	        trapdoorEucalyptus = new NTrapdoor("eucalyptus");
	        GameRegistry.registerBlock(trapdoorEucalyptus, "trapdoor.eucalyptus");

	        trapdoorSakura = new NTrapdoor("sakura");
	        GameRegistry.registerBlock(trapdoorSakura, "trapdoor.sakura");

	        trapdoorGhostwood = new NTrapdoor("ghostwood");
	        GameRegistry.registerBlock(trapdoorGhostwood, "trapdoor.ghostwood");

	        trapdoorRedwood = new NTrapdoor("redwood");
	        GameRegistry.registerBlock(trapdoorRedwood, "trapdoor.redwood");

	        trapdoorBloodwood = new NTrapdoor("bloodwood");
	        GameRegistry.registerBlock(trapdoorBloodwood, "trapdoor.bloodwood");

	        trapdoorHopseed = new NTrapdoor("hopseed");
	        GameRegistry.registerBlock(trapdoorHopseed, "trapdoor.hopseed");

	        trapdoorMaple = new NTrapdoor("maple");
	        GameRegistry.registerBlock(trapdoorMaple, "trapdoor.maple");

	        trapdoorAmaranth = new NTrapdoor("amaranth", "purpleheart"); /* TODO: fix amaranth having different names */
	        GameRegistry.registerBlock(trapdoorAmaranth, "trapdoor.amaranth");

	        trapdoorSilverbell = new NTrapdoor("silverbell");
	        GameRegistry.registerBlock(trapdoorSilverbell, "trapdoor.silverbell");

	        trapdoorTiger = new NTrapdoor("tiger");
	        GameRegistry.registerBlock(trapdoorTiger, "trapdoor.tiger");

	        trapdoorWillow = new NTrapdoor("willow");
	        GameRegistry.registerBlock(trapdoorWillow, "trapdoor.willow");

	        trapdoorDarkwood = new NTrapdoor("darkwood");
	        GameRegistry.registerBlock(trapdoorDarkwood, "trapdoor.darkwood");

	        trapdoorFusewood = new NTrapdoor("fusewood");
	        GameRegistry.registerBlock(trapdoorFusewood, "trapdoor.fusewood");
        }

        if (PHNatura.enablePressurePlates)
        {
        	pressurePlateEucalyptus = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 0, "eucalyptus");
        	GameRegistry.registerBlock(pressurePlateEucalyptus, "pressureplate.eucalyptus");
        	pressurePlateSakura = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 1, "sakura");
        	GameRegistry.registerBlock(pressurePlateSakura, "pressureplate.sakura");
        	pressurePlateGhostwood = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 2, "ghostwood");
        	GameRegistry.registerBlock(pressurePlateGhostwood, "pressureplate.ghostwood");
        	pressurePlateRedwood = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 3, "redwood");
        	GameRegistry.registerBlock(pressurePlateRedwood, "pressureplate.redwood");
        	pressurePlateBloodwood = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 4, "bloodwood");
        	GameRegistry.registerBlock(pressurePlateBloodwood, "pressureplate.bloodwood");
        	pressurePlateHopseed = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 5, "hopseed");
        	GameRegistry.registerBlock(pressurePlateHopseed, "pressureplate.hopseed");
        	pressurePlateMaple = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 6, "maple");
        	GameRegistry.registerBlock(pressurePlateMaple, "pressureplate.maple");
        	pressurePlateAmaranth = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 7, "amaranth");
        	GameRegistry.registerBlock(pressurePlateAmaranth, "pressureplate.amaranth");
        	pressurePlateSilverbell = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 8, "silverbell");
        	GameRegistry.registerBlock(pressurePlateSilverbell, "pressureplate.silverbell");
        	pressurePlateTiger = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 9, "tiger");
        	GameRegistry.registerBlock(pressurePlateTiger, "pressureplate.tiger");
        	pressurePlateWillow = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 10, "willow");
        	GameRegistry.registerBlock(pressurePlateWillow, "pressureplate.willow");
        	pressurePlateDarkwood = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 11, "darkwood");
        	GameRegistry.registerBlock(pressurePlateDarkwood, "pressureplate.darkwood");
        	pressurePlateFusewood = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 12, "fusewood");
        	GameRegistry.registerBlock(pressurePlateFusewood, "pressureplate.fusewood");
        }

        if (PHNatura.enableButtons)
        {
        	buttonEucalyptus = new NButton(planks, 0, "eucalyptus");
        	GameRegistry.registerBlock(buttonEucalyptus, "button.eucalyptus");
        	buttonSakura = new NButton(planks, 1, "sakura");
        	GameRegistry.registerBlock(buttonSakura, "button.sakura");
        	buttonGhostwood = new NButton(planks, 2, "ghostwood");
        	GameRegistry.registerBlock(buttonGhostwood, "button.ghostwood");
        	buttonRedwood = new NButton(planks, 3, "redwood");
        	GameRegistry.registerBlock(buttonRedwood, "button.redwood");
        	buttonBloodwood = new NButton(planks, 4, "bloodwood");
        	GameRegistry.registerBlock(buttonBloodwood, "button.bloodwood");
        	buttonHopseed = new NButton(planks, 5, "hopseed");
        	GameRegistry.registerBlock(buttonHopseed, "button.hopseed");
        	buttonMaple = new NButton(planks, 6, "maple");
        	GameRegistry.registerBlock(buttonMaple, "button.maple");
        	buttonAmaranth = new NButton(planks, 7, "amaranth");
        	GameRegistry.registerBlock(buttonAmaranth, "button.amaranth");
        	buttonSilverbell = new NButton(planks, 8, "silverbell");
        	GameRegistry.registerBlock(buttonSilverbell, "button.silverbell");
        	buttonTiger = new NButton(planks, 9, "tiger");
        	GameRegistry.registerBlock(buttonTiger, "button.tiger");
        	buttonWillow = new NButton(planks, 10, "willow");
        	GameRegistry.registerBlock(buttonWillow, "button.willow");
        	buttonDarkwood = new NButton(planks, 11, "darkwood");
        	GameRegistry.registerBlock(buttonDarkwood, "button.darkwood");
        	buttonFusewood = new NButton(planks, 12, "fusewood");
        	GameRegistry.registerBlock(buttonFusewood, "button.fusewood");
        }

        if (PHNatura.enableFenceGates)
        {
        	fenceGateEucalyptus = new NFenceGate(planks, 0, "eucalyptus");
        	GameRegistry.registerBlock(fenceGateEucalyptus, "fenceGate.eucalyptus");
        	fenceGateSakura = new NFenceGate(planks, 1, "sakura");
        	GameRegistry.registerBlock(fenceGateSakura, "fenceGate.sakura");
        	fenceGateGhostwood = new NFenceGate(planks, 2, "ghostwood");
        	GameRegistry.registerBlock(fenceGateGhostwood, "fenceGate.ghostwood");
        	fenceGateRedwood = new NFenceGate(planks, 3, "redwood");
        	GameRegistry.registerBlock(fenceGateRedwood, "fenceGate.redwood");
        	fenceGateBloodwood = new NFenceGate(planks, 4, "bloodwood");
        	GameRegistry.registerBlock(fenceGateBloodwood, "fenceGate.bloodwood");
        	fenceGateHopseed = new NFenceGate(planks, 5, "hopseed");
        	GameRegistry.registerBlock(fenceGateHopseed, "fenceGate.hopseed");
        	fenceGateMaple = new NFenceGate(planks, 6, "maple");
        	GameRegistry.registerBlock(fenceGateMaple, "fenceGate.maple");
        	fenceGateAmaranth = new NFenceGate(planks, 7, "amaranth");
        	GameRegistry.registerBlock(fenceGateAmaranth, "fenceGate.amaranth");
        	fenceGateSilverbell = new NFenceGate(planks, 8, "silverbell");
        	GameRegistry.registerBlock(fenceGateSilverbell, "fenceGate.silverbell");
        	fenceGateTiger = new NFenceGate(planks, 9, "tiger");
        	GameRegistry.registerBlock(fenceGateTiger, "fenceGate.tiger");
        	fenceGateWillow = new NFenceGate(planks, 10, "willow");
        	GameRegistry.registerBlock(fenceGateWillow, "fenceGate.willow");
        	fenceGateDarkwood = new NFenceGate(planks, 11, "darkwood");
        	GameRegistry.registerBlock(fenceGateDarkwood, "fenceGate.darkwood");
        	fenceGateFusewood = new NFenceGate(planks, 12, "fusewood");
        	GameRegistry.registerBlock(fenceGateFusewood, "fenceGate.fusewood");
        }

        /* Barricades */
        if (PHNatura.enableVanillaBarricades)
        {
	        String vanillaWoodNames[] = {"oak", "spruce", "birch", "jungle"};
	        String vanillaWoodNames2[] = {"acacia", "darkoak"};
	        vanillaBarricades = initBarricades ("", vanillaWoodNames, Blocks.log);
	        vanillaBarricades2 = initBarricades ("", vanillaWoodNames2, Blocks.log2);
        }
        String nameTree[] = {"eucalyptus", "sakura", "ghostwood", "hopseed"};
        String nameDark[] = {"darkwood", "fusewood"};
        String nameRare[] = {"maple", "silverbell", "amaranth", "tiger"};
        String nameWillow[] = {"willow"};

        if (PHNatura.enableNaturaBarricades)
        	barricades = ArrayUtils.addAll(initBarricades ("", nameTree, tree), ArrayUtils.addAll(
        			                       initBarricades ("", nameDark, darkTree), ArrayUtils.addAll(
        			                       initBarricades ("", nameRare, rareTree),
        			                       initBarricades ("", nameWillow, willow))));
        if (PHNatura.enableNaturaPlankBarricades)
        	plankBarricades = initBarricades ("plank", woodTextureNames, planks);

        ArmorMaterial Imp = EnumHelper.addArmorMaterial("Imp", 33, new int[] {1, 3, 2, 1}, 15);

        impHelmet = new NaturaArmor(Imp, 1, 0, "imp_helmet", "imp").setUnlocalizedName("natura.armor.imphelmet");
        GameRegistry.registerItem(impHelmet, "natura.armor.imphelmet");
        impJerkin = new NaturaArmor(Imp, 1, 1, "imp_body", "imp").setUnlocalizedName("natura.armor.impjerkin");
        GameRegistry.registerItem(impJerkin, "natura.armor.impjerkin");
        impLeggings = new NaturaArmor(Imp, 1, 2, "imp_leggings", "imp").setUnlocalizedName("natura.armor.impleggings");
        GameRegistry.registerItem(impLeggings, "natura.armor.impleggings");
        impBoots = new NaturaArmor(Imp, 1, 3, "imp_boots", "imp").setUnlocalizedName("natura.armor.impboots");
        GameRegistry.registerItem(impBoots, "natura.armor.impboots");

        flintAndBlaze = new FlintAndBlaze().setUnlocalizedName("flintandblaze").setTextureName("natura:flint_and_blaze");
        GameRegistry.registerItem(flintAndBlaze, "natura.flintandblaze");

        impMeat = new ImpMeat().setUnlocalizedName("impmeat");
        GameRegistry.registerItem(impMeat, "impmeat");
        GameRegistry.registerCustomItemStack("rawImphide", new ItemStack(impMeat, 1, 0));
        GameRegistry.registerCustomItemStack("cookedImphide", new ItemStack(impMeat, 1, 1));

        //Material.vine.setRequiresTool();
        bloodwood.setHarvestLevel("axe", 2);
        darkTree.setHarvestLevel("axe", 1, 1);
        darkTree.setHarvestLevel("axe", -1, 0);
        tree.setHarvestLevel("axe", -1);
        redwood.setHarvestLevel("axe", -1);
        taintedSoil.setHarvestLevel("shovel", 0);
        heatSand.setHarvestLevel("shovel", 0);

        bowlStew = new BowlStew().setUnlocalizedName("natura.stewbowl");
        GameRegistry.registerItem(bowlStew, "natura.stewbowl");

		/* fire! */
        /* TODO: make more objects burnable and make some checks */
		Blocks.fire.setFireInfo (planks, 5, 20);
		Blocks.fire.setFireInfo (tree, 5, 20);
		Blocks.fire.setFireInfo (redwood, 5, 20);
		Blocks.fire.setFireInfo (floraLeaves, 30, 60);
		Blocks.fire.setFireInfo (floraLeavesNoColor, 30, 60);
		Blocks.fire.setFireInfo (darkTree, 5, 20);
        Blocks.fire.setFireInfo (rareTree, 5, 20);
        Blocks.fire.setFireInfo (rareLeaves, 30, 60);

        addRecipes();
    }

    public void addRecipes ()
    {
        //Crops
		if (PHNatura.enableSeedBags)
		{
		    GameRegistry.addRecipe(new ItemStack(wheatBag, 1, 0), "sss", "sss", "sss", 's', Items.wheat_seeds);
		    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(barleyBag, 1, 0), "sss", "sss", "sss", 's', "seedBarley"));
		    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(potatoBag, 1, 0), "sss", "sss", "sss", 's', "cropPotato"));
		    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carrotBag, 1, 0), "sss", "sss", "sss", 's', "cropCarrot"));
		    GameRegistry.addRecipe(new ItemStack(netherWartBag, 1, 0), "sss", "sss", "sss", 's', Items.nether_wart);
		    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(cottonBag, 1, 0), "sss", "sss", "sss", 's', "seedCotton"));
		    GameRegistry.addRecipe(new ItemStack(boneBag, 1, 0), "sss", "sss", "sss", 's', new ItemStack(Items.dye, 1, 15));
		}

        GameRegistry.addRecipe(new ItemStack(Items.wheat_seeds, 9, 0), "s", 's', wheatBag);
        GameRegistry.addRecipe(new ItemStack(seeds, 9, 0), "s", 's', barleyBag);
        GameRegistry.addRecipe(new ItemStack(Items.potato, 9, 0), "s", 's', potatoBag);
        GameRegistry.addRecipe(new ItemStack(Items.carrot, 9, 0), "s", 's', carrotBag);
        GameRegistry.addRecipe(new ItemStack(Items.nether_wart, 9, 0), "s", 's', netherWartBag);
        GameRegistry.addRecipe(new ItemStack(seeds, 9, 1), "s", 's', cottonBag);
        GameRegistry.addRecipe(new ItemStack(Items.dye, 9, 15), "s", 's', boneBag);

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.string), "sss", 's', "cropCotton"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.wool), "sss", "sss", "sss", 's', "cropCotton"));

        GameRegistry.addRecipe(new ItemStack(waterDrop, 1), "X", 'X', Blocks.cactus);
        GameRegistry.addRecipe(new ItemStack(Items.water_bucket, 1), "www", "wBw", "www", 'w', waterDrop, 'B', Items.bucket);

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.bread), "bbb", 'b', "cropBarley"));

	/* old recipe: Barley used to give its own kind of flour.
	if (PHNatura.enableBarleyRecipe)
	    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(plantItem, 1, 1), "X", 'X', "cropBarley")); */
	if (PHNatura.enableBarleyRecipe)
	    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(plantItem, 1, 2), "X", 'X', "cropBarley"));
        if (PHNatura.enableWheatRecipe)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(plantItem, 1, 2), "X", 'X', "cropWheat"));

        GameRegistry.addRecipe(new ItemStack(plantItem, 2, 8), "X", 'X', new ItemStack(bluebells));

        FurnaceRecipes.smelting().func_151394_a(new ItemStack(saguaro, 1, 0), new ItemStack(Items.dye, 1, 2), 0.2F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(impMeat, 1, 0), new ItemStack(impMeat, 1, 1), 0.2F);

        for (int i = 1; i <= 2; i++)
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(plantItem, 1, i), new ItemStack(Items.bread, 1), 0.5f);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.cake, 1), "AAA", "BEB", " C ", 'A', Items.milk_bucket, 'B', Items.sugar, 'C', "foodFlour", 'E', Items.egg));//check1

        String[] berryTypes = {"cropRaspberry", "cropBlueberry", "cropBlackberry", "cropMaloberry"};

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(berryMedley, 1), Items.bowl, berryTypes[0], berryTypes[1], berryTypes[2]));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(berryMedley, 1), Items.bowl, berryTypes[1], berryTypes[2], berryTypes[3]));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(berryMedley, 1), Items.bowl, berryTypes[2], berryTypes[3], berryTypes[0]));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(berryMedley, 1), Items.bowl, berryTypes[0], berryTypes[2], berryTypes[3]));

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(berryMedley, 2), Items.bowl, Items.bowl, berryTypes[0], berryTypes[1], berryTypes[2], berryTypes[3]));

        //GameRegistry.addShapelessRecipe(new ItemStack(plantItem, 1, 2), new ItemStack(plantItem, 1, 1), Item.bucketWater );
        //GameRegistry.addShapelessRecipe(new ItemStack(plantItem, 2, 2), new ItemStack(plantItem, 1, 1), Item.egg );

        //Clouds
        GameRegistry.addRecipe(new ItemStack(Items.coal, 1, 1), "ccc", "ccc", "ccc", 'c', new ItemStack(cloud, 1, 2));
        GameRegistry.addRecipe(new ItemStack(plantItem, 1, 4), "cc", "cc", 'c', new ItemStack(cloud, 1, 3));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.gunpowder, 1, 0), "cc", "cc", 'c', "dustSulfur"));

        //Trees
        for (int i = 0; i < 3; i++)
        {
            GameRegistry.addRecipe(new ItemStack(planks, 4, i), "w", 'w', new ItemStack(tree, 1, i));
        }
        for (int i = 0; i < 4; i++)
        {
            GameRegistry.addRecipe(new ItemStack(planks, 4, i + 6), "w", 'w', new ItemStack(rareTree, 1, i));
        }
        GameRegistry.addRecipe(new ItemStack(planks, 4, 3), "w", 'w', new ItemStack(redwood, 1, 1));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 4), "w", 'w', new ItemStack(bloodwood, 1, Short.MAX_VALUE));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 5), "w", 'w', new ItemStack(tree, 1, 3));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 10), "w", 'w', new ItemStack(willow, 1, 0));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 11), "w", 'w', new ItemStack(darkTree, 1, 0));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 12), "w", 'w', new ItemStack(darkTree, 1, 1));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(plantItem, 1, 5), " s ", "#s#", "#s#", 's', "stickWood", '#', new ItemStack(floraLeavesNoColor, 1, 1)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.arrow, 4, 0), " f ", "#s#", " # ", 's', "stickWood", '#', new ItemStack(plantItem, 1, 5), 'f', Items.flint));

        List recipes = CraftingManager.getInstance().getRecipeList();
        
        if (PHNatura.enableDoors)
        {
	        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 0), "##", "##", "##", '#', new ItemStack(planks, 1, 3));
	        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 1), "##", "##", "##", '#', new ItemStack(planks, 1, 0));
	        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 2), "##", "##", "##", '#', new ItemStack(planks, 1, 5));
	        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 3), "##", "##", "##", '#', new ItemStack(planks, 1, 1));
	        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 4), "##", "##", "##", '#', new ItemStack(planks, 1, 2));
	        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 5), "##", "##", "##", '#', new ItemStack(planks, 1, 4));
	        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 6), "##", "##", "##", '#', new ItemStack(redwood, 1, 0));
        }

	if (PHNatura.enableCraftingTables && PHNatura.enableBookshelves)
	    for (int i = 0; i < woodTextureNames.length; i++)
	    {
	    	if (PHNatura.enableCraftingTables)
	    		addShapedRecipeFirst(recipes, new ItemStack(alternateWorkbench, 1, i), "##", "##", '#', new ItemStack(planks, 1, i));
	    	if (PHNatura.enableBookshelves)
	    		addShapedRecipeFirst(recipes, new ItemStack(alternateBookshelf, 1, i), "###", "bbb", "###", '#', new ItemStack(planks, 1, i), 'b', Items.book);
	    	if (PHNatura.enableFences)
	    		addShapedRecipeFirst(recipes, new ItemStack(alternateFence, 2, i), "s#s", "s#s", '#', new ItemStack(planks, 1, i), 's', Items.stick);
	    }

        GameRegistry.addRecipe(new ItemStack(Items.leather, 2), "##", "##", '#', new ItemStack(plantItem, 1, 6));

        impHelmetStack = new ItemStack(impHelmet);
        impHelmetStack.addEnchantment(Enchantment.protection, 1);
        impHelmetStack.addEnchantment(Enchantment.fireProtection, 1);
        GameRegistry.addRecipe(impHelmetStack.copy(), "###", "# #", '#', new ItemStack(plantItem, 1, 6));

        impJerkinStack = new ItemStack(impJerkin);
        impJerkinStack.addEnchantment(Enchantment.blastProtection, 1);
        impJerkinStack.addEnchantment(Enchantment.fireProtection, 1);
        GameRegistry.addRecipe(impJerkinStack.copy(), "# #", "###", "###", '#', new ItemStack(plantItem, 1, 6));

        impLeggingsStack = new ItemStack(impLeggings);
        impLeggingsStack.addEnchantment(Enchantment.projectileProtection, 1);
        impLeggingsStack.addEnchantment(Enchantment.fireProtection, 1);
        GameRegistry.addRecipe(impLeggingsStack.copy(), "###", "# #", "# #", '#', new ItemStack(plantItem, 1, 6));

        impBootsStack = new ItemStack(impBoots);
        impBootsStack.addEnchantment(Enchantment.featherFalling, 1);
        impBootsStack.addEnchantment(Enchantment.fireProtection, 1);
        GameRegistry.addRecipe(impBootsStack.copy(), "# #", "# #", '#', new ItemStack(plantItem, 1, 6));

        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.soul_sand, 1, 0), heatSand, taintedSoil);

        addShapelessRecipeFirst(recipes, new ItemStack(bowlStew, 1, 0), new ItemStack(Blocks.brown_mushroom), new ItemStack(Blocks.red_mushroom), new ItemStack(Items.bowl));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(bowlStew, 1, 14), new ItemStack(glowshroom, 1, 0), new ItemStack(glowshroom, 1, 1), new ItemStack(glowshroom, 1, 2), Items.bowl));

        /*bowlStew = new BowlStew(PHNatura.bowlStew).setUnlocalizedName("natura.stewbowl");*/

        //Turn logs into charcoal
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(tree, 1, 0), new ItemStack(Items.coal, 1, 1), 0.15f);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(tree, 1, 1), new ItemStack(Items.coal, 1, 1), 0.15f);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(tree, 1, 2), new ItemStack(Items.coal, 1, 1), 0.15f);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(tree, 1, 3), new ItemStack(Items.coal, 1, 1), 0.15f);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(redwood, 1, 0), new ItemStack(Items.coal, 1, 1), 0.15f);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(redwood, 1, 1), new ItemStack(Items.coal, 1, 1), 0.15f);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(redwood, 1, 2), new ItemStack(Items.coal, 1, 1), 0.15f);

        GameRegistry.addRecipe(new ItemStack(grassBlock, 1, 0), " s ", "s#s", " s ", 's', new ItemStack(Items.wheat_seeds), '#', new ItemStack(Blocks.dirt));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(grassBlock, 1, 1), new ItemStack(grassBlock, 1, 0), "dyeBlue"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(grassBlock, 1, 2), new ItemStack(grassBlock, 1, 0), "dyeRed"));

        if (PHNatura.enableTrapdoors || PHNatura.enableFenceGates || PHNatura.enableButtons || PHNatura.enablePressurePlates || PHNatura.enableStairs)
        {
	        Block[] trapdoors = {trapdoorEucalyptus, trapdoorSakura, trapdoorGhostwood, trapdoorRedwood, trapdoorBloodwood, trapdoorHopseed, trapdoorMaple, trapdoorSilverbell,
	                trapdoorAmaranth, trapdoorTiger, trapdoorWillow, trapdoorDarkwood, trapdoorFusewood};
        	Block[] fenceGates = {fenceGateEucalyptus, fenceGateSakura, fenceGateGhostwood, fenceGateRedwood, fenceGateBloodwood, fenceGateHopseed, fenceGateMaple, fenceGateSilverbell,
         	         fenceGateAmaranth, fenceGateTiger, fenceGateWillow, fenceGateDarkwood, fenceGateFusewood };
        	Block[] buttons = {buttonEucalyptus, buttonSakura, buttonGhostwood, buttonRedwood, buttonBloodwood, buttonHopseed, buttonMaple, buttonSilverbell, buttonAmaranth, buttonTiger,
            		buttonWillow, buttonDarkwood, buttonFusewood};
        	Block[] pressurePlates = {pressurePlateEucalyptus, pressurePlateSakura, pressurePlateGhostwood, pressurePlateRedwood, pressurePlateBloodwood, pressurePlateHopseed,
            		pressurePlateMaple, pressurePlateSilverbell, pressurePlateAmaranth, pressurePlateTiger, pressurePlateWillow, pressurePlateDarkwood, pressurePlateFusewood};
        	Block[] stairs = {stairEucalyptus, stairSakura, stairGhostwood, stairRedwood, stairBloodwood, stairHopseed, stairMaple, stairSilverbell, stairAmaranth, stairTiger, stairWillow,
        			stairDarkwood, stairFusewood};

	        for (int i = 0; i < woodTextureNames.length; i++)
	        {
	        	if (PHNatura.enableTrapdoors)
	        		addShapedRecipeFirst(recipes, new ItemStack(trapdoors[i], 2, 0), "###", "###", '#', new ItemStack(planks, 1, i));
	        	if (PHNatura.enableFenceGates)
	        		addShapedRecipeFirst(recipes, new ItemStack(fenceGates[i], 1, 0), "s#s", "s#s", '#', new ItemStack(planks, 1, i), 's', Items.stick);
	        	if (PHNatura.enableButtons)
	        		addShapedRecipeFirst(recipes, new ItemStack(buttons[i], 1, 0), "#", '#', new ItemStack(planks, 1, i));
	        	if (PHNatura.enablePressurePlates)
	        		addShapedRecipeFirst(recipes, new ItemStack(pressurePlates[i], 1, 0), "##", '#', new ItemStack(planks, 1, i));
	        	if (PHNatura.enableStairs)
	        		addShapedRecipeFirst(recipes, new ItemStack(stairs[i], 4, 0	), "#  ", "## ", "###", '#', new ItemStack(planks, 1, i));
	        }
        }

        if (PHNatura.enableSlabs)
        {
        	for (int i = 0; i < 8; i++)
        		addShapedRecipeFirst(recipes, new ItemStack(plankSlab1, 6, i), "###", '#', new ItemStack(planks, 1, i));
        	for (int i = 0; i < 5; i++)
        		addShapedRecipeFirst(recipes, new ItemStack(plankSlab2, 6, i), "###", '#', new ItemStack(planks, 1, 8 + i));
        	for (int i = 0; i < 3; i++)
        		GameRegistry.addRecipe(new ItemStack(grassSlab, 6, i), "bbb", 'b', new ItemStack(grassBlock, 1, i));
        }

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NContent.brail, 16), "X X", "X#X", "X X", 'X', Items.blaze_rod, '#', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NContent.brailPowered, 6), "X X", "X#X", "XRX", 'X', Items.blaze_rod, 'R', "dustRedstone", '#', new ItemStack(darkTree, 1, 1)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NContent.brailActivator, 6), "XSX", "X#X", "XSX", 'X', Items.blaze_rod, '#', Blocks.redstone_torch, 'S', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NContent.brailDetector, 6), "X X", "X#X", "XRX", 'X', Items.blaze_rod, 'R', "dustRedstone", '#', "pressurePlateWood")); /* ###: was nether pressure plate */

        GameRegistry.addRecipe(new ItemStack(NContent.netherrackFurnace), "###", "# #", "###", '#', Blocks.netherrack);
        GameRegistry.addRecipe(new ItemStack(NContent.respawnObelisk), "###", "# #", "###", '#', new ItemStack(tree, 1, 2));
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(Blocks.soul_sand, 1, 0), new ItemStack(netherGlass, 1, 0), 0.3f);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(heatSand, 1, 0), new ItemStack(netherGlass, 1, 1), 0.3f);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NContent.netherHopper), "# #", "#C#", " # ", '#', new ItemStack(Items.blaze_rod), 'C', "chestWood"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.glass_bottle, 3), "# #", " # ", '#', "glass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.daylight_detector), "GGG", "QQQ", "WWW", 'G', "glass", 'Q', "gemQuartz", 'W', "slabWood"));

        if (PHNatura.enableVanillaBarricades)
        {
        	recipeBarricades(vanillaBarricades, Blocks.log);
        	recipeBarricades(vanillaBarricades2, Blocks.log2);
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(vanillaBarricades[0], 1, 0), "b", "b", 'b', "logWood"));
        }

        if (PHNatura.enableNaturaBarricades)
        {
        	recipeBarricades(ArrayUtils.subarray(barricades, 0, 3), tree);
        	recipeBarricades(ArrayUtils.subarray(barricades, 4, 5), darkTree);
        	recipeBarricades(ArrayUtils.subarray(barricades, 6, 9), rareTree);
        	recipeBarricades(ArrayUtils.subarray(barricades, 10, 10), willow);
        }
        /* The stick recipe...
         * if (PHNatura.enableNaturaPlankBarricades)
        	recipeBarricades (plankBarricades, planks);
        	*/
    }

    public void addShapedRecipeFirst (List recipeList, ItemStack itemstack, Object... objArray)
    {
        String var3 = "";
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;

        if (objArray[var4] instanceof String[])
        {
            String[] var7 = ((String[]) objArray[var4++]);

            for (int var8 = 0; var8 < var7.length; ++var8)
            {
                String var9 = var7[var8];
                ++var6;
                var5 = var9.length();
                var3 = var3 + var9;
            }
        }
        else
        {
            while (objArray[var4] instanceof String)
            {
                String var11 = (String) objArray[var4++];
                ++var6;
                var5 = var11.length();
                var3 = var3 + var11;
            }
        }

        HashMap var12;

        for (var12 = new HashMap(); var4 < objArray.length; var4 += 2)
        {
            Character var13 = (Character) objArray[var4];
            ItemStack var14 = null;

            if (objArray[var4 + 1] instanceof Item)
            {
                var14 = new ItemStack((Item) objArray[var4 + 1]);
            }
            else if (objArray[var4 + 1] instanceof Block)
            {
                var14 = new ItemStack((Block) objArray[var4 + 1], 1, Short.MAX_VALUE);
            }
            else if (objArray[var4 + 1] instanceof ItemStack)
            {
                var14 = (ItemStack) objArray[var4 + 1];
            }

            var12.put(var13, var14);
        }

        ItemStack[] var15 = new ItemStack[var5 * var6];

        for (int var16 = 0; var16 < var5 * var6; ++var16)
        {
            char var10 = var3.charAt(var16);

            if (var12.containsKey(Character.valueOf(var10)))
            {
                var15[var16] = ((ItemStack) var12.get(Character.valueOf(var10))).copy();
            }
            else
            {
                var15[var16] = null;
            }
        }

        ShapedRecipes var17 = new ShapedRecipes(var5, var6, var15, itemstack);
        recipeList.add(0, var17);
    }

    public void addShapelessRecipeFirst (List recipeList, ItemStack par1ItemStack, Object... par2ArrayOfObj)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack) object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item) object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipe!");
                }

                arraylist.add(new ItemStack((Block) object1));
            }
        }

        recipeList.add(0, new ShapelessRecipes(par1ItemStack, arraylist));
    }

    public void addOredictSupport ()
    {
        //Food
        OreDictionary.registerOre("cropRaspberry", new ItemStack(berryItem, 1, 0));
        OreDictionary.registerOre("cropBlueberry", new ItemStack(berryItem, 1, 1));
        OreDictionary.registerOre("cropBlackberry", new ItemStack(berryItem, 1, 2));
        OreDictionary.registerOre("cropMaloberry", new ItemStack(berryItem, 1, 3));

        OreDictionary.registerOre("cropBarley", new ItemStack(plantItem, 1, 0));
        OreDictionary.registerOre("cropCotton", new ItemStack(plantItem, 1, 3));

        OreDictionary.registerOre("listAllgrain", new ItemStack(plantItem, 1, 0));

        OreDictionary.registerOre("foodFlour", new ItemStack(plantItem, 1, 1));
        OreDictionary.registerOre("foodFlour", new ItemStack(plantItem, 1, 2));
        OreDictionary.registerOre("dustWheat", new ItemStack(plantItem, 1, 2));
        OreDictionary.registerOre("foodEqualswheat", new ItemStack(plantItem, 1, 2));

        //Dusts
        OreDictionary.registerOre("dustSulphur", new ItemStack(plantItem, 1, 4));
        OreDictionary.registerOre("dustSulfur", new ItemStack(plantItem, 1, 4));

        //For Harvestcraft
        OreDictionary.registerOre("listAllseed", new ItemStack(seeds, 1, 0));
        OreDictionary.registerOre("listAllseed", new ItemStack(seeds, 1, 1));

        OreDictionary.registerOre("seedBarley", new ItemStack(seeds, 1, 0));
        OreDictionary.registerOre("seedCotton", new ItemStack(seeds, 1, 1));

        OreDictionary.registerOre("cropBlightberry", new ItemStack(netherBerryItem, 1, 0));
        OreDictionary.registerOre("cropDuskberry", new ItemStack(netherBerryItem, 1, 1));
        OreDictionary.registerOre("cropSkyberry", new ItemStack(netherBerryItem, 1, 2));
        OreDictionary.registerOre("cropStingberry", new ItemStack(netherBerryItem, 1, 3));

        OreDictionary.registerOre("taintedSoil", new ItemStack(taintedSoil, 1));

        //Slabs
        if (PHNatura.enableSlabs)
        {
	        OreDictionary.registerOre("slabWood", new ItemStack(plankSlab1, 1, Short.MAX_VALUE));
	        OreDictionary.registerOre("slabWood", new ItemStack(plankSlab2, 1, Short.MAX_VALUE));
        }

        //Saplings
        OreDictionary.registerOre("treeSapling", new ItemStack(floraSapling, 1, Short.MAX_VALUE));
        OreDictionary.registerOre("treeSapling", new ItemStack(rareSapling, 1, Short.MAX_VALUE));
        OreDictionary.registerOre("treeSapling", new ItemStack(netherSapling, 1, Short.MAX_VALUE));

        //Leaves
        OreDictionary.registerOre("treeLeaves", new ItemStack(floraLeaves, 1, Short.MAX_VALUE));
        OreDictionary.registerOre("treeLeaves", new ItemStack(floraLeavesNoColor, 1, Short.MAX_VALUE));
        OreDictionary.registerOre("treeLeaves", new ItemStack(rareLeaves, 1, Short.MAX_VALUE));
        OreDictionary.registerOre("treeLeaves", new ItemStack(darkLeaves, 1, Short.MAX_VALUE));

        //Crafting table
        if (PHNatura.enableCraftingTables)
        {
        	OreDictionary.registerOre("crafterWood", new ItemStack(alternateWorkbench, 1, OreDictionary.WILDCARD_VALUE));
        	OreDictionary.registerOre("craftingTableWood", new ItemStack(alternateWorkbench, 1, OreDictionary.WILDCARD_VALUE));
        }

        //Planks
        OreDictionary.registerOre("plankWood", new ItemStack(NContent.planks, 1, OreDictionary.WILDCARD_VALUE));

        //Logs
        OreDictionary.registerOre("logWood", new ItemStack(NContent.tree, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("logWood", new ItemStack(NContent.darkTree, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("logWood", new ItemStack(NContent.rareTree, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("logWood", new ItemStack(NContent.bloodwood, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("logWood", new ItemStack(NContent.redwood, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("logWood", new ItemStack(NContent.willow, 1, OreDictionary.WILDCARD_VALUE));

        //Stairs
        if (PHNatura.enableStairs)
        {
	        OreDictionary.registerOre("stairWood", new ItemStack(NContent.stairEucalyptus, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("stairWood", new ItemStack(NContent.stairSakura, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("stairWood", new ItemStack(NContent.stairGhostwood, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("stairWood", new ItemStack(NContent.stairRedwood, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("stairWood", new ItemStack(NContent.stairBloodwood, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("stairWood", new ItemStack(NContent.stairHopseed, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("stairWood", new ItemStack(NContent.stairMaple, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("stairWood", new ItemStack(NContent.stairSilverbell, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("stairWood", new ItemStack(NContent.stairAmaranth, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("stairWood", new ItemStack(NContent.stairTiger, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("stairWood", new ItemStack(NContent.stairWillow, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("stairWood", new ItemStack(NContent.stairDarkwood, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("stairWood", new ItemStack(NContent.stairFusewood, 1, OreDictionary.WILDCARD_VALUE)); 
        }

        //Dye
        OreDictionary.registerOre("dyeBlue", new ItemStack(plantItem, 1, 8));

        //Glass
        OreDictionary.registerOre("glassSoul", new ItemStack(netherGlass, 1, 0));
        OreDictionary.registerOre("glass", new ItemStack(netherGlass, 1, 0));
        OreDictionary.registerOre("glass", new ItemStack(netherGlass, 1, 1));

        //Chest
        OreDictionary.registerOre("chestWood", new ItemStack(Blocks.chest));

        /* Pressure Plates */
        if (PHNatura.enablePressurePlates)
        {
        	OreDictionary.registerOre("pressurePlateWood", Blocks.wooden_pressure_plate);
	        OreDictionary.registerOre("pressurePlateWood", new ItemStack(NContent.pressurePlateEucalyptus, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("pressurePlateWood", new ItemStack(NContent.pressurePlateSakura, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("pressurePlateWood", new ItemStack(NContent.pressurePlateGhostwood, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("pressurePlateWood", new ItemStack(NContent.pressurePlateRedwood, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("pressurePlateWood", new ItemStack(NContent.pressurePlateBloodwood, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("pressurePlateWood", new ItemStack(NContent.pressurePlateHopseed, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("pressurePlateWood", new ItemStack(NContent.pressurePlateMaple, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("pressurePlateWood", new ItemStack(NContent.pressurePlateSilverbell, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("pressurePlateWood", new ItemStack(NContent.pressurePlateAmaranth, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("pressurePlateWood", new ItemStack(NContent.pressurePlateTiger, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("pressurePlateWood", new ItemStack(NContent.pressurePlateWillow, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("pressurePlateWood", new ItemStack(NContent.pressurePlateDarkwood, 1, OreDictionary.WILDCARD_VALUE));
	        OreDictionary.registerOre("pressurePlateWood", new ItemStack(NContent.pressurePlateFusewood, 1, OreDictionary.WILDCARD_VALUE)); 
        }

        /* Fences */
        if (PHNatura.enableFences)
        {
        	OreDictionary.registerOre("fenceWood", Blocks.fence);
	        OreDictionary.registerOre("fenceWood", new ItemStack(alternateFence, 1, OreDictionary.WILDCARD_VALUE));
        }

        /* Cloud, only the normal one */
    	OreDictionary.registerOre("cloud", new ItemStack(cloud, 1, 0)); /* Chisel */
    }

    public void createEntities ()
    {
        EntityRegistry.registerModEntity(ImpEntity.class, "Imp", 0, Natura.instance, 32, 5, true);
        EntityRegistry.registerModEntity(HeatscarSpider.class, "FlameSpider", 1, Natura.instance, 32, 5, true);
        EntityRegistry.registerModEntity(NitroCreeper.class, "NitroCreeper", 2, Natura.instance, 64, 5, true);
        EntityRegistry.registerModEntity(BabyHeatscarSpider.class, "FlameSpiderBaby", 4, Natura.instance, 32, 5, true);

        BiomeGenBase[] nether = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.NETHER);

		if (PHNatura.impSpawnRarity != 0)
		  EntityRegistry.addSpawn(ImpEntity.class, PHNatura.impSpawnRarity, 8, 12, EnumCreatureType.creature, nether);
		if (PHNatura.heatscarSpawnRarity != 0)
		  EntityRegistry.addSpawn(HeatscarSpider.class, PHNatura.heatscarSpawnRarity, 4, 4, EnumCreatureType.monster, nether);
		if (PHNatura.nitroCreeperSpawnRarity != 0)
		  EntityRegistry.addSpawn(NitroCreeper.class, PHNatura.nitroCreeperSpawnRarity, 4, 6, EnumCreatureType.monster, nether);
		if (PHNatura.babyHeatscarSpawnRarity != 0)
		  EntityRegistry.addSpawn(BabyHeatscarSpider.class, PHNatura.babyHeatscarSpawnRarity, 4, 4, EnumCreatureType.monster, nether);

        BlockDispenser.dispenseBehaviorRegistry.putObject(spawnEgg, new DispenserBehaviorSpawnEgg());
    }

    public static Item spawnEgg;

    //Crops
    public static Item wheatBag;
    public static Item barleyBag;
    public static Item potatoBag;
    public static Item carrotBag;
    public static Item netherWartBag;
    public static Item cottonBag;
    public static Item boneBag;

    public static Item seeds;
    public static Item plantItem;
    public static Item netherBerryItem;
    public static Item berryItem;
    public static Item berryMedley;
    public static Item seedFood;

    public static Item waterDrop;

    public static CropBlock crops;
    public static BerryBush berryBush;
    public static NetherBerryBush netherBerryBush;


    //Others
    public static Block cloud;

    //Trees
    public static Block tree;
    public static Block redwood;
    public static Block planks;
    public static Block bloodwood;
    public static Block willow;

    public static NLeaves floraLeaves;
    public static NLeaves floraLeavesNoColor;
    public static FloraSaplingBlock floraSapling;

    public static Block saguaro;

    public static Block redwoodDoor;
    public static Block eucalyptusDoor;
    public static Block hopseedDoor;
    public static Block sakuraDoor;
    public static Block ghostDoor;
    public static Block bloodDoor;
    public static Block redwoodBarkDoor;

    public static Item doorItem;

    //Nether
    public static Block taintedSoil;
    public static Block heatSand;
    //public static Block infernalStone;
    public static Glowshroom glowshroom;
    public static Block darkTree;
    public static NLeaves darkLeaves;
    public static Block thornVines;
    public static NetherSaplingBlock netherSapling;

    public static Block glowshroomBlue;
    public static Block glowshroomGreen;
    public static Block glowshroomPurple;

    public static Block brail;
    public static Block brailPowered;
    public static Block brailDetector;
    public static Block brailActivator;

    public static Block netherrackFurnace;
    public static Block respawnObelisk;
    public static NetherGlass netherGlass;
    public static BlazeHopper netherHopper;

    public static Item potashApple;
    public static Item impMeat;

    //Tools
    public static Item impHelmet;
    public static Item impJerkin;
    public static Item impLeggings;
    public static Item impBoots;

    public static Item flintAndBlaze;

    public static ItemStack impHelmetStack;
    public static ItemStack impJerkinStack;
    public static ItemStack impLeggingsStack;
    public static ItemStack impBootsStack;

    //Extra overworld
    public static Block rareTree;
    public static NLeaves rareLeaves;
    public static RareSaplingBlock rareSapling;
    public static FlowerBlock bluebells;

    public static Item bowlStew;

    //Vanilla overrides and alternates
    public static final String woodTextureNames[] = {"eucalyptus", "sakura", "ghostwood", "redwood", "bloodwood", "hopseed", "maple", "silverbell", "purpleheart", "tiger", "willow", "darkwood",
            "fusewood"};
    public static Block alternateWorkbench;
    public static Block alternateBookshelf;
    public static Block alternateFence;

    //Golem type things
    public static Block grassBlock;

    /* slabs */
    public static Block grassSlab;
    public static Block plankSlab1;
    public static Block plankSlab2;

    /* stairs */
    public static Block stairEucalyptus;
    public static Block stairSakura;
    public static Block stairGhostwood;
    public static Block stairRedwood;
    public static Block stairBloodwood;
    public static Block stairHopseed;
    public static Block stairMaple;
    public static Block stairSilverbell;
    public static Block stairAmaranth;
    public static Block stairTiger;
    public static Block stairWillow;
    public static Block stairDarkwood;
    public static Block stairFusewood;

    /* pressure plates */
    public static Block pressurePlateEucalyptus;
    public static Block pressurePlateSakura;
    public static Block pressurePlateGhostwood;
    public static Block pressurePlateRedwood;
    public static Block pressurePlateBloodwood;
    public static Block pressurePlateHopseed;
    public static Block pressurePlateMaple;
    public static Block pressurePlateAmaranth;
    public static Block pressurePlateSilverbell;
    public static Block pressurePlateTiger;
    public static Block pressurePlateWillow;
    public static Block pressurePlateDarkwood;
    public static Block pressurePlateFusewood; 

    /* Trapdoors */
    public static Block trapdoorEucalyptus;
    public static Block trapdoorSakura;
    public static Block trapdoorGhostwood;
    public static Block trapdoorRedwood;
    public static Block trapdoorBloodwood;
    public static Block trapdoorHopseed;
    public static Block trapdoorMaple;
    public static Block trapdoorAmaranth;
    public static Block trapdoorSilverbell;
    public static Block trapdoorTiger;
    public static Block trapdoorWillow;
    public static Block trapdoorDarkwood;
    public static Block trapdoorFusewood;
    
    /* Buttons */
    public static Block buttonEucalyptus;
    public static Block buttonSakura;
    public static Block buttonGhostwood;
    public static Block buttonRedwood;
    public static Block buttonBloodwood;
    public static Block buttonHopseed;
    public static Block buttonMaple;
    public static Block buttonAmaranth;
    public static Block buttonSilverbell;
    public static Block buttonTiger;
    public static Block buttonWillow;
    public static Block buttonDarkwood;
    public static Block buttonFusewood;

    /* Fence gates */
    public static Block fenceGateEucalyptus;
    public static Block fenceGateSakura;
    public static Block fenceGateGhostwood;
    public static Block fenceGateRedwood;
    public static Block fenceGateBloodwood;
    public static Block fenceGateHopseed;
    public static Block fenceGateMaple;
    public static Block fenceGateAmaranth;
    public static Block fenceGateSilverbell;
    public static Block fenceGateTiger;
    public static Block fenceGateWillow;
    public static Block fenceGateDarkwood;
    public static Block fenceGateFusewood;

    /* Barricades */
    public static Block vanillaBarricades[];
    public static Block vanillaBarricades2[];
    public static Block barricades[];
    public static Block plankBarricades[];

    private Block[] initBarricades (String prefix, String name[], Block block)
    {
        Block ret[] = new Block[name.length];
        for (int i = 0; i < name.length; i++)
        {
        	ret[i] = new BarricadeBlock(block, i).setBlockName("barricade");
        	GameRegistry.registerBlock(ret[i], BarricadeItem.class, "barricade." + prefix + "." + name[i]);
        }
        return ret;
    }
    private void recipeBarricades (Block out[], Block in)
    {
    	for (int i = 0; i < out.length; i++)
    		GameRegistry.addRecipe(new ItemStack(out[i], 1, 0), "b", "b", 'b', new ItemStack(in, 1, i));
    }

    @Override
    public int getBurnTime (ItemStack fuel)
    {
    	if (fuel.getItem() == new ItemStack(floraSapling).getItem()
    		|| fuel.getItem() == new ItemStack(rareSapling).getItem()
    		|| fuel.getItem() == new ItemStack(netherSapling).getItem())
    		return 100;
        return 0;
    }
}
