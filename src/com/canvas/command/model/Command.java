package com.canvas.command.model;

public class Command {
	
	protected String commandLine;
	
	protected Command(String commandLine) {
		this.commandLine = commandLine;
	}
	
	public String getCommandLine() {
		return this.commandLine;
	}

}
