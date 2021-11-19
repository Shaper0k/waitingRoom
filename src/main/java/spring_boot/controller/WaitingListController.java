package spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring_boot.entity.WaitingList;
import spring_boot.service.WaitingListService;


@Controller
public class WaitingListController {

    private final WaitingListService waitingListService;

    public WaitingListController(WaitingListService waitingListService) {
        this.waitingListService = waitingListService;
    }

    @GetMapping(value = "/")
    public String start(){
        return "waiting_list";
    }

    @GetMapping(value = "/waiting_list")
    public String listUsers(Model model) {
        model.addAttribute("allwaitingList", waitingListService.getAllEntry());
        return "waiting_list";
    }

    @GetMapping(value = "/waiting_list/new")
    public String newUser(Model model) {
        model.addAttribute("waitingList", new WaitingList());
        return "new";
    }

    @PostMapping(value = "/waiting_list/add-user")
    public String addUser(@ModelAttribute WaitingList waitingList) {
        waitingListService.addEntry(waitingList);
        return "redirect:/waiting_list";
    }
    @PostMapping(value = "/waiting_list/edit/{id}")
    public String editUser(@ModelAttribute WaitingList waitingList) {
        waitingListService.updateEntry(waitingList);
        return "redirect:/waiting_list";
    }

    @PostMapping(value = "/waiting_list/{id}/delete")
    public String removeUser(@PathVariable("id") long id) {
        System.out.println(id);
        waitingListService.removeEntryById(id);
        return "redirect:/waiting_list";
    }

}
