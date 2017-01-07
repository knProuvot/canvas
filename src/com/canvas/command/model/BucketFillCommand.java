package com.canvas.command.model;

public class BucketFillCommand extends Command {

	private int x;
	private int y;
	private char color;

	public BucketFillCommand(String commandLine) {
		super(commandLine);
		String[] instruction = commandLine.split(" ");

		this.x = Integer.valueOf(instruction[1]);
		this.y = Integer.valueOf(instruction[2]);
		this.color = instruction[3].charAt(0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getColor() {
		return color;
	}

}
