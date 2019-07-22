package Commands;

import java.net.MalformedURLException;
import java.net.URL;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackInfo;

import Music.GuildMusicManager;
import Music.PlayerManager;
import Music.TrackScheduler;
import Outfasted.Misaki.Main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.AudioManager;

public class MusicCommands extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		AudioManager audioManager = event.getGuild().getAudioManager();
		
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
					
					if(audioManager.getConnectedChannel() == null) {	//only open if not connected to vc
						
						if(event.getMember().getVoiceState().getChannel() != null) {
							audioManager.openAudioConnection(event.getMember().getVoiceState().getChannel());	//join the vc where the user is
						}
						else if(event.getMember().getVoiceState().getChannel() == null) {
							event.getChannel().sendMessage("You are not in VC. Join a channel first and then ask me to join").queue();
						}
						
					}
					
					PlayerManager playerManager = PlayerManager.getInstance();
					playerManager.loadAndPlay(event.getChannel(), trackURL);
					playerManager.getGuildMusicManager(event.getGuild()).player.setVolume(65);
					
					event.getMessage().delete().queue();
				} 
				
				else if(!isURL(args[1])) {	//invalid argument
					event.getChannel().sendMessage("That is not an URL, baka").queue();
				}
				
			}
			
		}
		
		//Stop music
		else if(args[0].equalsIgnoreCase(Main.prefix + "stop") || args[0].equalsIgnoreCase(Main.prefix + "shoo")) {
			
			PlayerManager playerManager = PlayerManager.getInstance();
			GuildMusicManager musicManager = playerManager.getGuildMusicManager(event.getGuild());
			
			if(musicManager.scheduler.getQueue().isEmpty() && musicManager.player.getPlayingTrack() == null) {	//user tries to stop in empty queue
				event.getChannel().sendMessage("No music enqueued or playing").queue();
				return;
			}
			
			musicManager.scheduler.getQueue().clear();
			musicManager.player.stopTrack();
			musicManager.player.setPaused(false);
			audioManager.closeAudioConnection();
			
			event.getMessage().delete().queue();	//delete command
			
			//Embed
			EmbedBuilder stopEmbed = new EmbedBuilder();
			stopEmbed.setTitle("\u23F9 Music stopped. I have cleared the queue");
			stopEmbed.setColor(0xe8c205);
			stopEmbed.setFooter("Stopped by: " + event.getMember().getUser().getName(), event.getMember().getUser().getAvatarUrl());
			event.getChannel().sendMessage(stopEmbed.build()).queue();
			
			stopEmbed.clear();
		}
		
		//Skip song
		else if(args[0].equalsIgnoreCase(Main.prefix + "skip")) {
			
			PlayerManager playerManager = PlayerManager.getInstance();
			GuildMusicManager musicManager = playerManager.getGuildMusicManager(event.getGuild());
			TrackScheduler scheduler = musicManager.scheduler;
			AudioPlayer player = musicManager.player;
			
			if(player.getPlayingTrack() == null) {	//User tries to skip in empty queue
				event.getChannel().sendMessage("No songs playing right now").queue();
				return;
			}
			
			event.getMessage().delete().queue();	//delete command
			scheduler.nextTrack();
			
			//Embed
			EmbedBuilder skipEmbed = new EmbedBuilder();
			skipEmbed.setTitle("\u23E9 Skipping the current track");
			skipEmbed.setColor(0xe8c205);
			skipEmbed.setFooter("Skipped by: " + event.getMember().getUser().getName(), event.getMember().getUser().getAvatarUrl());
			event.getChannel().sendMessage(skipEmbed.build()).queue();
			
			skipEmbed.clear();
			
			if(player.getPlayingTrack() == null) {	//Skipped the last song
				audioManager.closeAudioConnection();
				event.getChannel().sendMessage("No more songs in queue, bye ⭐").queue();
			}
		}
		
		//Now playing
		else if(args[0].equalsIgnoreCase(Main.prefix + "now")) {
			
			PlayerManager playerManager = PlayerManager.getInstance();
			GuildMusicManager musicManager = playerManager.getGuildMusicManager(event.getGuild());
			AudioPlayer player = musicManager.player;
			
			if(player.getPlayingTrack() == null) {	//Empty queue
				event.getChannel().sendMessage("No songs playing right now").queue();
				return;
			}
			
			AudioTrackInfo info = player.getPlayingTrack().getInfo();
			
			
			event.getMessage().delete().queue();	//delete command
			
			//Embed
			EmbedBuilder nowEmbed = new EmbedBuilder();
			nowEmbed.setTitle("\u25B6 Now playing:");
			nowEmbed.addField("","" + info.title,true);
			nowEmbed.setColor(0xe8c205);
			event.getChannel().sendMessage(nowEmbed.build()).queue();
			
			nowEmbed.clear();
		}
		
		//Move
		
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
