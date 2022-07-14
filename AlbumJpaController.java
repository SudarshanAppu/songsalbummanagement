package com.in28minutes.springboot.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.model.SongsDetails;
import com.in28minutes.springboot.web.repository.SongsRepository;
import com.in28minutes.springboot.web.service.SongsService;


@Controller
@SessionAttributes("name")

public class AlbumJpaController {
		
		private SongsService songsrervice;
		private SongsRepository songsrepository;


		//@Autowired
	
	public AlbumJpaController(
        SongsService songsservice,
		SongsRepository songsrepository){
		super();
		this.songsrervice=songsservice;
		this.songsrepository=songsrepository;
		
		
	}
		
		@RequestMapping(value="/list-todos2", method = RequestMethod.GET)
		public String showSongs(ModelMap model){
			String name = (String) model.get("name");
			
			List<SongsDetails> sng =  songsrepository.findAll();
			//List<SongsDetails> arrayList=new ArrayList<>();
			System.out.println("name is :"+name);
			System.out.println("list is :"+sng);
			
			model.put("todos", sng);
			
			return "list-todos2";
		}
		
		@RequestMapping(value="/add-todo", method=RequestMethod.GET)
		public String newSongs(ModelMap model) {
					return "/todo2";
		}
		
		
		
		@RequestMapping(value="/add-todo", method=RequestMethod.POST)
		public String AddSongs(@RequestParam int id,@RequestParam String songtitle, @RequestParam String childfav, @RequestParam String artist, @RequestParam String datetime, @RequestParam float duration,ModelMap model) {
			System.out.println("/n"+"song title is :"+songtitle);
			SongsDetails sngdetails = new SongsDetails(id,songtitle, childfav, artist, datetime, duration);
			songsrepository.save(sngdetails);
			//songsrervice.addsongs(songtitle, childfav, artist, datetime, duration);
					return "redirect:/list-todos2";
		}
		@RequestMapping("/delete-todo")
		public String deletesong(@RequestParam int id) {
			songsrepository.deleteById(id);
			return "redirect:/list-todos2";
		}
		
		@RequestMapping(value="/update-todo", method=RequestMethod.GET)
		public String showupdatesong(@RequestParam int id,ModelMap model) {
			
			SongsDetails details =songsrepository.findById(id).get();
			//SongsDetails details =songsrervice.updatesong(songstitle);
			model.addAttribute("todo2songs",details);
			return "todo3";
		}
		
		
		@RequestMapping(value="/update-todo", method=RequestMethod.POST)
		public String updateSongs(@RequestParam int id,@RequestParam String songtitle, @RequestParam String childfav, @RequestParam String artist, @RequestParam String datetime, @RequestParam float duration,ModelMap model) {
			System.out.println("/n"+"song title is :"+songtitle);
			
			SongsDetails sngdetails = new SongsDetails(id,songtitle, childfav, artist, datetime, duration);
			songsrepository.deleteById(id);

			songsrepository.save(sngdetails);
			//songsrervice.addUpdateSongs(songtitle, childfav, artist, datetime, duration);
					return "redirect:/list-todos2";
		}

}
