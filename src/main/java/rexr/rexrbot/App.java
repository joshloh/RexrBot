package rexr.rexrbot;

import java.util.StringTokenizer;

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
		JDA api = new JDABuilder(AccountType.BOT).setToken(BotToken.getToken()).buildAsync();
		api.addEventListener(new App());
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent e)
	{
		// Do not respond to messages from other bots, including ourself
		if (e.getAuthor().isBot())
			return;

		Parser parser = new Parser(e);
		if (parser.validate())
		{
			parser.execute();
		}
	}
}
