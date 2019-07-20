package Commands;

import java.net.MalformedURLException;
import java.net.URL;

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
			
			
			
			if(args.length == 1) {
				
				event.getChannel().sendMessage("Hey, you didn't provide me any URL!").queue();
			}
			else if(args.length >= 2) {
				
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
	
	
}
