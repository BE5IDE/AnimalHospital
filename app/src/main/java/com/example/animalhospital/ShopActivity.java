package com.example.animalhospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img_product_main;
    RadioButton radio1,radio2,radio3;
    Button btn_minus, btn_plus;
    EditText edit_count;
    TextView txt_price,txt_delivery, txt_pay;
    CheckBox chk_agree;
    int count;
    int selected_price;
    int val_delivery= 0;
    int val_pay=0;
    int val_price = 0;
    String selected_name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        img_product_main= findViewById(R.id.img_product_main);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);

        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);


        edit_count = findViewById(R.id.edit_count);
        txt_price = findViewById(R.id.txt_price);
        txt_pay = findViewById(R.id.txt_pay);
        chk_agree = findViewById(R.id.chk_agree);

        radio1.setOnClickListener(this);
        radio2.setOnClickListener(this);
        radio3.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        edit_count.setOnClickListener(this);
        txt_price.setOnClickListener(this);
        txt_pay.setOnClickListener(this);
        chk_agree.setOnClickListener(this);



    }

    private void sumTotal() {
        int selected_count = Integer.parseInt(edit_count.getText().toString());
        val_price = selected_price*selected_count;
        txt_price.setText(val_price+"원");
        if(selected_price*selected_count > 10000){
            txt_delivery.setText("무료");
            val_delivery = 0;

        }
        else{
            val_delivery = 3000;
            txt_delivery.setText(val_delivery+"원");
        }
        val_price = val_pay+val_delivery;
        txt_pay.setText(val_pay+"원");
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.radio1:
                img_product_main.setImageResource(R.drawable.product1);
                selected_price = 1500;
                sumTotal();
                selected_name = findViewById(R.id.radio1).getTag().toString();
                break;
            case R.id.radio2:
                img_product_main.setImageResource(R.drawable.product2);
                selected_price = 2000;
                sumTotal();

                selected_name = findViewById(R.id.radio2).getTag().toString();
                break;
            case R.id.radio3:
                img_product_main.setImageResource(R.drawable.product3);

                selected_name = findViewById(R.id.radio3).getTag().toString();
                selected_price = 3000;
                sumTotal();
                break;
            case R.id.btn_minus:
                int count = Integer.parseInt(edit_count.getText().toString());
                if(count ==1){
                    Toast.makeText(this,"최소수량은 1입니다.",Toast.LENGTH_SHORT).show();
                }
                else{
                    --count;
                    edit_count.setText(String.valueOf(count));
                }
                break;
            case R.id.btn_pay:
                if(chk_agree.isChecked()){
                    Intent intent = new Intent(ShopActivity.this,PayActivity.class);
                    intent.putExtra("item_name",selected_name);
                    intent.putExtra("item_count",val_pay);
                    startActivity(intent);
                }else{
                    Toast.makeText(this,"결제에 동의해주세요",Toast.LENGTH_SHORT).show();
                }

            case R.id.btn_plus:
                count = Integer.parseInt(edit_count.getText().toString());
                if(count == 5){
                    Toast.makeText(this,"최대수량은5입니다.",Toast.LENGTH_SHORT).show();
                }
                else{
                    ++count;
                    edit_count.setText(String.valueOf(count));
                }
                break;

        }
    }
}