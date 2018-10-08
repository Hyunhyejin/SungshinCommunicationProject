package com.example.hyejin.sungshintcommuproject.CommunityService;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.hyejin.sungshintcommuproject.Data.PostData;
import com.example.hyejin.sungshintcommuproject.R;

import java.util.ArrayList;

public class FeedActivity extends AppCompatActivity implements FeedAdapter.ClickListener, SwipeRefreshLayout.OnRefreshListener,View.OnClickListener {

    private String TAG = " ## "+getClass().getSimpleName();                                                //로그에 사용되는 클래스 이름

    private RecyclerView recycler_posts;
    private FeedAdapter adapter_postsList;
    private ArrayList<PostData> array_posts;

    private SwipeRefreshLayout refreshLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_activity);
        array_posts = getPostData();
        initView();
    }

    private void initView(){
        refreshLayout = (SwipeRefreshLayout)findViewById(R.id.feed_activity_refresh);
        refreshLayout.setOnRefreshListener(this);
        recycler_posts = (RecyclerView)findViewById(R.id.feed_activity_recycler_posts);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_posts.setLayoutManager(layoutManager);

        adapter_postsList = new FeedAdapter(this,array_posts,this);
        recycler_posts.setAdapter(adapter_postsList);

    }

    /**
     * 추후에 http통신을 통해 서버에 있는 데이터를 가져온다.
     * */
    private ArrayList<PostData> getPostData(){
        ArrayList<PostData> datas = new ArrayList<>();
        for(int i =0; i<20; i++)
            datas.add(new PostData());
        return datas;
    }


    /**
     * 아래로 당기면 http통신을 통새 새로운 데이터를 가져온다.
     * */
    @Override
    public void onRefresh() {
        /***/
        refreshLayout.setRefreshing(false);
    }
    /**
     * 버튼들의 클릭리스너
     * */
    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }

    @Override
    public void onLikeBtnClick(int position) {
        Log.e(TAG,"좋아요 클릭"+position);
    }

    @Override
    public void onCommentClick(int position) {
        Log.e(TAG,"댓글 클릭"+position);


    }

    @Override
    public void onScrapClick(int position) {
        Log.e(TAG,"스크랩 클릭"+position);


    }


}

class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ItemViewHolder> {

    private Context context;
    private ArrayList<PostData> items;
    private ClickListener clickListener;

    public FeedAdapter(Context context, ArrayList<PostData> items, ClickListener clickListener) {
        this.context = context;
        this.items = items;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.feed_recycler_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return items!=null?items.size():0;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public Button btn_like;
        public Button btn_comments;
        public Button btn_scrap;

        public ItemViewHolder(View itemView) {
            super(itemView);
            btn_like = (Button)itemView.findViewById(R.id.feed_item_btn_like);
            btn_comments = (Button)itemView.findViewById(R.id.feed_item_btn_comments);
            btn_scrap = (Button)itemView.findViewById(R.id.feed_item_btn_scrap);

            btn_like.setOnClickListener(this);
            btn_comments.setOnClickListener(this);
            btn_scrap.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.feed_item_btn_like:
                    clickListener.onLikeBtnClick(getAdapterPosition());
                    break;
                case R.id.feed_item_btn_comments:
                    clickListener.onCommentClick(getAdapterPosition());
                    break;
                case R.id.feed_item_btn_scrap:
                    clickListener.onScrapClick(getAdapterPosition());
                    break;
            }
        }
    }

    interface ClickListener{
        void onLikeBtnClick(int position);
        void onCommentClick(int position);
        void onScrapClick(int position);
    }
}

