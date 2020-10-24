package com.example.android.justjava;


import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int numberOfCoffees = 0;
    int price = 15;

    public void increment(View view) {
        numberOfCoffees++;
        display(numberOfCoffees);

    }
    public void decrement(View view) {
        if(numberOfCoffees>0) {
            numberOfCoffees--;
        }
        display(numberOfCoffees);
    }
    public void submitOrder(View view) {
        display(numberOfCoffees);

        // checking if both checkbox value is true or false.
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_checkbox);
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);

        // Getting name of customer
        EditText name = findViewById(R.id.name);
        String text = name.getText().toString();
        boolean isWhippedCream = whippedCreamCheckBox.isChecked();
        boolean isChocolate = chocolateCheckBox.isChecked();
        int totalCost = price*numberOfCoffees;

        // Adding cost as per toppings selected by user.
        if(isWhippedCream){
            totalCost += (5*numberOfCoffees);
        }
        if (isChocolate){
            totalCost += (3*numberOfCoffees);
        }
        String priceMessage = createOrderSummary(text,totalCost, isWhippedCream,isChocolate);
        calculateCost(priceMessage);

        // Toast to tell user that his order is placed.
        Toast.makeText(this,"Order Placed!", Toast.LENGTH_SHORT).show();
    }


    private void calculateCost( String message) {
        TextView totalTextView = (TextView) findViewById(
                R.id.textView10);
         totalTextView.setText(message);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.textView3);
        quantityTextView.setText(""+number);
    }

    public void resetOrder(View view) {
        displayMessage();
        numberOfCoffees=0;
        display(numberOfCoffees);
    }
    private String createOrderSummary(String text,int price, boolean addWhippedCream,boolean addChocolate ){
        String orderMessage = " Name: "+text;
        orderMessage += "\n Quantity: "+ numberOfCoffees;
        orderMessage += "\n Add whipped cream? " + addWhippedCream;
        orderMessage += "\n Add chocolate? " + addChocolate;
        orderMessage += "\n Total Price: "+ NumberFormat.getCurrencyInstance().format(price);
        orderMessage += "\n Thank you!";
        return  orderMessage;
    }
    
    private void displayMessage() {
        TextView priceTextView = (TextView) findViewById(R.id.textView10);
        priceTextView.setText("Details");
    }

}