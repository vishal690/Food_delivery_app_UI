package eu.tutorials.food_delivery_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import eu.tutorials.food_delivery_app.Adapter.CartListAdapter;
import eu.tutorials.food_delivery_app.Helper.ManagementCart;
import eu.tutorials.food_delivery_app.Interface.ChangeNumberItemsListener;
import eu.tutorials.food_delivery_app.R;

public class CartListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private  RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    TextView totalFeeTxt,taxTxt,deliveryTxt,totalText,emptyTxt;
    private double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managementCart = new ManagementCart(this);

        initView();
        initList();
        CalculateCart();
        bottomNavigation();
    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(CartListActivity.this,CartListActivity.class)));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(CartListActivity.this,MainActivity.class)));
            }
        });
    }

    private void initView() {
//        recyclerViewList = findViewById(R.id.recyclerView);
        totalFeeTxt = findViewById(R.id.totalFeeText);
        taxTxt = findViewById(R.id.taxText);
        deliveryTxt = findViewById(R.id.deliveryText);
        totalText = findViewById(R.id.totalText);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView3);
        recyclerViewList = findViewById(R.id.cartView);
    }

    private void initList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                CalculateCart();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if(managementCart.getListCart().isEmpty()){
                emptyTxt.setVisibility(View.VISIBLE);
                scrollView.setVisibility(View.GONE);
        }else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }
    private void CalculateCart(){
        double percentTax = 0.02;
        double delivery = 10;

        tax = Math.round((managementCart.getTotalFee() * percentTax)*100 )/ 100;
        double total = Math.round((managementCart.getTotalFee() + tax + delivery)*100)/100;
        double itemTotal =Math.round(managementCart.getTotalFee()*100)/100;

        totalFeeTxt.setText("₹" + itemTotal);
        taxTxt.setText("₹"+tax);
        deliveryTxt.setText("₹"+delivery);
        totalText.setText("₹"+total);
    }
}