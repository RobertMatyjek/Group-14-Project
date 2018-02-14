package com.example.andrewratz.recipeasedatabase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    String title;
    String ingredients;
    String instructions;
    private static final String TAG = "MainActivity";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    for (DataSnapshot ds_children : ds.getChildren()) {
                        String key = ds_children.getKey();
                        Object value = ds_children.getValue();
                        //Title of recipe goes in different section
                        if (key.equals("title")) {
                            title = value.toString();
                            final TextView recipeTextView = (TextView) findViewById(R.id.recipe_name_view_id);
                            recipeTextView.setText(title);
                        }
                        //User doesn't need to see id
                        else if (key.equals("id")) {

                        }
                        //User doesn't need to see partition
                        else if (key.equals("partition")) {

                        }
                        //No URL for now
                        else if (key.equals("url")) {

                        }
                        else if (key.equals("ingredients")) {
                            ingredients = "Ingredients: \n";
                            for (DataSnapshot ingredient_children : ds_children.getChildren()) {
                                value = ingredient_children.child("text").getValue();
                                ingredients += (value + "\n");
                            }
                            final TextView ingredientsTextView = (TextView) findViewById(R.id.ingredients_view_id);
                            ingredientsTextView.setText(ingredients);
                        }
                        else if (key.equals("instructions")) {
                            instructions = "Instructions: \n";
                            for (DataSnapshot instruction_children : ds_children.getChildren()) {
                                value = instruction_children.child("text").getValue();
                                instructions += (value + "\n");
                            }
                            final TextView instructionsTextView = (TextView) findViewById(R.id.instructions_view_id);
                            instructionsTextView.setText(instructions);
                        }
                        //Should never happen
                        else {
                            Log.d(TAG, key + ": " + value);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i(TAG, "onCancelled", databaseError.toException());
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create recipe function
                Snackbar.make(view, "Recipe added to database", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
