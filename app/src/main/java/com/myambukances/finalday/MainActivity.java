package com.myambukances.finalday;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int bahasa = 0;
    String[] kosakata_ing = {"also","as","about","below","before","because","consider"};
    String[] kosakata_ind = {"Juga","sebagai","tentang","di bawah","sebelum","karena","mempertimbangkan"};
    String[] kosakata_des = {"adverb\n" +
            "in addition; too.\n" +
            "a brilliant linguist, he was also interested in botany\n" +
            "synonyms: too, as well, besides, in addition, additionally, furthermore, further, moreover, into the", "adverb\n" +
            "used in comparisons to refer to the extent or degree of something.\n" +
            "hailstones as big as tennis balls","adverb\n" +
            "used to indicate movement in an area.\n" +
            "men were floundering about\n" +
            "synonyms: around, here and there, to and fro, back and forth, from place to place, hither and thither, in all directions\n" +
            "used to express location in a particular place.\n" +
            "there was a lot of flu about\n" +
            "synonyms: near, nearby, around, hereabouts, not far (off/away), close by, in the vicinity, in the ","adverb\n" +
            "at a lower level or layer.\n" +
            "he jumped from the window into the moat below\n" +
            "synonyms: further down, lower down, in a lower position, underneath, beneath","preposition\n" +
            "during the period of time preceding (a particular event, date, or time).\n" +
            "she had to rest before dinner\n" +
            "synonyms: previously, before now/then, until now/then, up to now/then, earlier, formerly, hitherto, in the past, in days gone by, heretofore; prior to, previous to, earlier than, preparatory to, in preparation for, preliminary to, in anticipation of, in expectation of, in advance of, ahead of, leading up to, on the eve of, anterior to\n" +
            "in front of.\n" +
            "Matilda stood before her, panting\n" +
            "in preference to; with a higher priority than.\n" +
            "a woman who placed duty before all else\n" +
            "synonyms: in preference to, rather than, sooner than","conjunction\n" +
            "for the reason that; since.\n" +
            "we did it because we felt it our duty\n" +
            "synonyms: since, as, in view of the fact that, inasmuch as, owing to the fact that, seeing that/a","verb\n" +
            "think carefully about (something), typically before making a decision.\n" +
            "each application is considered on its merits\n" +
            "synonyms: think about, contemplate, reflect on, examine, review, mull over, ponder, deliberate"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewQ);
        setListViewAdapter();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                String kosakata, arti;
                if (bahasa == 0){
                    kosakata = kosakata_ing[position];
                    arti = kosakata_ind[position];
                } else {
                    kosakata = kosakata_ind[position];
                    arti = kosakata_ing[position];
                }
                intent.putExtra("kosakata", kosakata);
                intent.putExtra("arti", arti);
                intent.putExtra("desc", kosakata_des[position]);
                startActivity(intent);
            }
        });
    }

    public void setListViewAdapter(){
        ListViewAdapter adapter;
        if (bahasa == 0){
            adapter = new ListViewAdapter(MainActivity.this, kosakata_ing);
        } else {
            adapter = new ListViewAdapter(MainActivity.this, kosakata_ind);
        }
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mian, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_change:
                if (bahasa == 0){
                    setTitle("Indonesia - Inggris");
                    bahasa = 1;
                    setListViewAdapter();
                } else {
                    setTitle("Inggris - Indonesia");
                    bahasa = 0;
                    setListViewAdapter();
                }
                break;
        }
        return  true;
    }
}
