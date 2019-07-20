package Commands;

import Outfasted.Misaki.Main;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.AudioManager;

public class MusicCommands extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		//No response to other bots
		if (event.getAuthor().isBot()) {
			return;
		}
		
		if(args[0].equalsIgnoreCase(Main.prefix + "music")) {
			//event.getGuild().getVoiceChannelsByName("General",true);
			AudioManager audioManager = event.getGuild().getAudioManager();
			audioManager.openAudioConnection(event.getGuild().getVoiceChannelById("600895445648277518"));
		}
	}
}
