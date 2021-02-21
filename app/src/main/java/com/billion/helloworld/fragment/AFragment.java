package com.billion.helloworld.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.billion.helloworld.R;

/**
 * Created by 13360 on 2021/2/20.
 */

public class AFragment extends Fragment {
    private Activity mActivity;
    private TextView mTvFragmentA;
    private Button mBtnChangeFragment;
    private Button mBtnChangeContent;
    private Button mBtnCommunication;
    private BFragment mBfragment;
    private OnMessageCommunication messageHandler;

    //给Fragment传入参数
    public static AFragment newInstance(String title){
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    //Fragment向Activity传递消息接口
    interface OnMessageCommunication {
        void communication(String msg);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //类似于Activity中的setContentView
        return inflater.inflate(R.layout.layout_fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvFragmentA = (TextView) view.findViewById(R.id.tv_fragment_a);
        mBtnChangeFragment = (Button) view.findViewById(R.id.btn_change_fragment);
        mBtnChangeContent = (Button) view.findViewById(R.id.btn_change_content);
        mBtnCommunication = (Button) view.findViewById(R.id.btn_communication);
        //设置初始TextView的内容
        mTvFragmentA.setText(getArguments().getString("title"));
        mBtnChangeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBfragment == null){
                    mBfragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if(fragment != null){
                    //存在标签对应的Fragment，通过隐藏该Fragment实现当回退至该Fragment时保存Fragment的内容
                    //否则直接replace方法，当下次回退至该Fragment时会调用onCreateView和onViewCreated刷新Fragment的内容
                    //addToBackStack(null)将Fragment添加到回退栈中，从而按下返回键时回退至上一个Fragment而不是上一个Activity中
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, mBfragment).addToBackStack(null).commitAllowingStateLoss();
                }else{
                    //更换Fragment
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, mBfragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });
        mBtnChangeContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvFragmentA.setText("我是新内容");
            }
        });
        mBtnCommunication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageHandler.communication("Hello World\n你好 新世界");
            }
        });
        //解决getActivity()方法为空方法2
//        if(getActivity() != null){
//            // TODO: 2021/2/20
//        }else {
//            //取消异步任务
//        }
    }

    //Fragment与Activity绑定关系
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //解决getActivity()方法为空方法1
        //mActivity = (Activity) context;
        //当绑定关系时，将context转化为OnMessageCommunication类型以便可以调用communication(String msg)方法
        messageHandler = (OnMessageCommunication) context;
    }

    //当Activity销毁时，Fragment与Activity解除关系
    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消一些异步任务
    }
}
