package Commands;

import Music.PlayerManager;
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
			
			AudioManager audioManager = event.getGuild().getAudioManager();
			audioManager.openAudioConnection(event.getGuild().getVoiceChannelById("600895445648277518"));
			
			PlayerManager manager = PlayerManager.getInstance();
			manager.loadAndPlay(event.getChannel(), "https://www.youtube.com/watch?v=jQIzb72IATU");
			manager.getGuildMusicManager(event.getGuild()).player.setVolume(10);
		}
	}
}
