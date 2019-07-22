package Commands;

import java.net.MalformedURLException;
import java.net.URL;

import Music.GuildMusicManager;
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
			
			//User only provides command with no args
			if(args.length == 1) {	
				
				event.getChannel().sendMessage("Hey, you didn't provide me any URL!").queue();
				
			}
			
			//User provides command with args
			else if(args.length >= 2) {	
				
				String trackURL = args[1];
				
				if(isURL(args[1])) {		//valid argument: URL
					
					AudioManager audioManager = event.getGuild().getAudioManager();
					audioManager.openAudioConnection(event.getGuild().getVoiceChannelById("600895445648277518"));	//TODO autoselect vc
					
					PlayerManager manager = PlayerManager.getInstance();
					manager.loadAndPlay(event.getChannel(), trackURL);
					manager.getGuildMusicManager(event.getGuild()).player.setVolume(18);
					
					event.getMessage().delete().queue();
				} 
				
				else if(!isURL(args[1])) {	//invalid argument
					event.getChannel().sendMessage("That is not an URL, baka").queue();
				}
				
			}
			
		}
		
		//Stop music
		if(args[0].equalsIgnoreCase(Main.prefix + "stop")) {
			
			PlayerManager playerManager = PlayerManager.getInstance();
			GuildMusicManager musicManager = playerManager.getGuildMusicManager(event.getGuild());
			
			musicManager.scheduler.getQueue().clear();
			musicManager.player.stopTrack();
			musicManager.player.setPaused(false);
			
			event.getChannel().sendMessage("Stopping and clearing queue...").queue();
		}

	}
	

	
	//Validate if argument is URL
	private boolean isURL(String input) {
		try {
			new URL (input);
			return true;
			
		} catch (MalformedURLException ignored){
			return false;
		}
	}
	
	
}
