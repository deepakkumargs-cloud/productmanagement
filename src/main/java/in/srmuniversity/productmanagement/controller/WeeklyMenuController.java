package in.srmuniversity.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.srmuniversity.productmanagement.entity.WeeklyMenu;
import in.srmuniversity.productmanagement.service.WeeklyMenuService;

@RestController
public class WeeklyMenuController {

    @Autowired
    private WeeklyMenuService weeklyService;

    // Get API
    // Fetching all the items in the database in the weekly Menu.
    @RequestMapping("/weekly-menu")
    public List<WeeklyMenu> getWeeklyMenu() {
        return weeklyService.getWeeklyMenu();
    }

    // Post API
    // Adding weekly menu to the database [DB2]
    @RequestMapping(method = RequestMethod.POST, value = "/weekly-menu/add")
    public void addWeeklyMenu(@RequestBody WeeklyMenu menu) {
        weeklyService.addWeeklyMenu(menu);
    }

}
