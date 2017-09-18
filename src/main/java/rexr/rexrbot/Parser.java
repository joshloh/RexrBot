package rexr.rexrbot;

import java.util.StringTokenizer;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Parser
{
	// Variables
	private StringTokenizer st;
	private Message message;
	private User user;
	private MessageChannel channel;

	// Helper functions

	private void send(String msg)
	{
		channel.sendMessage(msg).queue();
	}

	// Functions

	public Parser(MessageReceivedEvent e)
	{
		message = e.getMessage();
		user = e.getAuthor();
		channel = e.getChannel();
		st = new StringTokenizer(message.getContent());
	}

	public boolean validate()
	{
		return st.nextToken().equals(Global.prefix);
	}

	public void execute()
	{
		if (!st.hasMoreTokens())
		{
			send("invalid command invoked");
			return;
		}
		String command = st.nextToken();
		switch (command)
		{
			case "add":
			{
				// TODO: call the add command with the rest of the tokens
				send("`add` command invoked");
				break;
			}
			case "summary":
			{
				// TODO: call the summary command with the rest of the tokens
				send("summary command invoked");
				break;
			}
			case "help":
			{
				// TODO: call the help command
				send("help command invoked");
				break;
			}
			default:
			{
				// TODO: call invalid command
				send("invalid command invoked");
			}
		}
	}
}