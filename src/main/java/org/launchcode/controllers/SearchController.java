package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

import static org.launchcode.controllers.ListController.columnChoices;
import static org.yaml.snakeyaml.tokens.Token.ID.Key;
import static org.yaml.snakeyaml.tokens.Token.ID.Value;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "results")
    public String search(Model model, @RequestParam String searchTerm, @RequestParam String searchType) {
        model.addAttribute("columns", columnChoices);

        if (searchType.equals("all")){
            ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
            for (HashMap<String, String> job : jobs) {
                job.get(Key);
                job.get(Value);

           }
            int Size = jobs.size();
            model.addAttribute("size", Size);
            model.addAttribute("key",Key);
            model.addAttribute("value",Value);
            model.addAttribute("jobs", jobs);
          return "search";
        }

        ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        for (HashMap<String, String> job : jobs) {
            job.get(Key);
            job.get(Value);
        }
        int Size = jobs.size();
        model.addAttribute("size", Size);
        model.addAttribute("key",Key);
        model.addAttribute("value",Value);
        model.addAttribute("jobs", jobs);
        return "search";

    }

//    @RequestMapping(value = "results")
//    public String search(Model model, @RequestParam String searchTerm) {
//
//        ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
//        model.addAttribute("jobs", jobs);
//        return "list-jobs";
//    }
}