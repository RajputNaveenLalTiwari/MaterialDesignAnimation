package com.example.workingonmaterialdesignanimation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class TransitionActivity extends AppCompatActivity implements View.OnClickListener
{
    Button  explodeCode,explodeXML,
            slideCode,slideXML,
            fadeCode,fadeXML;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        initPage();
        setupReturnAnimation();
    }

    private void initPage()
    {
        explodeCode = (Button) findViewById(R.id.explodeCode);
        explodeXML  = (Button) findViewById(R.id.explodeXML);
        slideCode   = (Button) findViewById(R.id.slideCode);
        slideXML    = (Button) findViewById(R.id.slideXML);
        fadeCode    = (Button) findViewById(R.id.fadeCode);
        fadeXML     = (Button) findViewById(R.id.fadeXML);

        explodeCode.setOnClickListener(this);
        explodeXML.setOnClickListener(this);
        slideCode.setOnClickListener(this);
        slideXML.setOnClickListener(this);
        fadeCode.setOnClickListener(this);
        fadeXML.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.explodeCode:
                explodeTransitionAnimationByCode();
                break;
            case R.id.explodeXML:
                explodeTransitionAnimationByXML();
                break;
            case R.id.slideCode:
                slideTransitionAnimationByCode();
                break;
            case R.id.slideXML:
                slideTransitionAnimationByXML();
                break;
            case R.id.fadeCode:
                fadeTransitionAnimationByCode();
                break;
            case R.id.fadeXML:
                fadeTransitionAnimationByXML();
                break;
        }
    }

    private void explodeTransitionAnimationByCode()
    {
        ActivityOptions activityOptions = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            activityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
        }
        Intent intent = new Intent(this,TransitionAnimationActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.EXPLODE_TRANSITION_BY_CODE);
        intent.putExtra(Constants.KEY_TITLE,"Explode By Code");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        {
            startActivity(intent,activityOptions.toBundle());
        }
    }

    private void explodeTransitionAnimationByXML()
    {
        ActivityOptions activityOptions = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            activityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
        }
        Intent intent = new Intent(this,TransitionAnimationActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.EXPLODE_TRANSITION_BY_XML);
        intent.putExtra(Constants.KEY_TITLE,"Explode By XML");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        {
            startActivity(intent,activityOptions.toBundle());
        }
    }

    private void slideTransitionAnimationByCode()
    {
        ActivityOptions activityOptions = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            activityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
        }
        Intent intent = new Intent(this,TransitionAnimationActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.SLIDE_TRANSITION_BY_CODE);
        intent.putExtra(Constants.KEY_TITLE,"Slide By Code");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        {
            startActivity(intent,activityOptions.toBundle());
        }
    }

    private void slideTransitionAnimationByXML()
    {
        ActivityOptions activityOptions = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            activityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
        }
        Intent intent = new Intent(this,TransitionAnimationActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.SLIDE_TRANSITION_BY_XML);
        intent.putExtra(Constants.KEY_TITLE,"Slide By XML");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        {
            startActivity(intent,activityOptions.toBundle());
        }
    }

    private void fadeTransitionAnimationByCode()
    {
        ActivityOptions activityOptions = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            activityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
        }
        Intent intent = new Intent(this,TransitionAnimationActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.FADE_TRANSITION_BY_CODE);
        intent.putExtra(Constants.KEY_TITLE,"Fade By Code");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        {
            startActivity(intent,activityOptions.toBundle());
        }
    }

    private void fadeTransitionAnimationByXML()
    {
        ActivityOptions activityOptions = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            activityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
        }
        Intent intent = new Intent(this,TransitionAnimationActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.FADE_TRANSITION_BY_XML);
        intent.putExtra(Constants.KEY_TITLE,"Fade By XML");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        {
            startActivity(intent,activityOptions.toBundle());
        }
    }

    private void setupReturnAnimation()
    {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
        {
            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.LEFT);
            slide.setDuration(1000);

            getWindow().setReenterTransition(slide);
            getWindow().setExitTransition(slide);

            getWindow().setAllowReturnTransitionOverlap(false);
        }
    }
}
