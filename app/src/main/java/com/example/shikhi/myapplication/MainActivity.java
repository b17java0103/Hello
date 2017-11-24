package com.example.shikhi.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String titles[] = {"Title1", "Title2", "Title3", "Title3", "Title4"};
    String descriptions[] = {"Description1", "Description2", "Description3", "Description4"};
    int images[] = {};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.list);
        MyAdapter adapter = new MyAdapter(getApplicationContext(), titles, descriptions, images);
        lv.setAdapter(adapter);

    }
}
class MyAdapter extends ArrayAdapter {
    int imagearray[];
    String titlearray[];
    String descarray[];


    MyAdapter(Context contx, String titles1[], String descriptions1[], int imgs1[]) {
        super(contx, R.layout.example_custlistview_row, R.id.textView, titles1);

        imagearray = imgs1;
        titlearray = titles1;
        descarray = descriptions1;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflator = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflator.inflate(R.layout.example_custlistview_row, parent, false);







        ImageView myImage = (ImageView) row.findViewById(R.id.imageView);
        TextView mytitle = (TextView) row.findViewById(R.id.textView);
        TextView mydesc = (TextView) row.findViewById(R.id.textView2);

        myImage.setImageResource(imagearray[position]);
        mytitle.setText(titlearray[position]);
        mydesc.setText(descarray[position]);


        return row;
    }
}
