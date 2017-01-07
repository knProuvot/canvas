package com.canvas.command;

import java.io.BufferedReader;
import java.io.IOException;

import com.canvas.command.model.BucketFillCommand;
import com.canvas.command.model.CreateCanvasCommand;
import com.canvas.command.model.CreateLineCommand;
import com.canvas.command.model.CreateRectangleCommand;
import com.canvas.command.model.ICommand;
import com.canvas.command.model.InvalidCommand;
import com.canvas.command.model.QuitCommand;

/**
 * Command interpretor will deduce what command to create depending on the
 * syntax
 * 
 */
public class CommandInterpretor {

	private BufferedReader input;
	private String inputLine;

	protected static final String CANVAS_COMMAND = "C";
	protected static final String LINE_COMMAND = "L";
	protected static final String RECTANGE_COMMAND = "R";
	protected static final String BUCKET_FILL_COMMAND = "B";
	protected static final String QUIT_COMMAND = "Q";

	public CommandInterpretor(BufferedReader bufferedReader) {
		this.input = bufferedReader;
	}

	public ICommand interpret() {
		// TODO Create a separate class for the reader
		inputLine = readInput();
		return interpretCommand();
	}

	protected ICommand interpretCommand() {
		String commandLine = prepareCommandLine(inputLine);
		ICommand command = createICommand(commandLine);
		command = checkCommandValidity(command);
		return command;
	}

	private String readInput() {
		try {
			return input.readLine();
		} catch (IOException e) {
			// TODO LOGGING ERROR
			return "";
		}
	}

	private String prepareCommandLine(String inputLine) {
		return inputLine.trim();
	}

	private ICommand createICommand(String commandLine) {
		ICommand command;

		String firstLetter = commandLine.substring(0, 1);

		switch (firstLetter) {
		case (CANVAS_COMMAND):
			command = new CreateCanvasCommand();
			break;
		case (LINE_COMMAND):
			command = new CreateLineCommand();
			break;
		case (RECTANGE_COMMAND):
			command = new CreateRectangleCommand();
			break;
		case (BUCKET_FILL_COMMAND):
			command = new BucketFillCommand();
			break;
		case (QUIT_COMMAND):
			command = new QuitCommand();
			break;
		default:
			command = new InvalidCommand();
			break;
		}

		return command;
	}

	private ICommand checkCommandValidity(ICommand command) {
		return null;
	}

	// TEST METHODS

	protected void setInputLine(String line) {
		this.inputLine = line;
	}
}
