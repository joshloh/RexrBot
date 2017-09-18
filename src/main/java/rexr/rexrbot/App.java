package rexr.rexrbot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class App extends ListenerAdapter
{
	public static void main(String[] args) throws LoginException, IllegalArgumentException, RateLimitedException
	{
		JDA api = new JDABuilder(AccountType.BOT)
				.setToken(BotToken.getToken()).buildAsync();
		api.addEventListener(new App());
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent e)
	{
		Message message = e.getMessage();
		MessageChannel channel = e.getChannel();
		User user = e.getAuthor();

		// Do not respond to messages from other bots, including ourself
		if (user.isBot())
			return;
		
		// Parse the command
		
		channel.sendMessage("Hello, " + user.getAsMention() + ", you said: " + message.getContent()).queue();
	}
}
