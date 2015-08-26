package org.gdgny.androidfan.coollook;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    public Uri uri;
    public Resources r;
    private RecyclerView.LayoutManager layoutManager;
    private CardAdapter mAdapter;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private long lastBackTime = 0;
    private long currentBackTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);竖屏
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("");
        fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(this);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        setSupportActionBar(toolbar);
        initView();
        r =this.getResources();
    }
    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView788);

        recyclerView.setHasFixedSize(true);
        int spanCount = 1;
        layoutManager = new StaggeredGridLayoutManager(
                spanCount,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new  CardAdapter();
        recyclerView.setAdapter(mAdapter);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.fab:
                // ע�͵����Ƿ���-ͼƬ��Ϣ��
                Intent intent = new Intent(Intent.ACTION_SEND);
//                      intent.setType("image/jpg");
                intent.setType("text/plain");
                Calendar cal = Calendar.getInstance();
                int w = cal.get(Calendar.DAY_OF_WEEK);
                if (w == 1) {
//                            uri =  Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
//                                    + r.getResourcePackageName(R.drawable.sun) + "/"
//                                    + r.getResourceTypeName(R.drawable.sun) + "/"
//                                    + r.getResourceEntryName(R.drawable.sun));
//                            intent.putExtra(Intent.EXTRA_STREAM,uri);
                    intent.putExtra(Intent.EXTRA_TEXT, getResources().getText(R.string.sun) + "download");
                }
                if (w == 2){
//                            uri =  Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
//                                    + r.getResourcePackageName(R.drawable.mon) + "/"
//                                    + r.getResourceTypeName(R.drawable.mon) + "/"
//                                    + r.getResourceEntryName(R.drawable.mon));
//                            intent.putExtra(Intent.EXTRA_STREAM, uri);
                    intent.putExtra(Intent.EXTRA_TEXT, getResources().getText(R.string.mon) + "download");
                }
                if (w == 3) {
//                            uri =  Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
//                                + r.getResourcePackageName(R.drawable.tue) + "/"
//                                + r.getResourceTypeName(R.drawable.tue) + "/"
//                                + r.getResourceEntryName(R.drawable.tue));
//                            intent.putExtra(Intent.EXTRA_STREAM,uri);
                    intent.putExtra(Intent.EXTRA_TEXT, getResources().getText(R.string.tue) + "download");
                }
                if (w == 4) {
//                            uri =  Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
//                                    + r.getResourcePackageName(R.drawable.thu) + "/"
//                                    + r.getResourceTypeName(R.drawable.thu) + "/"
//                                    + r.getResourceEntryName(R.drawable.thu));
//                            intent.putExtra(Intent.EXTRA_STREAM, uri);
                    intent.putExtra(Intent.EXTRA_TEXT, getResources().getText(R.string.thu) + "download");
                }
                if (w == 5) {
//                            uri =  Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
//                                    + r.getResourcePackageName(R.drawable.wed) + "/"
//                                    + r.getResourceTypeName(R.drawable.wed) + "/"
//                                    + r.getResourceEntryName(R.drawable.wed));
//                            intent.putExtra(Intent.EXTRA_STREAM, uri);
                    intent.putExtra(Intent.EXTRA_TEXT, getResources().getText(R.string.wed) + "download");
                }
                if (w == 6) {
//                             uri =  Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
//                                    + r.getResourcePackageName(R.drawable.fri) + "/"
//                                    + r.getResourceTypeName(R.drawable.fri) + "/"
//                                    + r.getResourceEntryName(R.drawable.fri));
//                            intent.putExtra(Intent.EXTRA_STREAM,uri);
                    intent.putExtra(Intent.EXTRA_TEXT, getResources().getText(R.string.fri) + "download");
                }
                if (w == 7) {
//                            uri =  Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
//                                    + r.getResourcePackageName(R.drawable.sat) + "/"
//                                    + r.getResourceTypeName(R.drawable.sat) + "/"
//                                    + r.getResourceEntryName(R.drawable.sat));
//                            intent.putExtra(Intent.EXTRA_STREAM, uri);
                    intent.putExtra(Intent.EXTRA_TEXT, getResources().getText(R.string.sat) + "download");
                }
                startActivity(Intent.createChooser(intent, "share to"));
                break;
        }
    }

    public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

        List<Photo> mItems;

        public CardAdapter() {

            super();
            mItems = new ArrayList<Photo>();
            Calendar cal = Calendar.getInstance();
            int w = cal.get(Calendar.DAY_OF_WEEK);
            Photo photo = new Photo();
//            photo.setName(getText(R.string.sun).toString());
//            photo.setThumbnail(R.drawable.sun);
//            mItems.add(photo);
//
//            photo = new Photo();
//            photo.setName(getText(R.string.mon).toString());
//            photo.setThumbnail(R.drawable.mon);
//            mItems.add(photo);
//
//            photo = new Photo();
//            photo.setName(getText(R.string.thu).toString());
//            photo.setThumbnail(R.drawable.thu);
//            mItems.add(photo);
//
//            photo = new Photo();
//            photo.setName(getText(R.string.tue).toString());
//            photo.setThumbnail(R.drawable.tue);
//            mItems.add(photo);
//
//            photo = new Photo();
//            photo.setName(getText(R.string.wed).toString());
//            photo.setThumbnail(R.drawable.wed);
//            mItems.add(photo);
//
//            photo = new Photo();
//            photo.setName(getText(R.string.fri).toString());
//            photo.setThumbnail(R.drawable.fri);
//            mItems.add(photo);
//
//            photo = new Photo();
//            photo.setName(getText(R.string.sat).toString());
//            photo.setThumbnail(R.drawable.sat);
//            mItems.add(photo);
          if(w ==1){
            photo.setName(getText(R.string.sun).toString());
            photo.setThumbnail(R.drawable.sun);
          }
            if(w==2){
                photo.setName(getText(R.string.mon).toString());
                photo.setThumbnail(R.drawable.mon);
            }
            if(w==3){
                photo.setName(getText(R.string.tue).toString());
                photo.setThumbnail(R.drawable.tue);
            }
            if(w==4){
                photo.setName(getText(R.string.wed).toString());
                photo.setThumbnail(R.drawable.wed);
            }
            if(w==5){
                photo.setName(getText(R.string.thu).toString());
                photo.setThumbnail(R.drawable.thu);
            }
            if(w==6){
                photo.setName(getText(R.string.fri).toString());
                photo.setThumbnail(R.drawable.fri);
            }
            if(w==7){
                photo.setName(getText(R.string.sat).toString());
                photo.setThumbnail(R.drawable.sat);
            }
            mItems.add(photo);
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_card, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            Photo photo = mItems.get(i);
            viewHolder.imgThumbnail.setImageResource(photo.getThumbnail());
            viewHolder.textview.setText(photo.getName());
        }
        @Override
        public int getItemCount() {
            return mItems.size();
        }
        public long getItemId(int position) {
            return position;
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            public  ImageView imgThumbnail;
            public TextView textview;
            public ViewHolder(View itemView) {
                super(itemView);
                imgThumbnail = (ImageView)itemView.findViewById(R.id.image_card);
                textview=(TextView)itemView.findViewById(R.id.text_card);
                Typeface face = Typeface.createFromAsset (getAssets(),"fonts/mo.ttf" );
                textview.setTypeface(face);
                TextPaint tp = textview .getPaint();
                tp.setFakeBoldText(true);
            }
        }
}
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){

            currentBackTime = System.currentTimeMillis();

            if(currentBackTime - lastBackTime > 2 * 1000){
                Toast.makeText(this,R.string.toast, Toast.LENGTH_SHORT).show();
                lastBackTime = currentBackTime;
            }else{
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
