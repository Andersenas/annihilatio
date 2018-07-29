package com.my_domain.homework.hw8;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.my_domain.homework.R;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class RxFirstActivity extends AppCompatActivity {
    private PublishSubject<Integer> iPublishSubject;
    private TextView textView;
    private LinearLayout linearLayout;
    private int x = 0;

    private View.OnClickListener startB = (View v) -> {
        x++;
        iPublishSubject.onNext(x);
    };

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, RxFirstActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_first);
        textView = findViewById(R.id.textRX);
        linearLayout = findViewById(R.id.hat);
        linearLayout.setOnClickListener(startB);
    }

    @Override
    protected void onResume() {
        super.onResume();
        iPublishSubject = PublishSubject.create();

        iPublishSubject.filter(Integer -> Integer % 2 == 0).subscribe(r);
    }


    public Observer<Integer> r = new Observer<Integer>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.e("AAA", "onSubscribe");
        }

        @Override
        public void onNext(Integer integer) {
            Log.e("AAA", "onNext = " + String.valueOf(integer));
            textView.setText(String.valueOf(integer));

        }

        @Override
        public void onError(Throwable e) {
            Log.e("AAA", "onError");
        }

        @Override
        public void onComplete() {
            Log.e("AAA", "onComplete()");
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        iPublishSubject.onComplete();
    }
}