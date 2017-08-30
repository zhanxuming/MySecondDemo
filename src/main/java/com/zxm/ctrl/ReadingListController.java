package com.zxm.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;
import com.zxm.domain.*;
import com.zxm.rep.ReadingListRepository;

@Controller
@RequestMapping("/")
public class ReadingListController {

	private ReadingListRepository readingListRepository;
	
	@Autowired
	public ReadingListController(ReadingListRepository readingListRepository) {
		this.readingListRepository = readingListRepository;
	}
	
	@RequestMapping(value="/{reader}",method=RequestMethod.GET)
	public String readersBooks(@PathVariable("reader")String reader,Model model) {
	
		List<Book> books = readingListRepository.findBookByReader(reader);
		model.addAttribute("books",books);
		return "readingList";
		
	}
	
	@RequestMapping(value="/{reader}",method=RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader")String reader,Book book) {
		book.setReader(reader);
		Book res = readingListRepository.save(book);
		
		return "redirect:/{reader}";
	}
	
	
}
