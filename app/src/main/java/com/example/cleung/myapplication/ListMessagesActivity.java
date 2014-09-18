package com.example.cleung.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import static android.R.id.text1;

// import static android.widget.LinearLayout.LayoutParams.WRAP_CONTENT;


/**
 * Created by cleung on 09/09/2014.
 */
public class ListMessagesActivity extends Activity {

    ListView messageListView;

    private static final String[] messages = {"Message 1", "Message 2", "Message 3", "Message 4", "Message 5", "Message 6", "Message 7", "Message 8"};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_messages_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_messages_layout);

        ProgressBar spinner = (ProgressBar) findViewById(R.id.progressBar1);

        messageListView = (ListView) findViewById(R.id.message_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, text1, messages);

        // ListView Item Click Listener
        messageListView.setAdapter(adapter);

        // ListView Item Click Listener
        messageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position:" + position + "  Value: " + messageListView.getItemAtPosition(position), Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
