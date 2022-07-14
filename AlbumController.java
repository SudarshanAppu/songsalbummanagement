package com.in28minutes.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.model.SongsDetails;
import com.in28minutes.springboot.web.service.SongsService;

//@Controller
@SessionAttributes("name")

public class AlbumController {
		
		@Autowired
        SongsService songsservice;
		
		
		@RequestMapping(value="/list-todos2", method = RequestMethod.GET)
		public String showSongs(ModelMap model){
			String name = (String) model.get("name");
			System.out.println("name is :"+name);
			System.out.println("list is :"+songsservice.retrievesongs1());
			model.put("todos", songsservice.retrievesongs1());
			return "list-todos2";
		}
		
		@RequestMapping(value="/add-todo", method=RequestMethod.GET)
		public String newSongs(ModelMap model) {
					return "/todo2";
		}
		
		
		
		@RequestMapping(value="/add-todo", method=RequestMethod.POST)
		public String AddSongs(@RequestParam String songtitle, @RequestParam String childfav, @RequestParam String artist, @RequestParam String datetime, @RequestParam float duration,ModelMap model) {
			System.out.println("/n"+"song title is :"+songtitle);
			songsservice.addsongs(songtitle, childfav, artist, datetime, duration);
					return "redirect:/list-todos2";
		}
		@RequestMapping("/delete-todo")
		public String deletesong(@RequestParam String songstitle) {
			songsservice.deletesong(songstitle);
			return "redirect:/list-todos2";
		}
		
		@RequestMapping(value="/update-todo", method=RequestMethod.GET)
		public String showupdatesong(@RequestParam String songstitle,ModelMap model) {
			//songsservice.deletesong(songstitle);
			
			SongsDetails details =songsservice.updatesong(songstitle);
			model.addAttribute("todo2songs",details);
			return "todo3";
		}
		
		
		@RequestMapping(value="/update-todo", method=RequestMethod.POST)
		public String updateSongs(@RequestParam String songtitle, @RequestParam String childfav, @RequestParam String artist, @RequestParam String datetime, @RequestParam float duration,ModelMap model) {
			//songsservice.deletesong(songtitle);
			System.out.println("/n"+"song title is :"+songtitle);
			songsservice.addUpdateSongs(songtitle, childfav, artist, datetime, duration);
					return "redirect:/list-todos2";
		}

}
