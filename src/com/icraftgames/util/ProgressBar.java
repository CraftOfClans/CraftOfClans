package com.icraftgames.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class ProgressBar {
	Block cornerOne;
	Block cornerTwo;
	Block end;
	
	Material full;
	Material empty;
	
	int fullMaterialDataValue = -1;
	int emptyMaterialDataValue = -1;
	
	//Note: the following must be a number from 0 to 1 -- 0 is empty, 1 is full.
	float percentFilled;
	
	List<List<Block>> blockList = new ArrayList<List<Block>>();
	
	public String name;
	
	/**
	 * 
	 * Constructor for the ProgressBar object.
	 * 
	 * @param barName
	 * Name of the progress bar. Use null if you don't need a name.
	 * 
	 * @param cornerOne
	 * One corner of the first chunk.
	 * 
	 * @param cornerTwo
	 * Opposite corner of the first chunk. Must share a plane with the first corner.
	 * 
	 * @param end
	 * Location somewhere on the end chunk of the progress bar.
	 * 
	 * @param fullMaterial
	 * Material that will be used as the filled texture.
	 * 
	 * @param emptyMaterial
	 * Material that will be used as the empty texture.
	 */
	
	public ProgressBar (String barName, Block cornerOne, Block cornerTwo, Block end, Material fullMaterial, Material emptyMaterial) {
		init (barName, cornerOne, cornerTwo, end, fullMaterial, emptyMaterial);
	}
	
	/**
	 * 
	 * Constructor for the ProgressBar object.
	 * 
	 * @param barName
	 * Name of the progress bar. Use null if you don't need a name.
	 * 
	 * @param cornerOne
	 * One corner of the first chunk.
	 * 
	 * @param cornerTwo
	 * Opposite corner of the first chunk. Must share a plane with the first corner.
	 * 
	 * @param end
	 * Location somewhere on the end chunk of the progress bar.
	 * 
	 * @param fullMaterial
	 * Material that will be used as the filled texture.
	 * 
	 * @param fullMaterialColor
	 * BlockColor enum for the full material. Use this to set the color of colored blocks such as wool or stained glass.
	 * 
	 * @param emptyMaterial
	 * Material that will be used as the empty texture.
	 * 
	 * @param emptyMaterialColor
	 * BlockColor enum for the empty material. Use this to set the color of colored blocks such as wool or stained glass.
	 */
	public ProgressBar (String barName, Block cornerOne, Block cornerTwo, Block end, Material fullMaterial, BlockColor fullMaterialColor, Material emptyMaterial, BlockColor emptyMaterialColor) {
		setFullColor (fullMaterialColor);
		setEmptyColor (emptyMaterialColor);
		init (barName, cornerOne, cornerTwo, end, fullMaterial, emptyMaterial);
	}
	
	/**
	 * 
	 * Constructor for the ProgressBar object.
	 * 
	 * @param barName
	 * Name of the progress bar. Use null if you don't need a name.
	 * 
	 * @param cornerOne
	 * One corner of the first chunk.
	 * 
	 * @param cornerTwo
	 * Opposite corner of the first chunk. Must share a plane with the first corner.
	 * 
	 * @param end
	 * Location somewhere on the end chunk of the progress bar.
	 * 
	 * @param fullMaterial
	 * Material that will be used as the filled texture.
	 * 
	 * @param fullMaterialColor
	 * BlockColor enum for the full material. Use this to set the color of colored blocks such as wool or stained glass.
	 * 
	 * @param emptyMaterial
	 * Material that will be used as the empty texture.
	 * 
	 */
	public ProgressBar (String barName, Block cornerOne, Block cornerTwo, Block end, Material fullMaterial, BlockColor fullMaterialColor, Material emptyMaterial) {
		setFullColor (fullMaterialColor);
		init (barName, cornerOne, cornerTwo, end, fullMaterial, emptyMaterial);
	}
	
	/**
	 * 
	 * Constructor for the ProgressBar object.
	 * 
	 * @param barName
	 * Name of the progress bar. Use null if you don't need a name.
	 * 
	 * @param cornerOne
	 * One corner of the first chunk.
	 * 
	 * @param cornerTwo
	 * Opposite corner of the first chunk. Must share a plane with the first corner.
	 * 
	 * @param end
	 * Location somewhere on the end chunk of the progress bar.
	 * 
	 * @param fullMaterial
	 * Material that will be used as the filled texture.
	 * 
	 * @param emptyMaterial
	 * Material that will be used as the empty texture.
	 * 
	 * @param emptyMaterialColor
	 * BlockColor enum for the empty material. Use this to set the color of colored blocks such as wool or stained glass.
	 */
	public ProgressBar (String barName, Block cornerOne, Block cornerTwo, Block end, Material fullMaterial, Material emptyMaterial, BlockColor emptyMaterialColor) {
		setEmptyColor (emptyMaterialColor);
		init (barName, cornerOne, cornerTwo, end, fullMaterial, emptyMaterial);
	}
	
	/**
	 * 
	 * Constructor for the ProgressBar object.
	 * 
	 * @param barName
	 * Name of the progress bar. Use null if you don't need a name.
	 * 
	 * @param cornerOne
	 * One corner of the first chunk.
	 * 
	 * @param cornerTwo
	 * Opposite corner of the first chunk. Must share a plane with the first corner.
	 * 
	 * @param end
	 * Location somewhere on the end chunk of the progress bar.
	 * 
	 * @param fullMaterial
	 * Material that will be used as the filled texture.
	 * 
	 * @param emptyMaterial
	 * Material that will be used as the empty texture.
	 * 
	 * @param emptyData
	 * Data value for the empty texture.
	 */
	public ProgressBar (String barName, Block cornerOne, Block cornerTwo, Block end, Material fullMaterial, Material emptyMaterial, byte emptyData) {
		this.emptyMaterialDataValue = emptyData;
		init (barName, cornerOne, cornerTwo, end, fullMaterial, emptyMaterial);
	}
	
	/**
	 * 
	 * Constructor for the ProgressBar object.
	 * 
	 * @param barName
	 * Name of the progress bar. Use null if you don't need a name.
	 * 
	 * @param cornerOne
	 * One corner of the first chunk.
	 * 
	 * @param cornerTwo
	 * Opposite corner of the first chunk. Must share a plane with the first corner.
	 * 
	 * @param end
	 * Location somewhere on the end chunk of the progress bar.
	 * 
	 * @param fullMaterial
	 * Material that will be used as the filled texture.
	 * 
	 * @param fullData
	 * Data value for the full texture
	 * 
	 * @param emptyMaterial
	 * Material that will be used as the empty texture.
	 * 
	 */
	public ProgressBar (String barName, Block cornerOne, Block cornerTwo, Block end, Material fullMaterial, byte fullData, Material emptyMaterial) {
		this.fullMaterialDataValue = fullData;
		init (barName, cornerOne, cornerTwo, end, fullMaterial, emptyMaterial);
	}
	
	/**
	 * 
	 * Constructor for the ProgressBar object.
	 * 
	 * @param barName
	 * Name of the progress bar. Use null if you don't need a name.
	 * 
	 * @param cornerOne
	 * One corner of the first chunk.
	 * 
	 * @param cornerTwo
	 * Opposite corner of the first chunk. Must share a plane with the first corner.
	 * 
	 * @param end
	 * Location somewhere on the end chunk of the progress bar.
	 * 
	 * @param fullMaterial
	 * Material that will be used as the filled texture.
	 * 
	 * @param fullData
	 * Data value for the full texture
	 * 
	 * @param emptyMaterial
	 * Material that will be used as the empty texture.
	 * 
	 * @param emptyData
	 * Data value for the empty texture.
	 */
	public ProgressBar (String barName, Block cornerOne, Block cornerTwo, Block end, Material fullMaterial, byte fullData, Material emptyMaterial, byte emptyData) {
		this.emptyMaterialDataValue = emptyData;
		this.fullMaterialDataValue = fullData;
		init (barName, cornerOne, cornerTwo, end, fullMaterial, emptyMaterial);
	}
	
	private void init (String barName, Block cornerOne, Block cornerTwo, Block end, Material fullMaterial, Material emptyMaterial) {
		this.name = barName;
		
		this.cornerOne = cornerOne;
		this.cornerTwo = cornerTwo;
		this.end = end;
		
		this.full = fullMaterial;
		this.empty = emptyMaterial;
		
		end.setType(Material.IRON_BLOCK);
		
		int xDist = 0;
		int yDist = 0;
		int zDist = 0;
		
		int xMove = 0;
		int yMove = 0;
		int zMove = 0;
		
		int dist = 0;
		
		if (cornerOne.getX() == cornerTwo.getX()) {
			xDist = end.getX() - cornerOne.getX();
			dist = xDist;
			if (cornerOne.getX() <= end.getX()) {
				xMove = 1;
			} else {
				xMove = -1;
			}
		} else if (cornerOne.getY() == cornerTwo.getY()) {
			yDist = end.getY() - cornerOne.getY();
			dist = yDist;
			if (cornerOne.getY() <= end.getY()) {
				yMove = 1;
			} else {
				yMove = -1;
			}
		} else if (cornerOne.getZ() == cornerTwo.getZ()) {
			zDist = end.getZ() - cornerOne.getZ();
			dist = zDist;
			if (cornerOne.getZ() <= end.getZ()) {
				zMove = 1;
			} else {
				zMove = -1;
			}
		} else {
			throw new IllegalArgumentException("The blocks corrisponding to cornerOne and cornerTwo must share a plane");
		}
		
		System.out.println(dist);
		
		Block cornerOneClone = cornerOne;
		Block cornerTwoClone = cornerTwo;
		
		for (int i = 1; i <= Math.abs(dist); i++) {
			System.out.println("Calculating cluster for " + cornerOneClone.getX() + ", " + cornerOneClone.getY() + ", " + cornerOneClone.getZ() + " and " + cornerTwoClone.getX() + ", " + cornerTwoClone.getY() + ", " + cornerTwoClone.getZ() + ".");
			List<Block> list = calculateCluster(cornerOneClone, cornerTwoClone);
			blockList.add(list);
			
			System.out.println("Moving... (" + xMove + ", " + yMove + ", " + zMove + ")");
			cornerOneClone = cornerOneClone.getRelative(xMove, yMove, zMove);
			cornerTwoClone = cornerTwoClone.getRelative(xMove, yMove, zMove);
		}
		
		System.out.println("Final cluster calculation...");
		List<Block> list = calculateCluster(cornerOneClone, cornerTwoClone);
		blockList.add(list);
		
		percentFilled = 0;
		
		update();
	}

	private void setFullColor (BlockColor color) {
		this.fullMaterialDataValue = getBlockColorDataValue (color);
	}
	
	private void setEmptyColor (BlockColor color) {
		this.emptyMaterialDataValue = getBlockColorDataValue (color);
	}
	
	// Note: this will return -1 if it fails, which I don't think it can.
	public static int getBlockColorDataValue (BlockColor color) {
		switch (color) {
			case WHITE:
				return 0;
			
			case ORANGE:
				return 1;
				
			case MAGENTA:
				return 2;
			
			case LIGHT_BLUE:
				return 3;
				
			case YELLOW:
				return 4;
			
			case LIME:
				return 5;
				
			case PINK:
				return 6;
			
			case GRAY:
				return 7;
				
			case LIGHT_GRAY:
				return 8;
				
			case CYAN:
				return 9;
				
			case PURPLE:
				return 10;
				
			case BLUE:
				return 11;
				
			case BROWN:
				return 12;
				
			case GREEN:
				return 13;
				
			case RED:
				return 14;
				
			case BLACK:
				return 15;
		}	
		return -1;
	}
	
	public static BlockColor getBlockColorFromDataValue (int data) {
		switch (data) {
			case 0:
				return BlockColor.WHITE;
			
			case 1:
				return BlockColor.ORANGE;
				
			case 2:
				return BlockColor.MAGENTA;
			
			case 3:
				return BlockColor.LIGHT_BLUE;
				
			case 4:
				return BlockColor.YELLOW;
			
			case 5:
				return BlockColor.LIME;
				
			case 6:
				return BlockColor.PINK;
			
			case 7:
				return BlockColor.GRAY;
				
			case 8:
				return BlockColor.LIGHT_GRAY;
				
			case 9:
				return BlockColor.CYAN;
				
			case 10:
				return BlockColor.PURPLE;
				
			case 11:
				return BlockColor.BLUE;
				
			case 12:
				return BlockColor.BROWN;
				
			case 13:
				return BlockColor.GREEN;
				
			case 14:
				return BlockColor.RED;
				
			case 15:
				return BlockColor.BLACK;
		}	
		return null;
	}
	
	private static List<Block> calculateCluster (Block cornerOne, Block cornerTwo) {
		List<Block> blockList = new ArrayList<Block>();
		
		// if they are the same block
		if (cornerOne.equals(cornerTwo)) {
			blockList.add(cornerOne);
			return blockList;
		}
		
		int minX = (int) Math.min(cornerOne.getX(), cornerTwo.getX());
		int minY = (int) Math.min(cornerOne.getY(), cornerTwo.getY());
		int minZ = (int) Math.min(cornerOne.getZ(), cornerTwo.getZ());
		
		int maxX = (int) Math.max(cornerOne.getX(), cornerTwo.getX());
		int maxY = (int) Math.max(cornerOne.getY(), cornerTwo.getY());
		int maxZ = (int) Math.max(cornerOne.getZ(), cornerTwo.getZ());
		
		
		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				for (int z = minZ; z <= maxZ; z++) {
					Block b = new Location(cornerOne.getWorld(), x, y, z).getBlock();
					if (!(blockList.contains(b))) {
						blockList.add(b);
					}
				}
			}
		}
		
		return blockList;
	}
	
	/**
	 * Sets the bar based on a percentage.
	 * @param percentage
	 * Percent full. Must be between 0 and 100.
	 */
	public void setPercentage (float percentage) {
		percentFilled = (percentage / 100);
		update();
	}
	
	@SuppressWarnings("deprecation")
	private void update () {
		for (List<Block> list : blockList) {
			//TODO: The following conversion will cause a bit of data loss in the case of long numbers. May be worth fixing.
			int numberFilled = Math.round(percentFilled * blockList.size());
			
			if ((blockList.indexOf(list) + 1) <= numberFilled) {
				for (Block b : list) {
					b.setType(full);
					if (!(this.fullMaterialDataValue == -1)) {
						b.setData((byte) fullMaterialDataValue);
					}
				}
			} else {
				for (Block b : list) {
					b.setType(empty);
					if (!(this.emptyMaterialDataValue == -1)) {
						b.setData((byte) emptyMaterialDataValue);
					}
				}
			}
		}
	}
	
	/**
	 * Sets the blocks that the progress bar has stored to air.
	 */
	public void clear () {
		for (List<Block> list : blockList) {
			for (Block b : list) {
				b.setType(Material.AIR);
			}
		}
	}
	
	public void clearSection (int index) {
		for (Block b : blockList.get(index)) {
			b.setType(Material.AIR);
		}
	}
	
	public static enum BlockColor {
		WHITE, ORANGE, MAGENTA, LIGHT_BLUE, YELLOW, LIME, PINK, GRAY, LIGHT_GRAY, CYAN, PURPLE, BLUE, BROWN, GREEN, RED, BLACK
	}
	
}