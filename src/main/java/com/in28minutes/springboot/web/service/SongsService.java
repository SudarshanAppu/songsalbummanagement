package com.in28minutes.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.in28minutes.springboot.web.model.SongsDetails;


@Service
public class SongsService {

	    
	    private static List<SongsDetails> songs =new ArrayList<SongsDetails>();
	    private int songscount=5;

	  static {

		  for(int i=1; i<6;i++) {
		 // songs.add(new SongsDetails(1,"songtitle "+i,"no","artist "+i,"2022-06-06",3.7f));
	  }
	  }	
	  
	  
	  
	    public List<SongsDetails> retrievesongs1() {
	        List<SongsDetails> songsList = new ArrayList<SongsDetails>();
	        for (SongsDetails sng : songs) {
	               songsList.add(sng);
	        }
	        return songs;
	    }
	    

	    public void addsongs(String title, String childfav, String artist, String datetime, float duration)
	    {
	    	//songs.add(new SongsDetails(1,title,childfav,artist,datetime,duration));
	    }

	    public void deletesong(String songstitle) {
	    	Predicate<? super SongsDetails> predicate = sng->sng.getSongsTitle().equals(songstitle);
	    	
	    	songs.removeIf(predicate);
	    	System.out.println(" list of songs: "+songs);
	    }
	    
	    public SongsDetails updatesong(String songstitle) {
	    	Predicate<? super SongsDetails> predicate = sng->sng.getSongsTitle().equals(songstitle);
	    		    	//songs.removeIf(predicate);
	    	SongsDetails songsdetails =songs.stream().filter(predicate).findFirst().get();
	    	System.out.println(" the song details are :"+songsdetails);
	    	return songsdetails;
	    	
	    }
	    
	    public void addUpdateSongs(String title, String childfav, String artist, String datetime, float duration)
	    {
	    	/*deletesong(title);
            Predicate<? super SongsDetails> predicate = sng->sng.getSongsTitle().equals(title);
	    	
	    	songs.removeIf(predicate);
	    	System.out.println(" list of songs: "+songs);*/
	    //	songs.add(new SongsDetails(1,title,childfav,artist,datetime,duration));
	    }


	  
}
