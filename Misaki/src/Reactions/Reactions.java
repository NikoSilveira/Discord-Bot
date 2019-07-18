package Reactions;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Reactions extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		//event.getMessage().addReaction("❌").queue();
		
	}
}
