package in.srmuniversity.productmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import in.srmuniversity.productmanagement.entity.WeeklyMenu;
import in.srmuniversity.productmanagement.repository.WeeklyMenuRepository;

public class WeeklyMenuService {

    @Autowired
    private WeeklyMenuRepository weeklyMenuRepository;

    public List<WeeklyMenu> getWeeklyMenu() {
        List<WeeklyMenu> menuList = new ArrayList<>();
        weeklyMenuRepository.findAll().forEach(menuList::add); // lambda Expression
        return menuList;
    }

    public void addWeeklyMenu(WeeklyMenu menu) {
        weeklyMenuRepository.save(menu);
    }

}
