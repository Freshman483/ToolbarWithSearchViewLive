package com.example.toolbarwithsearchviewlive;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    SearchView searchView;

    String[] stringToBeSearchedIn ={
            "James Allois",
            "Trevan Allendro",
            "George Alubasi",
            "Fevioni Italian",
            "Faith Githuma",
            "Alan Onyango",
            "Okoth Mukanda",
            "Billies Eastside",
            "Makamello  Joshien",
            "Benard Okwara",
            "Pauline Wafula",
            "David Wamalwa",
            "Pretty Pehiranha",
            "Paulo Dubai",
            "Euroman Pean",
            "Neuman Nioka"
    };
     ArrayAdapter<String> arrayAdapter_for_holding_search_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView=findViewById(R.id.searchView);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        listView=(ListView) findViewById(R.id.listView);
        setSupportActionBar(toolbar);

        arrayAdapter_for_holding_search_item=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringToBeSearchedIn);
        listView.setAdapter(arrayAdapter_for_holding_search_item);

        searchView.setQueryHint("Type here to search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                arrayAdapter_for_holding_search_item.getFilter().filter(newText);


                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Toast.makeText(MainActivity.this, "search closed", Toast.LENGTH_SHORT).show();
                return false;
            }
        });



    }


/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_only_menu,menu);



        MenuItem menuItem=menu.findItem(R.id.searchReal);
        SearchView searchView=(SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");

        //adding listener on searchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                arrayAdapter_for_holding_search_item.getFilter().filter(newText);

                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }*/
}