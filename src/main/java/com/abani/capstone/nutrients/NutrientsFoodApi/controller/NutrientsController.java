package com.abani.capstone.nutrients.NutrientsFoodApi.controller;

import com.abani.capstone.nutrients.NutrientsFoodApi.entity.Food;
import com.abani.capstone.nutrients.NutrientsFoodApi.entity.Nutrients;
import com.abani.capstone.nutrients.NutrientsFoodApi.entity.VersionTable;
import com.abani.capstone.nutrients.NutrientsFoodApi.service.FoodService;
import com.abani.capstone.nutrients.NutrientsFoodApi.service.NutrientService;
import com.abani.capstone.nutrients.NutrientsFoodApi.service.VersionTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class NutrientsController {

    @Autowired
    private NutrientService nutrientService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private VersionTableService versionTableService;

    @GetMapping(value = "/api/nutrients")
    public List<Nutrients> getAllNutrients() {
        List<Nutrients> nutrientsList = new ArrayList<>();

        /*Nutrients nutrient = new Nutrients();
        Set<Food> foods = new HashSet<>();
        foods.add(foodService.findByName("Ghee"));
        nutrient.setFoods(foods);
        nutrient.setName("Vitamin E");
        nutrient.setDescription("Vitamin E is a group of eight fat soluble chemicals that include four tocopherols and four tocotrienols." +
                " Vitamin E deficiency can cause nerve problems.");
        List<String> names = new ArrayList<>();
        names.add("Tocopheryl Acetate");
        names.add("Tocopheryl Acid Succinate");
        names.add("Tocotrienol");
        nutrient.setAlsoKnownAs(names);

        nutrient.setWikiUrl("https://en.wikipedia.org/wiki/Vitamin_E");
        nutrient.setSymbol("C29H50O2");
        nutrientService.saveNutrient(nutrient);*/

        nutrientsList = nutrientService.retrieveNutrients();

        if (versionTableService.retrieveVersionTable().isEmpty()){
            VersionTable versionTable = new VersionTable();
            versionTable.setVersion(1);

            versionTableService.saveVersionTable(versionTable);
        }

        /*Food food = foodService.findByName("Ghee");
        Map<Integer, String> map = new HashMap<>();
        Nutrients nutrient = nutrientService.findByName("Vitamin E");
        map = food.getQuantityOfNutrients();
        map.put(nutrient.getId(), "2.8 mg in 100 grams");
        food.setQuantityOfNutrients(map);
        foodService.updateFood(food);*/

        return nutrientsList;
    }

    @GetMapping(value = "/api/version")
    public VersionTable getCurrentVersion(){
        List<VersionTable> versionTableList = versionTableService.retrieveVersionTable();
        if (versionTableList.isEmpty()){
            return null;
        }
        return versionTableList.get(0);
    }

    @PostMapping(value = "/api/abaniTryingToAddFood")
    public String addFood(HttpServletRequest request){

        Food food = foodService.findByName(request.getParameter("name"));
        if (food == null) {
            food = new Food();
            food.setDescription(request.getParameter("description"));
            food.setImageUrl(request.getParameter("imgUrl"));
            food.setScientificName(request.getParameter("sName"));
            food.setWikiUrl(request.getParameter("wikiUrl"));
            foodService.saveFood(food);
        } else {
            return "Food Already Exist";
        }

        return "Food added";
    }
}
