package com.example.admin.basicstickyheader;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import tellh.com.stickyheaderview_rv.adapter.DataBean;
import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    Context context;
    private StickyHeaderViewAdapter adapter;
    private Random random = new Random(System.currentTimeMillis());

   private ArrayList<DataBean> player;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.d("MyApp", User.dataSource);






        rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));


       // userList.add("minu")
       player = new ArrayList<DataBean>();
        GenerateUserList();
        adapter = new StickyHeaderViewAdapter(player)
                .RegisterItemType(new UserItemViewBinder())
                .RegisterItemType(new ItemHeaderViewBinder());
        rv.setAdapter(adapter);
    }
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d("tag", "config changed");
        super.onConfigurationChanged(newConfig);
        int orientation = newConfig.orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d("tag", "Portrait");

            RecyclerView.LayoutManager linear = new LinearLayoutManager(this);
            rv.setLayoutManager(linear);

           // rv.setLayoutManager(new LinearLayoutManager(this));
            adapter = new StickyHeaderViewAdapter(player)
                    .RegisterItemType(new UserItemViewBinder())
                    .RegisterItemType(new ItemHeaderViewBinder());
            rv.setAdapter(adapter);
        }
        else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d("tag", "Landscape");
            RecyclerView.LayoutManager grid = new GridLayoutManager(this, 2);
            ((GridLayoutManager) grid).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    Log.d("grid",adapter.getItemViewType(position)+"");
                    switch(adapter.getItemViewType(position)){
                        case R.layout.header:
                            return 2;

                        case R.layout.item_user:
                            return 1;

                        default:
                            return 2;
                    }
                }
            });
            rv.setLayoutManager(grid);
            adapter = new StickyHeaderViewAdapter(player)
                    .RegisterItemType(new UserItemViewBinder())
                    .RegisterItemType(new ItemHeaderViewBinder());
            rv.setAdapter(adapter);

            //rv.setLayoutManager(new GridLayoutManager(context, 2));

        }
    }

   /* private void initData() {
        //Gson gson = new Gson();
       // Result result = get
       // Log.d("JsonData", User.dataSource);

        for(int i = 0; i< dataSource.length(); i++)

        Collections.sort(player, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        List<DataBean> userListBak = new ArrayList<>();
        String currentPrefix = player.get(0).getName().substring(0, 1).toUpperCase();
        userListBak.add(new ItemHeader(currentPrefix));
        for (User user : userList) {
            if (currentPrefix.compareToIgnoreCase(user.getPosition().substring(0, 1)) == 0)
                userListBak.add(user);
            else {
                currentPrefix = user.getPosition().substring(0, 1).toUpperCase();
                userListBak.add(new ItemHeader(currentPrefix));
                userListBak.add(user);
            }
        }
        adapter = new StickyHeaderViewAdapter(userListBak)
                .RegisterItemType(new UserItemViewBinder())
                .RegisterItemType(new ItemHeaderViewBinder());
        rv.setAdapter(adapter);
    }*/





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           case R.id.action_add_view:
                User user = new User("Sticky View", 123, "https://avatars.githubusercontent.com/u/15800681?v=3");
                user.setShouldSticky(random.nextBoolean());
                adapter.append(user);
                break;
            case R.id.action_clear_all:
                adapter.clear(rv);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);


    }*/










    private void GenerateUserList() {

        player.add(new ItemHeader("Keeper"));

        User players =new User("Keylor Navas");
        player.add(players);
        players = new User("Kiko Casilla");
        player.add(players);
        players = new User("Ruben Yanez");
        player.add(players);


        player.add(new ItemHeader("Defender"));

        players = new User("Marcelo");
        player.add(players);
        players = new User("Sergio Ramos");
        player.add(players);
        players = new User("Dani Carvajal");
        player.add(players);
        players = new User("Raphel Varane");
        player.add(players);
        players = new User("Pepe");
        player.add(players);
        players = new User("Nacho Frenandez");
        player.add(players);
        players = new User("Fabio Coentrao");
        player.add(players);
        players = new User("Danilo");
        player.add(players);

        player.add(new ItemHeader("Midfielder"));

        players = new User("Luka Modric");
        player.add(players);
        players = new User("Toni Kroos");
        player.add(players);
        players = new User("James Rodriguez");
        player.add(players);
        players = new User("Casemiro");
        player.add(players);
        players = new User("Isco Alcoron");
        player.add(players);
        players = new User("Kovacic");
        player.add(players);
        players = new User("Marco Asensio");
        player.add(players);
        players = new User("Lucas Vasquez");
        player.add(players);

        player.add(new ItemHeader("Forward"));


        players = new User("Cristiano Ronaldo");
        player.add(players);
        players = new User("Gareth Bale");
        player.add(players);

        players = new User("Alvaro Morata");
        player.add(players);
        players = new User("Karim Benzema");
        player.add(players);
        players = new User("Mariano");
        player.add(players);





       /* userList.add(new User("login1", 1, "http://www.something.com"));
        userList.add(new User("login2", 1, "http://www.something.com"));
        userList.add(new User("login3", 1, "http://www.something.com"));
        userList.add(new User("login4", 1, "http://www.something.com"));
        userList.add(new User("login5", 1, "http://www.something.com"));
        userList.add(new User("login6", 1, "http://www.something.com"));
        userList.add(new User("login67", 1, "http://www.something.com"));
        userList.add(new User("login68", 1, "http://www.something.com"));
        userList.add(new User("login69", 1, "http://www.something.com"));
        userList.add(new User("login610", 1, "http://www.something.com"));
        userList.add(new User("login611", 1, "http://www.something.com"));
        userList.add(new ItemHeader("n"));
        userList.add(new User("name1", 2, "http://www.something.com"));
        userList.add(new User("name2", 2, "http://www.something.com"));
        userList.add(new User("name3", 2, "http://www.something.com"));
        userList.add(new User("name4", 2, "http://www.something.com"));
        userList.add(new User("name5", 2, "http://www.something.com"));
        userList.add(new User("name6", 2, "http://www.something.com"));
        userList.add(new User("name7", 2, "http://www.something.com"));
        userList.add(new User("name2", 2, "http://www.something.com"));
        userList.add(new User("name3", 2, "http://www.something.com"));
        userList.add(new User("name4", 2, "http://www.something.com"));
        userList.add(new User("name5", 2, "http://www.something.com"));
        userList.add(new User("name6", 2, "http://www.something.com"));
        userList.add(new User("name7", 2, "http://www.something.com"));
        userList.add(new User("qqqqq", 33,"http://www.something.com"));
    */
    }








}
