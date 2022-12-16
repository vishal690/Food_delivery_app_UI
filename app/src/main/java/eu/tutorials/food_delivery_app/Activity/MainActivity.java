package eu.tutorials.food_delivery_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import eu.tutorials.food_delivery_app.Adoptor.CategaryAdeptor;
import eu.tutorials.food_delivery_app.Adoptor.PopularAdeptor;
import eu.tutorials.food_delivery_app.Domain.CategaryDomain;
import eu.tutorials.food_delivery_app.Domain.FoodDomain;
import eu.tutorials.food_delivery_app.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewpopular();
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategaryDomain> categary = new ArrayList<>();
        categary.add(new CategaryDomain("Pizza","cat_1"));
        categary.add(new CategaryDomain("Burger","cat_2"));
        categary.add(new CategaryDomain("Hotdog","cat_3"));
        categary.add(new CategaryDomain("Drink","cat_4"));
        categary.add(new CategaryDomain("Donut","cat_5"));

        adapter = new CategaryAdeptor(categary);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewpopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni Pizza","pop_1","Slices Pepperoni, Mozzerella Cheese, Fresh Oregano, Ground Black Pepper, Pizza Sauce",9.76));
        foodList.add(new FoodDomain("Cheese Burger","pop_2","Beef, Gouda Cheese, Lettuce, Tomato, Special Sauce",8.79));
        foodList.add(new FoodDomain("Vegetable Pizza","pop_3","Olive oil, Vegetable oil, Pitted Kalamate, Cherry Tomatoes, Basil, Fresh Oregano",8.57));

        adapter2 = new PopularAdeptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}