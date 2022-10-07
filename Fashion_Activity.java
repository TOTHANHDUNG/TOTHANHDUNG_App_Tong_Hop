package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Fashion_Activity extends AppCompatActivity {

    ListView lvFashion;
    ArrayList<Fashion> arrayFashion;
    FashionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dong_fashion);
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        Toast.makeText(Fashion_Activity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_farovite:
                        Intent intent=new Intent(Fashion_Activity.this,Fashion_Activity.class);
                        startActivity(intent);
                        Toast.makeText(Fashion_Activity.this, "Farovite", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profile:
                        Intent intent1=new Intent(Fashion_Activity.this,Profile_Activity.class);
                        startActivity(intent1);
                        Toast.makeText(Fashion_Activity.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        AnhXa();
        adapter = new FashionAdapter(this, R.layout.activity_fashion, arrayFashion);
        lvFashion.setAdapter(adapter);

        lvFashion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Fashion_Activity.this, Detail_Activity.class);
                    startActivity(intent);
                }
            }
        });
        lvFashion.setOnItemLongClickListener(new ItemLongClickRemove());
    }
    private void AnhXa(){
        lvFashion = (ListView) findViewById(R.id.listviewFashion);
        arrayFashion = new ArrayList<>();
        arrayFashion.add(new Fashion("SHIRT-JEAN","The Kid LAROI, Justin Bieber", R.drawable.abum1,"5.89$"));
        arrayFashion.add(new Fashion("JACKET","Lil Nas X",R.drawable.abum2,"4.78$"));
        arrayFashion.add(new Fashion("HATS","Sasha Alex Sloan",R.drawable.abum3,"9.99$"));
        arrayFashion.add(new Fashion("T-SHIRT","Alan Walker,Imanbek",R.drawable.abum4,"3.89$"));
        arrayFashion.add(new Fashion("THREE HOLES SHIRT","dhruv",R.drawable.abum5,"3.66$"));
        arrayFashion.add(new Fashion("TROUSERS","Doja Cat, SZA",R.drawable.abum6,"8.99$"));
        arrayFashion.add(new Fashion("SHOES","24KGoldn, lann Dior",R.drawable.abum7,"8.99$"));
    }
    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Fashion_Activity.this);
            alertDialogBuilder.setMessage("Bán có muốn xóa sản phẩm này!");
            alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    arrayFashion.remove(position);
                    //cập nhật lại listview
                    adapter.notifyDataSetChanged();
                }
            });
            alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //không làm gì
                }
            });
            alertDialogBuilder.show();
            return true;
        }
    }
}