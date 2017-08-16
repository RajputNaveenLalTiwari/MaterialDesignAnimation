package com.example.workingonmaterialdesignanimation;

import android.animation.Animator;
import android.os.Build;
import android.support.v4.view.WindowCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SharedElementTransitionActivity extends AppCompatActivity implements View.OnClickListener
{
    private RelativeLayout rootLayout;
    private Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_transition);
        initPage();
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

    private void initPage()
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shared Element Transition");

        rootLayout = (RelativeLayout) findViewById(R.id.rootLayout);
        exit = (Button) findViewById(R.id.exit);

        rootLayout.setOnClickListener(this);
        exit.setOnClickListener(this);
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
            case R.id.rootLayout:
                circularRevealAnimtion(rootLayout);
                break;
        }
    }

    private void circularRevealAnimtion(View view)
    {
        final TextView circularRevealAnimation = (TextView) findViewById(R.id.circularRevealAnimation);

        int centerX = ((view.getLeft())+(view.getRight()))/2;
        int centerY = ((view.getTop())+(view.getBottom()))/2;

        float radius = Math.max(circularRevealAnimation.getWidth(),circularRevealAnimation.getHeight())*2.0f;

        if(circularRevealAnimation.getVisibility() == View.INVISIBLE)
        {
            circularRevealAnimation.setVisibility(View.VISIBLE);
            circularRevealAnimation.setText("Welcome to android world!");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            {
                ViewAnimationUtils.createCircularReveal(circularRevealAnimation, centerX, centerY, 0, radius).start();
            }
        }
        else
        {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
            {
                Animator animator = ViewAnimationUtils.createCircularReveal(circularRevealAnimation,centerX,centerY,radius,0);
                animator.addListener(new Animator.AnimatorListener()
                {
                    @Override
                    public void onAnimationStart(Animator animation)
                    {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation)
                    {
                        circularRevealAnimation.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation)
                    {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation)
                    {

                    }
                });
                animator.start();
            }
        }
    }
}
