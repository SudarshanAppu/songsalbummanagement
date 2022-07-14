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
			System.out.println("List in page 1: "+sng);
			model.put("todos", sng);
			return "list-todos2";
		}
		
		@RequestMapping(value="/add-todo", method=RequestMethod.GET)
		public String newSongs(ModelMap model) {
					return "/todo2";
		}
		
		@RequestMapping(value="/add-todo", method=RequestMethod.POST)
		public String AddSongs(SongsDetails songsdetails,ModelMap model) {
			System.out.println("/n"+"song title is :"+songsdetails);
			songsrepository.save(songsdetails);
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
			model.addAttribute("todo2songs",details);
			return "todo3";
		}
		
		@RequestMapping(value="/update-todo", method=RequestMethod.POST)
		public String updateSongs(SongsDetails songsdetails,ModelMap model) {
			System.out.println("/n"+"song list :"+songsdetails);
			
			songsrepository.deleteById(songsdetails.getId());
			songsrepository.save(songsdetails);
					return "redirect:/list-todos2";
		}

}
