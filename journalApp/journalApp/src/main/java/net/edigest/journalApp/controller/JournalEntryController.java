package net.edigest.journalApp.controller;

import java.util.*;

import net.edigest.journalApp.entity.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/journal")
public class JournalEntryController 
{
	private Map<Long,JournalEntry> journalEntries=new HashMap<>();
	
	@GetMapping
	public List<JournalEntry> getAll()
	{
		return new ArrayList<JournalEntry>(journalEntries.values());
	}
	
	@PostMapping
	public boolean createEntry(@RequestBody JournalEntry journalEntry)
	{
		journalEntries.put(journalEntry.getId(), journalEntry);
		return true;
	}
	
	@GetMapping("id/{myId}")
	public JournalEntry getJouralEntryById(@PathVariable Long myId)
	{
		return journalEntries.get(myId);
	}
	
	@DeleteMapping("id/{myId}")
	public JournalEntry deleteJournalEntryById(@PathVariable Long myId)
	{
		return journalEntries.remove(myId);
	}
	
	@PutMapping("id/{myId}")
	public JournalEntry updateJounralById(@PathVariable Long myId, @RequestBody JournalEntry journalEntry)
	{
		return journalEntries.put(myId, journalEntry);
	}
	
}
