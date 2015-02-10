package co.mobilemakers.firstassessment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements Changeable {

    private final static String THEME_PREFERENCE = "theme_preference";
    private int mThemeName;
    String markdownCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getThemeSelected();
        setTheme(mThemeName);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().
                    add(R.id.container, new StartFragment()).
                    commit();
        }
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
        Boolean handle = false;

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Intent intent =  new Intent(this, AppSettingsActivity.class);
                startActivity(intent);
                Toast.makeText(this,getString(R.string.settings_toast), Toast.LENGTH_LONG).show();
                handle = true;
        }

        if (!handle) {
            handle = super.onOptionsItemSelected(item);
        }

        return handle;
    }

    private void getThemeSelected() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        switch (Integer.valueOf(sharedPreferences.getString(THEME_PREFERENCE, "1"))){
            case 1:
                mThemeName = R.style.FirstTheme;
                break;
            case 2:
                mThemeName = R.style.SecondTheme;
                break;
        }
    }

    @Override
    public void addMarkdown(String mdown) {
        markdownCode += mdown;
    }

    @Override
    public void cleanMarkdown() {
        markdownCode = "";
    }

    @Override
    public String getMarkdown() {
        return markdownCode;
    }
}
