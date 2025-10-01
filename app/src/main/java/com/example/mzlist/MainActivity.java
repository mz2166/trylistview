package com.example.mzlist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String[] fruits = {"Apple", "Banana", "Orange", "Grape", "Mango"};
    ListView listViewFruits;
    ImageView imageViewFruit;
    ArrayList<String> fruitsarr = new ArrayList<>();
    EditText editImageNumber, editImageName;
    Button buttonAdd;
    int[] fruitImages = {
            R.drawable.apple,   // index 0 = Apple
            R.drawable.banana,  // index 1 = Banana
            R.drawable.orange,  // index 2 = Orange
            R.drawable.grape,   // index 3 = Grape
            R.drawable.mango,
            R.drawable.carrot,    // 5
            R.drawable.cherries,    // 6
            R.drawable.watermelon,// index 4 = Mango
    };

    ArrayList<Integer> fruitImageList = new ArrayList<>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // your layout file here

        listViewFruits = findViewById(R.id.listViewFruits);
        imageViewFruit = findViewById(R.id.imageViewFruit);

        // Convert array to ArrayList
        fruitsarr = new ArrayList<>(Arrays.asList(fruits));

        // Set adapter for ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                fruitsarr);
        listViewFruits.setAdapter(adapter);
        listViewFruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Use position to get image from fruitImages array
                imageViewFruit.setImageResource(fruitImages[position]);
            }
        });
        //thats my xml and java i want when i put image fruit name and puts its id and press add it added it to the listview and put the image of the spesefice fruit the fruitts that i want to add is carrots and cherry and watermelon these fruits are just to add and i have previus fruit names and images that it just added to the listview and the number of the image is it index and when i put watermelon in image name edittext it shows watermelon image in imge section


    }
}