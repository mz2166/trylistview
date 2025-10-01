package com.example.mzlist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String[] fruits = {"Apple", "Banana", "Orange", "Mango"};
    ListView listViewFruits;
    ImageView imageViewFruit;
    ArrayList<String> fruitsarr = new ArrayList<>();
    EditText editImageNumber, editImageName;
    Button buttonAdd;
    int[] fruitImages = {
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.orange,
            R.drawable.mango,
            R.drawable.carrot,
            R.drawable.cherries,
            R.drawable.watermelon,
    };

    ArrayList<Integer> imageIndexList = new ArrayList<>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewFruits = findViewById(R.id.listViewFruits);
        imageViewFruit = findViewById(R.id.imageViewFruit);
        editImageNumber = findViewById(R.id.editImageNumber);
        editImageName = findViewById(R.id.editImageName);
        buttonAdd = findViewById(R.id.buttonAdd);

        fruitsarr = new ArrayList<>(Arrays.asList(fruits));


        imageIndexList = new ArrayList<>();
        for (int i = 0; i < fruits.length; i++) {
            imageIndexList.add(i);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruitsarr);
        listViewFruits.setAdapter(adapter);


        listViewFruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int imageIndex = imageIndexList.get(position);
                if (imageIndex >= 0 && imageIndex < fruitImages.length) {
                    imageViewFruit.setImageResource(fruitImages[imageIndex]);
                }
            }
        });


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editImageName.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a fruit name", Toast.LENGTH_SHORT).show();
                    return;
                }


                int imageIndex = -1;
                if (name.equalsIgnoreCase("Carrot")) {
                    imageIndex = 4;
                } else if (name.equalsIgnoreCase("Cherries")) {
                    imageIndex = 5;
                } else if (name.equalsIgnoreCase("Watermelon")) {
                    imageIndex = 6;
                } else {
                    Toast.makeText(MainActivity.this, "You can only add Carrot, Cherries, or Watermelon", Toast.LENGTH_SHORT).show();
                    return;
                }


                fruitsarr.add(name);
                imageIndexList.add(imageIndex);
                adapter.notifyDataSetChanged();

                editImageName.setText("");
                Toast.makeText(MainActivity.this, name + " added!", Toast.LENGTH_SHORT).show();
            }
        });
        listViewFruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int imageIndex = imageIndexList.get(position);

                if (imageIndex >= 0 && imageIndex < fruitImages.length) {

                    imageViewFruit.setImageResource(fruitImages[imageIndex]);


                    Toast.makeText(MainActivity.this,
                            "The id of the fruit is " + imageIndex,
                            Toast.LENGTH_SHORT).show();


                    editImageNumber.setText(String.valueOf(imageIndex));
                }
            }
        });


        listViewFruits.setOnItemLongClickListener((adapterView, view, position, id) -> {
            String fruitName = fruitsarr.get(position);

            new android.app.AlertDialog.Builder(MainActivity.this)
                    .setTitle("Delete Fruit")
                    .setMessage("Are you sure you want to delete \"" + fruitName + "\"?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        fruitsarr.remove(position);
                        imageIndexList.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, fruitName + " deleted", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("No", null)
                    .show();

            return true;
        });

    }
}