package com.example.naszga.happybirthday;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.text.NumberFormat;

public class JustJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    int amountToPay = 0,
            getOldQty = 0;
    //
    TextView msgView = (TextView)findViewById(R.id.msg);
    TextView buyerName = (TextView)findViewById(R.id.getName);
    CheckBox whippedCreamCheckView = (CheckBox)findViewById(R.id.wcream);
    CheckBox chocolateCheckView = (CheckBox)findViewById(R.id.chocolate);
    //
    public void submitOrder(View view) {
        //message
        String getCheckSelections = "";
        //
        if(whippedCreamCheckView.isChecked()) {
            getCheckSelections = "Add '" +
                    whippedCreamCheckView.getText().toString().toLowerCase() + "?' True\n";
        }
        else {
            getCheckSelections = "Add '" +
                    whippedCreamCheckView.getText().toString().toLowerCase() + "?' False";
        }
        //
        if(chocolateCheckView.isChecked()) {
            getCheckSelections = "Add '" +
                    chocolateCheckView.getText().toString().toLowerCase() + "?' True\n";
        }
        else {
            getCheckSelections = "Add '" +
                    chocolateCheckView.getText().toString().toLowerCase() + "?' False";
        }
        //
        if(buyerName.getText().toString().equalsIgnoreCase("enter name")) {
            msgView.setText("MSG: Please Enter The Correct Name For The Buyer");
        }
        else {
            msgView.setText(displaySummary(getCheckSelections));
            //
            Intent mailIntent = new Intent(Intent.ACTION_SENDTO);
            mailIntent.setData(Uri.parse("mailto:"));
            mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order To " +
                    buyerName.getText().toString());
            mailIntent.putExtra(Intent.EXTRA_TEXT, displaySummary(getCheckSelections));
            //
            if(mailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mailIntent);
            }
        }
    }
    //
    private String displaySummary(String toppingChoice) {
        return "Order Summary!\n" +
                "Name: " + buyerName.getText().toString() + "\n" +
                "Quantity: " + getOldQty + "\n" +
                "Amount To Pay: $" + amountToPay + ".00\n" +
                "Topping List: " + toppingChoice + "\n\n" +
                "Thank You For Making Your Orders!";
    }
    //
    public void increaseQuantity(View view) {
        //get the existing value
        TextView incrQty = (TextView)findViewById(R.id.get_qty_to_purchase);
        getOldQty = Integer.parseInt(incrQty.getText().toString());
        //increase old by 1
        getOldQty++;
        if(getOldQty < 0) {
            getOldQty = 0;
            //
            msgView.setText("MSG: Quantity Specified Cannot Be Greater Than 100");
            incrQty.setText("" + getOldQty);
            //
            Toast.makeText(this, "Cannot Purchase A 100 Cups", Toast.LENGTH_SHORT).show();
        }
        else {
            incrQty.setText("" + getOldQty);
        }
        //
        display(getOldQty);
        displayAmountPrice(getOldQty);
    }
    //
    public void decreaseQuantity(View view) {
        //get the existing value
        TextView decrQty = (TextView)findViewById(R.id.get_qty_to_purchase);
        getOldQty = Integer.parseInt(decrQty.getText().toString());
        //decrease old by 1
        getOldQty--;
        if(getOldQty < 0) {
            getOldQty = 0;
            //
            msgView.setText("MSG: Quantity Specified Cannot Be Less Than 0");
            decrQty.setText("" + getOldQty);
            //
            Toast.makeText(this, "Cannot Purchase Less Than 1 Cup", Toast.LENGTH_SHORT).show();
        }
        else {
            decrQty.setText("" + getOldQty);
        }
        //
        display(getOldQty);
        displayAmountPrice(getOldQty);
    }
    //
    private void displayAmountPrice(int number) {
        TextView priceView = (TextView)findViewById(R.id.priceValue);
        //
        amountToPay = Integer.parseInt(priceView.getText().toString()) * number;
        //
        TextView amountView = (TextView)findViewById(R.id.totalAmount);
        amountView.setText("" + NumberFormat.getCurrencyInstance().format(amountToPay));
    }
    //
    private void display(int number) {
        TextView quantityTextView = (TextView)findViewById(R.id.get_qty_to_purchase);
        quantityTextView.setText("" + number);
    }
}
