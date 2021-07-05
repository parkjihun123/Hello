package com.example.mypizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img_pizza_main;
    RadioButton pizza1;
    RadioButton pizza2;
    RadioButton pizza3;
    RadioButton medium;
    RadioButton large;
    Button btn_minus;
    Button btn_plus;
    EditText edit_cola_count;
    CheckBox chk_agree;
    TextView txt_pizza_price;
    TextView txt_size_price;
    TextView txt_cola_price;
    TextView txt_total_pay;
    Button btn_pay;

    int val_pizza_price = 10000;
    int val_size_price = 0;
    int val_cola_count = 1;
    int val_cola_price = 1000;
    int val_total_pay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_pizza_main = findViewById(R.id.img_pizza_main); //setContentView 다음에 작성!!!
        pizza1 = findViewById(R.id.pizza1);
        pizza2 = findViewById(R.id.pizza2);
        pizza3 = findViewById(R.id.pizza3);
        medium = findViewById(R.id.medium);
        large = findViewById(R.id.large);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        edit_cola_count = findViewById(R.id.edit_cola_count);
        chk_agree = findViewById(R.id.chk_agree);
        txt_pizza_price = findViewById(R.id.txt_pizza_price);
        txt_size_price = findViewById(R.id.txt_size_price);
        txt_cola_price = findViewById(R.id.txt_cola_price);
        txt_total_pay = findViewById(R.id.txt_total_pay);
        btn_pay = findViewById(R.id.btn_pay);

        pizza1.setOnClickListener(this);
        pizza2.setOnClickListener(this);
        pizza3.setOnClickListener(this);
        medium.setOnClickListener(this);
        large.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_pay.setOnClickListener(this);
        chk_agree.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pizza1:
                img_pizza_main.setImageResource(R.drawable.menu_pizza1);
                val_pizza_price = 10000;
                makeTotal();
                break;
            case R.id.pizza2:
                img_pizza_main.setImageResource(R.drawable.menu_pizza2);
                val_pizza_price = 20000;
                makeTotal();
                break;
            case R.id.pizza3:
                img_pizza_main.setImageResource(R.drawable.menu_pizza3);
                val_pizza_price = 30000;
                makeTotal();
                break;
            case R.id.medium:
                val_size_price = 0;
                makeTotal();
                break;
            case R.id.large:
                val_size_price = 5000;
                makeTotal();
                break;
            case R.id.btn_minus:
                if (val_cola_count == 0) {
                    Toast.makeText(getApplicationContext(), "최소수량은 0입니다.", Toast.LENGTH_SHORT).show();
                } else {
                    val_cola_count--;
                    edit_cola_count.setText(val_cola_count + "");
                    makeTotal();
                }
                break;
            case R.id.btn_plus:

                if (val_cola_count == 5) {
                    Toast.makeText(getApplicationContext(), "최대수량은 5입니다.", Toast.LENGTH_SHORT).show();
                } else {
                    val_cola_count++;
                    edit_cola_count.setText(val_cola_count + "");
                    makeTotal();
                }
                break;
            case R.id.btn_pay:
                if (chk_agree.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "주문내역에 동의해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "최종 결제 금액은 " + txt_total_pay.getText() + " 입니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void makeTotal() {
        txt_pizza_price.setText(val_pizza_price + "원");
        txt_size_price.setText(val_size_price + "원");
        txt_cola_price.setText(val_cola_count * val_cola_price + "원");
        int sum = val_pizza_price + val_size_price + val_cola_count * val_cola_price;
        txt_total_pay.setText(sum + "원");
    }
}