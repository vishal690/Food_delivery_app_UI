package eu.tutorials.food_delivery_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import eu.tutorials.food_delivery_app.Adapter.CategaryAdeapter;
import eu.tutorials.food_delivery_app.Adapter.PopularAdapter;
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
        bottomNavigation();
    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(MainActivity.this,CartListActivity.class)));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(MainActivity.this,MainActivity.class)));
            }
        });
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

        adapter = new CategaryAdeapter(categary);
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

        adapter2 = new PopularAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}