package com.icraftgames.jnbt;

public final class EndTag extends Tag{
	/**
	 * Creates the tag.
	 */
	public EndTag() {
		super("");
	}

	@Override
	public Object getValue() {
		return null;
	}
	
	@Override
	public String toString() {
		return "TAG_End";
	}
}
