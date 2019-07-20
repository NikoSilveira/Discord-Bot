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
		
		//Play music
		if(args[0].equalsIgnoreCase(Main.prefix + "play")) {
			
			String trackURL = args[1];
			
			AudioManager audioManager = event.getGuild().getAudioManager();
			audioManager.openAudioConnection(event.getGuild().getVoiceChannelById("600895445648277518"));	//TODO autoselect vc
			
			PlayerManager manager = PlayerManager.getInstance();
			manager.loadAndPlay(event.getChannel(), trackURL);
			manager.getGuildMusicManager(event.getGuild()).player.setVolume(13);
			
			event.getMessage().delete().queue();
		}
	}
}
