package com.example.workingonmaterialdesignanimation;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Context context;
    LinearLayout sharedElementTransitionContainer;
    ImageView done,nofiles;
    TextView text;
    Button transitionActivity,touchFeedBackActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        sharedElementTransitionContainer = (LinearLayout) findViewById(R.id.sharedElementTransitionContainer);
        sharedElementTransitionContainer.setOnClickListener(this);

        done = (ImageView) findViewById(R.id.done);
        text = (TextView) findViewById(R.id.text);
        nofiles = (ImageView) findViewById(R.id.nofiles);
        transitionActivity = (Button) findViewById(R.id.transitionActivity);
        transitionActivity.setOnClickListener(this);
        touchFeedBackActivity = (Button) findViewById(R.id.touchFeedBackActivity);
        touchFeedBackActivity.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.sharedElementTransitionContainer:
                sharedElementTransition();
                break;
            case R.id.transitionActivity:
                transitionActivity();
                break;
            case R.id.touchFeedBackActivity:
                touchFeedBackActivity();
                break;
        }
    }

    private void sharedElementTransition()
    {
        Pair[] pair = new Pair[3];
        pair[0] = new Pair<View,String>(done,"done_shared_transition");
        pair[1] = new Pair<View,String>(text,"text_shared_transition");
        pair[2] = new Pair<View,String>(nofiles,"nofiles_shared_transition");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
        {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(this,pair);
            Intent intent = new Intent(this,SharedElementTransitionActivity.class);
            startActivity(intent,activityOptions.toBundle());
        }
    }

    private void transitionActivity()
    {
        Intent intent = new Intent(context,TransitionActivity.class);
        startActivity(intent);
    }

    private void touchFeedBackActivity()
    {
        Intent intent = new Intent(context,TouchFeedbackActivity.class);
        startActivity(intent);
    }
}
