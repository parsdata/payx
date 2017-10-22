package project.parsdata.com.V;

import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;


public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = null;
        new DrawerBuilder().withActivity(this).withToolbar(toolbar).withDrawerGravity(GravityCompat.END).addDrawerItems(
              new SectionDrawerItem().withName("تنظیمات").withDivider(false),
                new SectionDrawerItem().withName("تنظیمات").withDivider(false),
                new SectionDrawerItem().withName("تنظیمات").withDivider(false),
                new SectionDrawerItem().withName("تنظیمات").withDivider(false)
        ).build();

        Drawer drawer = null;

    }
}
