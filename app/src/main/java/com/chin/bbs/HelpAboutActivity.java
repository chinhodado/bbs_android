package com.chin.bbs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class HelpAboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_about);
        TextView tv = (TextView) findViewById(R.id.textView_help);
        Intent intent = getIntent();
        if (intent != null) {
            String intentStr = intent.getStringExtra("INTENT");
            if (intentStr.equals("help")) {
                tv.setText(Html.fromHtml(getString(R.string.help_text)));
                setTitle("Help");
            }
            else if (intentStr.equals("about")) {
                tv.setText(Html.fromHtml(getString(R.string.about_text)));
                setTitle("About");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // don't create any menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent intent = new Intent(this, HelpAboutActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
