package com.example.gttrader.View;

import androidx.appcompat.app.AppCompatActivity;
//import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;

import com.example.gttrader.Entity.Building;
import com.example.gttrader.Entity.Universe;
import com.example.gttrader.Entity.Player;
import com.example.gttrader.R;
import com.example.gttrader.ViewModel.TravelViewModel;

/**
 * UI for player travel
 */
public class TravelActivity extends AppCompatActivity {
    private LinearLayout layout;
    private Universe universe = Universe.getUniverse();
    private Player player = universe.getPlayer();
    private Button back;
    private Button goButton;
    private Building location;


    private TravelViewModel travelViewModel = new TravelViewModel();
    //private Inflation inflation = new Inflation();
//    private boolean can_travel = false;
//    private double batteryNeeded = 0;

    TextView current_location;
    TextView next_location;
    TextView battery_remains;
    TextView battery_needed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Goods.setInflation(2);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        layout = findViewById(R.id.linearLayoutTravel);
        back = findViewById(R.id.TravelBack);
        current_location = findViewById(R.id.current_location);
        next_location = findViewById(R.id.next_location);
        battery_remains = findViewById(R.id.battery_remains);
        battery_needed = findViewById(R.id.battery_needed);

        Intent intent = getIntent();
        String name = intent.getStringExtra("nameOfPlace");

        for (Building location2 : Building.values()) {
            if (location2.getName().equals(name)) {
                location = location2;
            }
        }

        boolean can_travel = travelViewModel.canTravel(player.getBuilding(), location);

        String currLocation = "Current Location: " + player.getBuilding().getName();
        String nextLocation = "Next Location: " + location.getName();
        current_location.setText(currLocation);
        next_location.setText(nextLocation);

        String batteryRemaining = "Battery Remains: " + (int) travelViewModel.getBatterRemains() + " %.";
        battery_remains.setText(batteryRemaining);

        String batteryNeededString = "Battery needed to travel to " + location.getName() + " is "
                + Math.round(travelViewModel.batteryNeeded(player.getBuilding(), location)) + " %.";
        battery_needed.setText(batteryNeededString);

        goButton = findViewById(R.id.travel_button);
        final double batteryNeeded = travelViewModel.batteryNeeded(player.getBuilding(), location);

        if (!can_travel) {
            goButton.setEnabled(false);
        }

        goButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { // button clicked
                //battery_remains.setText("Battery Remains: " + (int) travelViewModel.getBatterRemains() + " %.");
                player.setBuilding(location);
                player.getScooter().setBatteryLife(travelViewModel.getBatterRemains()
                        - batteryNeeded);
                //player.getScooter().setBatteryLife(90.0);
                startActivity(new Intent(TravelActivity.this, Main2Activity.class));

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { // button clicked
                //battery_remains.setText("Battery Remains: " + (int) travelViewModel.getBatterRemains() + " %.");
                startActivity(new Intent(TravelActivity.this, Main2Activity.class));
            }
        });

    }
}
