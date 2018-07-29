package com.my_domain.homework.hw8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.my_domain.homework.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxSecondActivity extends AppCompatActivity {

    private Observable<Long> interval;
    private TextView textView;
    private long l = 0L;
    private Disposable disposable;

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, RxSecondActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_second);
        textView = findViewById(R.id.textRXTwo);

    }

    @Override
    protected void onResume() {
        super.onResume();
        interval = Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .filter(Integer -> Integer % 2 == 0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        interval.subscribe(r);
    }

    private Observer<Long> r = new Observer<Long>() {

        @Override
        public void onSubscribe(Disposable d) {
            RxSecondActivity.this.disposable = d;
        }

        @Override
        public void onNext(Long aLong) {
            Log.e("AAA", String.valueOf(aLong));
            textView.setText(String.valueOf(aLong));
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {
            Log.e("AAA", "onComplete()");
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        disposable.dispose();
    }
}
