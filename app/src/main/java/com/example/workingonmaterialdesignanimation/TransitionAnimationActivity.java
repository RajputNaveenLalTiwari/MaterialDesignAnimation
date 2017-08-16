package com.example.workingonmaterialdesignanimation;

import android.os.Build;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;

public class TransitionAnimationActivity extends AppCompatActivity implements View.OnClickListener
{
    Constants.TransitionType type;
    String toolBarTitle;

    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_animation);
        
        initPage();
        initAnimation();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setAllowEnterTransitionOverlap(false);
        }
    }

    private void initPage()
    {
        type = (Constants.TransitionType) getIntent().getSerializableExtra(Constants.KEY_ANIM_TYPE);
        toolBarTitle = getIntent().getExtras().getString(Constants.KEY_TITLE);

        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolBarTitle);
    }

    private void initAnimation()
    {
        switch (type)
        {
            case EXPLODE_TRANSITION_BY_CODE:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    Explode explodeTransition = new Explode();
                    explodeTransition.setDuration(500);
                    getWindow().setEnterTransition(explodeTransition);
                }
                break;
            case EXPLODE_TRANSITION_BY_XML:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
                {
                    Transition explodeTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    {
                        getWindow().setEnterTransition(explodeTransition);
                    }
                }
                break;
            case SLIDE_TRANSITION_BY_CODE:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Slide slideTransition = new Slide();
                    slideTransition.setDuration(1000);
                    slideTransition.setSlideEdge(Gravity.TOP);
                    slideTransition.setInterpolator(new AnticipateOvershootInterpolator());
                    getWindow().setEnterTransition(slideTransition);
                }
                break;
            case SLIDE_TRANSITION_BY_XML:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
                {
                    Transition slideTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    {
                        getWindow().setEnterTransition(slideTransition);
                    }
                }
                break;
            case FADE_TRANSITION_BY_CODE:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    Fade fadeTransition = new Fade();
                    fadeTransition.setDuration(1000);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    {
                        getWindow().setEnterTransition(fadeTransition);
                    }
                }
                break;
            case FADE_TRANSITION_BY_XML:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
                {
                    Transition fadeTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    {
                        getWindow().setEnterTransition(fadeTransition);
                    }
                }
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            finishAfterTransition();
        }
        else
        {
            supportFinishAfterTransition();
        }
        return true;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.exit:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    finishAfterTransition();
                }
                else
                {
                    supportFinishAfterTransition();
                }
                break;
        }
    }
}
