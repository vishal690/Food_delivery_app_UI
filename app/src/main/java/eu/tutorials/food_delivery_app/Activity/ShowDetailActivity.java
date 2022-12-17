package eu.tutorials.food_delivery_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import eu.tutorials.food_delivery_app.Domain.FoodDomain;
import eu.tutorials.food_delivery_app.Helper.ManagementCart;
import eu.tutorials.food_delivery_app.R;

public class ShowDetailActivity extends AppCompatActivity {

    private TextView addToCartBtn;
    private  TextView titleText,feeText,decriptionText,numberText;
    private ImageView plusBtn,minusBtn,picFood;
    private FoodDomain object;
    int numberOrder = 1;
    private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart = new ManagementCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
    object=(FoodDomain)getIntent().getSerializableExtra("object");
    int drawableResourceId = this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        titleText.setText(object.getTitle());
        feeText.setText("₹"+object.getFee());
        decriptionText.setText(object.getDescription());
        numberText.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder+1;
                numberText.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOrder >1){
                    numberOrder = numberOrder - 1;
                }
                numberText.setText(String.valueOf(numberOrder));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
            }
        });

    }

    private void initView() {
        addToCartBtn =findViewById(R.id.addToCartBtn);
        titleText =findViewById(R.id.titleText);
        feeText =findViewById(R.id.priceText);
        decriptionText =findViewById(R.id.descriptionText);
        numberText =findViewById(R.id.numberOrder);
        plusBtn =findViewById(R.id.plusBtn);
        minusBtn =findViewById(R.id.minusBtn);
        picFood = findViewById(R.id.picfood);
    }
}