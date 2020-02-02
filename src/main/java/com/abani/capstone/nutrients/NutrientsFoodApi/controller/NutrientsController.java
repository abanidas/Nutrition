package com.abani.capstone.nutrients.NutrientsFoodApi.controller;

import com.abani.capstone.nutrients.NutrientsFoodApi.entity.Food;
import com.abani.capstone.nutrients.NutrientsFoodApi.entity.NutrientFoodMapper;
import com.abani.capstone.nutrients.NutrientsFoodApi.entity.Nutrients;
import com.abani.capstone.nutrients.NutrientsFoodApi.entity.VersionTable;
import com.abani.capstone.nutrients.NutrientsFoodApi.service.FoodService;
import com.abani.capstone.nutrients.NutrientsFoodApi.service.NutrientService;
import com.abani.capstone.nutrients.NutrientsFoodApi.service.VersionTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        List<Nutrients> nutrientsList;

        nutrientsList = nutrientService.retrieveNutrients();

        if (versionTableService.retrieveVersionTable().isEmpty()){
            VersionTable versionTable = new VersionTable();
            versionTable.setVersion(1);

            versionTableService.saveVersionTable(versionTable);
        }

        return nutrientsList;
    }

    @GetMapping(value = "/api/foods")
    public List<Food> getAllFoods(){
        List<Food> foods = foodService.retrieveFoods();
        return foods;
    }

    @GetMapping(value = "/api/loadFoodName")
    public List<Map<String, String>> getFoodWithId(){
        List<Food> foods = foodService.retrieveFoods();
        List<Map<String, String>> foodList = new ArrayList<>();
        for (Food f : foods) {
            Map<String, String> foodMap = new HashMap<>();
            foodMap.put("id", String.valueOf(f.getId()));
            foodMap.put("name", f.getName());
            foodList.add(foodMap);
        }
        return foodList;
    }

    @GetMapping(value = "/api/version")
    public VersionTable getCurrentVersion(){
        List<VersionTable> versionTableList = versionTableService.retrieveVersionTable();
        if (versionTableList.isEmpty()){
            return null;
        }
        return versionTableList.get(0);
    }

    @PostMapping(value = "/api/food/add")
    public String addFood(HttpServletRequest request){

        Food food = foodService.findByName(request.getParameter("name"));
        if (food == null) {
            food = new Food();
            food.setName(request.getParameter("name"));
            food.setDescription(request.getParameter("description"));
            food.setImageUrl(request.getParameter("imgUrl"));
            food.setScientificName(request.getParameter("sName"));
            food.setWikiUrl(request.getParameter("wikiUrl") );
            foodService.saveFood(food);
        } else {
            return "Food Already Exist";
        }

        return "Food added";
    }

    @PostMapping(value = "/api/nutrient/add")
    public String addNutrients(@RequestParam(name = "foods") List<String> foodIds, @RequestParam(name = "names") String names, HttpServletRequest request){

        Nutrients nutrient = nutrientService.findByName(request.getParameter("name"));
        System.out.println("name " + request.getParameter("name"));
        if (nutrient == null) {
            nutrient = new Nutrients();

            Set<Food> foods = new HashSet<>();
            for (String fid: foodIds){
                foods.add(foodService.getFood(Long.parseLong(fid)).get());
            }
            nutrient.setFoods(foods);
            nutrient.setName(request.getParameter("name"));
            nutrient.setDescription(request.getParameter("desc"));
            nutrient.setAlsoKnownAs(Arrays.asList(names.split(",")));

            nutrient.setWikiUrl(request.getParameter("wiki"));
            nutrient.setSymbol(request.getParameter("symbol"));
            nutrientService.saveNutrient(nutrient);
        }
        else {
            return "Nutrient already exist";
        }

        return "Nutrient Added";
    }

    @PutMapping(value = "/api/map")
    public String mapNutrientAndFood(@RequestBody NutrientFoodMapper mapper){

        if(mapper.getFoodId() == null || mapper.getNutrientId() == null){
            return "Invalid operation";
        }
        Food food = foodService.getFood(mapper.getFoodId()).orElse(null);
        Nutrients nutrient = nutrientService.getNutrient(mapper.getNutrientId()).orElse(null);
        if(food == null || nutrient == null){
            return "Data not found";
        }
        food.getQuantityOfNutrients().put(nutrient.getId(), mapper.getQuantity());
        foodService.updateFood(food);
        return "Successfully added";
    }
}
